<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page language="java" contentType="text/html; ISO-8859-1" pageEncoding="windows-1256" %>
<!DOCTYPE html>
<html>
<link rel="stylesheet" type="text/css" href="webjars/bootstrap/4.3.1/css/bootstrap.min.css">
<script src="webjars/bootstrap/4.3.1/js/bootstrap.min.js"></script>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=windows-1256">
<title>Insert title here</title>
</head>
<body>
<div class="container mt-5">
    <div class="card">
        <div class="card-body">
            <h1 class="card-title">Add Product</h1>
            <form action="saveProduct" method="post">
                <div class="form-group">
                    <label class="control-label">Product Name</label>
                    <input type="text" name="productName" class="form-control" />
                </div>
                <div class="form-group">
                    <label class="control-label">Product Price</label>
                    <input type="text" name="productPrice" class="form-control" />
                </div>
                <div class="form-group">
                    <label class="control-label">Creation Date</label>
                    <input type="date" name="creationDate" class="form-control" />
                </div>
                <div class="form-group">
                    <button type="submit" class="btn btn-primary">Add</button>
                </div>
            </form>
        </div>
    </div>
    ${msg}
    <a href="listProducts">Products List</a>
</div>
</body>