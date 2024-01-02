package in.cdac;

import org.springframework.beans.factory.BeanFactory;
import org.springframework.beans.factory.xml.XmlBeanFactory;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.core.io.ClassPathResource;
import org.springframework.core.io.Resource;

public class Main {
    public static void main(String[] args) {
        
        //initializeBeanFactory();
        initializeApplicationContext();   
    }

    public static void initializeApplicationContext(){
         ApplicationContext appContext = new ClassPathXmlApplicationContext("applicationContext.xml");
         User u1 = (User)appContext.getBean("user1");   
         System.out.println(u1);
         System.out.println(u1.getName()+"=="+u1.getEmail());
         System.out.println(u1.getAds().getStreetName());

        //  u1 = (User)appContext.getBean("user1");   
        //  System.out.println(u1);
        //  System.out.println(u1.getName()+"=="+u1.getEmail());
        //  System.out.println(u1.getAds().getStreetName());
         
    }


    public static void initializeBeanFactory(){
        Resource rs = new ClassPathResource("applicationContext.xml");
        BeanFactory bfactory = new XmlBeanFactory(rs);

        User u1 = (User) bfactory.getBean("user1");
        System.out.println(u1);

        u1 = (User) bfactory.getBean("user1");
        System.out.println(u1);
       // System.out.println(u1.getName()+"=="+u1.getEmail());
        // u1.setName("Rajesh");
        // u1.setEmail("Rajesh@cdac.in");
        // //System.out.println(u1.getName()+"=="+u1.getEmail());   
    }
}