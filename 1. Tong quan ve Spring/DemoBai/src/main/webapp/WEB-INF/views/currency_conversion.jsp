<%--
  Created by IntelliJ IDEA.
  User: Admin
  Date: 12/13/2021
  Time: 4:28 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
<form action="/convert">
    <table>
        <tr>
            <th>Số tiền: </th>
            <td><input type="text" name="vnd" > </td>
        </tr>
        <tr>
            <th>Tỉ giá USD: </th>
            <td><input type="text" name="usd" value="23000"></td>
        </tr>
        <tr>
            <th></th>
            <td><button>Tính</button></td>
        </tr>
    </table>
</form>
Kết quả: ${result}
</form>
</body>
</html>
