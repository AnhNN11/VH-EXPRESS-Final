<%-- 
    Document   : add_car_route
    Created on : Oct 4, 2023, 5:21:40 AM
    Author     : tuna
--%>
<jsp:useBean class="model.repository.CarRepository" id="showcar"></jsp:useBean>
<jsp:useBean class="model.repository.UserRepository" id="showuser"></jsp:useBean>
<jsp:useBean class="model.repository.LocationRepository" id="show1"></jsp:useBean>

<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta charset="UTF-8" http-equiv="Content-Type" content="text/html; charset=UTF-8">
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

            .body{
                display: flex;
                flex-direction: column;
                justify-content: center;
                align-items: center;
            }

            .title-page{
                color: white;
                margin-bottom: 20px;
            }

            .form-box{
                margin-top: 100px;
                width: 70%;
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
                /*                width: 40%;
                                display: flex;
                                justify-content: start;*/
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
            <form action="addcarroute" method="POST" class="form-box">
                <div class="title-page">
                    Add New Car Route
                </div>
                <div class="double-form-items">
                    <div class="form-items-select">
                        <label for="types">Xe:</label>
                        <select name="car_id" id="car_id">
                            <c:forEach var="car" items="${showcar.getListCars()}">
                                <option value="${car.id}">${car.name}</option>
                            </c:forEach>
                        </select>
                    </div>
                    <div class="form-items-select">
                        <label for="types">Tài xế:</label>
                        <select name="driver_id" id="driver_id">
                            <c:forEach var="user" items="${showuser.getListDriver()}">
                                <option value="${user.id}">${user.fullname}</option>
                            </c:forEach>
                        </select>
                    </div>
                </div>

                <div class="double-form-items">
                    <div class="form-items-select">
                        <label for="from">Điểm đi:</label>
                        <select name="from" id="from">
                            <c:forEach var="location" items="${show1.listLocations}">
                                <option value="${location.id}">${location.province}</option>
                            </c:forEach>
                        </select>
                    </div>
                    <div class="form-items-select">
                        <label for="to">Điểm đến:</label>
                        <select name="to" id="to">
                            <c:forEach var="location" items="${show1.listLocations}">
                                <option value="${location.id}">${location.province}</option>
                            </c:forEach>
                        </select>
                    </div>
                </div>

                <div class="double-form-items">
                    <div class="form-items-select">
                        <label for="price">Giá Vé:</label>
                        <input type="text" id="price" name="price" required>
                    </div>
                    <div class="form-items-select">
                        <label for="datestart">Ngày Khởi Hành:</label>
                        <input name="datestart" class="form-control col-sm-12" type="date" required min="<%= new java.text.SimpleDateFormat("yyyy-MM-dd").format(new java.util.Date())%>">
                    </div>
                </div>

                <div class="double-form-items">
                    <div class="form-items-select">
                        <label for="start">Giờ Khởi Hành:</label>
                        <select name="start" id="start">
                            <% for (int hour = 0; hour < 24; hour++) { %>
                            <% for (int minute = 0; minute < 60; minute += 60) {%>
                            <option value="<%= String.format("%02d:%02d", hour, minute)%>">
                                <%= String.format("%02d:%02d %s", hour % 12 == 0 ? 12 : hour % 12, minute, hour < 12 ? "AM" : "PM")%>
                            </option>
                            <% } %>
                            <% }%>
                        </select>
                    </div>
                    <div class="form-items-select">
                        <label for="end">Giờ Đến:</label>
                        <select name="end" id="end">
                            <% for (int hour = 0; hour < 24; hour++) { %>
                            <% for (int minute = 0; minute < 60; minute += 60) {%>
                            <option value="<%= String.format("%02d:%02d", hour, minute)%>">
                                <%= String.format("%02d:%02d %s", hour % 12 == 0 ? 12 : hour % 12, minute, hour < 12 ? "AM" : "PM")%>
                            </option>
                            <% } %>
                            <% }%>
                        </select>
                    </div>
                </div>
                <input class="button-form" type="submit" value="Thêm Tuyến Đường">
            </form>
        </div>
    </body>
</html>
