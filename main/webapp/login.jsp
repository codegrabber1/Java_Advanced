<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<html>
<head>
    <meta charset="UTF-8">
    <link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/twitter-bootstrap/4.5.3/css/bootstrap.min.css">
    <link rel="stylesheet" href="styles/style.css">
    <title>Авторизація</title>
</head>
<body>

<jsp:include page="header.jsp"></jsp:include>
<h2>Авторизація</h2>
<div class="wrraper">
    <div class="container">
    <div class="row">
        <div class="form_block">
            <form action="login" method="post">
                <div class="row">
                    <div class="col-12 col-md-12">
                        <p>
                            <label for="login">Ваш логін:</label>
                            <input type="email" id="login" name="login">
                        </p>
                        <p>
                            <label for="pass">Ваш пароль:</label>
                            <input type="password" id="pass" name="pass">
                        </p>
                    </div>
                </div>

                <input type="submit" class="btn btn-warning" value="Відправити">
            </form>
        </div>
    </div>
</div>
</div>
<jsp:include page="footer.jsp"></jsp:include>
</body>
</html>
