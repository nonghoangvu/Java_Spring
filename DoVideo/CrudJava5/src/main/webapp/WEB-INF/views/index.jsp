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
<div class="container text-center">
    <h1 class="text-secondary">Student Management</h1>
    <a href="/add" class="h4">New Student</a>
    <table class="table text-center mt-3">
        <thead>
        <tr>
            <th scope="col">#</th>
            <th scope="col">FullName</th>
            <th scope="col">Age</th>
            <th scope="col">Gender</th>
            <th scope="col">Action</th>
        </tr>
        </thead>
        <tbody>
        <c:forEach varStatus="i" items="${listStudent}" var="s">
        <tr>
            <th scope="row">${i.index + 1}</th>
            <td>${s.fullName}</td>
            <td>${s.age}</td>
            <td>${s.gender ? "Male" : "Female"}</td>
            <td>
                <a href="/${s.id}" class="btn btn-outline-danger">Delete</a>
                <a href="/update/${s.id}" class="btn btn-outline-info">Edit</a>
            </td>
            </c:forEach>
        </tr>
        </tbody>
    </table>
</div>
</body>
</html>
