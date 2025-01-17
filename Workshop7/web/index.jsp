<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <title>TODO supply a title</title>
        <meta charset="UTF-8">
        <meta name="viewport" content="width=device-width, initial-scale=1.0">
        <style>

            body{
                margin: 0;
            }

            .formContainer{
                display: flex;
                justify-content: center;
                align-items: center;
                height: 100vh;
            }

            form{
                width: fit-content;
                box-shadow: rgba(0, 0, 0, 0.35) 0px 5px 15px;
                padding:54px;
                border-radius: 10px;
                display: flex;
                flex-direction: column;
                gap: 42px;
            }
            label, input{
                display: block;
            }

            label {
                padding-left: 4px;
                margin-bottom: 12px;
                color: #868e96;
            }

            input{
                border:none;
                border-bottom: 2px solid transparent;
                border-image: linear-gradient(0.1turn,#868e96,#868e96);
                border-image-slice: 1;
                width: 270px;
                transition: border-bottom 1s ease-in-out, border-image 1s linear;
            }

            input:focus{
                outline: none;
                border-bottom: 2px solid transparent;
                border-image: linear-gradient(0.1turn, #23D1FD,#6F78FE,#B524FF);
                border-image-slice: 1;
            }

            h1{
                font-weight: 700;
                text-align: center;
                margin: 0;
                margin-bottom: 24px;
                font-size: 64px;
                background-image: linear-gradient(0.1turn, #23D1FD,#6F78FE,#B524FF);
                -webkit-background-clip: text;
                color: transparent;
            }

            .buttonContainer{
                display: flex;
                justify-content: center;
            }

            button{
                width: fit-content;
                color: #fff;
                background-image: linear-gradient(to left,#23D1FD,#6F78FE,#B524FF);
                border: none;
                padding:24px 64px;
                border-radius: 100px;
                text-transform: uppercase;
                font-weight: 600;
                transition: transform 0.3s ease-in-out;
                cursor: pointer;
            }

            button:hover{
                transform: scale(1.05);

            }
        </style>
    </head>
    <body>

        <div class="formContainer">
            <c:if test="${Boolean.parseBoolean(login)==true}">
                <h1>Login successful!</h1>
            </c:if>
            <c:if test="${Boolean.parseBoolean(login)!=true||login==null}">
                <form action="auth/servlet1" method="post">
                    <h1>Welcome</h1>
                    <div>
                        <label for="username">Username</label>
                        <input type="text" id="username" name="username" required placeholder=" "/>
                    </div>
                    <div>
                        <label for="password">Password</label>
                        <input type="password" id="password" name="password" required placeholder=" "/>
                    </div>
                    <div class="buttonContainer">
                        <button type="submit">Login</button>
                    </div>
                </form>          
            </c:if>
        </div>
    </body>
</html>
