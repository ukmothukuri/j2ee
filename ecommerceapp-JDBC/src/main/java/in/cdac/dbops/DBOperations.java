package in.cdac.dbops;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import in.cdac.dao.Product;
import in.cdac.dao.User;

public class DBOperations {
    Connection con = null;
    String query = null;
    PreparedStatement pstmt = null;

    public DBOperations(){
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            String url = "jdbc:mysql://localhost:3306/ecommerce";
            String uname = "root";
            String pwd = "root";
            con = DriverManager.getConnection(url, uname, pwd);
            if (con == null)
                System.out.println("Connection Failed");
            else
                System.out.println("Connection established");
        } catch (ClassNotFoundException cnf) {
            cnf.printStackTrace();
        } catch (SQLException sql) {
            sql.printStackTrace();
        }finally{
           closeConnection();     
        }
    }

    public boolean insertUserDetails(User user){
        query = "insert into userdetails values (?,?,?,?,?)";
        try {
            pstmt = con.prepareStatement(query);
            pstmt.setString(1, user.getUseremail());    
            pstmt.setString(2, user.getUsername());    
            pstmt.setString(3, user.getUserpassword());    
            pstmt.setInt(4, user.getUserinterests());    
            pstmt.setString(5, user.getUsermobile());    
            int rowsAffected = pstmt.executeUpdate();
            if(rowsAffected == 1){
                return true;
            }           
        }catch(SQLException sqe){
            sqe.printStackTrace();
        }finally{
           closeConnection();     
        }
        return false;
    }

    public boolean validateUserDetails(User user)
    {
        query = "select userpassword from userdetails where useremail=?";
        try{
            pstmt = con.prepareStatement(query);
            pstmt.setString(1, user.getUseremail());

            ResultSet rs = pstmt.executeQuery();
            if(rs.next()){
                String userPwd = rs.getString("userpassword");
                if(userPwd.equals(user.getUserpassword())){
                    return true;
                }
            }

        }catch(SQLException sqe){
            sqe.printStackTrace();
        }finally{
           closeConnection();     
        }
        return false;
    }

    public ArrayList<Product> getAllProductDetails(){
        query = "select * from products";
        ArrayList<Product> productsList = new ArrayList<>();
        try{
            pstmt = con.prepareStatement(query);           
            ResultSet rs = pstmt.executeQuery();
            while(rs.next())
            {
                Product pd = new Product();
                pd.setProductID(rs.getInt(1));
                pd.setProductName(rs.getString(2));
                pd.setProductPrice(rs.getInt(3));
                pd.setProductDesc(rs.getString(4));

                productsList.add(pd);
            }

        }catch(SQLException sqe){
            sqe.printStackTrace();
        }finally{
           closeConnection();     
        }
       return productsList;
    }

    public Product getSelectedProductDetails(int productID){
        query = "select * from products where productID=?";
        Product pd = null;
        try{
            pstmt = con.prepareStatement(query);    
            pstmt.setInt(1, productID);       
            ResultSet rs = pstmt.executeQuery();
            while(rs.next())
            {
                pd = new Product();
                pd.setProductID(rs.getInt(1));
                pd.setProductName(rs.getString(2));
                pd.setProductPrice(rs.getInt(3));
                pd.setProductDesc(rs.getString(4));                
            }

        }catch(SQLException sqe){
            sqe.printStackTrace();
        } finally{
           closeConnection();     
        }
       return pd;
    }

    public void closeConnection(){
        if(con != null){
            try{
                con.close();
            }catch(SQLException se){
                se.printStackTrace();
            }
            
        }
    }

}
