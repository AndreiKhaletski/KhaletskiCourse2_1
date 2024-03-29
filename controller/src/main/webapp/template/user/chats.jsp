<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<!DOCTYPE html>
<html>
 <head>
  <meta charset="utf-8">
  <title>Сообщения</title>
 </head>
 <body>
    <table border="1">
       <caption>Сообщения</caption>
       <tr>
        <th>Дата и время отправки</th>
        <th>От кого</th>
        <th>Текст</th>
       </tr>
      <c:choose>
        <c:when test="${empty message}">
          <tr>
            <td colspan="3" align="center">Сообщений нет!</td>
          </tr>
        </c:when>
        <c:otherwise>
          <c:forEach var="messages" items="${message}">
                  <tr>
                   <td>${messages.sendingDataTime}</td>
                   <td>${messages.sender}</td>
                   <td>${messages.text}</td>
                  </tr>
              </c:forEach>
        </c:otherwise>
      </c:choose>
    </table>
 </body>
</html>