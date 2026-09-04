package amazon_locker;

import amazon_locker.enums.LockerSizes;

public class Compartment {
    private final LockerSizes size;
    private final String compartmentId;
    private Boolean occupied;

    private String generateCompartmentID() {
        return String.valueOf((int) (Math.random() * 1000000)) + System.currentTimeMillis();
    }

    public Compartment(LockerSizes size){
        this.size = size;
        this.compartmentId = generateCompartmentID();
        this.occupied = false;
    }

    public LockerSizes getSize() {
        return size;
    }

    public String getCompartmentId() {
        return compartmentId;
    }

    public Boolean isOccupied() {
        return occupied;
    }

    public void setOccupied() {
        this.occupied = true;
    }

    public void setUnoccupied() {
        this.occupied = false;
    }

    public void setOpen(){
        this.setUnoccupied();
    }

}
