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
<div class="container shadow-lg p-3 mt-5 bg-body-tertiary rounded">
    <h1>Quan ly phong</h1>
    <form:form modelAttribute="phong" action="/phong/add" method="post">
        <div class="row mb-3">
            <div class="col-6">
                <div class="mb-3">
                    <label class="form-label">Ten phong</label>
                    <form:input path="tenPhong" type="text" class="form-control"/>
                    <form:errors path="tenPhong" cssClass="text-danger" element="div"/>
                </div>
                <div class="mb-3">
                    <label class="form-label">Trang thai</label>
                    <div>
                        <form:radiobutton path="trangThai" value="1"/>
                        <label>Con phong</label>
                    </div>
                    <div>
                        <form:radiobutton path="trangThai" value="0"/>
                        <label>Het phong</label>
                    </div>
                    <form:errors path="trangThai" cssClass="text-danger" element="div"/>
                </div>
                <div class="mb-3">
                    <form:select path="idLoaiPhong" class="form-select">
                        <option value="">Chon</option>
                        <form:options items="${listLoaiPhong}" itemLabel="tenLoaiPhong" itemValue="id"/>
                    </form:select>
                    <form:errors path="idLoaiPhong" cssClass="text-danger" element="div"/>
                </div>
            </div>
            <div class="col-6">
                <div class="mb-3">
                    <label class="form-label">So luong phong</label>
                    <form:input path="soLuongPhong" type="text" class="form-control"/>
                    <form:errors path="soLuongPhong" cssClass="text-danger" element="div"/>
                </div>
                <div class="mb-3">
                    <label class="form-label">Ghi chu</label>
                    <form:input path="ghiChu" type="text" class="form-control"/>
                    <form:errors path="ghiChu" cssClass="text-danger" element="div"/>
                </div>
            </div>
        </div>
        <button class="btn btn-primary">Add</button>
        <hr>
    </form:form>
    <table class="table table-striped">
        <thead>
        <tr>
            <th>Ten phong</th>
            <th>So luong phong</th>
            <th>Trang thai</th>
            <th>Ghi chu</th>
            <th>Ten loai phong</th>
            <th>Hanh dong</th>
        </tr>
        </thead>
        <tbody>
        <c:forEach items="${listPhong.content}" var="p">
            <tr>
                <td>${p.tenPhong}</td>
                <td>${p.soLuongPhong}</td>
                <td>${p.trangThai == 0 ? 'Het phong' : 'Con phong'}</td>
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
            <li class="page-item"><a href="/phong/paging?p=0" class="page-link">First</a></li>
            <c:if test="${listPhong.hasPrevious()}">
                <li class="page-item"><a href="/phong/paging?p=${listPhong.number - 1}" class="page-link">Previous</a>
                </li>
            </c:if>
            <li class="page-item"><a class="page-link">${listPhong.number + 1}</a></li>
            <c:if test="${listPhong.hasNext()}">
                <li class="page-item"><a href="/phong/paging?p=${listPhong.number + 1}" class="page-link">Next</a></li>
            </c:if>
            <li class="page-item"><a href="/phong/paging?p=${listPhong.totalPages - 1}" class="page-link">Last</a></li>
        </ul>
    </nav>
</div>
</body>
</html>
