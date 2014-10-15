<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Registration</title>
<style type="text/css">
.error {
    color: red;
		}
</style>
</head>
<body>
 <form:form method="POST" commandName="userProfile" action="saveDetails">
        <table>
            <tr>
                <td>UserName:</td>
                <td><form:input path="userName" /></td>
                <td><form:errors path="userName" cssClass="error" /></td>
            </tr>
            <tr>
                <td>Password:</td>
                <td><form:input path="password" /></td>
                <td><form:errors path="password" cssClass="error" /></td>
            </tr>
            <tr>
                <td>Confirm Password:</td>
                <td><form:input path="confirmPassword" /></td>
                <td><form:errors path="confirmPassword" cssClass="error" /></td>
            </tr>
            <tr>
                <td>FirstName:</td>
                <td><form:input path="firstName" /></td>
                <td><form:errors path="firstName" cssClass="error" /></td>
            </tr>
            <tr>
                <td>LastName:</td>
                <td><form:input path="lastName" /></td>
                <td><form:errors path="lastName" cssClass="error" /></td>
            </tr>
            <tr>
                <td>Email:</td>
                <td><form:input path="email" /></td>
                <td><form:errors path="email" cssClass="error" /></td>
            </tr>
            
            <tr>
                <td>Gender:</td>
                <td><form:select path="gender">
                        <form:option value="" label="Select Gender" />
                        <form:option value="MALE" label="Male" />
                        <form:option value="FEMALE" label="Female" />
                    </form:select></td>
                <td><form:errors path="gender" cssClass="error" /></td>
            </tr>
            <tr>
                <td>Birthday:</td>
                <td><form:input path="dateOfBirth" placeholder="MM/dd/yyyy"/></td>
                <td><form:errors path="dateOfBirth" cssClass="error" /></td>
            </tr>
            <tr>
                <td>Phone:</td>
                <td><form:input path="phoneNo" /></td>
                <td><form:errors path="phoneNo" cssClass="error" /></td>
            </tr>
            <tr>
                <td colspan="3"><input type="submit" value="Register"></td>
            </tr>
        </table>
 
    </form:form>
</body>
</html>