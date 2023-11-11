<%-- 
    Document   : payment
    Created on : Oct 17, 2023, 2:14:04 AM
    Author     : tuna
--%>

<%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<jsp:useBean class="model.repository.LocationRepository" id="show1"></jsp:useBean>
<jsp:useBean class="model.repository.CarRepository" id="showcar"></jsp:useBean>
<jsp:useBean class="model.repository.SeatRepository" id="show2"></jsp:useBean>
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
                *{
                    font-family: sans-serif;
                }
                html,body{
                    width: 100%;
                    height:100%;
                }
                .body{
                    /*background-color: #00C6FF;*/
                    margin-top: 80px;
                    width: 100%;
                    display: flex;
                    flex-direction: column;
                    align-items: center;
                }

                .form{
                    margin: 10px;
                    width:90%;
                    background-color: #419197;
                    display: flex;
                    flex-direction: column;
                    align-items: center;
                    border-radius: 10px;
                    color: white;
                }

                table{
                    margin:10px;
                }

                .title{
                    padding: 10px;
                    font-size: 24px;
                }
                .head-row{
                    background-color: lightblue;
                }
                .text-head{
                    padding: 5px;
                    text-align: center;
                    color: var(--dark);
                }

                .information-column{
                    width: 40%;
                    padding: 10px;
                }
                .price-column{
                    text-align: center;
                }

                .info-route-column{
                    display: flex;
                    justify-content: center;
                }

                .info-route-column p{
                    margin: 5px;
                }

                .info-route{
                    text-align: left;
                }

                .delete-column{
                    text-align: center;
                }
                input{
                    margin: 5px;
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
                    background-color: var(--primary);
                    color: white;
                }

            </style>
        </head>
        <body>
        <%@ include file="/include/header.jsp" %>
        <div class="body">
            <div class="form">
                <div class="title">Order Number: ${cur_order.id} </div>
                <table width="100%" border="1">
                    <thead>
                        <tr class="head-row">
                            <th class="information-column text-head">Passenger Information</th>
                            <th class="text-head">Ticket information</th>
                            <th class="price-column text-head">Price</th>
                        </tr>
                    </thead>
                    <tbody>
                        <c:forEach var="ticket" items="${lticket_newS}">
                            <tr>
                                <td class="information-column">
                                    <div>Name passenger: ${ticket.passenger_name}</div>
                                    <div>Phone passenger: ${ticket.passenger_phone}</div>
                                </td>
                                <td class="info-route-column">
                                    <div class="info-route">
                                        <p>Number seat: ${ticket.seat_id}</p>
                                        <p>Car Name: ${showcar.getCar(curCarroute.car_id).name}</p>
                                        <p>Car Plate: ${showcar.getCar(curCarroute.car_id).licenseplate}</p>
                                        <p>From: ${show1.getlocation(curCarroute.from).province}</p>
                                        <p>To: ${show1.getlocation(curCarroute.to).province}</p>
                                        <p>Start: ${curCarroute.start}</p>
                                        <p>End: ${curCarroute.end}</p>
                                    </div>
                                </td>
                                <td class="price-column">
                                    ${curCarroute.price}
                                </td>
                            </tr>
                        </c:forEach>
                    </tbody>
                </table>
                <div>Total: ${cur_order.total_price}</div>
                <!--<a href="payment.jsp">Payment</a>-->
                <form action="ajax" method="post">
                    <input type="hidden" name="orderNumber" value="${cur_order.id}">
                    <input type="hidden" name="amount" value="${cur_order.total_price}">
                    <button class="button-form" type="submit">Payment</button>
                </form>
            </div>
        </div>
    </body>
</html>
