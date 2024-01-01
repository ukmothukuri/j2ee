package in.cdac;

import java.util.ArrayList;
import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;

import in.cdac.dao.Address;
import in.cdac.dao.Product;
import in.cdac.dao.User;
import in.cdac.dbops.AddressDAO;
import in.cdac.dbops.ProductDAO;
import in.cdac.dbops.UserDAO;

/**
 * Hello world!
 *
 */
public class App 
{
    public static void main( String[] args )
    {    
      testOnetoManyMapping();
    }


    public static void testOnetoManyMapping(){
         // Product pd3 = new Product();
         // pd3.setProductName("Hp Keyboard");
         // pd3.setProductPrice(650.0);
         // pd3.setProductDescription("Its a querty keyboard");

         // Product pd4 = new Product();
         // pd4.setProductName("Logitech Mouse");
         // pd4.setProductPrice(250.0);
         // pd4.setProductDescription("Its a mouse");

           ProductDAO pdao = new ProductDAO();
        UserDAO userDAO =  new UserDAO();
         //  pdao.saveProductDetails(pd3);
         //  pdao.saveProductDetails(pd4);
         
           Product pd3 = pdao.getSelectedProductDetails(1);
           Product pd4 = pdao.getSelectedProductDetails(2);

          User user1 = userDAO.getSelectedUserDetails("Harsh@cdac.in");
          pd3.setUser(user1);
          pd4.setUser(user1);

          pdao.updateProductDetails(pd3);
          pdao.updateProductDetails(pd4);

         // List list = new ArrayList<>();
         // list.add(pd3);
         // list.add(pd4);

         // User user1 = new User();
         // user1.setUserEmail("Harsh@cdac.in");
         // user1.setUserName("Harsh Kumar");
         // user1.setUserMobile("9222012426");
         // user1.setUserPassword("harsh@123");
         // user1.setProducts(list);

         // userDAO.saveUserDetails(user1);
    }

    public void testOnetoOneMapping(){
       User user1 = new User();
       user1.setUserEmail("Ramesh@cdac.in");
       user1.setUserName("Ramesh Kumar");
       user1.setUserMobile("9222012426");
       user1.setUserPassword("ramesh@123");

       Address ads = new Address();
       ads.setSteetName("Street No-3");       
       ads.setLocality("Hardware Park-3");
       ads.setCity("Hyderabad");
       ads.setState("Telangana");
       ads.setPincode(500005);
       //AddressDAO adsDAO = new AddressDAO(); // used in unidirectional mapping
       //adsDAO.saveAddressDetails(ads);

       user1.setAddress(ads); // used in biderctional mapping

       boolean status = false;
       UserDAO userDAO = new UserDAO();
       

      status = userDAO.saveUserDetails(user1);
      System.out.println(status+" Insertion status for user "+user1.getUserName());

      //  User user2 = userDAO.getSelectedUserDetails("Rajesh@cdac.in");
      //  System.out.println(user2.getUserName());
      //  System.out.println(user2.getAddress().getSteetName());
    }
}
