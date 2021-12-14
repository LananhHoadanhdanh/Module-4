<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%--
  Created by IntelliJ IDEA.
  User: Admin
  Date: 12/14/2021
  Time: 8:17 AM
  To change this template use File | Settings | File Templates.
--%>
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
  <title>Sandwich Condiments</title>
</head>
<body>
<h2>Sandwich Condiments</h2>
<form action="/save">
  <input type="checkbox" value="Lettuce" name="condiment"> Lettuce
  <input type="checkbox" value="Tomato" name="condiment"> Tomato
  <input type="checkbox" value="Mustard" name="condiment"> Mustard
  <input type="checkbox" value="Sprouts" name="condiment"> Sprouts
  <br><button>save</button>
</form>
<br>

<c:forEach var="con" items="${condiment}">
  ${con} <br>
</c:forEach>
</body>
</html>
