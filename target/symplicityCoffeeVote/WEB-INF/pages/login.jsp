<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <link href="//maxcdn.bootstrapcdn.com/bootstrap/3.3.0/css/bootstrap.min.css" rel="stylesheet" id="bootstrap-css">
    <script src="//maxcdn.bootstrapcdn.com/bootstrap/3.3.0/js/bootstrap.min.js"></script>
    <script src="//code.jquery.com/jquery-1.11.1.min.js"></script>

</head>
<body onload='document.loginForm.username.focus();'>
<div class="container" id="login-box" style="margin-top: 200px">
    <div class="row">
        <div class="col-md-4 col-md-offset-4">
            <div class="panel panel-default">
                <div class="panel-heading">
                    <h3 class="panel-title">Welcome to vote application</h3>
                </div>
                <div class="panel-body">
                    <h4>Login with username and password</h4>
                    <c:if test="${not empty error}">
                        <div class="error">${error}</div>
                    </c:if>
                    <c:if test="${not empty msg}">
                        <div class="msg">${msg}</div>
                    </c:if>
                    <form name='loginForm' action="<c:url value='/login' />" method='POST' role="form">
                        <fieldset>
                            <fieldset>
                                <div class="form-group">
                                    <input class="form-control" placeholder="Username" name="username" type="text"
                                           autofocus>
                                </div>
                                <div class="form-group">
                                    <input class="form-control" placeholder="Password" name="password"
                                           type="password" value="">
                                </div>
                                <button type="submit" class="btn btn-success btn-block">Login</button>
                            </fieldset>
                        </fieldset>
                        <input type="hidden" name="${_csrf.parameterName}"
                               value="${_csrf.token}"/>

                    </form>

                </div>
            </div>
        </div>
    </div>
</div>


</body>
</html>