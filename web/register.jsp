<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>

<%-- Kiểm tra xem có thông báo lỗi trong session không --%>
<%
    String emailExistsMessage = (String) session.getAttribute("emailExistsMessage");
    if (emailExistsMessage != null) {
        // Xóa thông báo lỗi khỏi session để tránh hiển thị nhiều lần
        session.removeAttribute("emailExistsMessage");
    }
%>

<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
        <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/4.5.2/css/bootstrap.min.css">
        <link rel="stylesheet" href="css/style.css">
    </head>
    <body>
        <!--        <form action="register" method="POST">
                    <div class="container">
        <%-- Hiển thị thông báo lỗi nếu có --%>
        <div class="error-message">
        <%= (emailExistsMessage != null) ? emailExistsMessage : ""%>
    </div>
    <h1>Register</h1>
    <p>Please fill in this form to create an account.</p>
    <hr>

    <label for="fullname"><b>Repeat Password</b></label>
    <input type="text" placeholder="Enter Fullname" name="fullname" id="fullname" required>

    <label for="email"><b>Email</b></label>
    <input type="text" placeholder="Enter Email" name="email" id="email" required>

    <label for="password"><b>Password</b></label>
    <input type="password" placeholder="Enter Password" name="password" id="password" required>

    <hr>

    <p>By creating an account you agree to our <a href="#">Terms & Privacy</a>.</p>
    <button type="submit" class="registerbtn">Register</button>
</div>

<div class="container signin">
    <p>Already have an account? <a href="#">Sign in</a>.</p>
</div>
</form>-->
        <!-- Section: Design Block -->
        <section class="vh-100">
            <div class="container-fluid h-custom">
                <div class="row d-flex justify-content-center align-items-center h-100">
                    <div class="col-md-9 col-lg-6 col-xl-5">
                        <img src="https://mdbcdn.b-cdn.net/img/Photos/new-templates/bootstrap-login-form/draw2.webp"
                             class="img-fluid" alt="Sample image">
                    </div>
                    <div class="col-md-8 col-lg-6 col-xl-4 offset-xl-1">
                        <form action="register" method="POST">

                            <p class="text-center font-weight-bold mb-0 me-3 ">Sign up</p>

                            <!-- Full name input -->
                            <div class="form-outline mb-4  ">
                                <input type="text" id="form3Example3" name="fullname" class="form-control form-control-lg"
                                       placeholder="Full name" />
                                <!-- <label class="form-label" for="form3Example3"></label> -->
                            </div>

                          
                            <!-- Email input -->
                            <div class="form-outline mb-4">
                                <input type="email" id="form3Example3" name="email"class="form-control form-control-lg "
                                       placeholder="Email address" />
                                <!-- <label class="form-label" for="form3Example3"></label> -->
                            </div>

                            <!-- Password input -->
                            <div class="form-outline mb-3">
                                <input type="password" name="password"id="form3Example4" class="form-control form-control-lg"
                                       placeholder="Enter password" />
                                <!-- <label class="form-label" for="form3Example4"></label> -->
                            </div>

                            <!-- <div class="d-flex justify-content-between align-items-center">
                                Checkbox
                                <div class="form-check mb-0">
                                    <input class="form-check-input me-2" type="checkbox" value="" id="form2Example3" />
                                    <label class="form-check-label" for="form2Example3">
                                        Remember me
                                    </label>
                                </div>
                                <a href="#!" class="text-body">Forgot password?</a>
                            </div> -->

                            <div class="text-center text-lg-start mt-4 pt-2">
                                <button type="submit" class="btn color-teal btn-lg"
                                        style="padding-left: 2.5rem; padding-right: 2.5rem;">Sign up</button>
                                <p class="small fw-bold mt-2 pt-1 mb-0">I have an account?
                                    <a href="login.jsp" class="link-danger registed-teal">Login</a>
                                </p>
                            </div>

                            <!-- <div class="divider d-flex align-items-center my-4">
                                <p class="text-center fw-bold mx-3 mb-0">Or</p>
                            </div>
    
                            <div class="d-flex flex-row align-items-center justify-content-center">
                                
                                <button type="button" class="btn color-teal btn-floating mx-2 circle">
                                    <i class="fab fa-facebook-f"></i>
                                </button>
    
                                <button type="button" class="btn color-teal btn-floating mx-2 circle">
                                    <i class="fab fa-twitter"></i>
                                </button>
    
                                <button type="button" class="btn color-teal btn-floating mx-2 circle">
                                    <i class="fab fa-linkedin-in"></i>
                                </button>
                            </div> -->

                        </form>
                    </div>
                </div>
            </div>
            <div
                class="d-flex flex-column flex-md-row text-center text-md-start justify-content-between py-4 px-4 px-xl-5 color-teal">
                <!-- Copyright -->
                <div class="text-white mb-3 mb-md-0 footer-title">
                    Viet Hoang Express
                </div>
                <!-- Copyright -->

                <!-- Right -->
                <!-- <div>
                    <a href="#!" class="text-white me-4 mx-3">
                        <i class="fab fa-facebook-f"></i>
                    </a>
                    <a href="#!" class="text-white me-4 mx-3">
                        <i class="fab fa-twitter"></i>
                    </a>
                    <a href="#!" class="text-white me-4 mx-3">
                        <i class="fab fa-google"></i>
                    </a>
                    <a href="#!" class="text-white me-4 mx-3">
                        <i class="fab fa-linkedin-in"></i>
                    </a>
                </div> -->
                <!-- Right -->
            </div>
        </section>
        <!-- Section: Design Block -->



    

    </body>

    <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.5.1/jquery.min.js"></script>
    <script src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.16.0/umd/popper.min.js"></script>
    <script src="https://maxcdn.bootstrapcdn.com/bootstrap/4.5.2/js/bootstrap.min.js"></script>
</html>
