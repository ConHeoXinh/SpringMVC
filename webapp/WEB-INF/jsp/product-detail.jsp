<%-- 
    Document   : product-detail
    Created on : Oct 20, 2022, 1:41:10 PM
    Author     : quant
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<div class="row">
    <div class="col-md-6">

        <c:choose>
            <c:when test="${product.image != null && product.image.startsWith('https')==true}">
                <img class="card-img-top img-fluid" src="${product.image}" alt="Card image">
            </c:when>
            <c:when test="${product.image == null || product.image.startsWith('https')==false}">
                <img class="card-img-top img-fluid" src="<c:url value="/images/Test.jpg"/>" alt="Card image">
            </c:when>
        </c:choose>

    </div>
    <div class="col-md-6">
        <h1>${product.name}</h1>
        <h3 class="text-danger">${product.price} VND</h3>
        <p>${product.description}</p>

        <div>
            <input type="button" value="Dat hang" class="btn btn-danger"/>
        </div>
    </div>
</div>
<br>
<form>
    <div class="form-group"  style="padding: 10px">
        <textarea class="form-control" id="commentId" placeholder="Nhap danh gia cua ban...."></textarea>
        <input type="button" onclick="addComment(${product.id})" value="Gui binh luan" class="btn btn-danger"/>
    </div>
</form>


<div id="commentArea">
    <c:forEach items="${product.commentCollection}" var="comment">
        <div class="row"">
            <div class="col-md-2">
                <img class="rounded-circle img-fluid" src="<c:url value="/images/Test.jpg" />"/>
            </div>
            <div class="col-md-10 my-date">
                <p>${comment.content}</p>
                <i>${comment.createDate}</i>
            </div>
        </div>
    </c:forEach>
</div>

<script>
    window.onload = function () {
        let dates = document.querySelectorAll(".my-date > i");
        for (let i = 0; i < dates.length; i++) {
            let d = dates[i];
            d.innerText = moment(d.innerText).fromNow();
        }
    };
</script>