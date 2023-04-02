    <%-- 
    Document   : signup
    Created on : Oct 17, 2022, 10:12:54 PM
    Author     : USER
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/5.15.2/css/all.min.css"/>
        <title>EAW</title>
        <style>
            *{
                margin: 0;
                padding: 0;
                box-sizing: border-box;
                font-family: 'Poppins',sans-serif;
                overflow: auto;
            }
            body{
                background: #1abc9c;
                overflow: hidden;
            }
            ::selection{
                background: rgba(26,188,156,0.3);
            }
            .container{
                max-width: 440px;
                padding: 0 20px;
                margin: 30px auto;
            }
            .wrapper{
                width: 100%;
                background: #fff;
                border-radius: 5px;
                box-shadow: 0px 4px 10px 1px rgba(0,0,0,0.1);
            }
            .wrapper .title{
                height: 90px;
                background: #16a085;
                border-radius: 5px 5px 0 0;
                color: #fff;
                font-size: 30px;
                font-weight: 600;
                display: flex;
                align-items: center;
                justify-content: center;
            }
            .wrapper form{
                padding: 30px 25px 25px 25px;
            }
            .wrapper form .row{
                height: 45px;
                margin-bottom: 15px;
                position: relative;
            }
            .wrapper form .row input{
                height: 100%;
                width: 100%;
                outline: none;
                padding-left: 60px;
                border-radius: 5px;
                border: 1px solid lightgrey;
                font-size: 16px;
                transition: all 0.3s ease;
            }
            form .row input:focus{
                border-color: #16a085;
                box-shadow: inset 0px 0px 2px 2px rgba(26,188,156,0.25);
            }
            form .row input::placeholder{
                color: #999;
            }
            .wrapper form .row i{
                position: absolute;
                width: 47px;
                height: 100%;
                color: #fff;
                font-size: 18px;
                background: #16a085;
                border: 1px solid #16a085;
                border-radius: 5px 0 0 5px;
                display: flex;
                align-items: center;
                justify-content: center;
            }
            .wrapper form .pass{
                margin: -8px 0 20px 0;
            }
            .wrapper form .pass a{
                color: #16a085;
                font-size: 17px;
                text-decoration: none;
            }
            .wrapper form .pass a:hover{
                text-decoration: underline;
            }
            .wrapper form .button input{
                color: #fff;
                font-size: 20px;
                font-weight: 500;
                padding-left: 0px;
                background: #16a085;
                border: 1px solid #16a085;
                cursor: pointer;
            }
            form .button input:hover{
                background: #12876f;
            }
            .wrapper form .logins{
                text-align: center;
                margin-top: 20px;
                font-size: 17px;
            }
            .wrapper form .logins a{
                color: #16a085;
                text-decoration: none;
            }
            form .logins a:hover{
                text-decoration: underline;
            }
        </style>
    </head>
    <body>
        <div class="container">
            <div class="wrapper">
                <div class="title"><span>Forgot Password</span></div>

                <form action="changepass" method="post">

                    <h5 style="color: red; margin-bottom: 30px">${requestScope.err}</h5>
                    <input type="hidden" name="email" value="${sessionScope.acc.email}">
                    <p>Enter New Password:</p>
                    <div class="row">

                        <i class="fas fa-lock"></i>
                        <input type="password" name="pass" placeholder="Password" required/><br/>
                    </div>
                    <p>Repass:</p>
                    <div class="row">

                        <i class="fas fa-lock"></i>
                        <input type="password" name="repass" placeholder="Repeat Password" required/><br/>
                    </div>
                    <div class="row button">
                        <input type="submit" value="Change">
                    </div>

                    <div class="logins">Already have an account ? <a href="login">Login now</a></div>

                </form>   
            </div>

        </div>

    </body>
</html>
