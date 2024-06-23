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
<div class="container">
    <h1 class="text-center">New Employee</h1>
    <form action="/khach-hang" method="post">
        <div class="form-floating mb-3">
            <input type="text" class="form-control" name="hoTen">
            <label>Full Name</label>
        </div>
        <div class="form-floating mb-3">
            <input type="text" class="form-control" name="sdt">
            <label>Phone number</label>
        </div>
        <div class="form-floating mb-3">
            <select class="form-select" name="hang">
                <option selected>Rank</option>
                <option value="Vang">Vang</option>
                <option value="Bac">Bac</option>
                <option value="Dong">Dong</option>
            </select>
        </div>
        <div class="form-check mb-3">
            <input class="form-check-input" type="checkbox" value="true" name="trangThai" id="flexCheckChecked" checked>
            <label class="form-check-label" for="flexCheckChecked">
                Activity
            </label>
        </div>
        <button class="btn btn-outline-secondary">Save</button>
    </form>

    <h2>List Employees</h2>
    <c:forEach var="x" items="${listEmp}">
        <a href="/khach-hang/detail?sdt=${x.sdt}">${x.hoTen}</a> <br>
    </c:forEach>
</div>
</body>
</html>
