<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Login</title>
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.3/dist/css/bootstrap.min.css" rel="stylesheet"
          integrity="sha384-QWTKZyjpPEjISv5WaRU9OFeRpok6YctnYmDr5pNlyT2bRjXh0JMhjY6hW+ALEwIH" crossorigin="anonymous">
    <script defer src="https://cdn.jsdelivr.net/npm/bootstrap@5.3.3/dist/js/bootstrap.bundle.min.js"
            integrity="sha384-YvpcrYf0tY3lHB60NNkmXc5s9fDVZLESaAA55NDzOxhy9GkcIdslK1eN7N6jIeHz"
            crossorigin="anonymous"></script>
</head>
<body>
<div class="container w-25 mt-2">
    <h1 class="text-center text-uppercase text-bold text-secondary">Login</h1>
    <div>
        <form:form action="/login" method="post" modelAttribute="user">
            <p>Username: <form:input path="username" class="form-control " type="text" value="${user.username}"/></p>
            <form:errors path="username" cssClass="text-danger" element="div"></form:errors>
            <p>Password: <form:input path="password" class="form-control" type="password" value="${user.password}"/></p>
            <form:errors path="password" cssClass="text-danger" element="div"></form:errors>
            <button class="btn btn-outline-secondary mt-2">Login</button>
        </form:form>
    </div>
</div>
</body>
</html>
