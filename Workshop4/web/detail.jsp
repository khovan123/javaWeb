<!DOCTYPE html>
<%
    String displayName=null;
    if (request.getSession(false) == null || request.getSession(false).getAttribute("displayName") == null) {     
        request.getSession(false).invalidate();
        Cookie[] cookies = request.getCookies();
        boolean loggined = false;        
        if (cookies != null) {
            for (Cookie c : cookies) {  
                if (c.getName().equals("login") && c.getValue().equals("true")) {
                    for (Cookie ck : cookies) {  
                        if (ck.getName().equals("displayName")) {
                            loggined = true;
                            displayName = (String) ck.getValue();
                            break;
                        }
                    }
                    break;
                }
            }
        }

            if (!loggined) {
            response.sendRedirect("login.jsp");
        }
    }else{
        displayName = (String) request.getSession(false).getAttribute("displayName");
        request.getSession(false).invalidate();
    }
%>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
    <body>
        <h1 style="text-align: center">Hello: <%=displayName%></h1>
    </body>
</html>
