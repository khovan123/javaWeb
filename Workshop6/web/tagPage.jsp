<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<ul>
    <c:forEach begin="1" end="${maxIndex}" var="index">
        <li key="${index}" style="">
            <a style="${index==active?"color:red;text-decoration: none;":""}" href="${pageContext.request.getContextPath()}/DemoStupidPage/search?page=${index}">${index==1?"First":(index==maxIndex?"Last":index)}</a>
        </li>   
    </c:forEach>
</ul>