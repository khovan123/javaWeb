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

            .container{
                display: flex;
                justify-content: center;
                align-items: center;
                height: 100vh;
            }

            .innerContainer{
                height: 90%;
                width: fit-content;
                padding:54px;
                border-radius: 10px;
                display: flex;
                flex-direction: column;
                justify-content: space-between;
            }

            h1{
                padding-top: 124px;
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

            a{
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
                text-decoration: none;
            }

            a:hover{
                transform: scale(1.05);

            }
        </style>
    </head>
    <body>
        <div class="container">
            <div class="innerContainer">
                <h1>Login successful!</h1>
                <div class="buttonContainer">
                    <a href="CalServlet">Get your caculator</a>
                </div>
            </div>
        </div>
    </body>
</html>
