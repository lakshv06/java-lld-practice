import enums.SpotType;

public class Ticket {
    String TicketId;
    String spotId;
    Long entryTime;
    SpotType vehType;

    public Ticket(String TicketId, String spotId, Long timeInMs, SpotType vehType) {
        this.TicketId = TicketId;
        this.spotId = spotId;
        this.entryTime = timeInMs;
        this.vehType = vehType;
    }

    public String getTicketId() {
        return TicketId;
    }

    public String getSpotId() {
        return spotId;
    }

    public Long getEntryTime() {
        return entryTime;
    }

    public SpotType getVehType() {
        return vehType;
    }
}
