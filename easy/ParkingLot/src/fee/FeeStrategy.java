package fee;

import core.Ticket;

public interface FeeStrategy {

    public double calculateFee(Ticket ticket);
}
