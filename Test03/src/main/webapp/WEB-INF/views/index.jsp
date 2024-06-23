<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.3/dist/css/bootstrap.min.css" rel="stylesheet"
          integrity="sha384-QWTKZyjpPEjISv5WaRU9OFeRpok6YctnYmDr5pNlyT2bRjXh0JMhjY6hW+ALEwIH" crossorigin="anonymous">
    <script defer src="https://cdn.jsdelivr.net/npm/bootstrap@5.3.3/dist/js/bootstrap.bundle.min.js"
            integrity="sha384-YvpcrYf0tY3lHB60NNkmXc5s9fDVZLESaAA55NDzOxhy9GkcIdslK1eN7N6jIeHz"
            crossorigin="anonymous"></script>
</head>
<body>
<div class="container shadow p-3 mb-5 bg-body-tertiary rounded border mt-5">
    <h1>Product Management</h1>
    <hr>
    <table class="table">
        <thead>
        <tr>
            <th scope="col">ID</th>
            <th scope="col">Name</th>
            <th scope="col">Price</th>
            <th scope="col">Memory</th>
            <th scope="col">Color</th>
            <th scope="col">Brand</th>
            <th scope="col">Action</th>
        </tr>
        </thead>
        <tbody>
<%--        <c:forEach items="${computers.content}" var="c">--%>
<%--            <tr>--%>
<%--                <th scope="row">${c.id}</th>--%>
<%--                <td>Mark</td>--%>
<%--                <td>Otto</td>--%>
<%--                <td>@mdo</td>--%>
<%--            </tr>--%>
<%--        </c:forEach>--%>
        </tbody>
    </table>
</div>
</body>
</html>
