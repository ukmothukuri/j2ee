package in.cdac.dbops;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;

import in.cdac.HibernateUtil;
import in.cdac.dao.Address;
import in.cdac.dao.User;

public class AddressDAO {
    SessionFactory sf = null;
    Session session = null;
    Transaction trans = null;

    public boolean saveAddressDetails(Address address){  
        boolean status = false;      
        try{
            sf = HibernateUtil.getSessionFactory();
            session = sf.openSession();
            trans = session.beginTransaction();
            int addressID= (Integer)session.save(address);
            trans.commit();        
            if(session != null){
                session.close();
            }
            System.out.println("Here is the address ID "+addressID);
            status = true;
        }
        catch(Exception ee){
            ee.printStackTrace();
            status = false;
        }   
        return status;
    }
}
