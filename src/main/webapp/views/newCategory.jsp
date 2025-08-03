<%--
  Created by IntelliJ IDEA.
  User: My Best
  Date: 2025/08/01
  Time: 13:06
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Create Catalog</title>
</head>
<body>
    <form action="<%=request.getContextPath()%>/categoryController/create" method="post">
        <label for ="catalogName">Catalog Name</label>
        <input type="text" id="catalogName" name="catalogName"/><br>
        <label for="description">Description</label>
        <input type="text" id="description" name="description"/><br>
        <label for="active">Status</label>
        <input type="radio" id="active" name="status" value="true" checked/><label for="active">Active</label>
        <input type="radio" id="inActive" name="status" value="false"/><label for="inActive">Inactive</label><br>
        <input type="submit" value="Create"/>
    </form>
</body>
</html>
