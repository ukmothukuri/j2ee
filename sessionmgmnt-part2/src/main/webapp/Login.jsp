<%@ page info="This is an index page" %>
<%@ page import="java.util.*" %>

<%
    ArrayList list = new ArrayList();
    String projectTitle = "ECommerce Portal";

    String errorMsg1 = "";
    String errorMsg2 = "";
    if(request.getAttribute("emailmsg") != null){
        errorMsg1 = (String) request.getAttribute("emailmsg");
    }
    if(request.getAttribute("pwdmsg") != null){
        errorMsg2 = (String) request.getAttribute("pwdmsg");
    }
%>

<html>
    <head>
        <title><%= projectTitle%></title>
        <link href="../css/mycss.css" rel="stylesheet"> 
        <script src="../js/myscripts.js"></script>
    </head>
    <body>
        <!-- Html comments. login section which takes the email and password with no encryption-->
        <%-- jsp comments... login section which takes the email and password with no encryption--%>
        <div>
            <center>
                <form method="post" action="./login">                                        
                    <br>EMail: <input type="email" id="useremail" name="useremail" placeholder="Enter your email" />
                    <p style="color: red;"> <%=errorMsg1 %> </p>
                    <br>Password: <input type="password" id="userpwd" name="userpwd" placeholder="Enter your password"/>                    
                    <p style="color: red;"> <%=errorMsg2 %></p>
                    <br>
                    <input type="submit" value="Login" />
                </form>
            </center>
        </div>
    </body>
</html>