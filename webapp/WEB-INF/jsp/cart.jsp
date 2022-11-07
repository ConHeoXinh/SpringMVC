<%-- 
    Document   : cart
    Created on : Oct 22, 2022, 1:29:20 PM
    Author     : quant
--%>

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<h1>Gio hang</h1>

<c:if test="${cart==null}">
    <h3 class="text-danger">ko co san pham nao trong gio</h3>
</c:if>
<c:if test="${cart!=null}">
    <table class="table">
        <tr>
            <th>Ma san pham</th>
            <th>Ten san pham</th>
            <th>Don gia</th>
            <th>So luong</th>
            <th></th>
        </tr>
        <c:forEach var="c" items="${carts}">
            <tr id="product${c.productId}">
                <td>${c.productId}</td>
                <td>${c.productName}</td>
                <td>${c.price} VND</td>
                <td>
                    <div class="form-group">
                        <input type="number" onblur="updateCart(this, ${c.productId})" value="${c.quantity}" class="form-control"/>
                    </div>
                </td>
                <td>
                    <input type="button" value="Xoa" onclick="deleteCart(${c.productId})" class="btn btn-danger"/>
                </td>
            </tr>
        </c:forEach>
    </table>
    <div>
        <h4>Tong tien hoa don: <span id="amountCart">${cartStats.amount}</span> VND</h4>
    </div>
        <input type="button" value="Thanh toan" onclick="pay()" class="btn btn-danger"/>
</c:if>