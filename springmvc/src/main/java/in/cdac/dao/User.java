package in.cdac.dao;
import jakarta.validation.constraints.Pattern;
import  jakarta.validation.constraints.Size;

public class User {

    private String useremail;
    //@Size(min=3, max=50, message="Minimum 1 character and max 50 characters are allowed")    
    @Pattern(regexp = "^[a-zA-Z]{3}", message = "Minimum 3 characters")
    private String username;
    private String usermobile;
    private String userpassword;
    
    public String getUseremail() {
        return useremail;
    }
    public void setUseremail(String useremail) {
        this.useremail = useremail;
    }
    public String getUsername() {
        return username;
    }
    public void setUsername(String username) {
        this.username = username;
    }
    public String getUsermobile() {
        return usermobile;
    }
    public void setUsermobile(String usermobile) {
        this.usermobile = usermobile;
    }
    public String getUserpassword() {
        return userpassword;
    }
    public void setUserpassword(String userpassword) {
        this.userpassword = userpassword;
    }
}
