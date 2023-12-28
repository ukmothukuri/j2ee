package in.cdac.dbops;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

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
        }
        return false;
    }

    public void getAllProductDetails(){

    }

    public void getSelectedProductDetails(int productID){

    }


}
