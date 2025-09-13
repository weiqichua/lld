import core.ParkingLot;

public class ParkingLotDemo {
    public void run() {
        ParkingLot parkingLot = ParkingLot.getParkingLot();
        
        List<ParkingSpot> parkingSpotsFloor1 = List.of(
            new ParkingSpot(101, VehicleType.CAR),
            new ParkingSpot(102, VehicleType.TRUCK)
        );
        
    }
}
