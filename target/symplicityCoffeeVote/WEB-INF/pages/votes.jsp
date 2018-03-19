<%@taglib uri="http://www.springframework.org/tags/form" prefix="form" %>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <meta name="viewport" content="initial-scale=1, maximum-scale=1">
    <link rel='stylesheet' href='webjars/bootstrap/3.2.0/css/bootstrap.min.css'>
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

            <%--<ul>--%>
            <%--<c:forEach var="listValue" items="${votes}">--%>
            <%--<li>${listValue.fruit}</li>--%>
            <%--<li>${listValue.userName}</li>--%>
            <%--</c:forEach>--%>
            <%--</ul>--%>
        <c:forEach items="${votes}" var="voteMap" varStatus="status">
    <tr>
        <td>${voteMap.key}</td>
        <td>${voteMap.value}</td>
    </tr>
    </c:forEach>
    </c:if>
    </tr>
</table>
<input type="button" value="Back" onclick="javascript:history.back()"/>

<script type="text/javascript" src="webjars/jquery/2.1.1/jquery.min.js"></script>
<script type="text/javascript" src="webjars/bootstrap/3.2.0/js/bootstrap.min.js"></script>

</body>
</html>