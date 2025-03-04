<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
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
                .buttonContainer{
                    display: flex;
                    justify-content: center;
                    padding-bottom: 40px;
                }

                button{
                    width: fit-content;
                    color: #fff;
                    background-color: #95A5A6;
                    border: none;
                    padding:24px 56px;
                    border-radius: 100px;
                    text-transform: uppercase;
                    font-weight: 600;
                    transition: transform 0.3s ease-in-out;
                    cursor: pointer;
                    font-size: 14px;
                }

                button:hover{
                    transform: scale(1.05);

                }
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
                    flex-basis: 30%;
                }
                .col-2 {
                    flex-basis: 70%;
                }
                .row{
                    display:flex;
                    gap:6px;

                    a{
                        text-decoration:none;
                        font-size: 14px;
                    }

                    .delete{
                        color:red;
                    }
                }
            }
        </style>
    </head>
    <body>
        <c:if test="${students==null}">
            <a href="marks">Show marks</a>
        </c:if>
        <c:if test="${students!=null}">
            <div class="container">
                <h2>Table<small> Marks of Student</small></h2>
                <ul class="responsive-table">
                    <li class="table-header">
                        <div class="col col-1">Name</div>
                        <div class="col col-2">Marks</div>
                    </li>
                    <c:forEach var="student" items="${students}">
                        <li class="table-row">
                            <div class="col col-1">${student.getName()}</div>
                            <div class="col col-2">${student.toString()}</div>
                        </li>    
                    </c:forEach>
                </ul>
            </div>
        </c:if>
    </body>
</html>
