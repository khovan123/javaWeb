1. Servlet

1.1 Option 1
If you defined servlet in web.xml like this:
```
<?xml version="1.0" encoding="UTF-8"?>
<web-app>
    <servlet>
        <servlet-name>YourServlet</servlet-name>
        <servlet-class>YourServlet</servlet-class>
    </servlet>
    <servlet-mapping>
        <servlet-name>YourServlet</servlet-name>
        <url-pattern>/url-to-your-servlet</url-pattern>
    </servlet-mapping>
</web-app>
```
!!! After this, do not define: @WebServlet("/url-to-your-servlet") in your servlet

1.2 Option 2
If you defined servlet in web.xml like above and you would like to use @WebServlet("/url-to-your-servlet") in your servlet. You must to delete this part in web.xml:
```
    <servlet-mapping>
        <servlet-name>YourServlet</servlet-name>
        <url-pattern>/url-to-your-servlet</url-pattern>
    </servlet-mapping>
```
