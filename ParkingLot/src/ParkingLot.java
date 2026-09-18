import enums.SpotType;

import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.UUID;

public class ParkingLot {
    private List<ParkingSpot> parkingSpots;
    private Map<String, Ticket> activeTickets;
    private Set<String> occupiedSpots; // stores spot ids or maybe i should directly reference the spots??

    private Long getPayment(Long entryTime){
        Long currentTime = System.currentTimeMillis();
        long durationInMillis = currentTime - entryTime;
        long hours = (long) Math.ceil((double) durationInMillis / (1000 * 60 * 60));
        hours = Math.max(1, hours);
        return hours * 25;
    }

    private synchronized ParkingSpot getAvailableSpot(SpotType spotType){
        for(ParkingSpot spot : parkingSpots){
            if(spot.getSpotType().equals(spotType) && !occupiedSpots.contains(spot.getParkingSpotId())){
                return spot;
            }
        }
        return null;
    }

    public ParkingLot(List<ParkingSpot> parkingSpots) {
        this.parkingSpots = parkingSpots;
    }

    private String generateTicketId(){
        return UUID.randomUUID().toString();
    }

    public Ticket entry(SpotType spotType){
        synchronized (this) {
            ParkingSpot parkSpot = getAvailableSpot(spotType);
            if (parkSpot == null) {
                return null;
            }
            occupiedSpots.add(parkSpot.getParkingSpotId());
            String ticketId = generateTicketId();
            Ticket ticket = new Ticket(ticketId, parkSpot.getParkingSpotId(), System.currentTimeMillis(), spotType);
            activeTickets.put(ticketId, ticket);
            return ticket;
        }
    }

    public Long exit(String ticketId) throws Exception {
        if(ticketId == null){throw new Exception("Ticket id is null");}
        if(!activeTickets.containsKey(ticketId)){throw new Exception("Ticket does not exist");}

        Ticket ticket = activeTickets.get(ticketId);
        if(ticket==null){throw new Exception("Ticket does not exist");}
        synchronized (this){
        occupiedSpots.remove(ticket.getSpotId());
        activeTickets.remove(ticketId);
    }
        return  getPayment(ticket.getEntryTime());
    }
}
