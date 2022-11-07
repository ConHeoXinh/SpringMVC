/* 
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/JSP_Servlet/JavaScript.js to edit this template
 */
function generateColor() {
    let r = parseInt(Math.random() * 255);
    let g = parseInt(Math.random() * 255);
    let b = parseInt(Math.random() * 255);
    return `rgb(${r},${g},${b})`;
}

function cateChart(id, cateLabels = [], cateInfo = []) {
    let colors = [];
    for (let i = 0; i < cateInfo.length; i++) {
        colors.push(generateColor());
    }

    const data = {
        labels: cateLabels,
        datasets: [{
                label: 'Thong ke san pham theo danh muc',
                data: cateInfo,
                backgroundColor: colors,
                hoverOffset: 4
            }]
    };
    const config = {
        type: 'doughnut',
        data: data,
    };

    let ctx = document.getElementById(id).getContext("2d");
    new Chart(ctx, config);
}

function productChart(id, productLabels = [], productInfo = []){
    let colors = [];
    for (let i = 0; i < productInfo.length; i++) {
        colors.push(generateColor());
    }

    const data = {
        labels: productLabels,
        datasets: [{
                label: 'Thong ke san pham theo san pham',
                data: productInfo,
                backgroundColor: colors,
                borderColor: colors,
                hoverOffset: 4
            }]
    };
    const config = {
        type: 'bar',
        data: data,
    };

    let ctx = document.getElementById(id).getContext("2d");
    new Chart(ctx, config);
}

function productMonthChart(id, productLabels = [], productInfo = []){
    let colors = [];
    for (let i = 0; i < productInfo.length; i++) {
        colors.push(generateColor());
    }

    const data = {
        labels: productLabels,
        datasets: [{
                label: 'Thong ke san pham theo thang',
                data: productInfo,
                backgroundColor: colors,
                borderColor: colors,
                hoverOffset: 4
            }]
    };
    const config = {
        type: 'bar',
        data: data,
    };

    let ctx = document.getElementById(id).getContext("2d");
    new Chart(ctx, config);
}
