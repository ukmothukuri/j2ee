<%@ include file="Header.jsp" %>
<%@ page import="in.cdac.dao.Product, java.util.ArrayList" %>


        <link href="<%=request.getContextPath()%>/css/mycss.css" rel="stylesheet">

        <div style="height: 300px;float:right">
            Hi..<%= session.getAttribute("email")%> |
                <a href="<%=request.getContextPath()%>/logout">Logout</a>
        </div>
        <br>
        <% ArrayList<Product> products = null;
            if(request.getAttribute("products") != null){
            products = (ArrayList<Product>)request.getAttribute("products");
                }
                %>

                <br>
                <br>
                <center>
                    <h4>List of products:</h4>
                    <br>
                    <table>
                        <tr>
                            <th>Product ID </th>
                            <th>Product Name</th>
                            <th>Product Price</th>
                        </tr>

                        <% for(Product pd : products){ %>
                            <tr>
                                <td>
                                    <%=pd.getProductID()%>
                                </td>
                                <td>
                                    <%=pd.getProductName()%>
                                </td>
                                <td>
                                    <%out.print(pd.getProductPrice());%>
                                </td>
                            </tr>
                            <% } %>
                    </table>
                </center>
                <br>

                <%@ include file="Footer.jsp" %>