<%@ include file="Header.jsp" %>
<html>
    <head>
        <title>ECommerce Portal</title>
        <link href="<%=request.getContextPath()%>/css/mycss.css" rel="stylesheet"> 
        <script src="<%=request.getContextPath()%>/js/myscripts.js"></script>
    </head>
    <body>
        <div style="height: 600px;">
            <center>
                <form method="post" action="<%=request.getContextPath()%>/registration">
                    UserName: <input type="text" id="username" name="username" placeholder="Enter your name" />
                    <br>EMail: <input type="email" id="useremail" name="useremail" placeholder="Enter your email" />
                    <br>Mobile: <input type="text" id="usermobile" name="usermobile" placeholder="Enter your mobile" />
                    <br><hr>
                    Password: <input type="password" id="userpwd" name="userpwd" placeholder="Enter your password"/>
                    <br>Confirm Password: <input type="password" id="userconfirmpwd" placeholder="Enter your confirm password"/>
                    <br>  <br>
                    Interested in: <select id="userinterests" name="userinterests" multiple>
                        <option value="-1">Select</option>
                        <option value="0">Electronics</option>
                        <option value="1">Grossory</option>
                        <option value="2">Home appliances</option>                        
                    </select>
                    <br>

                    <input type="submit" value="Register" />
                </form>
            </center>
        </div>
    </body>
</html>
<%@ include file="Footer.jsp" %>