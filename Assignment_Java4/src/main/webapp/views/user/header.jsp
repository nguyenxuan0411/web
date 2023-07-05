<%@ page language="java" contentType="text/html; charset=utf-8" pageEncoding="utf-8" %>
<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>Insert title here</title>
    <base href="/java4_asm/">
</head>
<body>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<header>
    <nav class="navbar is-light is-fixed-top" role="navigation" aria-label="main navigation">
        <div class="navbar-brand">
            <a href="Home" class="navbar-item"><b>HOME</b></a> <a role="button" class="navbar-burger" aria-label="menu"
                                                                aria-expanded="false" data-target="nav-bar"
                                                                href=""> <span
                aria-hidden="true"></span> <span aria-hidden="true"></span> <span aria-hidden="true"></span>
        </a>
        </div>
        <div class="navbar-menu">
            <div class="navbar-end">
                <a href="Favorite" class="navbar-item">MY FAVORITES</a>
                <div class="navbar-item has-dropdown is-hoverable">
                    <a href="Home" class="navbar-link">MY ACCOUNT</a>
                    <div class="navbar-dropdown">
                        <c:if test="${!isLogin}">
                            <a href="Login" class="navbar-item">Sign-in</a>
                            <a href="ForgotPassword" class="navbar-item">Forgot password</a>
                            <a href="Registration" class="navbar-item">Sign-up</a>
                        </c:if>
                        <c:if test="${isLogin}">
                            <a href="Logoff" class="navbar-item">Sign-out</a>
                            <a href="ChangePassword" class="navbar-item">Change password</a>
                            <a href="EditProfile" class="navbar-item">Edit profile</a>
                        </c:if>
                    </div>
                </div>
            </div>
        </div>
    </nav>
</header>
</body>
</html>