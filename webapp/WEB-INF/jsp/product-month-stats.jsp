<%-- 
    Document   : product-month-stats
    Created on : Oct 25, 2022, 2:18:26 PM
    Author     : quant
--%>

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<h1 class="text-center text-success">Thong ke doanh thu theo thang</h1>

<form action="">
    <div class="form-group">
        <label>Tu khoa</label>
        <input type="text" name="kw" class="form-control"/>
    </div>
    <div class="form-group">
        <label>Tu thoi diem</label>
        <input type="date" name="fromDate" class="form-control"/>
    </div>
    <div class="form-group">
        <label>Den thoi diem</label>
        <input type="date" name="toDate" class="form-control"/>
    </div>
    <input type="submit" value="Bao cao" class="btn btn-success"/>
</form>

<div>
    <canvas id="myProductMonthStatsChart"></canvas>
</div>

<table class="table">
    <tr>
        <th>Thang</th>
        <th>Doanh thu</th>
    </tr>
    <c:forEach var="p" items="${productMonthStats}">
        <tr>
            <td>${p[0]}/${p[1]}</td>
            <td>${p[2]} VND</td>
        </tr>
    </c:forEach>
</table>

<script>
    let productLabels = [], productInfo = [];
    <c:forEach items="${productMonthStats}" var="p">
    productLabels.push(`${p[0]}/${p[1]}`);
    productInfo.push(`${p[2]}`);
    </c:forEach>

    window.onload = function () {
        productChart("myProductMonthStatsChart", productLabels, productInfo);
    }
</script>