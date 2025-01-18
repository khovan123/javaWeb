<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>DemoStupidPage</title>
        <style>
            body {
                font-family: 'lato', sans-serif;
                margin: 0;
            }
            ul{
                padding:0;
            }
            .container {
                max-width: 1000px;
                height: 100vh;
                margin-left: auto;
                margin-right: auto;
                padding-left: 10px;
                padding-right: 10px;

            }
            .inner-container{
                display: flex;
                height: 90%;
                flex-direction: column;
                justify-content: space-between;
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
                    flex-basis: 40%;
                }
                .col-2 {
                    flex-basis: 60%;
                }

            }

            .pagination{
                list-style: none;
                display: flex;
                justify-content: center;
                align-items: center;
                gap:12px;
                li{
                    a{
                        text-decoration: none;
                        color: black;
                        padding: 6px 12px;
                        border-radius: 5px;
                        transition: all 0.25s linear;

                    }
                    a:hover{
                        background: #95A5A6;

                    }
                    .active{
                        background: #95A5A6;
                    }
                }
            }

        </style>
    </head>
    <body>          
        <c:if test="${records == null}">
            <script>
                window.location.href = "${"DemoStupidPage/search?page=1"}"
            </script>
        </c:if>
        <c:if test="${records != null}">
            <div class="container">
                <h2>Table<small>Infomation</small></h2>
                <div class="inner-container">
                    <ul class="responsive-table">
                        <li class="table-header">
                            <div class="col col-1">ID</div>
                            <div class="col col-2">Name</div>     
                        </li>
                        <c:forEach var="record" items="${records}">
                            <li class="table-row">
                                <div class="col col-1" data-label="Id">${record.getId()}</div>
                                <div class="col col-2" data-label="Name">${record.getName()}</div>
                            </li>
                        </c:forEach>    
                    </ul>
                    <c:import url="tagPage.jsp">
                        <c:param name="maxIndex" value="${maxIndex}"/>
                        <c:param name="active" value="${active}"/>
                    </c:import>
                </div>
            </div>
        </c:if>        
    </body>
</html>
