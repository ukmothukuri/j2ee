package in.cdac.dbops;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;

import in.cdac.HibernateUtil;
import in.cdac.dao.Product;
import in.cdac.dao.User;

public class ProductDAO {
    SessionFactory sf = null;
    Session session = null;
    Transaction trans = null;

    public boolean saveProductDetails(Product prd){  
        boolean status = false;      
        try{
            sf = HibernateUtil.getSessionFactory();
            session = sf.openSession();
            trans = session.beginTransaction();
            int prdID= (Integer)session.save(prd);
            trans.commit();        
            if(session != null){
                session.close();
            }
            System.out.println("Here is the product ID "+prdID);
            status = true;
        }
        catch(Exception ee){
            ee.printStackTrace();
            status = false;
        }   
        return status;
    }


    public Product getSelectedProductDetails(int productID){
        Product prd = null;
         try {
            sf = HibernateUtil.getSessionFactory();
            session = sf.openSession();            
            prd = session.get(Product.class, productID);           

            if(session != null){
                session.close();
            }
        } catch(Exception ee){
            ee.printStackTrace();           
        }  
        return prd;
    }

    public boolean updateProductDetails(Product prd){
        boolean status = false;      
        try{
            sf = HibernateUtil.getSessionFactory();
            session = sf.openSession();
            trans = session.beginTransaction();

            session.update(prd);

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
