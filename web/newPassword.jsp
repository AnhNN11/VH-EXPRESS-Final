<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta charset="UTF-8">
        <title>Set New Password</title>
        <style>
            .mainDiv {
                display: flex;

                justify-content: center;

                font-family: 'Open Sans', sans-serif;
            }
            .cardStyle {
                width: 500px;
                border-color: white;
                background: #fff;
                padding: 36px 0;
                border-radius: 4px;
                align-items: center;
                margin: 30px 0;
                box-shadow: 0px 0 2px 0 rgba(0, 0, 0, 0.25);
            }
            #signupLogo {
                max-height: 100px;
                margin: auto;
                display: flex;
                flex-direction: column;
            }
            .formTitle{
                font-weight: 600;
                margin-top: 20px;
                color: #2F2D3B;
                text-align: center;
            }
            .inputLabel {
                font-size: 15px;
                color: #555;
                margin-bottom: 6px;
                margin-top: 24px;
            }
            .inputDiv {
                width: 70%;
                display: flex;
                flex-direction: column;
                margin: auto;
            }
            input {
                height: 40px;
                font-size: 16px;
                border-radius: 4px;
                border: none;
                border: solid 1px #ccc;
                padding: 0 11px;
            }
            input:disabled {
                cursor: not-allowed;
                border: solid 1px #eee;
            }
            .buttonWrapper {
                margin-top: 40px;
            }
            .btn {
                width: 70%;
                height: 40px;
                margin: auto;
                display: block;
                align-items: center;
                color: #fff;
                background-color: #065492;
                border-color: #065492;
                text-shadow: 0 -1px 0 rgba(0, 0, 0, 0.12);
                box-shadow: 0 2px 0 rgba(0, 0, 0, 0.035);
                border-radius: 4px;
                font-size: 14px;
                cursor: pointer;
            }
            .submitButton:disabled,

        </style>
    </head>
    <body>
        <!--    <h1>Set New Password</h1>
            <form action="newpassword" method="post">
                <label for="password">New Password:</label>
                <input type="password" id="password" name="password" required>
                <br>
                <input type="submit" value="Set Password">
            </form>-->

        <div class="mainDiv">
            <div class="cardStyle">
                <form action="newpassword" method="post" name="signupForm" id="signupForm">
                    <img src="images/NewPassword.png" id="signupLogo"/>
                    <h2 class="formTitle">
                        Reset Password 
                    </h2>
                    <div class="inputDiv">
                        <label class="inputLabel" for="password">New Password</label>
                        <input type="password" placeholder="NewPassword" id="password" name="password" required >
                    </div>
                    <button class="btn" style="background: #20c997; text-decoration: none !important; font-weight: 500; margin-top: 10px; color: #fff; text-transform: uppercase; font-size: 14px; padding: 10px 24px; display: inline-block; border-radius: 50px; margin-left: 70px; margin-top: 40px" type="submit">Get New Password</button>

                </form>
            </div>
        </div>
    </body>
</html>
