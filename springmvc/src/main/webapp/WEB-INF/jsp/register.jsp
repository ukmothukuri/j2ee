<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>

    <html>
    <div>
        This is Register Page

        <form:form action="registerUser" method="post">
            <table>
                <tr>
                    <td>User Email:</td>
                    <td>
                        <form:input path="useremail" />
                    </td>
                </tr>
                <tr>
                    <td>User Name:</td>
                    <td>
                        <form:input path="username" />
                    </td>
                    <form:errors path="username"/>
                </tr>
                <tr>
                    <td>User Mobile:</td>
                    <td>
                        <form:input path="usermobile" />
                    </td>
                </tr>
                <tr>
                    <td>User Password:</td>
                    <td>
                        <form:input path="userpassword" />
                    </td>
                </tr>
                <tr>
                    <td colspan="2">
                        <input type="submit" value="Register" />
                    </td>
                </tr>
            </table>
        </form:form>
    </div>



    </html>