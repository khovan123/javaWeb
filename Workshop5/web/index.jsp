<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Employee List</title>
        <style>
            body {
                font-family: 'lato', sans-serif;
                margin: 0;
            }
            .container {
                max-width: 1000px;
                margin-left: auto;
                margin-right: auto;
                padding-left: 10px;
                padding-right: 10px;
            }

            h2 {
                font-size: 26px;
                margin: 20px 0;
                text-align: center;
                small {
                    font-size: 0.5em;
                }
            }

            .responsive-table {
                li {
                    border-radius: 3px;
                    padding: 25px 30px;
                    display: flex;
                    justify-content: space-between;
                    margin-bottom: 25px;
                }
                .table-header {
                    background-color: #95A5A6;
                    font-size: 14px;
                    text-transform: uppercase;
                    letter-spacing: 0.03em;
                }
                .table-row {
                    background-color: #ffffff;
                    box-shadow: 0px 0px 9px 0px rgba(0,0,0,0.1);
                }
                .col-1 {
                    flex-basis: 25%;
                }
                .col-2 {
                    flex-basis: 25%;
                }
                .col-3 {
                    flex-basis: 20%;
                }
                .col-4 {
                    flex-basis: 20%;
                }
                .col-5{
                    flex-basis: 10%;
                }
            }
            .formContainer{
                height: 100vh;
                display: flex;
                justify-content: center;
                align-items: center;
                background-color: #343a40;
                .form{
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
                        font-size: 12px;
                    }

                    button:hover{
                        transform: scale(1.05);

                    }
                }
            }
        </style>
    </head>
    <body>
        <c:if test="${employees == null}">
            <div class="formContainer">
                <form action="send" method="get" class="form">
                    <h1>Welcome</h1>
                    <div class="buttonContainer">
                        <button type="submit">Employees Information</button>
                    </div>
                </form>
            </div>
        </c:if>
        <c:if test="${employees != null}">
            <div class="container">
                <h2>Table<small>Employee Information</small></h2>
                <ul class="responsive-table">
                    <li class="table-header">
                        <div class="col col-1">First</div>
                        <div class="col col-2">Last Name</div>
                        <div class="col col-3">City</div>
                        <div class="col col-4">Street</div>
                        <div class="col col-5">Code ZIP</div>  
                    </li>
                    <c:forEach var="employee" items="${employees}">
                        <li class="table-row">
                            <div class="col col-1">${employee.getName().getFirstName()} </div>
                            <div class="col col-2">${employee.getName().getLastName()}</div>
                            <div class="col col-3">${employee.getAddress().getCity()}</div>
                            <div class="col col-4">${employee.getAddress().getStreet()}</div>
                            <div class="col col-5">${employee.getAddress().getZIP()}</div>
                        </li>    
                    </c:forEach>

                </ul>
            </div>
        </c:if>

    </body>
</html>
