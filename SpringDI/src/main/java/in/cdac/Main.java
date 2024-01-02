package in.cdac;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class Main {
    public static void main(String[] args) {
        ApplicationContext apcon = new ClassPathXmlApplicationContext("applicationContext.xml");
        User user = (User)apcon.getBean(User.class);
        System.out.println(""+user);
        System.out.println(""+user.getAds());

    }
}