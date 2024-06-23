<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
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
<div class="container m-5">
    <h1 class="text-center">ABCXYZ</h1>
    <form action="/dat-phong/search" method="get">
        <div class="mb-3">
            <label for="exampleInputEmail1" class="form-label">Tim kiem</label>
            <input type="search" name="maDatPhong" class="form-control" aria-describedby="emailHelp">
        </div>
        <button class="btn btn-primary">Tim kiem</button>
    </form>
    <form:form action="/dat-phong/update" modelAttribute="order" method="post">
        <form:input path="id" type="hidden"/>
        <div class="row">
            <div class="col-6">
                <div class="mb-3">
                    <label for="exampleInputEmail1" class="form-label">Ma</label>
                    <form:input path="maDatPhong" type="text" class="form-control" aria-describedby="emailHelp"/>
                    <form:errors path="maDatPhong" cssClass="form-text text-danger" element="div"/>
                </div>
                <div class="mb-3">
                    <label for="exampleInputEmail1" class="form-label">So luong khach</label>
                    <form:input path="soLuongKhach" type="number" class="form-control" aria-describedby="emailHelp"/>
                    <form:errors path="soLuongKhach" cssClass="form-text text-danger" element="div"/>
                </div>
                <div class="mb-3">
                    <label for="exampleInputEmail1" class="form-label">Khach hang</label>
                    <form:select path="idKhachHang" cssClass="form-select">
                        <form:options items="${khachHang}" itemLabel="tenKhachHang" itemValue="id"/>
                    </form:select>
                </div>
            </div>
            <div class="col-6">
                <div class="mb-3">
                    <label for="exampleInputEmail1" class="form-label">Ngay dat</label>
                    <form:input path="ngayGioDat" type="date" class="form-control" id="exampleInputEmail1" aria-describedby="emailHelp"/>
                    <form:errors path="ngayGioDat" cssClass="form-text text-danger" element="div"/>
                </div>
                <div class="mb-3">
                    <label for="exampleInputEmail1" class="form-label">So luong phong</label>
                    <form:input path="soLuongPhongDat" type="number" class="form-control" aria-describedby="emailHelp"/>
                    <form:errors path="soLuongPhongDat" cssClass="form-text text-danger" element="div"/>
                </div>
                <div class="mb-3">
                    <label for="exampleInputEmail1" class="form-label">Ghi chu</label>
                    <form:input path="ghiChu" type="text" class="form-control" aria-describedby="emailHelp"/>
                </div>
            </div>
        </div>
        <button class="btn btn-primary">Update</button>
    </form:form>
    <c:if test="${not empty datPhong}">
        <table class="table">
            <thead>
            <tr>
                <th>Ma</th>
                <th>Ngay dat</th>
                <th>So luong khach</th>
                <th>So luong phong</th>
                <th>Ma khach hang</th>
                <th>Ten khach hang</th>
                <th>Hanh dong</th>
            </tr>
            </thead>
            <tbody>
            <c:forEach var="x" items="${datPhong}">
                <tr>
                    <th scope="row">${x.maDatPhong}</th>
                    <td>${x.ngayGioDat}</td>
                    <td>${x.soLuongKhach}</td>
                    <td>${x.soLuongPhongDat}</td>
                    <td>${x.idKhachHang.id}</td>
                    <td>${x.idKhachHang.tenKhachHang}</td>
                    <td>
                        <a href="/dat-phong/view-update/${x.id}" class="btn btn-warning">Update</a>
                        <a href="/dat-phong/delete/${x.id}" class="btn btn-danger">Xoa</a>
                    </td>
                </tr>
            </c:forEach>
            </tbody>
        </table>
    </c:if>
    <c:if test="${empty datPhong}">
        <h1 class="text-center text-secondary">No result!</h1>
    </c:if>
</div>
<div class="form-check form-check-inline">
    <input class="form-check-input" type="radio">
    <label class="form-check-label">Male</label>
</div>
<div class="form-check form-check-inline">
    <input class="form-check-input" type="radio">
    <label class="form-check-label">Female</label>
</div>
</body>
</html>
