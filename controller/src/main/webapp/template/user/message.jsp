<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<!DOCTYPE html>
<html lang="ru">
<head>
    <meta charset="utf-8">
    <title>Кабинет</title>
</head>
<body>
    <h1>Вы вошли под своим логином и паролем</h1>
    <p>Вы можете посмотреть сообщения, адресованные вам, или отправить сообщение пользователю.</p>

    <form action="${basePath}/api/message" method="get">
        <p><input type="submit" value="Посмотреть входящие сообщения"></p>
        <hr>
    </form>

    <form action="${basePath}/api/message" method="post">
        <p>Кому отправить?
            <label>
                <input maxlength="10" size="20" name="recipienthtml">
            </label>
        </p>
        <p>Текст сообщения:</p>
        <p>
            <label>
                <textarea name="texthtml" cols="40" rows="3"></textarea>
            </label>
        </p>
        <p><input type="submit" value="Отправить"></p>
    </form>

    <form action="${basePath}/api/message" method="get">
            <p><input type="submit" value="Посмотреть входящие сообщения"></p>
            <hr>
        </form>
</body>
</html>
