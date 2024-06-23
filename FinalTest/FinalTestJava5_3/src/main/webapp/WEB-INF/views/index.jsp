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
<div class="container show-lg p-3 bg-body-tertiary rounded mt-5">
    <h1>Quan ly phong</h1>
    <form action="/dat-phong/search">
        <label class="form-label">Tim kiem</label>
        <input type="text" class="form-control" name="keyword" placeholder="Ma dat phong" value="${keyword}">
        <button class="btn btn-primary mt-3">Tim kiem</button>
    </form>
    <hr>
    <form:form action="/dat-phong/update?id=${phong.id}" modelAttribute="phong">
        <div class="row">
            <div class="col-6">
                <div class="mb-3">
                    <label class="form-label">Ma</label>
                    <form:input path="maDatPhong" type="text" class="form-control"/>
                    <form:errors path="maDatPhong" cssClass="text-danger" element="div"/>
                </div>
                <div class="mb-3">
                    <label class="form-label">So luong khach hang</label>
                    <form:input path="soLuongKhach" type="text" class="form-control"/>
                    <form:errors path="soLuongKhach" cssClass="text-danger" element="div"/>
                </div>
                <div class="mb-3">
                    <label class="form-label">So luong khach hang</label>
                    <form:select path="idKhachHang" class="form-select">
                        <option value=""></option>
                        <form:options items="${listKhachHang}" itemValue="id" itemLabel="tenKhachHang"/>
                    </form:select>
                    <form:errors path="idKhachHang" cssClass="text-danger" element="div"/>
                </div>
            </div>
            <div class="col-6">
                <div class="mb-3">
                    <label class="form-label">Ngay dat</label>
                    <form:input path="ngayGioDat" type="date" class="form-control"/>
                    <form:errors path="ngayGioDat" cssClass="text-danger" element="div"/>
                </div>
                <div class="mb-3">
                    <label class="form-label">So luong phong</label>
                    <form:input path="soLuongPhongDat" type="number" class="form-control"/>
                    <form:errors path="soLuongPhongDat" cssClass="text-danger" element="div"/>
                </div>
                <div class="mb-3">
                    <label class="form-label">Ghi chu</label>
                    <form:input path="ghiChu" type="text" class="form-control"/>
                    <form:errors path="ghiChu" cssClass="text-danger" element="div"/>
                </div>
            </div>
        </div>
        <button class="btn btn-primary">Update</button>
    </form:form>
    <c:if test="${not empty listPhong}">
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
            <c:forEach var="p" items="${listPhong}">
                <tr>
                    <td>${p.maDatPhong}</td>
                    <td>${p.ngayGioDat}</td>
                    <td>${p.soLuongKhach}</td>
                    <td>${p.soLuongPhongDat}</td>
                    <td>${p.idKhachHang.maKhachHang}</td>
                    <td>${p.idKhachHang.tenKhachHang}</td>
                    <td>
                        <button class="btn btn-warning" onclick="window.location.href='/dat-phong/view-update/${p.id}'">
                            Update
                        </button>
                    </td>
                </tr>
            </c:forEach>
            </tbody>
        </table>
    </c:if>
    <c:if test="${empty listPhong}">
        <h1>Khong con phan tu nao</h1>
    </c:if>
</div>
</body>
</html>
