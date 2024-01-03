package in.cdac;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class Main {
    public static void main(String[] args) {
        
        ApplicationContext context = new ClassPathXmlApplicationContext("applicationContext.xml");
        // User u = (User)context.getBean("userObj");
        // u.setUsername("Vikram");
        // u.setUseremail("vikram@cdac.in");
        // u.setUsermobile("2312398712");
        // u.setUserpassword("ck@123");

        DBOperations dbOperations = (DBOperations)context.getBean("dbops");
        //dbOperations.insertUserDetails(u);
        //dbOperations.getAllStudents();
        dbOperations.getStudentByEmail("naveen@cdac.in");



    }
}