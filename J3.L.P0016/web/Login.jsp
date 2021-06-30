<%-- 
    Document   : Login
    Created on : Jun 10, 2021, 9:14:54 AM
    Author     : phamv
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="en">
    <head>
        <title>TaiPham</title>
        <meta charset="UTF-8">
        <meta name="viewport" content="width=device-width, initial-scale=1">
        <meta name="google-signin-scope" content="profile email">
        <meta name="google-signin-client_id" content="873925439812-fapggmsegurddctr84sht46dutscnc5g.apps.googleusercontent.com">
        <script src="https://apis.google.com/js/platform.js" async defer></script>
        <!--===============================================================================================-->	
        <link rel="icon" type="image/png" href="images/icons/favicon.ico"/>
        <!--===============================================================================================-->
        <link rel="stylesheet" type="text/css" href="vendor/bootstrap/css/bootstrap.min.css">
        <!--===============================================================================================-->
        <link rel="stylesheet" type="text/css" href="fonts/font-awesome-4.7.0/css/font-awesome.min.css">
        <!--===============================================================================================-->
        <link rel="stylesheet" type="text/css" href="fonts/iconic/css/material-design-iconic-font.min.css">
        <!--===============================================================================================-->
        <link rel="stylesheet" type="text/css" href="vendor/animate/animate.css">
        <!--===============================================================================================-->	
        <link rel="stylesheet" type="text/css" href="vendor/css-hamburgers/hamburgers.min.css">
        <!--===============================================================================================-->
        <link rel="stylesheet" type="text/css" href="vendor/animsition/css/animsition.min.css">
        <!--===============================================================================================-->
        <link rel="stylesheet" type="text/css" href="vendor/select2/select2.min.css">
        <!--===============================================================================================-->	
        <link rel="stylesheet" type="text/css" href="vendor/daterangepicker/daterangepicker.css">
        <!--===============================================================================================-->
        <link rel="stylesheet" type="text/css" href="css/util.css">
        <link rel="stylesheet" type="text/css" href="css/main.css">
        <!--===============================================================================================-->
        <%--Recaptcha--%>
        <script src='https://www.google.com/recaptcha/api.js?hl=en'></script>
        
        <!--===============================================================================================-->
    </head>
    <body>

        <div class="limiter">
            <div class="container-login100" style="background-image: url('images/bg-01.jpg');">
                <div class="wrap-login100 p-l-55 p-r-55 p-t-65 p-b-54">
                    <form class="login100-form validate-form" action="MainController" method="post">
                        <span class="login100-form-title p-b-49">
                            Login

                        </span>
                        <table>
                            <tr>
                            <font color="red">${requestScope.INVALID}</font>
                            <div class="wrap-input100 validate-input m-b-23" data-validate = "Username is reauired">
                                <span class="label-input100">Username</span>
                                <input class="input100" type="text" name="userName" value="${param.userName}" placeholder="Type your username">

                                <span class="focus-input100" data-symbol="&#xf206;"></span>
                            </div>
                            </tr>

                            <tr>
                            <div class="wrap-input100 validate-input" data-validate="Password is required">
                                <span class="label-input100">Password</span>
                                <input class="input100" type="password" name="password" value="${param.password}" placeholder="Type your password">

                                <span class="focus-input100" data-symbol="&#xf190;"></span>
                            </div>
                            </tr>
                            <tr>
                            <div class="col-md-6 g-recaptcha" data-callback="recaptchaCallback" data-sitekey="6LdFHk8bAAAAALdiTWET6bI_0UUc0S7x4lwixzGM"></div>
                            </tr>
                            <tr>
                            <div class="container-login100-form-btn">
                                <div class="wrap-login100-form-btn">
                                    <div class="login100-form-bgbtn"></div>
                                    <input type="submit" name="action" value="Login" class="login100-form-btn">

                                </div>
                            </div>
                            </tr>
                        </table>
                        <div class="txt1 text-center p-t-54 p-b-20">
                            <span>
                                <a href="SignUp.jsp">Sign Up</a>
                            </span>
                        </div>

                        <div class="flex-c-m">
                            <div class="g-signin2" data-onsuccess="onSignIn" data-theme="dark"></div>
                            <script>
                                function onSignIn(googleUser) {
                                    // Useful data for your client-side scripts:
                                    var profile = googleUser.getBasicProfile();
                                    console.log("ID: " + profile.getId()); // Don't send this directly to your server!
                                    console.log('Full Name: ' + profile.getName());
                                    console.log('Given Name: ' + profile.getGivenName());
                                    console.log('Family Name: ' + profile.getFamilyName());
                                    console.log("Image URL: " + profile.getImageUrl());
                                    console.log("Email: " + profile.getEmail());
                                    document.getElementById("email").value = profile.getEmail();
                                    
                                    googleUser.disconnect();
                                    
                                    // The ID token you need to pass to your backend:
                                    var id_token = googleUser.getAuthResponse().id_token;
                                    console.log("ID Token: " + id_token);
                                }
                            </script>
                        </div>

                        <div class="flex-col-c p-t-155">
                            <span class="txt1 p-b-17">
                                Or Sign Up Using
                            </span>

                            <a href="#" class="txt2">
                                Sign Up
                            </a>
                        </div>
                    </form>
                </div>
            </div>
        </div>


        <div id="dropDownSelect1"></div>

        <!--===============================================================================================-->
        <script src="vendor/jquery/jquery-3.2.1.min.js"></script>
        <!--===============================================================================================-->
        <script src="vendor/animsition/js/animsition.min.js"></script>
        <!--===============================================================================================-->
        <script src="vendor/bootstrap/js/popper.js"></script>
        <script src="vendor/bootstrap/js/bootstrap.min.js"></script>
        <!--===============================================================================================-->
        <script src="vendor/select2/select2.min.js"></script>
        <!--===============================================================================================-->
        <script src="vendor/daterangepicker/moment.min.js"></script>
        <script src="vendor/daterangepicker/daterangepicker.js"></script>
        <!--===============================================================================================-->
        <script src="vendor/countdowntime/countdowntime.js"></script>
        <!--===============================================================================================-->
        <script src="js/main.js"></script>

    </body>
</html>
