<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>Статистика</title>
</head>
<body>
    <form action="${basePath}/api/admin/statistics" method="get">
        <h1>Статистика приложения</h1>
        <p>Количество активных пользователей: ${activeUsers}</p>
        <p>Количество пользователей в приложении: ${quantityUsers}</p>
        <p>Количество сообщений отправленных в приложении: ${quantityMessages}</p>
    </form>
</body>
</html>