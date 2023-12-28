<%@ include file="Header.jsp" %>


<%
 String errorMsg = "";
 if(request.getAttribute("errormsg") != null){
    errorMsg = (String) request.getAttribute("errormsg");
 }

%>
<html>
    <head>
        <title>ECommerce Portal</title>
        <link href="<%=request.getContextPath()%>/css/mycss.css" rel="stylesheet"> 
        <script src="<%=request.getContextPath()%>/js/myscripts.js"></script>
    </head>
    <body>
        <div style="height: 600px;">
            <center>
                <form method="post" action="<%=request.getContextPath()%>/login">                    
                    <br>EMail: <input type="email" id="useremail" name="useremail" placeholder="Enter your email" />
                    <br>Password: <input type="password" id="userpwd" name="userpwd" placeholder="Enter your password"/>                    
                    <br>
                    <p style="color: red;"><%=errorMsg%></p>
                    <input type="submit" value="Login" />
                </form>
            </center>
        </div>
    </body>
</html>
<%@ include file="Footer.jsp" %>