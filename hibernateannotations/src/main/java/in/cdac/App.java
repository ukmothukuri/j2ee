package in.cdac;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;

import in.cdac.dao.User;
import in.cdac.dbops.UserDAO;

/**
 * Hello world!
 *
 */
public class App 
{
    public static void main( String[] args )
    {    

       User user1 = new User();
       user1.setUserEmail("praveen@cdac.in");
       user1.setUserName("Praveen Kumar");
       user1.setUserMobile("9222012346");
       user1.setUserPassword("praveen@123");

       User user2 = new User();
       user2.setUserEmail("kiran@cdac.in");
       user2.setUserName("kiran Kumar");
       user2.setUserMobile("8222012345");
       user2.setUserPassword("kiran@1234");

       boolean status = false;
       UserDAO userDAO = new UserDAO();
    //    status = userDAO.saveUserDetails(user1);
    //    System.out.println(status+" Insertion status for user "+user1.getUserName());
    //    status = userDAO.saveUserDetails(user2);
    //    System.out.println(status+" Insertion status for user "+user2.getUserName());

    //     List<User> users = userDAO.getAllUserDetails();
    //     System.out.println(users);

        User user3 = userDAO.getSelectedUserDetails("kiran@cdac.in");
        //System.out.println(user3.getUserName());

        status = userDAO.deleteUserDetails(user3);
        System.out.println(user3.getUserEmail()+" is deleted? "+status);
    }
}
