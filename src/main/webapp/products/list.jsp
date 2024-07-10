<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<!DOCTYPE html>
<html>
<head>
    <title>Danh sách sản phẩm</title>

    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.0.2/dist/css/bootstrap.min.css" rel="stylesheet"
          integrity="sha384-EVSTQN3/azprG1Anm3QDgpJLIm9Nao0Yz1ztcQTwFspd3yD65VohhpuuCOmLASjC" crossorigin="anonymous">
</head>
<body>
<div class="container">
    <div class="container">
        <button class="btn btn-primary mt-4" onclick="window.location.href='/product?action=create'">Thêm mới</button>
        <div>
            <p>
                Danh sách top
                <select id="top" name="top">
                    <option value="3">3</option>
                    <option value="5">5</option>
                    <option value="10">10</option>
                </select>
                Sản phẩm được đặt hàng nhiều nhất
                <button class="btn btn-primary mt-4" onclick="window.location.href='/product?action=see'">Xem</button>
            </p>
        </div>
        <table class="table table-hover">
            <thead>
            <tr>
                <th>STT</th>
                <th>Name</th>
                <th>Price</th>
                <th>Discount</th>
                <th>Stock</th>
            </tr>
            </thead>
            <tbody>
            <c:forEach var="product" items="${products}" varStatus="status">
                <tr>
                    <td>${status.count}</td>
                    <td>${product.productName}</td>
                    <td><fmt:formatNumber type="number" maxFractionDigits="5" value="${product.price}" /> VND</td>
                    <td>${product.discount}</td>
                    <td>${product.stock}</td>
            </c:forEach>
            </tbody>
        </table>
    </div>
</div>
</body>
<script src="https://cdn.jsdelivr.net/npm/bootstrap@5.0.2/dist/js/bootstrap.bundle.min.js"
        integrity="sha384-MrcW6ZMFYlzcLA8Nl+NtUVF0sA7MsXsP1UyJoMp4YLEuNSfAP+JcXn/tWtIaxVXM"
        crossorigin="anonymous"></script>
</html>