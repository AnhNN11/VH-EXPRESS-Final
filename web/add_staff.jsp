<%-- 
    Document   : add_staff
    Created on : Oct 4, 2023, 5:15:04 AM
    Author     : tuna
--%>

<%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
        <link rel="stylesheet" href="css/add_staff.css"/>

        <link
            rel="stylesheet"
            href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/6.4.0/css/all.min.css"
            integrity="sha512-iecdLmaskl7CVkqkXNQ/ZH/XLlvWZOJyj7Yy7tcenmpD1ypASozpmT/E0iPtmFIB46ZmdtAc9eNBvH0H/ZpiBw=="
            crossorigin="anonymous"
            referrerpolicy="no-referrer"
            />
        <style>
            :root {
                --primary: #20c997;
                --secondary: #E0E0E0;
                --light: #befff7;
                --dark: #419197;
                --font-family-sans-serif: -apple-system, BlinkMacSystemFont, "Segoe UI", Roboto, "Helvetica Neue", Arial, "Noto Sans", sans-serif, "Apple Color Emoji", "Segoe UI Emoji", "Segoe UI Symbol", "Noto Color Emoji";
            }
            *{
                font-family: sans-serif;
            }

            .body{
                display: flex;
                flex-direction: column;
                justify-content: center;
                align-items: center;
            }
            .title-page{
                color: white;
            }

            .form-box{
                margin-top: 100px;
                width: 50%;
                height: auto;
                display: flex;
                flex-direction: column;
                background-color: #419197;
                border-radius: 20px;
                box-shadow: 10px 10px 50px grey;
            }

            .form-items{
                margin-top: 10px;
                width: 70%;
                /*height:50px;*/
                display: flex;
                flex-direction: column;
                /*background-color: #befff7;*/
                font-size: 16px;
                color: white;
                gap: 10px;
            }

            .double-form-items{
                display: flex;
                width: 70%;
                justify-content: space-between;
                gap: 20px;

            }

            .double-form-items div{
                width: 50%;
            }

            .form-items-select{
                font-size: 16px;
                color: white;
                gap: 20px;
            }


            input{
                padding: 5px 20px;
                font-size: 16px;
                border: none;
                background-color: #419197;
                border-bottom: solid 1px white;
                color: white;
            }

            .button-form{
                margin:20px 0px;
                padding: 10px;
                color: #419197;
                background-color: white;
                border-radius: 10px;
                border: none;
            }

            .button-form:hover {
                background-color: #20c997;
                color: white;
            }

            .form-items-select select{
                padding: 5px;
                border-radius: 10px;
            }

        </style>
    </head>
    <body>
        <%@ include file="/include/header.jsp" %>
        <%@ include file="/include/sidebar.jsp" %>
        <div class="body">
            <form action="addStaff" method="POST" class="form-box">
                <div class="title-page">
                    Create Staff and Driver
                </div>
                <div class="form-items">
                    <label for="fullname">Name: </label>
                    <input type="text" id="fullname" name="fullname" required>
                </div>

                <div class="double-form-items">
                    <div class="form-items-select">
                        <label for="authority">Authority : </label>
                        <select name="authority" id="authority">
                            <option value="ROLE_STAFF">STAFF</option>
                            <option value="ROLE_ADMIN">ADMIN</option> 
                            <option value="ROLE_DRIVER">DRIVER</option>
                        </select>
                    </div>
                    <div class="form-items-select">
                        <label for="gender">Gender:</label>
                        <select name="gender" id="gender">
                            <option value="female">Female</option>
                            <option value="male">Male</option>
                            <option value="others">Others</option>
                        </select>
                    </div>
                </div>

                <div class="form-items">
                    <label for="email">Email : </label>
                    <input type="email" id="email" name="email" required>
                </div>
                <div class="double-form-items">
                    <div class="form-items">
                        <label for="phone">Phone : </label>
                        <input type="text" id="phone" name="phone" required>
                    </div>
                    <div class="form-items">
                        <label for="age">Age : </label>
                        <input type="text" id="age" name="age" required>
                    </div>
                </div>
                <div class="form-items">
                    <label for="address">Adress : </label>
                    <input type="text" id="address" name="address" required>
                </div>
                <input class="button-form" type="submit" value="Add Staff">
            </form>
        </div>
    </body>
</html>