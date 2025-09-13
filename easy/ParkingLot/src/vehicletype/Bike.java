package vehicletype;

public class Bike extends Vehicle {
    // Inherit licensePlate from vehicle - a protected variable can be accessed directly by its subclass

    public Bike(String licensePlate) {
        super(licensePlate, VehicleType.BIKE);
    }

    // Does not have to be an abstract method! Can be a concrete method!

        // @Override
        // protected VehicleType getType() {
        //     return null;
        // }
}
