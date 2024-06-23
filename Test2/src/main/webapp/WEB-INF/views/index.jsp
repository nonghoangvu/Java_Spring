<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%--
  Created by IntelliJ IDEA.
  User: NONG HOANG VU
  Date: 5/22/2024
  Time: 9:32 AM
  To change this template use File | Settings | File Templates.
--%>
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
    <h1 class="text-center text-uppercase">New invoice</h1>
    <c:if test="${param.success != null}">
        <div class="alert alert-success" role="alert">
            Successfully
        </div>
    </c:if>
    <form:form method="post" modelAttribute="invoice" action="/">
        <div class="mb-3">
            <label for="id" class="form-label">ID</label>
            <form:input path="id" type="number" class="form-control"/>
            <form:errors path="id" element="div" cssClass="form-text text-danger"/>
        </div>
        <div class="mb-3">
            <label for="id" class="form-label">Customer</label>
            <form:select path="customer" items="${customer}" itemValue="name" cssClass="form-select" itemLabel="name"/>
            <form:errors path="customer" element="div" cssClass="form-text text-danger"/>
        </div>
        <div class="mb-3">
            <label for="id" class="form-label">Value</label>
            <form:input path="value" type="number" class="form-control"/>
            <form:errors path="value" element="div" cssClass="form-text text-danger"/>
        </div>
        <div class="mb-3">
            <label for="id" class="form-label">Payment Method: </label>
            <form:radiobutton path="paymentMethod" value="cash" label="Cash"/>
            <form:radiobutton path="paymentMethod" value="transfer" label="Transfer"/>
            <form:errors path="paymentMethod" element="div" cssClass="form-text text-danger"/>
        </div>
        <div class="mb-3">
            <label for="id" class="form-label">Status: </label>
            <form:checkbox path="paymentMethod" value="cash"/>
            <form:errors path="status" element="div" cssClass="form-text text-danger"/>
        </div>
        <button class="btn btn-outline-dark">Submit</button>
    </form:form>
</div>
</body>
</html>
