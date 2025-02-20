<%-- 
    Document   : FindUs
    Created on : Jun 1, 2020, 11:50:54 AM
    Author     : pc
--%>

<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Find us</title>
        <link type="text/css" rel="stylesheet" href="css/style.css">
        <link href="css/findus.css" rel="stylesheet" type="text/css"/>
        <link href="css/container.css" rel="stylesheet" type="text/css"/>
        <link href="css/header.css" rel="stylesheet" type="text/css"/>
        <link href="css/footer.css" rel="stylesheet" type="text/css"/>
    </head>
    <body>

        <div class="wrap">
            <%@include file="header.jsp" %>
            <div class="content">
                <div class="main-content">
                    <div class="content-left">
                        <h2>Find us</h2>
                        <div class="info">
                            <div class="contact">
                                <h3>Address and Contact</h3>
                                <p>${address}</p>
                            </div>
                            <div class="tel-mail">
                                <p>
                                    <span>Tel: </span>
                                    ${tel}
                                </p>
                                <p>
                                    <span>Email: </span>
                                    ${mail}
                                </p>
                            </div>
                        </div>
                        <div class="opening">
                            <h3>Opening Hours</h3>
                            <c:forEach var="i" items="${openHours}">
                                <p>${i}</p>
                            </c:forEach>
                        </div>
                        <div class="map">

                            <iframe src="https://www.google.com/maps/embed?pb=!1m14!1m12!1m3!1d239.80866341059487!2d108.22034569330057!3d15.912286526300768!2m3!1f0!2f0!3f0!3m2!1i1024!2i768!4f13.1!5e0!3m2!1svi!2sus!4v1739862313950!5m2!1svi!2sus" width="600" height="450" frameborder="0" style="border:0;" allowfullscreen="" aria-hidden="false" tabindex="0"></iframe>
                        </div>



                    </div>
                    <%@include file="container.jsp" %>
                </div>
                <%@include file="footer.jsp" %>
            </div>
        </div>
    </body>
</html>
