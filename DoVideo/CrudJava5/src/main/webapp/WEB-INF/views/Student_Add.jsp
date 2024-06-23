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
<div class="container">
    <h1 class="text-center text-secondary">New Student</h1>
    <form:form action="/add" method="post" class="row mt-5" modelAttribute="student">
        <form:errors path="*" element="div" cssClass="alert alert-danger"></form:errors>
        <div class="col-6">
            <div class="form-floating mb-3">
                <form:input path="fullName" type="text" class="form-control"/>
                <label>Full name</label>
            </div>
        </div>
        <div class="col-6">
            <div class="form-floating mb-3">
                <form:input path="age" type="text" class="form-control"/>
                <label>Age</label>
            </div>
        </div>
        <div class="col-6">
            <div class="form-check form-check-inline">
                <form:radiobutton path="gender" class="form-check-input" name="gender" value="true"/>
                <label class="form-check-label">Male</label>
            </div>
            <div class="form-check form-check-inline">
                <form:radiobutton path="gender" class="form-check-input" name="gender" value="false"/>
                <label class="form-check-label">Female</label>
            </div>
        </div>
        <button class="btn btn-outline-secondary mt-5">Save</button>
    </form:form>
</div>
</body>
</html>
