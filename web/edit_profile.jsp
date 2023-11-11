<%-- 
    Document   : edit_profile
    Created on : Oct 6, 2023, 12:55:20 AM
    Author     : tuna
--%>

<%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>

        <link
            rel="stylesheet"
            href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/6.4.0/css/all.min.css"
            integrity="sha512-iecdLmaskl7CVkqkXNQ/ZH/XLlvWZOJyj7Yy7tcenmpD1ypASozpmT/E0iPtmFIB46ZmdtAc9eNBvH0H/ZpiBw=="
            crossorigin="anonymous"
            referrerpolicy="no-referrer"
            />
        <link rel="stylesheet" href="css/edit_profile.css"/>
    </head>
    <body>
        <%@ include file="/include/header.jsp" %>
        <div class="body">
            <form action="editprofile" method="POST" class="form-box">
                <div class="title-page">
                    Edit your profile
                </div>
                <div class="form">
                    <div class="double-form">
                        <div class="single-form big-form">
                            <label>Name: </label>
                            <input type="text" name="fullname" value="${cur_user.fullname}"/>
                        </div>
                        <div class="single-form small-form">
                            <label>Gender: </label>
                            <select name="gender">
                                <option value='${cur_user.gender}'>${cur_user.gender}</option>
                                <option value="MALE">MALE</option>
                                <option value="FEMALE">FEMALE</option>
                                <option value="OTHERS">OTHERS</option>
                            </select>
                        </div>
                    </div>

                    <div class="double-form">
                        <div class="single-form big-form">
                            <label>Phone: </label>
                            <input type="text" name="phone" value="${cur_user.phone}"/>
                        </div>
                        <div class="single-form small-form">
                            <label>Age: </label>
                            <input type="text" name="age" value="${cur_user.age}"/>
                        </div>
                    </div>
                    <div class="single-form">
                        <label>Address: </label>
                        <input type="text" name="address" value="${cur_user.address}"/>
                    </div>
                    <button class="form-button" type="submit"> Update profile</button> 
                    <div class="message">${msgEditProfile}</div>
                </div>
            </form>
        </div>
    </body>
</html>
