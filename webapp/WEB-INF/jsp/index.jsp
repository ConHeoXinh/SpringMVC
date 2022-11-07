<%-- 
    Document   : index
    Created on : Oct 19, 2022, 1:30:35 PM
    Author     : quant
--%>

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>

<c:if test="${currentUser != null}">
    ${currentUser.email} - ${currentUser.firstName}
</c:if>

<div class="row">
    <c:forEach var="p" items="${products}">
        <div class="col-md-4 col-xs-12" style="padding: 10px">
            <div class="card">
                <a href="<c:url value="/products/${p.id}"/>">
                    <c:choose>
                        <c:when test="${p.image != null && p.image.startsWith('https')==true}">
                            <img class="card-img-top img-fluid" src="${p.image}" alt="Card image">
                        </c:when>
                        <c:when test="${p.image == null || p.image.startsWith('https')==false}">
                            <img class="card-img-top img-fluid" src="<c:url value="/images/Test.jpg"/>" alt="Card image">
                        </c:when>
                    </c:choose>
                </a>

                <div class="card-body">
                    <h4 class="card-title">${p.name}</h4>
                    <p class="card-text">${p.price} VND</p>
                    <a href="#" class="btn btn-primary"onclick="addToCart(${p.id}, '${p.name}', ${p.price})">Dat hang</a>
                </div>
            </div>
        </div>
    </c:forEach>
</div>

<ul class="pagination justify-content-center">
    <c:forEach var="i" begin="1" end="${Math.ceil(productCounter/6)}">
        <c:url value="/" var="proPage">
            <c:param name="page" value="${i}"></c:param>
        </c:url>
        <li class="page-item"><a class="page-link" href="${proPage}">${i}</a></li>
        </c:forEach>
</ul>
<hr>
<div class="alert alert-success">
    <h1>Ca san pham ban chay</h1>
</div>
<div class="row">
    <c:forEach var="p" items="${hotProducts}">
        <div class="col-md-4 col-xs-12" style="padding: 10px">
            <div class="card">
                <a href="<c:url value="/products/${p[0]}"/>">
                    <c:choose>
                        <c:when test="${p[3] != null && p[3].startsWith('https')==true}">
                            <img class="card-img-top img-fluid" src="${p[3]}" alt="Card image">
                        </c:when>
                        <c:when test="${p[3] == null || p[3].startsWith('https')==false}">
                            <img class="card-img-top img-fluid" src="<c:url value="/images/Test.jpg"/>" alt="Card image">
                        </c:when>
                    </c:choose>
                </a>

                <div class="card-body">
                    <h4 class="card-title">${p[1]}</h4>
                    <p class="card-text">${p[2]} VND</p>
                    <p class="text-danger">so luong ban: ${p[4]}</p>
                    <a href="#" class="btn btn-primary">Dat hang</a>
                </div>
            </div>
        </div>
    </c:forEach>
</div>

<hr>
<div class="alert alert-success">
    <h1>Cac san phan dc thao luan nhieu nhat</h1>
</div>
<div class="row">
    <c:forEach var="p" items="${disProducts}">
        <div class="col-md-4 col-xs-12" style="padding: 10px">
            <div class="card">
                <a href="<c:url value="/products/${p[0]}"/>">
                    <c:choose>
                        <c:when test="${p[3] != null && p[3].startsWith('https')==true}">
                            <img class="card-img-top img-fluid" src="${p[3]}" alt="Card image">
                        </c:when>
                        <c:when test="${p[3] == null || p[3].startsWith('https')==false}">
                            <img class="card-img-top img-fluid" src="<c:url value="/images/Test.jpg"/>" alt="Card image">
                        </c:when>
                    </c:choose>
                </a>

                <div class="card-body">
                    <h4 class="card-title">${p[1]}</h4>
                    <p class="card-text">${p[2]} VND</p>
                    <p class="text-danger">so thao luan: ${p[4]}</p>
                    <a href="#" class="btn btn-primary">Dat hang</a>
                </div>
            </div>
        </div>
    </c:forEach>
</div>