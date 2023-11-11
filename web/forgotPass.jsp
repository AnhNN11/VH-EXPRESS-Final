<%@page contentType="text/html" pageEncoding="UTF-8"%>
<html>
    <head>
        <meta charset="UTF-8">
        <meta name="viewport" content="width=device-width, initial-scale=1">
        <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/4.5.2/css/bootstrap.min.css">
        <link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/6.4.0/css/all.min.css">
        <link rel="stylesheet" href="css/style.css">
        <title>Forgot Password</title>
        <!-- Các liên kết CSS và JS khác ở đây -->
        <style>
            body {
                margin: 0;
                padding: 0;
                background-color: #f2f3f8;
                font-family: 'Open Sans', sans-serif;
                font-size: 14px;
                font-weight: normal;
                line-height: 1.5;
                text-transform: none;
            }

            /* Để làm cho table tràn toàn bộ màn hình */
            table {
                width: 100%;
            }

            /* Để làm cho footer giữa màn hình */
            .footer-title {
                color: #20c997;
                font-weight: bold;
                font-size: 40px;
                font-style: italic;
                text-align: center;
            }

            /* Điều chỉnh style cho form */
            .card {
                border-radius: 3px;
                -webkit-box-shadow: 0 6px 18px 0 rgba(0, 0, 0, 0.06);
                -moz-box-shadow: 0 6px 18px 0 rgba(0, 0, 0, 0.06);
                box-shadow: 0 6px 18px 0 rgba(0, 0, 0, 0.06);
                max-width: 670px;
                background: #fff;
                margin: 0 auto;
            }

            /* Thêm mã CSS khác ở đây */
        </style>
    </head>
    <body>
        <a href="login.jsp">
            <button class="btn" style="background: #20c997; text-decoration: none !important; font-weight: 500; color: #fff; text-transform: uppercase; font-size: 14px; padding: 10px 24px; display: inline-block; border-radius: 50px; position: absolute; top: 20px; left: 20px;">
                <i class="fas fa-chevron-left"></i> Back
            </button>
        </a>

        <!-- 100% body table -->
        <table cellspacing="0" border="0" cellpadding="0" width="100%">
            <tr>
                <td>
                    <table style="max-width: 670px; margin: 0 auto; background-color: #f2f3f8;" width="100%" border="0" align="center" cellpadding="0" cellspacing="0">
                        <tr>
                            <td style="height: 50px;">&nbsp;</td>
                        </tr>
                        <tr>
                            <td style="text-align:center;">
                                <div class="mb-3 mb-md-0 footer-title">
                                    Viet Hoang Express
                                </div>
                            </td>
                        </tr>

                        <tr>
                            <td>
                                <table width="95%" border="0" align="center" cellpadding="0" cellspacing="0">
                                    <tr>
                                        <td style="height: 15px;">&nbsp;</td>
                                    </tr>
                                    <tr>
                                        <td style="padding: 0 35px;">

                                            <form class="card mt-4" action="forgotPassword" method="POST">
                                                <div class="card-body">
                                                    <h1 style="color: #1e1e2d; font-weight: 500; margin: 0; font-size: 32px; font-family: 'Rubik', sans-serif;">You have requested to reset your password</h1>
                                                    <p>Change your password in three easy steps. This will help you
                                                        to secure your password!</p>
                                                    <ol class="list-unstyled">
                                                        <li><span class="text-primary text-medium">1. </span>Enter
                                                            your email address below.</li>
                                                        <li><span class="text-primary text-medium">2. </span>Our
                                                            system will send you an OTP to your email</li>
                                                        <li><span class="text-primary text-medium">3. </span>Enter the OTP on the 
                                                            next page</li>
                                                    </ol>
                                                    <div class="form-group">
                                                        <label for="email-for-pass">Enter your email address</label>
                                                        <input placeholder="Enter your email" class="form-control" type="text" name="email" id="email-for-pass" required>
                                                        <small class="form-text text-muted">Enter the registered email address. Then we'll email an OTP to this address.</small>
                                                    </div>
                                                </div>
                                                <div class="card-footer">
                                                    <button class="btn" style="background: #20c997; text-decoration: none !important; font-weight: 500; margin-top: 10px; color: #fff; text-transform: uppercase; font-size: 14px; padding: 10px 24px; display: inline-block; border-radius: 50px;" type="submit">Get New Password</button>
                                                </div>
                                            </form>
                                        </td>
                                    </tr>
                                    <tr>
                                        <td style="height: 40px;">&nbsp;</td>
                                    </tr>
                                </table>
                            </td>
                        </tr>
                        <tr>
                            <td style="height: 20px;">&nbsp;</td>
                        </tr>
                    </table>
                </td>
            </tr>
        </table>
        <div
            class="d-flex flex-column flex-md-row text-center text-md-start justify-content-between py-4 px-4 px-xl-5 color-teal">
            <!-- Copyright -->
            <a src="index.html">
                <div class="text-white mb-3 mb-md-0 footer-title">
                    Viet Hoang Express
                </div>
            </a>


        </div>
        <!-- /100% body table -->

        <!-- Các liên kết JS ở đây -->
    </body>
</html>