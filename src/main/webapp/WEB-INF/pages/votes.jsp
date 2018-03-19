<%@taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<html>
<head>
    <title>Spring MVC Form Handling</title>
</head>




<body>

<h2>Submitted User Information</h2>
<table>

    <tr>
        <td>Fruit</td>
        <td>${fruit}</td>
    </tr>
    <tr>
        <c:if test="${not empty votes}">

            <ul>
                <c:forEach var="listValue" items="${votes}">
                    <li>${listValue.fruit}</li>
                    <li>${listValue.userName}</li>
                </c:forEach>
            </ul>

        </c:if>
    </tr>
</table>
<input type="button" value="Back" onclick="javascript:history.back()"/>
</body>
</html>