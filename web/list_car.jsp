<%-- 
    Document   : list_car
    Created on : Oct 5, 2023, 8:35:06 PM
    Author     : tuna
--%>

<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>List Car</title>
        <link rel="stylesheet" href="css/list_staff.css"/>

        <link
            rel="stylesheet"
            href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/6.4.0/css/all.min.css"
            integrity="sha512-iecdLmaskl7CVkqkXNQ/ZH/XLlvWZOJyj7Yy7tcenmpD1ypASozpmT/E0iPtmFIB46ZmdtAc9eNBvH0H/ZpiBw=="
            crossorigin="anonymous"
            referrerpolicy="no-referrer"
            >
        <link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/bootstrap@4.0.0/dist/css/bootstrap.min.css" integrity="sha384-Gn5384xqQ1aoWXA+058RXPxPg6fy4IWvTNh0E263XmFcJlSAwiGgFAW/dAiS6JXm" crossorigin="anonymous">
        <style>
            .modal {
                top: 10%;
            }

            .table td, table th{
                text-align: center;
            }

            /* Add this CSS to your stylesheet */
            .btn-fix {
                /* Your regular button styles here */
                border: none;
                color: blue;
            }

            .btn-fix:active,
            .btn-fix:focus {
                outline: none; 
                border: none; 
            }
            
        </style>
    </head>
    <body>
        <%@ include file="/include/header.jsp" %>
        <%@ include file="/include/sidebar.jsp" %>
        <div class="body">

            <div class="title-page">
                List Car
            </div>
            <div class="container">

                <div class="box-search">
                    <form action="listcar" method="POST">
                        <table width="50%" cellspacing="0" class="table-search">
                            <tbody>
                            <td class="text">
                                <input class="form-control" type="text" name="car_name">
                            </td>
                            <td>
                                <input type="submit" class="btn btn-primary" value="Search Car Name">
                            </td>
                            </tbody>
                        </table>
                    </form>
                </div>
            </div>

            <div class="table">
                <table border="2" class="table table-striped">
                    <thead class="thead-dark">
                        <tr>
                            <th>ID</th>
                            <th>Name</th>
                            <th>Type</th>
                            <th>Count Seat</th>
                            <th>Active</th>
                            <th>License Plate</th>
                            <th>Edit</th>
                            <th>Delete</th>
                        </tr>
                    </thead>
                    <tbody>
                        <c:forEach var="car" items="${clistS}">
                            <tr id="row${car.id}">
                                <td>${car.id}</td>
                                <td>${car.name}</td>
                                <td>${car.type}</td>
                                <td>${car.countseat}</td>
                                <td>${car.isactive}</td>
                                <td>${car.licenseplate}</td>
                                <td>
                                    <button type="button" class="btn-fix update-car" data-toggle="modal" data-target="#myModal" data-car-id="${car.id}">
                                        Update
                                    </button>
                                </td>
                                <td>
                                    <a href="deletecar?id=${car.id}">Delete</a>
                                </td>
                            </tr>
                        </c:forEach>
                    </tbody>
                </table>
            </div>
        </div>

        <!-- The Modal -->
        <form action="updatecar" method="get">
            <div class="modal" id="myModal">
                <div class="modal-dialog">
                    <div class="modal-content">
                        <!-- Modal Header -->
                        <div class="modal-header">
                            <h4 class="modal-title">Update Car</h4>
                            <button type="button" class="close" data-dismiss="modal">&times;</button>
                        </div>
                        <!-- Modal body -->
                        <div class="modal-body">
                            <div class="container-fluid">
                                <input name="id" type="text" class="form-control" id="idInput" hidden>
                                <div class="form-group">
                                    <label for="nameInput">Name</label>
                                    <input name="name" type="text" class="form-control" id="nameInput" placeholder="Enter name">
                                </div>
                                <div class="form-group">
                                    <label for="typeInput">Type</label>
                                    <select name="type" class="form-control" id="typeInput" placeholder="Enter type">
                                        <option value="VIP">VIP</option>
                                        <option value="ECONOMY">ECONOMY</option>
                                        <option value="STANDARD">STANDARD</option>
                                    </select>
                                </div>
                                <div class="form-group">
                                    <label for="countSeatInput">Count Seat</label>
                                    <select name="countseat" class="form-control" id="countSeatInput" placeholder="Enter count seat"> 
                                        <option value="22">22</option>
                                        <option value="35">35</option>
                                        <option value="45">45</option>
                                    </select>
                                </div>
                                <div class="form-group">
                                    <label for="activeInput">Active</label>
                                    <Select name="isactive" class="form-control" id="activeInput" placeholder="Enter active">
                                        <option value="1">NEW</option>
                                        <option value="2">MEDIUM</option>
                                        <option value="3">OLD</option>
                                    </select>
                                </div>
                                <div class="form-group">
                                    <label for="licensePlateInput">License Plate</label>
                                    <input name="licenseplate" type="text" class="form-control" id="licensePlateInput" placeholder="Enter license plate">
                                </div>
                            </div>
                        </div>
                        <!-- Modal footer -->
                        <div class="modal-footer">
                            <button type="submit" class="btn btn-success">Update</button>
                        </div>
                    </div>
                </div>
            </div>
        </form>

        <script src="https://code.jquery.com/jquery-3.2.1.slim.min.js" integrity="sha384-KJ3o2DKtIkvYIK3UENzmM7KCkRr/rE9/Qpg6aAZGJwFDMVNA/GpGFF93hXpG5KkN" crossorigin="anonymous"></script>
        <script src="https://cdn.jsdelivr.net/npm/popper.js@1.12.9/dist/umd/popper.min.js" integrity="sha384-ApNbgh9B+Y1QKtv3Rn7W3mgPxhU9K/ScQsAP7hUibX39j7fakFPskvXusvfa0b4Q" crossorigin="anonymous"></script>
        <script src="https://cdn.jsdelivr.net/npm/bootstrap@4.0.0/dist/js/bootstrap.min.js" integrity="sha384-JZR6Spejh4U02d8jOt6vLEHfe/JQGiRRSQQxSfFWpi1MquVdAyjUar5+76PVCmYl" crossorigin="anonymous"></script>
        <script>
            // Add an event listener to all "Update" buttons
            const updateButtons = document.querySelectorAll('.update-car');
            updateButtons.forEach(function (button) {
                button.addEventListener('click', function (event) {
                    const carId = button.getAttribute('data-car-id');
                    const idInput = document.getElementById('idInput');
                    idInput.value = carId;
                });
            });
        </script>
    </body>
</html>
