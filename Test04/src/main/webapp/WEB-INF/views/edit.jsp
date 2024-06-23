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
<div class="container shadow p-3 mb-5 bg-body-tertiary rounded border mt-5">
    <h1>Update Product</h1>
    <hr>
    <form:form action="/edit" modelAttribute="computer" method="post">
        <input type="hidden" value="${computer.id}" name="id">
        <div class="mb-3">
            <label class="form-label">Code</label>
            <form:input path="ma" type="text" class="form-control"/>
        </div>
        <div class="mb-3">
            <label class="form-label">Name</label>
            <form:input path="tenMayTinh" type="text" class="form-control"/>
        </div>
        <div class="mb-3">
            <label class="form-label">Price</label>
            <form:input path="gia" type="text" class="form-control"/>
        </div>
        <div class="mb-3">
            <label class="form-label">Brand</label>
            <form:select path="hang" cssClass="form-select">
                <option value="" selected>Open this select menu</option>
                <form:options items="${brands}" itemLabel="tenHang"/>
            </form:select>
        </div>
        <div class="mb-3">
            <label class="form-label">Memory</label>
            <form:input path="boNho" type="text" class="form-control"/>
        </div>
        <div class="mb-3">
            <label class="form-label">Color</label>
            <div class="form-check form-check-inline">
                <form:radiobutton path="mauSac" class="form-check-input" value="Xanh"/>
                <label class="form-check-label">Green</label>
            </div>
            <div class="form-check form-check-inline">
                <form:radiobutton path="mauSac" class="form-check-input" value="Xám"/>
                <label class="form-check-label">Gray</label>
            </div>
        </div>
        <div class="mb-3">
            <label class="form-label">Description</label>
            <form:input path="mieuTa" type="text" class="form-control"/>
        </div>
        <button class="btn btn-success">Submit</button>
    </form:form>
</div>
</body>
</html>
