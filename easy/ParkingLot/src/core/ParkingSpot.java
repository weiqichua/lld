package core;
import vehicletype.Vehicle;
import vehicletype.VehicleType;

public class ParkingSpot {

    private final int spotId;
    private final VehicleType type;
    private Vehicle currentVehicle;
    private boolean isAvailable;

    public ParkingSpot(int spotId, VehicleType type) {
        this.spotId = spotId;
        this.type = type;
        this.isAvailable = true;
    }

    public synchronized boolean isAvailable() {
        return isAvailable;
    }


    public synchronized boolean park(Vehicle vehicle) {
        if (!isAvailable && vehicle.getType() == type)  {
            return false;
        }
        currentVehicle = vehicle;
        isAvailable = false;
        return true;

    }

    public void unpark() {
        currentVehicle = null;
        isAvailable = true;
    }

    public VehicleType getVehicleType() {
        return type;
    }

    public Vehicle getVehicle() {
        return currentVehicle;
    }

    public int getSpotId() {
        return spotId;
    }

}
