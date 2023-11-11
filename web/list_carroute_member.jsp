<%-- 
    Document   : list_carrouter_member
    Created on : Oct 9, 2023, 10:44:29 AM
    Author     : tuna
--%>
<jsp:useBean class="model.repository.CarRepository" id="show"></jsp:useBean>
<jsp:useBean class="model.repository.LocationRepository" id="show1"></jsp:useBean>
<%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html lang="en">
    <head>
        <meta charset="UTF-8">
        <meta name="viewport" content="width=device-width, initial-scale=1.0">
        <meta http-equiv="X-UA-Compatible" content="ie=edge">
        <title>Document</title>
        <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/4.5.2/css/bootstrap.min.css">
        <link rel="stylesheet" href="css/list_staff.css"/>
        <style>
            .carousel{
                width: 100%;
            }

            .carousel-item img {
                max-height: 500px; /* Điều chỉnh chiều cao tối đa */
                object-fit: cover; /* Hiển thị hình ảnh đầy đủ trong khung hiển thị */
                width: 100%;
            }
            .step-item{
                width: auto;
                height: 250px;
                border: dashed 3px var(--teal);
                display: flex;
                flex-direction: column;
                justify-content: space-between;
                align-items: center;
                padding: 20px 40px;
            }

            .step-name{
                font-weight: 600;
                font-size: 28px;
                color: black;
            }

            .step-content{
                text-align: left;
                margin-bottom: 10px;
            }

            .step-content p{
                margin: 0;
            }

            .highlight{
                color: var(--dark);
                font-weight: 600;
            }

            .step-item a{
                height: auto;
                background-color: var(--teal);
                margin: 0 auto;
                padding: 10px 40px;
                color: white;
                font-weight: 600;
                border-radius: 2px;
            }
            .box-search {
                background-color: #fff;
                padding: 10px;
                margin-top: -300px; /* Điều chỉnh khoảng cách giữa carousel và giao diện tìm kiếm */
                border-radius: 5px;
                box-shadow: 0px 0px 10px rgba(0, 0, 0, 0.5);
                position: relative; /* Để điều chỉnh vị trí tương đối cho box-search */
                z-index: 1; /* Để đảm bảo rằng box-search nằm trên carousel */
            }
            /* Đảm bảo rằng các phần tử trong carousel không bị che phủ bởi box-search */
            .carousel-item {
                z-index: 0;
            }
            .ftco-section {
                margin-top: 250px; /* Điều chỉnh khoảng cách theo ý muốn */
            }
            /* CSS cho nút "Tìm vé" */
            .btn-find-ticket {
                background-color: #007bff; /* Màu nền */
                color: #fff; /* Màu chữ */
                border: none; /* Loại bỏ viền */
                border-radius: 5px; /* Bo tròn góc */
                width: 100px;
                /* Kích thước nút */
                margin-left: 30px;
                font-size: 16px; /* Cỡ chữ */
                cursor: pointer; /* Đổi con trỏ chuột thành con trỏ tay khi di chuột qua nút */
                transition: background-color 0.3s ease; /* Hiệu ứng màu nền thay đổi mượt mà */
            }

            /* CSS cho hover nút "Tìm vé" (thay đổi màu nền khi di chuột qua) */
            .btn-find-ticket:hover {
                background-color: #0056b3; /* Màu nền thay đổi khi hover */
            }

            footer {
                width: 100%;
                margin-top: 30px;
                background-color: var(--teal);
                color: #fff;
                padding: 20px 0;
                /*text-align: center;*/
            }

            /* Định dạng cho liên kết trong footer */
            footer a {
                color: #fff;
                text-decoration: none;
            }

            /* Định dạng cho liên kết hover */
            footer a:hover {
                text-decoration: underline;
            }

            td{
                padding: 0px 10px;
            }

            body{
                display: flex;
                flex-direction: column;
                align-items: center;
                width: 100%;
            }

        </style>

    </head>

    <body>
        <%@ include file="/include/header.jsp" %>
        <!--CAROUSEL-->
        <div id="myCarousel" class="carousel slide" data-ride="carousel">
            <!-- Indicators -->
            <ul class="carousel-indicators">
                <li data-target="#myCarousel" data-slide-to="0" class="active"></li>
                <li data-target="#myCarousel" data-slide-to="1"></li>
                <li data-target="#myCarousel" data-slide-to="2"></li>
            </ul>

            <!-- Slides -->
            <div class="carousel-inner">
                <div class="carousel-item active">
                    <img src="images/img1.webp" alt="Image 1" class="img-fluid">
                    <div class="carousel-caption">
                        <h3>Slide 1</h3>
                        <p>Some text for slide 1.</p>
                    </div>
                </div>
                <div class="carousel-item">
                    <img src="images/img2.jpeg" alt="Image 2" class="img-fluid">
                    <div class="carousel-caption">
                        <h3>Slide 2</h3>
                        <p>Some text for slide 2.</p>
                    </div>
                </div>
                <div class="carousel-item">
                    <img src="images/img3.jpeg" alt="Image 3" class="img-fluid">
                    <div class="carousel-caption">
                        <h3>Slide 3</h3>
                        <p>Some text for slide 3.</p>
                    </div>
                </div>
            </div>

            <!-- Left and right controls -->
            <a class="carousel-control-prev" href="#myCarousel" data-slide="prev">
                <span class="carousel-control-prev-icon"></span>
            </a>
            <a class="carousel-control-next" href="#myCarousel" data-slide="next">
                <span class="carousel-control-next-icon"></span>
            </a>
        </div>

        <!-- CAROUSEL-->
        <div class="container">
            <div class="box-search">
                <form action="listcarroute" method="POST">
                    <table width="100%" cellspacing="0" class="table-search">
                        <tbody>
                            <tr>
                                <td>                                   
                                    <select name="from" id="from" class="form-control col-sm-12">
                                        <c:forEach var="location" items="${show1.listLocations}">
                                            <option value="${location.id}">${location.province}</option>
                                        </c:forEach>
                                    </select>
                                </td>
                                <td>
                                    <select class="form-control col-sm-12" name="to">
                                        <c:forEach var="location" items="${show1.listLocations}">
                                            <option value="${location.id}">${location.province}</option>
                                        </c:forEach>
                                    </select>
                                </td>
                                <td class="date">
                                    <input class="form-control col-sm-12" type="date" name="datestart">
                                </td>
                                <td>
                                    <input type="submit" class="btn-find-ticket" value="Tìm vé">
                                </td>
                            </tr>
                        </tbody>
                    </table>
                </form>
            </div>
        </div>

        <div class="box-list">
            <div class="title-page">
                List Car Route
            </div>

            <div class="table">
                <table border="2">
                    <thead>
                        <tr>
                            <th>Name car</th>
                            <th>From</th>
                            <th>To</th>
                            <th>Price</th>
                            <th>Start</th>
                            <th>End</th>
                            <th>Date Start</th>
                                <c:if test="${authority!='ROLE_MEMBER'}">
                                <td>Edit</td>
                                <td>Delete</td>
                            </c:if>
                            <th>Booking</th>
                        </tr>
                    </thead>
                    <tbody>
                        <c:forEach var="carroute" items="${crlistS}">
                            <tr id="row${carroute.id}">
                                <td>${show.getCar(carroute.car_id).name}</td>
                                <td>${show1.getlocation(carroute.from).province}</td>
                                <td>${show1.getlocation(carroute.to).province}</td>
                                <td>${carroute.price}</td>
                                <td>${carroute.start}</td>
                                <td>${carroute.end}</td>
                                <td>${carroute.datestart}</td>
                                <c:if test="${authority!='ROLE_MEMBER'}">
                                    <td><a href="#">Edit</a></td>
                                    <td><a href="#">Delete</a></td>
                                </c:if>

                                <td><a href="listseat?crid=${carroute.id}">Booking</a></td>
                                <!--<td><a href="ticket_member.jsp">Booking1</a></td>-->
                            </tr>
                        </c:forEach>
                    </tbody>
                </table>
            </div>
        </div>

        <footer>
            <div class="container">
                <div class="row">
                    <div class="col-md-6">
                        <h5>Thông tin liên hệ</h5>
                        <p>123 Đường ABC, Thành phố XYZ</p>
                        <p>Email: example@example.com</p>
                    </div>
                    <div class="col-md-6">
                        <h5>Liên kết hữu ích</h5>
                        <ul class="list-unstyled">
                            <li><a href="#">Trang chủ</a></li>
                            <li><a href="#">Về chúng tôi</a></li>
                            <li><a href="#">Sản phẩm</a></li>
                            <li><a href="#">Liên hệ</a></li>
                        </ul>
                    </div>
                </div>
            </div>
        </footer>
    </body>
    <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.5.1/jquery.min.js"></script>
    <script src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.16.0/umd/popper.min.js"></script>
    <script src="https://maxcdn.bootstrapcdn.com/bootstrap/4.5.2/js/bootstrap.min.js"></script>
</html>

