<%-- 
    Document   : login
    Created on : Oct 17, 2022, 2:18:50 PM
    Author     : quant
--%>

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<h1 class="text-center text-danger">Dang ky</h1>

<h1 class="text-center text-danger">Dang nhap</h1>

<c:if test="${param.error != null}">
    <div class="alert alert-danger">
        Da co loi xay ra, vui long quay lai sau
    </div>
</c:if>

<c:if test="${param.accessDenied != null}">
    <div class="alert alert-danger">
        ban ko co quyen truy cap
    </div>
</c:if>

<c:url value="/login" var="action"/>

<form action="${action}" method="post">
    <div class="form-group">
        <label for="username">Username</label>
        <input type="text" id="username" name="username" class="form-control"/>
    </div>

    <div class="form-group">
        <label for="password">confirm Password</label>
        <input type="text" id="password" name="password" class="form-control"/>
    </div>

    <div class="form-group">

        <input type="submit" value="DANG NHAP" class="btn btn-danger"/>
    </div>
</form>
