package core;

import vehicletype.Vehicle;
import vehicletype.VehicleType;

import java.util.List;
import java.util.Optional;

public class ParkingFloor {
    private final int floorNumber;
    private final List<ParkingSpot> spots;

    public ParkingFloor(int floorNumber, List<ParkingSpot> spots) {
        this.floorNumber = floorNumber;
        this.spots = spots;
    }

    public synchronized Optional<ParkingSpot> getAvailableSpot(VehicleType type) {
        return spots.stream().filter(spot -> spot.isAvailable() && spot.getVehicleType() == type).findFirst();
    }

    public int getFloorNumber() {
        return floorNumber;
    }

    public List<ParkingSpot> getParkingSpots() {
        return spots;
    }


}