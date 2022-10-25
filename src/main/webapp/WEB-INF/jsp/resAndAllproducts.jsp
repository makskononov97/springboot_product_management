<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
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
        <input type="submit" value="Search">

        <br>
        <br>
        <table>
            <tr>
                <th>Results:</th>
            </tr>


            <c:forEach var="prod" items="${searchRes}">

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

        <input type="button" value="Add new product"
               onclick="window.location.href = 'addNewProduct'"/>

        <input type="button" value="Show all"
               onclick="window.location.href = 'products'"/>



    </form>
</div>

<div id="main"></div>
<div id="footer">Footer</div>

</body>
</html>