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
<div class="container shadow-lg p-3 mb-5 bg-body-tertiary rounded mt-5">
    <h1>Quan ly phong</h1>
    <hr>
    <form:form action="/phong/add" modelAttribute="phong" method="post">
        <div class="row">
            <div class="col-6">
                <div class="mb-3">
                    <label class="form-label">Ten Phong</label>
                    <form:input path="tenPhong" type="text" class="form-control"/>
                    <form:errors path="tenPhong" element="div" cssClass="text-danger"/>
                </div>
                <div class="mb-3">
                    <label class="form-label">Trang Thai</label>
                    <div>
                        <form:radiobutton path="trangThai" value="1"/>
                        <label class="form-label">Con phong</label>
                    </div>
                    <div>
                        <form:radiobutton path="trangThai" value="0"/>
                        <label class="form-label">Het phong</label>
                    </div>
                    <form:errors path="trangThai" element="div" cssClass="text-danger"/>
                </div>
                <div class="mb-3">
                    <label class="form-label">Loai Phong</label>
                    <form:select path="idLoaiPhong" class="form-select">
                        <option value=""></option>
                        <form:options items="${listLoaiPhong}" itemValue="id" itemLabel="tenLoaiPhong"/>
                    </form:select>
                    <form:errors path="idLoaiPhong" element="div" cssClass="text-danger"/>
                </div>
            </div>
            <div class="col-6">
                <div class="mb-3">
                    <label class="form-label">So Luong Phong</label>
                    <form:input path="soLuongPhong" type="number" class="form-control"/>
                    <form:errors path="soLuongPhong" element="div" cssClass="text-danger"/>
                </div>
                <div class="mb-3">
                    <label class="form-label"> Ghi Chu</label>
                    <form:input path="ghiChu" type="text" class="form-control"/>
                    <form:errors path="ghiChu" element="div" cssClass="text-danger"/>
                </div>
            </div>
        </div>
        <button class="btn btn-primary">Add</button>
    </form:form>
    <hr>
    <table class="table">
        <thead>
        <tr>
            <th>Ten phong</th>
            <th>So luong phong</th>
            <th>Trang thai</th>
            <th>Ghi Chu</th>
            <th>Ten loai phong</th>
            <th>Hoat dong</th>
        </tr>
        </thead>
        <tbody>
        <c:forEach var="p" items="${listPhong.content}">
            <tr>
                <td>${p.tenPhong}</td>
                <td>${p.soLuongPhong}</td>
                <td>${p.trangThai == 0 ? 'Con phong' : 'Het phong'}</td>
                <td>${p.ghiChu}</td>
                <td>${p.idLoaiPhong.tenLoaiPhong}</td>
                <td>
                    <button class="btn btn-primary" onclick="window.location.href='/phong/detail/${p.id}'">Detail
                    </button>
                </td>
            </tr>
        </c:forEach>
        </tbody>
    </table>
    <nav>
        <ul class="pagination">
            <li class="page-item"><a href="/phong/paging?page=0" class="page-link">First</a></li>
            <c:if test="${listPhong.hasPrevious()}">
                <li class="page-item"><a href="/phong/paging?page=${listPhong.number - 1}" class="page-link">Prev</a></li>
            </c:if>
            <li class="page-item"><a class="page-link">${listPhong.number + 1}</a></li>
            <c:if test="${listPhong.hasNext()}">
                <li class="page-item"><a href="/phong/paging?page=${listPhong.number + 1}" class="page-link">Next</a></li>
            </c:if>
            <li class="page-item"><a href="/phong/paging?page=${listPhong.totalPages - 1}" class="page-link">Last</a>
            </li>
        </ul>
    </nav>
</div>
</body>
</html>
