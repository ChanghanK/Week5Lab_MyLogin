<%-- 
    Document   : home
    Created on : Feb 4, 2021, 5:01:32 PM
    Author     : 827637
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Home Page</title>
    </head>
    <body>
        <h1>Home Page</h1>
        <h2>Hello ${user.username}.</h2>
        <a href="login?logout=logout">Log out</a>
    </body>
</html>
