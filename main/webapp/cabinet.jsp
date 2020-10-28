<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<html>
<head>
    <link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/twitter-bootstrap/4.5.3/css/bootstrap.min.css">
    <link rel="stylesheet" href="styles/style.css">
    <title>Кабінет користувача</title>
</head>
<body>
<jsp:include page="header.jsp"></jsp:include>

<div class="wrraper">
    <div class="container">
        <div class="row">
            <div class="form_block">
                <h1>Вітаю, ${firstName}!</h1>
            </div>
        </div>
    </div>
</div>

<jsp:include page="footer.jsp"></jsp:include>
</body>
</html>
