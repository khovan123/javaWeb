<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head> 
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
            display: flex;
            justify-content: start;
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
            padding:20px 50px;
            border-radius: 100px;
            text-transform: uppercase;
            font-weight: 600;
            transition: transform 0.3s ease-in-out;
            cursor: pointer;
        }

        button:hover{
            transform: scale(1.05);

        }
        
        .checkBox{
            display: flex;
            align-items: center;
            gap: 6px;
        }
        .checkBox label{
            margin: 0;
        }
        .checkBox input{
            width: fit-content;
            margin: 0;
        }
    </style>
    <body>
        <div class="formContainer">
            <form action="auth" method="post">
                <h1>Login Now</h1>
                <div>
                    <label>Username</label> 
                    <input type="text" id="userName" name="userName"/>
                </div>
                <div>
                    <label>Password</label>
                    <input type="password" id="passowrd" name="password"/>
                </div>
                <div class="checkBox">
                    <label>Remember me</label>
                    <input type="checkbox" id="remember" name="remember" value="remember"/>
                </div>
                <div class="buttonContainer">
                    <button type="submit" style="grid-column: 2/3;width: fit-content;">Login</button>
                </div>
            </form>
        </div>
    </body>
</html>
