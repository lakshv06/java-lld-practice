import enums.SpotType;

public class ParkingSpot {
    private String parkingSpotId;
    private SpotType spotType;

    ParkingSpot(String parkingSpotId, SpotType spotType) {
        this.parkingSpotId = parkingSpotId;
        this.spotType = spotType;
    }

    public String getParkingSpotId() {
        return parkingSpotId;
    }
    public SpotType getSpotType() {
        return spotType;
    }
}
