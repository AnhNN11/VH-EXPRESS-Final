<%-- 
    Document   : ticket_member
    Created on : Oct 4, 2023, 2:01:14 AM
    Author     : tuna
--%>

<%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
        <!--<link rel="stylesheet" href="css/sidebar.css"/>-->
        <!--<link rel="stylesheet" href="css/member.css"/>-->
        <link rel="stylesheet" href="css/ticket_member.css"/>

        <link
            rel="stylesheet"
            href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/6.4.0/css/all.min.css"
            integrity="sha512-iecdLmaskl7CVkqkXNQ/ZH/XLlvWZOJyj7Yy7tcenmpD1ypASozpmT/E0iPtmFIB46ZmdtAc9eNBvH0H/ZpiBw=="
            crossorigin="anonymous"
            referrerpolicy="no-referrer"
            />
    </head>
    <body>
        <%@ include file="/include/header.jsp" %>
        <%@ include file="/include/sidebar.jsp" %>
        <div class="center">
            <div class="tickets">
                <div class="ticket-selector">
                    <div class="head">
                        <div class="title">Car route</div>
                    </div>
                    <div class="select-address" id="select-address">
                        <div class="item-address">
                            <p>From: </p>
                            <select name="from" id="from">
                                <option value="1">Đà Nẵng</option>
                                <option value="2">Kon tum</option>
                                <option value="3">Quảng Bình</option>
                            </select>
                        </div>
                        <div class="item-address">
                            <p>To: </p>
                            <select name="to" id="to">
                                <option value="1">Đà Nẵng</option>
                                <option value="2">Kon tum</option>
                                <option value="3">Quảng Bình</option>
                            </select>
                        </div>
                        <a href="#" class="find-button">Find</a>

                    </div>
                    <div class="seats">
                        <div class="status">
                            <div class="item">Available</div>
                            <div class="item">Booked</div>
                            <div class="item">Selected</div>
                        </div>
                        <div class="all-seats">
                            <div class="seat-main">
                            </div>
                            <div class="seat-phu">
                            </div>
                            <!-- <input type="checkbox" name="tickets" id="s1" />
                            <label for="s1" class="seat booked"></label> -->
                        </div>
                    </div>
                    <div class="timings">
                        <div class="dates">
                            <input type="radio" name="date" id="d1" checked />
                            <label for="d1" class="dates-item">
                                <div class="day">Sun</div>
                                <div class="date">11</div>
                            </label>
                            <input type="radio" id="d2" name="date" />
                            <label class="dates-item" for="d2">
                                <div class="day">Mon</div>
                                <div class="date">12</div>
                            </label>
                            <input type="radio" id="d3" name="date" />
                            <label class="dates-item" for="d3">
                                <div class="day">Tue</div>
                                <div class="date">13</div>
                            </label>
                            <input type="radio" id="d4" name="date" />
                            <label class="dates-item" for="d4">
                                <div class="day">Wed</div>
                                <div class="date">14</div>
                            </label>
                            <input type="radio" id="d5" name="date" />
                            <label class="dates-item" for="d5">
                                <div class="day">Thu</div>
                                <div class="date">15</div>
                            </label>
                            <input type="radio" id="d6" name="date" />
                            <label class="dates-item" for="d6">
                                <div class="day">Fri</div>
                                <div class="date">16</div>
                            </label>
                            <input type="radio" id="d7" name="date" />
                            <label class="dates-item" for="d7">
                                <div class="day">Sat</div>
                                <div class="date">17</div>
                            </label>
                        </div>
                        <div class="times">
                            <input type="radio" name="time" id="t1" checked />
                            <label for="t1" class="time">11:00</label>
                            <input type="radio" id="t2" name="time" />
                            <label for="t2" class="time"> 14:30 </label>
                            <input type="radio" id="t3" name="time" />
                            <label for="t3" class="time"> 18:00 </label>
                            <input type="radio" id="t4" name="time" />
                            <label for="t4" class="time"> 21:30 </label>
                        </div>
                    </div>
                </div>
                <div class="price">
                    <div class="total">
                        <div class="ticket-num">
                            <p>Ticket: </p>
                            <p class="count">0</p> 
                        </div>
                        <div class="ticket-num">
                            <p>Price: </p>
                            <p class="amount">0</p>
                        </div>
                        <div class="array-seats">0</div>

                    </div>
                    <div class="car-route">
                        <p>Route:</p>
                        <div class="name-route">
                            <p class="from-route">Đà Nẵng</p>
                            <p>-</p>
                            <p class="to-route">Đà Nẵng</p>
                        </div>
                    </div>
                    <button type="button">Purchase</button>
                </div>
            </div>
        </div>

        <script>
            let seatsMain = document.querySelector(".seat-main");
            for (var i = 0; i < 18; i++) {
                let randint = Math.floor(Math.random() * 2);
                let booked = randint === 1 ? "booked" : "";
                seatsMain.insertAdjacentHTML(
                        "beforeend",
                        '<input class="seat" type="checkbox" name="tickets" id="s' +
                        (i + 2) +
                        '" /><label for="s' +
                        (i + 2) +
                        '" class="seat ' +
                        booked +
                        '">' + (i + 1) + '</label>'
                        );
            }
            let ticketMain = seatsMain.querySelectorAll("input");
            ticketMain.forEach((ticket) => {
                ticket.addEventListener("change", () => {
                    let amount = document.querySelector(".amount").innerHTML;
                    let count = document.querySelector(".count").innerHTML;
                    let array = document.querySelector(".array-seats").innerHTML;
                    amount = Number(amount);
                    count = Number(count);
                    if (ticket.checked) {
                        count += 1;
                        amount += 200;
                    } else {
                        count -= 1;
                        amount -= 200;
                    }
                    document.querySelector(".amount").innerHTML = amount;
                    document.querySelector(".count").innerHTML = count;
                    document.querySelector(".array-seats").innerHTML = array;

                });
            });

            let seatsPhu = document.querySelector(".seat-phu");
            for (var i = 18; i < 22; i++) {
                let randint = Math.floor(Math.random() * 2);
                let booked = randint === 1 ? "booked" : "";
                seatsPhu.insertAdjacentHTML(
                        "beforeend",
                        '<input class="seat" type="checkbox" name="tickets" id="s' +
                        (i + 2) +
                        '" /><label for="s' +
                        (i + 2) +
                        '" class="seat ' +
                        booked +
                        '">' + (i + 1) + '</label>'
                        );
            }

            let ticketPhu = seatsPhu.querySelectorAll("input");
            ticketPhu.forEach((ticket) => {
                ticket.addEventListener("change", () => {
                    let amount = document.querySelector(".amount").innerHTML;
                    let count = document.querySelector(".count").innerHTML;

                    amount = Number(amount);
                    count = Number(count);

                    if (ticket.checked) {
                        count += 1;
                        amount += 200;
                    } else {
                        count -= 1;
                        amount -= 200;
                    }
                    document.querySelector(".amount").innerHTML = amount;
                    document.querySelector(".count").innerHTML = count;
                });
            });

            var selectElement = document.getElementById("select-address");

            selectElement.addEventListener("change", function () {
                var fromElement = document.getElementById("from");
                var fromRouteElement = document.querySelector(".from-route");

                var toElement = document.getElementById("to");
                var toRouteElement = document.querySelector(".to-route");

                var fromValue = fromElement.value;

                if (fromValue === "1") {
                    fromRouteElement.textContent = "Đà Nẵng";
                } else if (fromValue === "2") {
                    fromRouteElement.textContent = "Kon Tum";
                } else if (fromValue === "3") {
                    fromRouteElement.textContent = "Quãng Bình";
                }

                var toValue = toElement.value;

                if (toValue === "1") {
                    toRouteElement.textContent = "Đà Nẵng";
                } else if (toValue === "2") {
                    toRouteElement.textContent = "Kon Tum";
                } else if (toValue === "3") {
                    toRouteElement.textContent = "Quãng Bình";
                }
            });
        </script>
    </body>
</html>
