<%@ include file="Header.jsp" %>

<div style="height: 300px;float:right">
    Hi..<%= session.getAttribute("email")%> | 
    <a href="<%=request.getContextPath()%>/logout">Logout</a>
</div>
<br>

<%@ include file="Footer.jsp" %>