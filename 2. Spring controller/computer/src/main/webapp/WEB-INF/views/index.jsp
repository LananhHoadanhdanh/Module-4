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
  <title>Computer</title>
</head>
<body>
<h2>Computer</h2>
<form action="/computer">
  <input type="text" name="first">
  <input type="text" name="second">
  <select name="cal" id="cal">
    <option value="plus">+</option>
    <option value="minus">-</option>
    <option value="multi">*</option>
    <option value="div">/</option>
  </select>
  <button>Tinh</button>
</form>
<br>
<p>Result: ${result}</p>
</body>
</html>
