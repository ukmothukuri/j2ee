package in.cdac.dbops;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.query.Query;

import in.cdac.HibernateUtil;
import in.cdac.dao.User;

public class UserDAO {
    
    SessionFactory sf = null;
    Session session = null;
    Transaction trans = null;

    public boolean saveUserDetails(User user){  
        boolean status = false;      
        try{
            sf = HibernateUtil.getSessionFactory();
            session = sf.openSession();
            trans = session.beginTransaction();
            session.persist(user);
            trans.commit();        
            if(session != null){
                session.close();
            }
            status = true;
        }
        catch(Exception ee){
            ee.printStackTrace();
            status = false;
        }   
        return status;
    }


    public List<User> getAllUserDetails(){
        List<User> usersList = null;
        try {
            sf = HibernateUtil.getSessionFactory();
            session = sf.openSession();
            Query qry = session.createQuery("from User", User.class);
            usersList = qry.list();           

            if(session != null){
                session.close();
            }
        } catch(Exception ee){
            ee.printStackTrace();           
        }  
        return usersList;
    }


    public User getSelectedUserDetails(String email){
        User user = null;
         try {
            sf = HibernateUtil.getSessionFactory();
            session = sf.openSession();            
            user = session.get(User.class, email);           

            if(session != null){
                session.close();
            }
        } catch(Exception ee){
            ee.printStackTrace();           
        }  
        return user;
    }

    public boolean updateUserDetails(User user){
        boolean status = false;      
        try{
            sf = HibernateUtil.getSessionFactory();
            session = sf.openSession();
            trans = session.beginTransaction();

            session.update(user);

            trans.commit();        
            if(session != null){
                session.close();
            }
            status = true;
        }
        catch(Exception ee){
            ee.printStackTrace();
            status = false;
            trans.rollback();
        }   
        return status;
    }

    public boolean deleteUserDetails(User user){
         boolean status = false;      
        try{
            sf = HibernateUtil.getSessionFactory();
            session = sf.openSession();
            trans = session.beginTransaction();

            session.delete(user);

            trans.commit();        
            if(session != null){
                session.close();
            }
            status = true;
        }
        catch(Exception ee){
            ee.printStackTrace();
            status = false;
            trans.rollback();
        }   
        return status;
    }
}
