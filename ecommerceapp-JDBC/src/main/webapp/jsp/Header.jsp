<div>
    <a href="<%=request.getContextPath()%>/jsp/Home.jsp">Home</a> | 
    <a href="#">About us</a> | 
    <a href="<%=request.getContextPath()%>/jsp/Contact.jsp">Contact us</a>
    <br>
    <% if(session == null || session.getAttribute("email") == null)
     {
    %>
    <div style="float:right">
        <a href="<%=request.getContextPath()%>/jsp/Login.jsp">Login</a> | 
        <a href="<%=request.getContextPath()%>/jsp/Register.jsp">Register</a>
    </div>
    <br>
    <hr>
    <% } %>
</div>