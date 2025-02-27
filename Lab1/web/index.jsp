<!DOCTYPE html>
<html>
    <head>
        <title>TODO supply a title</title>
        <meta charset="UTF-8">
        <meta name="viewport" content="width=device-width, initial-scale=1.0">
        <style>
            body {
                font-family: 'lato', sans-serif;
                margin: 0;
            }
            .container{
                height: 100vh;
                display: flex;
                justify-content: center;
                align-items: center;
                background-color: #343a40;
                .innerContainer{
                    border-radius: 20px;
                    background-color: #ffffff;
                    width: 99%;
                    height: 99%;
                    display:flex;
                    flex-direction: column;
                    align-items: center;
                    justify-content: space-between;
                    h1{
                        font-size:80px;
                        background-image: linear-gradient(0.1turn, #23D1FD,#6F78FE,#B524FF);
                        -webkit-background-clip: text;
                        color: transparent;
                    }
                    .buttonContainer{
                        display: flex;
                        justify-content: center;
                        padding-bottom: 40px;
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
                        font-size: 12px;
                        text-decoration: none;
                    }

                    a:hover{
                        transform: scale(1.05);

                    }
                }
            }
        </style>
    </head>
    <body>
        <div class="container">
            <div class="innerContainer">
                <h1>Welcome</h1>
                <span class="buttonContainer">
                    <a href='login.jsp'>Getting Started</a>
                </span>
            </div>
        </div>
    </body>
</html>
