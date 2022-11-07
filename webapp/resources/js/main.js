/* 
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/JSP_Servlet/JavaScript.js to edit this template
 */


function addComment(productId) {
    fetch("/SpringMVCSale/api/add-comment", {
        method: 'post',
        body: JSON.stringify({
            "content": document.getElementById("commentId").value,
            "productId": productId
        }),
        headers: {
            "Content-Type": "application/json"
        }
    }).then(function (res) {
        console.info(res);
        return res.json();
    }).then(function (data) {
        console.info(data);

        let area = document.getElementById("commentArea");
        area.innerHTML = `
        <div class="row"">
            <div class="col-md-2">
                <img class="rounded-circle img-fluid" src="${data.userId.avatar}"/>
            </div>
            <div class="col-md-10 my-date">
                <p>${data.content}</p>
                <i>${moment(data.createDate).fromNow()}</i>
            </div>
        </div>
        ` + area.innerHTML;
    });
}

function addToCart(id, name, price) {
    event.preventDefault();
    fetch("/SpringMVCSale/api/cart", {
        method: 'post',
        body: JSON.stringify({
            "productId": id,
            "productName": name,
            "price": price,
            "quantity": 1
        }),
        headers: {
            "Content-Type": "application/json"
        }
    }).then(function (res) {
        return res.json();
    }).then(function (data) {
        let counter = document.getElementById("cartCounter");
        counter.innerText = data;
    });
}

function updateCart(obj, productId) {
    fetch("/SpringMVCSale/api/cart", {
        method: "put",
        body: JSON.stringify({
            "productId": productId,
            "productName": "name",
            "price": 0,
            "quantity": obj.value
        }),
        headers: {
            "Content-Type": "application/json"
        }
    }).then(function (res) {
        return res.json();
    }).then(function (data) {
        let counter = document.getElementById("cartCounter");
        counter.innerText = data.counter;
        let amount = document.getElementById("amountCart");
        amount.innerText = data.amount;
    });
}

function deleteCart(productId) {
    if (confirm("ban chac chan xoa item nay ko?") == true) {
        fetch(`/SpringMVCSale/api/cart/${productId}`, {
            method: "delete"
        }).then(function (res) {
            return res.json();
        }).then(function (data) {
            let counter = document.getElementById("cartCounter");
            counter.innerText = data.counter;
            let amount = document.getElementById("amountCart");
            amount.innerText = data.amount;
            //location.reload();//C1 reload trang khi xoa

            // an khi xoa
            let row = document.getElementById(`product${productId}`);
            row.style.display = "none";
        });
    }
}

function pay() {
    if (confirm("ban chac chan thanh toan ?") == true) {
        fetch("/SpringMVCSale/api/pay", {
            method: "post"
        }).then(function (res) {
            return res.json();
        }).then(function (code) {
            console.info(code);
            location.reload();
        })
    }
}