

<%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
        <link rel="stylesheet" href="css/header.css"/>
        <link
            rel="stylesheet"
            href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/6.4.0/css/all.min.css"
            integrity="sha512-iecdLmaskl7CVkqkXNQ/ZH/XLlvWZOJyj7Yy7tcenmpD1ypASozpmT/E0iPtmFIB46ZmdtAc9eNBvH0H/ZpiBw=="
            crossorigin="anonymous"
            referrerpolicy="no-referrer"
            />
    </head>
    <body>
        <header>
            <div class="header__cont">
                <a class="col-md-2 text-left title" href="welcome_member.jsp">
                    <span class="title-vh" >VH</span>
                    <span class="title-express"> Express</span>
                </a>
                <!--<nav class="header__cont-nav">
                    <a href="home.jsp" class="nav-item">Home</a>
                    <a href="search.jsp" class="nav-item">Search</a>
                    <a href="hotels" class="nav-item">List</a>
                <c:if test="${role=='owner'}">
                    <a href="add.jsp" class="nav-item">Add</a>
                </c:if>
                </nav>-->
                <div class="header__cont-user">
                    <i class="fa-solid fa-bars"></i>
                    <div class="role-name">${cur_name}</div>
                    <div class="user-info">
                        <c:if test="${authority=='ROLE_MEMBER'}">
                            <a href="editprofile?msg=''" class="user-info-item">Edit profile</a>
                            <a href="listhistory" class="user-info-item">List History</a>
                        </c:if>
                        <a href="login" class="user-info-item">Log out</a>
                    </div>
                </div>
            </div>
        </header>
    </body>
</html>
