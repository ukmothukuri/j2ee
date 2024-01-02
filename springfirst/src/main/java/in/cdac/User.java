package in.cdac;

public class User {

    private String name;
    private String email;
    private Address ads;

     
// Constructor based DI
    // public User(String name, String email, Address address){
    //     this.name = name;
    //     this.email = email;
    //     ads = address;
    // }

    // public User(Address address){
    //     ads = address;
    // }

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

    public Address getAds() {
        return ads;
    }


    // Setter based DI
    public void setAds(Address ads) {
        this.ads = ads;
    }
    
}
