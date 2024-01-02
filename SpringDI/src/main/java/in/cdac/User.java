package in.cdac;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;

public class User {

    private String name;    
    private String email;

    @Autowired   
    //@Qualifier("address2")
    private Address ads;

    public Address getAds() {
        return ads;
    }

    public String getName() {
        return name;
    }
    public void setName(String name) {
        this.name = name;
    }
    public String getEmail() {
        return email;
    }
    public void setEmail(String email) {
        this.email = email;
    }   
}
