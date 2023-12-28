package in.cdac.dao;

public class User {
    
    public User(){}

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
    public String getUserpassword() {
        return userpassword;
    }
    public void setUserpassword(String userpassword) {
        this.userpassword = userpassword;
    }
    public int getUserinterests() {
        return userinterests;
    }
    public void setUserinterests(int userinterests) {
        this.userinterests = userinterests;
    }
    public String getUsermobile() {
        return usermobile;
    }
    public void setUsermobile(String usermobile) {
        this.usermobile = usermobile;
    }

    private String useremail;
    private String username;
    private String userpassword;
    private int userinterests;
    private String usermobile;

    
}
