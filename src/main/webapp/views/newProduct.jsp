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
    <title>Create Product</title>
</head>
<body>
<form action="<%=request.getContextPath()%>/productController/create" method="post">
    <label for ="price">Price</label>
    <input type="text" id="price" name="price"/><br>
    <label for="productName">Name</label>
    <input type="text" id="productName" name="productName"/><br>
    <label for="active">Status</label>
    <input type="radio" id="active" name="status" value="true" checked/><label for="active">Active</label>
    <input type="radio" id="inActive" name="status" value="false"/><label for="inActive">Inactive</label><br>
    <input type="submit" value="Create"/>
</form>
</body>
</html>
