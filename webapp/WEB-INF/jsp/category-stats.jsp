<%-- 
    Document   : category-base
    Created on : Oct 24, 2022, 8:56:09 PM
    Author     : quant
--%>

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<h1 class="text-center text-danger">
    Thong ke san pham theo danh muc
</h1>

<div>
    <canvas id="myCateStatsChart"></canvas>
</div>

<table class="table">
    <tr>
        <th>Ma danh muc</th>
        <th>Ten danh muc</th>
        <th>So luong</th>
    </tr>
    <c:forEach var="c" items="${cateStats}">
        <tr>
            <td>${c[0]}</td>
            <td>${c[1]}</td>
            <td>${c[2]}</td>
        </tr>
    </c:forEach>
</table>

<script>
    let cateLabels = [], cateInfo=[];
    <c:forEach items="${cateStats}" var="c">
    cateLabels.push(`${c[1]}`);
    cateInfo.push(`${c[2]}`);
    </c:forEach>

    window.onload = function () {
        cateChart("myCateStatsChart", cateLabels, cateInfo);
    }
</script>