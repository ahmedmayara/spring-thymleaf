<%@ page language="java" contentType="text/html; ISO-8859-1" pageEncoding="windows-1256" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<link rel="stylesheet" type="text/css" href="webjars/bootstrap/4.3.1/css/bootstrap.min.css">
<script src="webjars/bootstrap/4.3.1/js/bootstrap.min.js" type="application/javascript"></script>
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=windows-1256">
    <title>Insert title here</title>
</head>
<body>
<div class="container mt-5">
    <div class="card">
        <div class="card-header">
            <h3>Product Details</h3>
        </div>
        <div class="card-body">
            <form action="updateProduct" method="post">
                <div class="form-group">
                    <label>Product ID</label>
                    <input readonly type="text" name="productId" value="${product.productId}" class="form-control"/>
                </div>
                <div class="form-group">
                    <label>Product Name</label>
                    <input type="text" name="productName" value="${product.productName}" class="form-control"/>
                </div>
                <div class="form-group">
                    <label>Product Price</label>
                    <input type="text" name="productPrice" value="${product.productPrice}" class="form-control"/>
                </div>
                <div class="form-group">
                    <label>Creation Date</label>
                    <fmt:formatDate value="${product.createdAt}" pattern="yyyy-MM-dd" var="formatDate"/>
                    <input type="date" name="creationDate" value="${formatDate}" class="form-control"/>
                </div>
                <div class="flex flex-row">
                    <input type="submit" value="Update" class="btn btn-primary"/>
                    <a href="listProducts" class="btn btn-secondary">Back</a>
                </div>
            </form>
        </div>
    </div>
</div>
</body>
</html>