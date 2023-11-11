<%-- 
    Document   : welcome
    Created on : Oct 1, 2023, 10:27:19 PM
    Author     : ADMIN
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>

<%
    session = request.getSession();
    String email = "";
    
    if (session.getAttribute("session_user")==null || session.getAttribute("session_user")=="" ||session.getAttribute("session_user").equals("")) {
        response.sendRedirect("login");
            
    }else{
        email = session.getAttribute("session_user").toString();
    }
%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
    <body>
        <h1>Welcome to VHExpress Home Pages</h1>
        <h3>Hello...<%=email%></h3>
        
        <a href="logout.jsp">Logout</a>
    </body>
</html>
