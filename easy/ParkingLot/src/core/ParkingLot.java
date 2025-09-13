package core;
import vehicletype.Vehicle;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import java.util.Optional;
import java.util.UUID;

import fee.FeeStrategy;
import fee.FlatRateFeeStrategy;

public class ParkingLot {

    private static final ParkingLot parkingLot = new ParkingLot();
    private final List<ParkingFloor> floors;
    private final Map<String, Ticket> activeTickets = new ConcurrentHashMap<>();
    private FeeStrategy feeStrategy;


    // Inject floors and tickets into constructor? => Not necessarily
    private ParkingLot() {
        floors = new ArrayList<ParkingFloor>();
        feeStrategy = new FlatRateFeeStrategy();

    }

    public static ParkingLot getParkingLot() {
        return parkingLot;
    }

    public void addFloor(ParkingFloor floor) {
        floors.add(floor);
    }
    
    public void setFeeStrategy(FeeStrategy feeStrategy) {
        this.feeStrategy = feeStrategy;
    }

    public List<ParkingFloor> getParkingFloors() {
        return floors;
    }

    public synchronized Ticket parkVehicle(Vehicle vehicle) throws Exception {
        for (ParkingFloor floor: floors) {
            Optional<ParkingSpot> spotOpt = floor.getAvailableSpot(vehicle.getType());
            if (spotOpt.isPresent()) {
                ParkingSpot spot = spotOpt.get();
                if (spot.park(vehicle)) {
                    String ticketId = UUID.randomUUID().toString();
                    Ticket ticket = new Ticket(ticketId, vehicle, spot);
                    activeTickets.put(ticketId, ticket);
                    return ticket;
                }
            }
        }
        throw new Exception("No availalbe spot for " + vehicle.getType());
    }

    public synchronized double unparkVehicle(String ticketId) throws Exception {
        Ticket ticket = activeTickets.remove(ticketId);
        if (ticket == null) throw new Exception("Invalid ticket.");

        ParkingSpot spot = ticket.getSpot();
        spot.unpark();

        ticket.setExitTimeStamp();
        return feeStrategy.calculateFee(ticket);
    }

}

