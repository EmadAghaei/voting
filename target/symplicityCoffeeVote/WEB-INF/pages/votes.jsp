<%@taglib uri="http://www.springframework.org/tags/form" prefix="form" %>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <meta name="viewport" content="initial-scale=1, maximum-scale=1">
    <link rel='stylesheet' href='webjars/bootstrap/3.2.0/css/bootstrap.min.css'>
    <link href="//maxcdn.bootstrapcdn.com/bootstrap/3.3.0/css/bootstrap.min.css" rel="stylesheet" id="bootstrap-css">
    <script src="//maxcdn.bootstrapcdn.com/bootstrap/3.3.0/js/bootstrap.min.js"></script>
    <script src="//code.jquery.com/jquery-1.11.1.min.js"></script>

<body>
<script>
    function formSubmit() {
        document.getElementById("logoutForm").submit();
    }
</script>

<c:if test="${pageContext.request.userPrincipal.name != null}">
    <p>
        <a href="javascript:formSubmit()" class="btn btn-success" style=" margin-left : 50px; margin-top: 25px">
            <span class="glyphicon glyphicon-log-out"></span> Log out
        </a>
    </p>
</c:if>
<c:url value="/logout" var="logoutUrl"/>
<form action="${logoutUrl}" method="post" id="logoutForm">
    <input type="hidden" name="${_csrf.parameterName}" value="${_csrf.token}"/>
</form>


<div class="alert alert-warning" style="margin-top: 50px">
    <div>
        <a href="#" class="close" data-dismiss="alert"></a>
        <strong>Thank you!</strong> Your vote is submitted. You have selected ${fruit}
    </div>
    <%--</div>--%dsff>
    <%--<p>${fruit}</p>--%>

</div>
<div class="table-responsive col-sm-4" style="margin-left: 50px">
    <table class="table ">
        <thead>
        <tr>

            <th scope="col">Fruit</th>
            <th scope="col">Number of votes</th>
        </tr>
        </thead>
        <c:if test="${not empty votes}">
            <c:forEach items="${votes}" var="voteMap" varStatus="status">
                <tr>

                    <td>${voteMap.key}</td>
                    <td>${voteMap.value}</td>
                </tr>
            </c:forEach>
        </c:if>

    </table>
</div>
<%--<input type="button" value="Back" onclick="javascript:history.back()"/>--%>


<script type="text/javascript" src="webjars/jquery/2.1.1/jquery.min.js"></script>
<script type="text/javascript" src="webjars/bootstrap/3.2.0/js/bootstrap.min.js"></script>

</body>
</html>