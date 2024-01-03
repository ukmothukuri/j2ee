package in.cdac;

import java.util.List;

import org.springframework.jdbc.core.JdbcTemplate;

public class DBOperations {
    
    private JdbcTemplate jTemplate;

    public DBOperations(JdbcTemplate jTemplate){
        this.jTemplate = jTemplate;
    }
    // public void setjTemplate(JdbcTemplate jTemplate) {
    //     this.jTemplate = jTemplate;
    // }


    public int insertUserDetails(User user){
        String query = "insert into userdetails values (?,?,?,?,?)";
        int recordsinserted = jTemplate.update(query, user.getUseremail(), 
        user.getUsername(), user.getUserpassword(),0,user.getUsermobile());
        return recordsinserted;
    }

    public void getAllStudents(){
        String query = "select * from userdetails";
        List<User> userList = jTemplate.query(query, new UserResultMapper());
        for(User u : userList){
            System.out.println(u.getUsername());
        }
    }

    public void getStudentByEmail(String email){
         String query = "select * from userdetails where useremail=?";
         User user = jTemplate.queryForObject(query, new Object[]{email}, new UserResultMapper());   
         System.out.println(user.getUsername()+"==="+user.getUsermobile());
    }    
}
