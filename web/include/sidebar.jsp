<%-- 
    Document   : sidebar
    Created on : Oct 4, 2023, 1:05:26 AM
    Author     : tuna
--%>

<%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
    <head>
        <link rel="stylesheet" href="css/sidebar.css"/>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
    <body>
        <div class="sidebar">
            <div class="items">
                <c:if test="${authority=='ROLE_MEMBER'}">
                    <a href="list_carroute.jsp" class=""> Car Route List</a>         
                    <a href="ticket_member.jsp" class=""> Ticket</a>
                </c:if>
                <c:if test="${authority=='ROLE_ADMIN'}">
                    <a href="listuser" class="">List Staff/Driver</a>
                    <a href="add_staff.jsp" class="">Create Staff/Driver</a>
                </c:if>
                <c:if test="${authority=='ROLE_STAFF'}">
                    <a href="addcarroute" class="">Create Car Route</a>
                    <a href="addcar" class="">Add New Car</a>
                    <a href="listcarroute" class=""> Car Route List</a>
                    <a href="listcar" class="">List car</a>

                </c:if>
                <c:if test="${authority=='ROLE_MEMBER'}">

                </c:if>
            </div>
        </div>
    </body>
</html>
