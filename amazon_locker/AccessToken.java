package amazon_locker;

import java.time.LocalDateTime;

public class AccessToken {
    private final String tokenId;
    private final LocalDateTime expirationTime;
    private final Compartment compartment;

    private String getTokenId(){
        return String.valueOf((int)(Math.random()*1000000)) + LocalDateTime.now().toString();
    }

    public AccessToken(LocalDateTime expirationTime, Compartment compartment) {
        this.tokenId = getTokenId();
        this.expirationTime = expirationTime;
        this.compartment = compartment;
    }

    public Boolean isExpired(){
        return LocalDateTime.now().isAfter(expirationTime);
    }

    public String getToken() {
        return tokenId;
    }

    public String getCompartmentId() {
        return compartment.getCompartmentId();
    }

}
