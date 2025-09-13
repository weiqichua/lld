package core;

import vehicletype.Vehicle;

import java.util.Date;

public class Ticket {
    private final String ticketId;
    private final long entryTimeStamp;
    private final ParkingSpot spotInfo;
    private final Vehicle vehicle;
    private long exitTimeStamp;

    public Ticket(String ticketId, Vehicle vehicle, ParkingSpot spot) {
        this.ticketId = ticketId;
        this.entryTimeStamp = new Date().getTime();
        this.spotInfo = spot;
        this.vehicle = vehicle;
    }

    public String getTicketId() { return ticketId; }
    public Vehicle getVehicle() { return vehicle; }
    public ParkingSpot getSpot() { return spotInfo; }
    public long getEntryTimeStamp() { return entryTimeStamp; }
    public long getExitTimeStamp() { return exitTimeStamp; }


    public void setExitTimeStamp() {
        this.exitTimeStamp = exitTimeStamp;
    }
}
