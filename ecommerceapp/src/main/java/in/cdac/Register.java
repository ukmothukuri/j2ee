package in.cdac;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.Enumeration;

import javax.servlet.ServletConfig;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class Register extends HttpServlet {

    private String dbConnector = null;
    private String ipaddress = null;
    private ServletConfig sconfig;

    public void init(ServletConfig config) throws ServletException {
        System.out.println("Serlvet  initialized.....");    
        dbConnector = config.getInitParameter("dbconnector");
        ipaddress = config.getInitParameter("dbipaddress");

        sconfig = config;
    }

    // public void doGet(HttpServletRequest req, HttpServletResponse resp)
    //     throws ServletException, IOException
    // {
    //     System.out.println("This is DoGet method");
    // }

    public void doPost(HttpServletRequest req, HttpServletResponse resp)
        throws ServletException, IOException
    {
        PrintWriter out = resp.getWriter();
        String username;
        String useremail;
        String usermobile;
        String userpassword;

        // String username = req.getParameter("username");
        // String useremail = req.getParameter("useremail");
        // String usermobile = req.getParameter("usermobile");
        // String userpassword = req.getParameter("userpwd");


        Enumeration parameters = req.getParameterNames();
        while(parameters.hasMoreElements()){
            String fieldName = (String)parameters.nextElement();
            String[] fieldValues = req.getParameterValues(fieldName);
            for(String value : fieldValues){
                System.out.println(fieldName+"==="+value);                            
            }
        }

        System.out.println("SConfig -  DB Connector used is :"+dbConnector);
        System.out.println("SConfig - DB IP Address is :"+ipaddress);


        ServletContext ctx = sconfig.getServletContext();
        System.out.println("SContext -  DB Connector used is :"+ctx.getInitParameter("dbconnector"));


        // out.println("Registration is successful for the user "+username); 
        // out.println("Your Email :"+useremail);       
        // out.println("Your Mobile :"+usermobile);
    }

    public void destroy() {

        System.out.println("Servlet Destroyed....");
    }
}
