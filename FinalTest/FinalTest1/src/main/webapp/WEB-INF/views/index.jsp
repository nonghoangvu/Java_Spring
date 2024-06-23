<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
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
<div class="container shadow-lg p-3 mb-5 mt-5 bg-body-tertiary rounded">
    <h1>Quan ly dich vu</h1>
    <form:form action="/dich-vu/add" method="post" modelAttribute="dichVu">
        <div class="row">
            <div class="col-6">
                <div class="mb-3">
                    <label class="form-label">Ten dich vu</label>
                    <form:input path="tenDichVu" type="text" class="form-control"/>
                </div>
                <div class="mb-3">
                    <label class="form-label">Don vi tien</label>
                    <form:input path="donViTien" type="text" class="form-control"/>
                </div>
            </div>
            <div class="col-6">
                <div class="mb-3">
                    <label class="form-label">Don gia</label>
                    <form:input path="donGia" type="number" class="form-control"/>
                </div>
                <div class="mb-3">
                    <label class="form-label">Ten loai dich vu</label>
                    <form:select path="idLoaiDichVu" class="form-select">
                        <option value="">Chon</option>
                        <form:options items="${loaiDichVu}" itemValue="id" itemLabel="tenLoaiDichVu"/>
                    </form:select>
                </div>
            </div>
        </div>
        <button class="btn btn-primary">Add</button>
    </form:form>
    <table class="table">
        <thead>
        <tr>
            <th>Ten dich vu</th>
            <th>Don gia</th>
            <th>Don vi tien</th>
            <th>Ten loai dich vu</th>
            <th>Mo ta loai dich vu</th>
            <th>Hanh dong</th>
        </tr>
        </thead>
        <tbody>
        <c:forEach items="${listDichVu}" var="dv">
            <tr>
                <td>${dv.tenDichVu}</td>
                <td>${dv.donGia}</td>
                <td>${dv.donViTien}</td>
                <td>${dv.idLoaiDichVu.tenLoaiDichVu}</td>
                <td>${dv.idLoaiDichVu.moTa}</td>
                <td>
                    <button class="btn btn-warning" onclick="window.location.href='/dich-vu/detail/${dv.id}'">Detail</button>
                </td>
            </tr>
        </c:forEach>
        </tbody>
    </table>
</div>
</body>
</html>
