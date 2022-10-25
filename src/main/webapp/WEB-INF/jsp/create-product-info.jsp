<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
         pageEncoding="ISO-8859-1"%>

<!DOCTYPE html>
<html>
<head>
    <meta charset="utf-8">
    <title>My App</title>
    <style>
        div{
            margin: 10px;
            border: 1px solid black;
            font-size: 20px;
            height: 80px;
        }
        #header{
            background-color: #ccc;
        }
        #leftSidebar{
            background-color: #ddd;
            float: left;
            width: 250px;
            height: 390px;
        }
        #main{
            background-color: #eee;
            height: 400px;
            margin-left: 270px;
        }
        #footer{
            background-color: #ccc;
        }
    </style>
</head>
<body>

<div id="header"></div>

<div id="leftSidebar">

    <input type="button" value="Return to products list"
           onclick="window.location.href = 'products'"/>

</div>


<div id="main">

<h2>Please enter information about the new product</h2>
<br>


<form:form action="createProduct" modelAttribute="product" method="get">

    <form:hidden path="id"/>

    Name <form:input path="name"/>
    <form:errors path="name"/>
    <br><br>
    Text <form:input path="text"/>
    <form:errors path="text"/>
    <br><br>
    Price <form:input path="price"/>
    <form:errors path="price"/>
    <br><br>
    <input type="submit" value="OK">
    <br><br>
    <input type="button" value="Clear fields"
           onclick="window.location.href = 'addNewProduct'"/>


</form:form>

<br>


</div>
<div id="footer"></div>
</body>
</html>
