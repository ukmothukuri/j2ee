<div>
    <a href="Home.jsp">Home</a> | 
    <a href="#">About us</a> | 
    <a href="#">Contact us</a>
    <br>
    <% if(session == null || session.getAttribute("email") == null)
     {
    %>
    <div style="float:right">
        <a href="Login.jsp">Login</a> | 
        <a href="Register.jsp">Register</a>
    </div>
    <br>
    <hr>
    <% } %>
</div>