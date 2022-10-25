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

<div id="header">Head of App</div>
<div id="leftSidebar">

        <form action="searchProduct" method="get">

            <input type="text" name="searchName"/>
            <input type="submit" value="Search"/>



        </form>
    <br>

    <table>
        <tr>
            <th>All products</th>
        </tr>


        <c:forEach var="prod" items="${allProds}">

            <c:url var="updateButton" value="updateInfo">
                <c:param name="prodId" value="${prod.id}"/>
            </c:url>

            <c:url var="deleteButton" value="deleteProduct">
                <c:param name="prodId" value="${prod.id}"/>
            </c:url>

            <tr>
                <td>${prod.name}</td>
                <td>

                    <input type="button" value="Update"
                           onclick="window.location.href = '${updateButton}'"/>

                    <input type="button" value="Delete"
                           onclick="window.location.href = '${deleteButton}'"/>

                </td>
            </tr>
        </c:forEach>

    </table>
    <br>
    <input type="button" value="Add new product"
           onclick="window.location.href = 'addNewProduct'"/>

</div>
<div id="main">

</div>
<div id="footer">

</div>

</body>
</html>