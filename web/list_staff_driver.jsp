<%-- 
    Document   : list_staff_driver
    Created on : Oct 4, 2023, 4:56:19 AM
    Author     : tuna
--%>

<%@page import="org.apache.catalina.User"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8"%>
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
                background: none;
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
                List Staff Driver and Member
            </div>
            <form action="listuser">
                <table width="100%" cellspacing="0" class="table-search">
                    <input type="text" class="form-control"
                           placeholder="Find" autocomplete="off" name="name">
                    <a>
                        <button type="submit" class="btn">Tìm kiếm</button>
                    </a>
                </table>
            </form>

            

            <div class="table" >
                <table border="2"  class="table table-striped">
                    <thead class="thead-dark">
                        <tr>
                            <th>ID</th>
                            <th>Authority</th>
                            <th>Full Name</th>
                            <th>Email</th>
                            <th>Phone</th>
                            <th>Age</th>
                            <th>Gender</th>
                            <th>Address</th>
                            <th>Edit</th>
                            <th>Delete</th>
                        </tr>
                    </thead>
                    <tbody>
                        <c:forEach var="user" items="${ulistS}">
                            <tr id="row${user.id}">
                                <td>${user.id}</td>
                                <td>${user.authority}</td>
                                <td>${user.fullname}</td>
                                <td>${user.email}</td>
                                <td>${user.phone}</td>      
                                <td>${user.age}</td>      
                                <td>${user.gender}</td>
                                <td >${user.address}</td>
                                <td><button type="button" class="btn-fix update-user" data-toggle="modal" data-target="#myModal" data-user-id="${user.id}">
                                        Update
                                    </button></td>
                                <td><a href="#" onclick="messconfirm(${user.id})">Delete</a></td>
                            </tr>
                        </c:forEach>
                    </tbody>
                </table>
            </div>
        </div>
                        <!-- The Modal -->
        <form action="updateuser" method="get">
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
                                    <label for="nameInput">Full Name</label>
                                    <input name="name" type="text" class="form-control" id="nameInput" placeholder="Enter name">
                                </div>
                                <div class="form-group">
                                    <label for="authoInput">Authority</label>
                                    <select name="authority" class="form-control" id="authoInput">
                                        <option value="">--Option--</option>
                                        <option value="ROLE_MEMBER">ROLE_MEMBER</option>
                                        <option value="ROLE_STAFF">ROLE_STAFF</option>
                                        <option value="ROLE_DRIVER">ROLE_DRIVER</option>
                                    </select>
                                </div>
                                <div class="form-group">
                                    <label for="ageInput">Age</label>
                                    <input name="age" class="form-control" id="ageInput" placeholder="Enter age"> 
                                </div>
                                <div class="form-group">
                                    <label for="phoneInput">Phone</label>
                                    <input name="phone" class="form-control" id="phoneInput" placeholder="Enter phone"> 
                                </div>
                                <div class="form-group">
                                    <label for="genderInput">Active</label>
                                    <Select name="gender" class="form-control" id="genderInput" placeholder="Enter gender">
                                        <option value="">--Option--</option>
                                        <option value="MALE">MALE</option>
                                        <option value="FEMALE">FEMALE</option>
                                        <option value="OTHER">OTHER</option>
                                    </select>
                                </div>
                                <div class="form-group">
                                    <label for="addressInput">License Plate</label>
                                    <input name="address" type="text" class="form-control" id="addressInput" placeholder="Enter Address">
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
            const updateButtons = document.querySelectorAll('.update-user');
            updateButtons.forEach(function (button) {
                button.addEventListener('click', function (event) {
                    const userId = button.getAttribute('data-user-id');
                    const idInput = document.getElementById('idInput');
                    idInput.value = userId;
                });
            });
        </script>

        <script>
            function messconfirm(id) {
                var option = confirm('Are you sure to delete');
                if (option === true) {
                    window.location.href = 'deleteuser?sid=' + id;
                }
            }
        </script>
    </body>
</html>
