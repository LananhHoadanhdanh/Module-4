<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%--
  Created by IntelliJ IDEA.
  User: vieth
  Date: 12/2/2021
  Time: 4:46 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
<center>
    <h2>Edit Blog?</h2>
    <form method="post">
        <table style="text-align: left" cellpadding="5">
            <tr>
                <th>Name:</th>
                <td><input type="text" name="name" value="${product.name}"></td>
            </tr>
            <tr>
                <th>Price:</th>
                <td><input type="number" name="price" value="${product.price}"></td>
            </tr>
            <tr>
                <th>Quantity:</th>
                <td><input type="number" name="quantity" value="${product.quantity}"></td>
            </tr>
            <tr>
                <th>Color:</th>
                <td><input type="text" name="color" value="${product.color}"></td>
            </tr>
            <tr>
                <th>CategoryId:</th>
                <td>
                    <select name="categoryId">
                        <option value="${product.categoryId}">${product.categoryId}</option>
                        <c:forEach var="category" items="${categories}">
                            <option value="${category.id}">${category.id}. ${category.name}</option>
                        </c:forEach>
                    </select>
                </td>
            </tr>
            <tr>
                <th>Are you sure?</th>
                <td>
                    <button>Send</button>
                </td>
            </tr>
        </table>
    </form>
    <a href="/products"><h3>Back to product list</h3></a>
</center>
</body>
</html>
