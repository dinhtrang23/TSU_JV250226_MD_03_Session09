<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%--
  Created by IntelliJ IDEA.
  User: My Best
  Date: 2025/08/02
  Time: 21:19
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Product</title>
</head>
<body>
<h3>List Product</h3>
<table border="1">
    <thead>
    <tr>
        <th>No</th>
        <th>Product ID</th>
        <th>Product Name</th>
        <th>Price</th>
        <th>Image</th>
        <th>Created</th>
        <th>Catalog</th>
        <th>Status</th>
        <th>Actions</th>
    </tr>
    </thead>
    <tbody>
    <c:forEach items="${listProducts}" var="product" varStatus="loop">
        <tr>
            <td>${loop.index+1}</td>
            <td>${product.productId}</td>
            <td>${product.productName}</td>
            <td>${product.price}</td>
            <td><img src="${product.image}" width="100" height="100" alt="${product.productName}"/></td>
            <td>${product.created}</td>
            <td>${product.catalog.catalogName}</td>
            <td>${product.status?"Active":"Inactive"}</td>
            <td>
                <a href="<%=request.getContextPath()%>/productController/initUpdate?productId=${product.productId}">Update</a>
                <a href="<%=request.getContextPath()%>/productController/delete?productId=${product.productId}">Delete</a>
            </td>
        </tr>
    </c:forEach>
    </tbody>
</table>
<a href="<%=request.getContextPath()%>/productController/initCreate">Create new catalog...</a>
</body>
</html>
