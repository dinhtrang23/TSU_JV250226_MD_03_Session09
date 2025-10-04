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
    <title>Title</title>
</head>
<body>
<form action="<%=request.getContextPath()%>/productController/update" method="post" enctype="multipart/form-data">
    <label for="productId">Product Id</label>
    <input type="text" id="productIdId" name="productId" value="${product.productId}" readonly/><br>
    <label for="productName">Product Name</label>
    <input type="text" id="productName" name="productName" value="${product.productName}"/><br>
    <label for="price">Price</label>
    <input type="text" id="price" name="price" value="${product.price}"/><br>
    <label for="file">Product Image</label>
    <input type="file" id="file" name="file"/><br>
    <label for="created">Created</label>
    <input type="date" id="created" name="created" value="${product.created}"/><br>
    <label for="catalog">Catalog</label>
    <select id="catalog" name="catalogId">
        <c:forEach var="cat" items="${catalogList}">
            <option value="${cat.catalogId}" ${product.catalog.catalogId == cat.catalogId ? "selected" : ""}>
                    ${cat.catalogName}
            </option>
        </c:forEach>
    </select><br>
    <label for="active">Status</label>
    <input type="radio" id="active" name="status" value="true" ${product.status?"checked":""}/><label for="active">Active</label>
    <input type="radio" id="inActive" name="status" value="false" ${product.status?"":"checked"}/><label for="inActive">Inactive</label><br>
    <input type="submit" value="Update"/>
</form>
</body>
</html>
