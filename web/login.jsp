<%-- 
    Document   : login
    Created on : Oct 2, 2023, 2:46:15 PM
    Author     : ADMIN
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%><%-- Kiểm tra xem có thông báo lỗi trong session không --%>
<%
    String confirmmail = (String) session.getAttribute("verified");
    if (confirmmail != null) {
        // Xóa thông báo lỗi khỏi session để tránh hiển thị nhiều lần
        session.removeAttribute("confirmmail");
    }
%>


<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
        <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/4.5.2/css/bootstrap.min.css">
        <link rel="stylesheet" href="css/style.css">
    </head>   
    <body>    
        <!--        <form action="login" method="post">  
                    <div class="container">   
                        <label>Email : </label>   
                        <input type="text" placeholder="Enter Email" name="email" required>  
                        <label>Password : </label>   
                        <input type="password" placeholder="Enter Password" name="password" required>  
                        <button type="submit">Login</button>   
                        <input type="checkbox" checked="checked"> Remember me   
                        <button type="button" class="cancelbtn"> Cancel</button>   
                        Forgot <a href="#"> password? </a>   
                    </div>   
                </form>     -->

        <section class="vh-100">
            <div class="container-fluid h-custom">
                <div class="row d-flex justify-content-center align-items-center h-100">
                    <div class="col-md-9 col-lg-6 col-xl-5">
                        <img src="https://mdbcdn.b-cdn.net/img/Photos/new-templates/bootstrap-login-form/draw2.webp"
                             class="img-fluid" alt="Sample image">
                    </div>

                    <div class="col-md-8 col-lg-6 col-xl-4 offset-xl-1">
                        <form action="login" method="post">

                            <p class="text-center font-weight-bold mb-2 me-3 ">Log in</p>  
                            <p> <%= (confirmmail != null) ? confirmmail : ""%></p>



                            <!-- Email input -->
                            <div class="form-outline mb-4">
                                <input type="email" id="form3Example3" name="email" class="form-control form-control-lg"
                                       placeholder="Email address" />
                                <!-- <label class="form-label" for="form3Example3"></label> -->
                            </div>

                            <!-- Password input -->
                            <div class="form-outline mb-3">
                                <input type="password" id="form3Example4" name="password" class="form-control form-control-lg"
                                       placeholder="Enter password" />
                                <!-- <label class="form-label" for="form3Example4"></label> -->
                            </div>

                            <div class="d-flex justify-content-between align-items-center">
                                <!-- Checkbox -->
                                <div class="form-check mb-0">
                                    <input class="form-check-input me-2" type="checkbox" value="" id="form2Example3" />
                                    <label class="form-check-label" for="form2Example3">
                                        Remember me
                                    </label>
                                </div>
                                
                                //
                                
                                <a href="forgotPass.jsp" class="text-body">Forgot password?</a>
                          
                                
                            </div>

                            <div class="text-center text-lg-start mt-4 pt-2">
                                <button type="submit" class="btn color-teal btn-lg"
                                        style="padding-left: 2.5rem; padding-right: 2.5rem;">Login</button>
                                <p class="small fw-bold mt-2 pt-1 mb-0">Don't have an account?
                                    <a href="register.jsp" class="link-danger registed-teal">Register</a>
                                </p>
                            </div>

                            <div class="divider d-flex align-items-center my-4">
                                <p class="text-center fw-bold mx-3 mb-0">Or</p>
                            </div>
                            <button type="button" class="gg-button"> 
                                <i class="fab fa-google"></i>
                                <p>Login with Google</p>
                            </button>


                        </form>
                    </div>
                </div>
            </div>
            <div
                class="d-flex flex-column flex-md-row text-center text-md-start justify-content-between py-4 px-4 px-xl-5 color-teal">
                <!-- Copyright -->
                <a src="index.html">
                    <div class="text-white mb-3 mb-md-0 footer-title">
                        Viet Hoang Express
                    </div>
                </a>

             
            </div>
        </section>
        <!-- loader -->
        <!--        <div id="ftco-loader" class="show fullscreen"><svg class="circular" width="48px" height="48px">
                    <circle class="path-bg" cx="24" cy="24" r="22" fill="none" stroke-width="4" stroke="#eeeeee" />
                    <circle class="path" cx="24" cy="24" r="22" fill="none" stroke-width="4" stroke-miterlimit="10"
                            stroke="#F96D00" />
                    </svg></div>-->


    </body>     
    <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.5.1/jquery.min.js"></script>
    <script src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.16.0/umd/popper.min.js"></script>
    <script src="https://maxcdn.bootstrapcdn.com/bootstrap/4.5.2/js/bootstrap.min.js"></script>

</html>
