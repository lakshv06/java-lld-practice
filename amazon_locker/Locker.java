package amazon_locker;

import amazon_locker.enums.LockerSizes;
import java.time.LocalDateTime;
import java.util.HashMap;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.Map;
import java.util.Queue;
import java.util.Set;

public class Locker {
    private String lockerId; // can be used in some parent class if we want to have multiple lockers in the future
    private final Map<LockerSizes, Queue<Compartment>> freeCompartments = new HashMap<>();
    private final Set<Compartment> OccupiedCompartments = new HashSet<>();
    private final Map<String, AccessToken> tokenIdToAccessTokenMap= new HashMap<>(); // is it actually required?

    private String getLockerId(){
        return String.valueOf((int)(Math.random()*1000000)) + LocalDateTime.now().toString();
    }

    public Locker(Compartment[] compartments){
        this.lockerId = getLockerId();

        for (LockerSizes size : LockerSizes.values()) {
            freeCompartments.put(size, new LinkedList<>());
        }

        for(Compartment compartment: compartments){
            freeCompartments.putIfAbsent(compartment.getSize(), new LinkedList<>());
            freeCompartments.get(compartment.getSize()).add(compartment);
        }
    }

    public String deposit(LockerSizes size){ // returns token
        if(freeCompartments.get(size).isEmpty()){
            throw new RuntimeException("No free compartments of size: " + size);
        }
        Compartment cmp = freeCompartments.get(size).poll();
        AccessToken token = new AccessToken(LocalDateTime.now().plusDays(1), cmp);
        tokenIdToAccessTokenMap.put(token.getToken(), token);
        cmp.setOccupied();
        OccupiedCompartments.add(cmp);
        return token.getToken();
    }

    public void pickup(String accessT){

    }

    public void openExpiredCompartments(){

    }

}
