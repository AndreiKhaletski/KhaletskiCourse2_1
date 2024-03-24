<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>Login Form</title>
</head>
<body>
    <h1>Авторизуйтесь</h1>
    <form action="${basePath}/api/login" method="post">
        <label for="login">Логин:</label>
        <input type="text" id="login" name="login"><br>
        <label for="password">Пароль:</label>
        <input type="password" id="password" name="password"><br>
        <input type="submit" value="Войти">
    </form>
</body>
</html>