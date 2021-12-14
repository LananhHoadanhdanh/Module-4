<%--
  Created by IntelliJ IDEA.
  User: Admin
  Date: 12/13/2021
  Time: 4:46 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
<h2>Vietnamese Dictionary</h2>
<form action="/translate">
    <input type="text" name="vietNam" placeholder="Enter your word: "/>
    <input type="submit" id="submit" value="Search"/> <br><br>
    Kết quả: ${result}
</form>
</body>
</html>
