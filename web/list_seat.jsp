<%-- 
    Document   : list_seat
    Created on : Oct 10, 2023, 2:34:30 PM
    Author     : tuna
--%>

<%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<jsp:useBean class="model.repository.LocationRepository" id="show1"></jsp:useBean>
<jsp:useBean class="model.repository.SeatRepository" id="show2"></jsp:useBean>


    <!DOCTYPE html>
    <html>
        <head>
            <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
            <title>JSP Page</title>
            <link rel="stylesheet" href="css/list_staff.css"/>

            <link
                rel="stylesheet"
                href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/6.4.0/css/all.min.css"
                integrity="sha512-iecdLmaskl7CVkqkXNQ/ZH/XLlvWZOJyj7Yy7tcenmpD1ypASozpmT/E0iPtmFIB46ZmdtAc9eNBvH0H/ZpiBw=="
                crossorigin="anonymous"
                referrerpolicy="no-referrer"
                />
            <style>
                /*            :root {
                                --primary: #20c997;
                                --secondary: #E0E0E0;
                                --light: #befff7;
                                --dark: #419197;
                                --font-family-sans-serif: -apple-system, BlinkMacSystemFont, "Segoe UI", Roboto, "Helvetica Neue", Arial, "Noto Sans", sans-serif, "Apple Color Emoji", "Segoe UI Emoji", "Segoe UI Symbol", "Noto Color Emoji";
                
                            }*/
                html,body{
                    width:100%;
                }
                .body{
                    margin: 10px 0px;
                    text-align: center;
                    width: 100%;
                }
                .content{
                    width: 100%;
                    display: flex;
                    justify-content: center;
                    align-items: center;
                }

                .all-seats {
                    /*background-color: antiquewhite;*/
                    width: 100%;
                    display: grid;
                    grid-template-columns: repeat(6, 1fr);
                    grid-gap: 15px;
                    margin: 20px 0;
                    margin-top: 20px;
                    /* position: relative; */
                }

                .seat {
                    width: 40px;
                    height: 40px;
                    background: white;
                    border-radius: 0.5mm;
                    outline: 0.3mm solid rgb(180, 180, 180);
                    cursor: pointer;
                }

                .all-seats input:checked+label {
                    background: rgb(28, 185, 120);
                    outline: none;
                }

                .seat.booked {
                    background: rgb(180, 180, 180);
                    outline: none;
                }

                .seat.payed {
                    background: red;
                    outline: none;
                }

                input {
                    display: none;
                }

                .seat{
                    text-align: center;
                    display: flex;
                    justify-content: center;
                    align-items: center;
                }

                .right{
                    width: 50%;
                }

                .left{
                    height: auto;
                    width: 50%;
                    text-align: left;
                    padding: 20px;
                    display: flex;
                    justify-content: center;
                    align-items: center;
                    flex-direction: column;
                }

                .carroute-information{
                    width: 50%;
                    height: 100%;
                    padding: 20px;
                    display: flex;
                    flex-direction: column;
                    background-color: #419197;
                    color: white;
                    border-radius: 20px;
                    gap: 5px;
                }
                .left button{
                    width: 50%;
                    margin-left: 25%;
                    background-color: white;
                    color: #419197;
                    border-radius: 10px;
                    padding: 5px;
                    border: none;

                }
                .left button:hover{
                    background-color: #20c997;
                    color: white;
                }


                .left .title-page{
                    margin-bottom: 20px;
                }
                
                .example-color{
                    width: 100%;
                    padding: 10px 20px;
                    display: flex;
                    justify-content: space-around;
                }
                
                .check-box{
                    display: flex;
                    gap: 10px;
                    align-items: center;
                }
                
                .check-color{
                    width: 30px ;
                    height: 30px;
                    background-color: var(--primary);
                    border: 1px black solid;
                    border-radius: 5px; 
                }
                
                .uncheck-color{
                    background-color: white
                }
                
                .booked-color{
                    background-color: rgb(180, 180, 180)
                }
                
                .payed{
                    background-color: red;
                }
            </style>
        </head>
        <body>

        <%@ include file="/include/header.jsp" %>
        <div class="body">
            <div class="content">
                <div class="left">
                    <div class="title-page">
                        Carroute Information
                    </div>
                    <div class="carroute-information">
                        <div class="name-car">
                            Name: ${curCar.name}
                        </div>
                        <div class="datestart">
                            Date: ${curCarroute.datestart}
                        </div>
                        <div class="from">
                            From: ${show1.getlocation(curCarroute.from).province}
                        </div>
                        <div class="to">
                            To: ${show1.getlocation(curCarroute.to).province}
                        </div>
                        <div class="start">
                            Start: ${curCarroute.start}
                        </div>
                        <div class="end">
                            End: ${curCarroute.end}
                        </div>
                        <div class="list-seat" >
                            Seat: <span id="seat-list">${seat}</span>
                        </div>
                        <div class="total">
                            Total:
                            <span id="total">0</span>VND
                        </div>
                        <button href="" onclick="createTicket()" >Tiếp tục</button>
                    </div>

                </div>
                <div class="right">
                    <div class="title-page">
                        List Ticket
                    </div>
                    <div class="example-color">
                        <div class="check-box">
                            <div class="check-color"></div>
                            <p>Checked</p>
                        </div>
                        
                        <div class="check-box">
                            <div class="check-color uncheck-color"></div>
                            <p>Unchecked</p>
                        </div>
                        
                        <div class="check-box">
                            <div class="check-color booked-color"></div>
                            <p>Booked</p>
                        </div>
                        
                        <div class="check-box">
                            <div class="check-color payed"></div>
                            <p>Payed</p>
                        </div>
                    </div>
                    <form>
                        <div class="all-seats">
                            <c:forEach var="ticket" items="${tlistS}">
                                <c:if test="${ticket.status == 0}">
                                    <input type="checkbox" name="ticket" id="${show2.getById(ticket.seat_id).seat_number}"  onClick="handleClick(this,${curCarroute.price})"/>
                                    <label for="${show2.getById(ticket.seat_id).seat_number}" class="seat ">${show2.getById(ticket.seat_id).seat_number}</label>
                                </c:if>
                                <c:if test="${ticket.status == 1}">
                                    <input type="checkbox" name="ticket" id="${show2.getById(ticket.seat_id).seat_number}"  disabled/>
                                    <label for="${show2.getById(ticket.seat_id).seat_number}" class="seat booked">${show2.getById(ticket.seat_id).seat_number}</label>
                                </c:if>
                                <c:if test="${ticket.status == 2}">
                                    <input type="checkbox" name="ticket" id="${show2.getById(ticket.seat_id).seat_number}"  disabled/>
                                    <label for="${show2.getById(ticket.seat_id).seat_number}" class="seat payed">${show2.getById(ticket.seat_id).seat_number}</label>
                                </c:if>
                            </c:forEach>
                        </div>
                    </form>
                </div>


            </div>
        </div>
        <script>
            const seatList = document.getElementById("seat-list");
            const total = document.getElementById("total");

            let arr = [];
            let realList = [];
            let count = 0;
            const handleClick = (e, b) => {
                if (arr.includes(e.id)) {
                    arr = arr.filter((item) => item !== e.id);
                    count -= b;
                    total.innerHTML = count;
                    seatList.innerHTML = arr;
                } else {
                    console.log(e);
                    count += b;
                    arr = [...arr, e.id];
                    total.innerHTML = count;
                    seatList.innerHTML = arr;
                }
            }

            const createTicket = () => {
                window.location.href = 'createticket?lticket=' + arr;
            }
        </script>
    </body>

</html>
