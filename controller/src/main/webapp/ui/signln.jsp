<%@ page language="java"
    contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>Авторизация</title>
</head>
<body>
    <h1>Авторизуйтесь</h1>
    <form action="http://127.0.0.1:8080/controller-1.0-SNAPSHOT/login" method="post">
        <label for="login">Логин:</label>
        <input type="text" id="login" name="login" required><br>
        <label for="password">Пароль:</label>
        <input type="password" id="password" name="password" required><br>
        <input type="submit" value="Войти">
    </form>
</body>
</html>