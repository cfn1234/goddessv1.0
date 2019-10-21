<%@ page contentType="text/html;charset=UTF-8" pageEncoding="UTF-8" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<c:set var="cep" value="${pageContext.request.contextPath}" />
<!DOCTYPE html>
<html>
<head>
    <meta http-equiv="Content-type" content="text/html; charset=UTF-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge,chrome=1"/>
    <title>登录</title>
    <script type="text/javascript">
        var cepPath = "${cep}";
    </script>
</head>
<body>

<h1>${message}</h1>
<form method="post" action="${cep}/login">
    用户名：<input name="username"><br>
    密码：<input name="password"><br>
    <input type="submit" value="登录">
</form>

</body>
</html>
