<%-- 
    Document   : welcome_staff
    Created on : Nov 3, 2023, 3:30:04 AM
    Author     : tuna
--%>

<%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
        <style>
            :root {
                --primary: #20c997;
                --secondary: #E0E0E0;
                --light: #befff7;
                --dark: #419197;
                --font-family-sans-serif: -apple-system, BlinkMacSystemFont, "Segoe UI", Roboto, "Helvetica Neue", Arial, "Noto Sans", sans-serif, "Apple Color Emoji", "Segoe UI Emoji", "Segoe UI Symbol", "Noto Color Emoji";
            }
            .body{
                padding-top: 100px;
                margin-left:20%;
                width: 80%;
                height: 100%;
                background-color: white;
                text-align: center;
                color: var(--primary);
                font-size: 24px;
            }
            
        </style>
    </head>
    <body>
        <%@ include file="/include/header.jsp" %>
        <%@ include file="/include/sidebar.jsp" %>
        <div class="body">
            <h1>Welcome Staff</h1>
        </div>
    </body>
</html>
