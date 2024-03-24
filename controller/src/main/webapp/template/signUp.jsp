<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>Регистрация</title>
</head>
<body>
    <form action="${basePath}/api/user" method="post">
        <p><b>Пожалуйста, заполните обязательные поля для регистрации.</b></p>
        <p>Логин:
            <input maxlength="10" size="20" name="login"></p>
        <p>Пароль:
            <input type="password" maxlength="10" size="20" name="password"></p>
        <p>Введите информацию о себе:</p>
        <p>Фамилия: <input type="text" name="fullName"></p>
        <p>Имя: <input type="text" name="fullName"></p>
        <p>Отчество: <input type="text" name="fullName"></p>
        <p><label for="date">Дата рождения:</label>
            <input type="date" id="date" name="date"></p>
        <p><label>Роль:</label>
            <select name="role">
                <option value="user">User</option>
                <option value="admin">Admin</option>
            </select>
        </p>
        <p><input type="submit" value="Зарегистрироваться"></p>
    </form>
</body>
</html>