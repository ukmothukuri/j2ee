package in.cdac;

import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

public class HibernateUtil 
{
    private static SessionFactory sessionFactory;

    static{
        try{        
            sessionFactory = new Configuration().configure().buildSessionFactory();
        }catch(Exception ee){
            ee.printStackTrace();
        }
    }

    public static SessionFactory getSessionFactory(){
        return sessionFactory;
    }
    
}
