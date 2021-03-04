<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<html>
<head>
    <link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/twitter-bootstrap/4.5.3/css/bootstrap.min.css">
    <link rel="stylesheet" href="styles/style.css">
    <title>Реєстрація</title>
</head>
<body>

<jsp:include page="header.jsp"></jsp:include>

<h2>Реєстрація</h2>
    <div class="wrraper">
<div class="container">
    <div class="row">
        <div class="form_block">
            <ul class="nav nav-tabs" id="authTabs" role="tablist">
                <li class="nav-item">
                    <a class="nav-link active" data-toggle="tab" href="#register" role="tab">Реєстрація</a>
                </li>
                <li class="nav-item">
                    <a class="nav-link" data-toggle="tab" href="#auth" role="tab">Авторизація</a>
                </li>

            </ul>
            <div class="tab-content">
                <div class="tab-pane fade show active" role="tabpanel" id="register">
                    <form action="registration" method="post">
                        <div class="row">
                            <div class="col-12 col-md-6">
                                <p>
                                    <label for="register_name">Ваше ім'я:</label>
                                    <input type="text" id="register_name" name="name">
                                </p>
                             </div>
                            <div class="col-12 col-md-6">
                                <p>
                                    <label for="lname">Ваше прізвище:</label>
                                    <input type="text" id="lname" name="lastname">
                                </p>
                            </div>
                            <div class="col-md-12">
                                <p>
                                    <label for="register_email">Ваш email:</label>
                                    <input type="email" id="register_email" name="email">
                                </p>
                                <p>
                                    <label for="register_pass">Ваш пароль:</label>
                                    <input type="password" id="register_pass" name="pass">
                                </p>
                            </div>
                        </div>
                        <input type="submit" name="btnSubmit" class="btn btn-warning btnRegistration" value="Відправити">
                    </form>
                </div>

                <div class="tab-pane fade" role="tabpanel" id="auth">
                    <form action="login" method="post">
                        <div class="row">
                            <div class="col-12 col-md-12">
                                <p>
                                    <label for="login">Ваш логін:</label>
                                    <input type="email" id="login" name="login">
                                </p>
                                <p>
                                    <label for="password">Ваш пароль:</label>
                                    <input type="password" id="password" name="pass">
                                </p>
                            </div>
                        </div>

                        <input type="submit" class="btn btn-warning btnLogin" value="Відправити">
                    </form>

                </div>
            </div>
        </div>
    </div>
</div>
</div>
<jsp:include page="footer.jsp"></jsp:include>
<script src="https://cdnjs.cloudflare.com/ajax/libs/jquery/3.5.1/jquery.min.js"></script>
<script src="https://cdnjs.cloudflare.com/ajax/libs/twitter-bootstrap/4.5.3/js/bootstrap.min.js"></script>
<script src="js/scripts.js"></script>
</body>
</html>