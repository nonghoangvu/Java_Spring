<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.3/dist/css/bootstrap.min.css" rel="stylesheet"
          integrity="sha384-QWTKZyjpPEjISv5WaRU9OFeRpok6YctnYmDr5pNlyT2bRjXh0JMhjY6hW+ALEwIH" crossorigin="anonymous">
    <script src="https://cdn.jsdelivr.net/npm/bootstrap@5.3.3/dist/js/bootstrap.bundle.min.js"
            integrity="sha384-YvpcrYf0tY3lHB60NNkmXc5s9fDVZLESaAA55NDzOxhy9GkcIdslK1eN7N6jIeHz"
            crossorigin="anonymous"></script>
</head>
<body>
<div class="container">
    <h1 class="text-center text-secondary text-uppercase">Data</h1>
    <table class="table">
        <thead>
        <tr>
            <th scope="col">#</th>
            <th scope="col">Phone</th>
            <th scope="col">Email</th>
            <th scope="col">Password</th>
            <th scope="col">Locked</th>
        </tr>
        </thead>
        <tbody>
        <c:forEach items="${list}" var="x" varStatus="i">
            <tr>
                <th scope="row">${i.index + 1}</th>
                <td>${x.phoneNumber}</td>
                <td>${x.email}</td>
                <td>${x.password}</td>
                <td>${x.isLocked}</td>
            </tr>
        </c:forEach>
        </tbody>
    </table>
</div>
</body>
</html>
