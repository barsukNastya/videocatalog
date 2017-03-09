<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
         pageEncoding="ISO-8859-1" session="false" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
    <link href="assets/css/bootstrap-united.css" rel="stylesheet" />
    <link rel="stylesheet" href="<c:url value="/assets/css/styles.css" />" type="text/css" media="screen" />

    <style>

    </style>
    <title>User Login</title>
</head>
<body>


<div class="container">
    <div class="col-lg-6 col-lg-offset-3 login-body">
        <div class="row well">
            <form:form id="myForm" method="post"
                           class="bs-example form-horizontal" commandName="userLogin">
                    <fieldset>
                        <legend>User Login Form</legend>

                        <div class="form-group">
                            <label for="userNameInput" class="col-lg-3 control-label">User
                                Name</label>
                            <div class="col-lg-9">
                                <form:input type="text" class="form-control" path="userName"
                                            id="userNameInput" placeholder="User Name" />
                                <form:errors path="userName" cssClass="error" />
                            </div>
                        </div>

                        <div class="form-group">
                            <label for="passwordInput" class="col-lg-3 control-label">Password</label>
                            <div class="col-lg-9">
                                <form:input type="password" class="form-control"
                                            path="userPassword" id="passwordInput" placeholder="Password" />
                                <form:errors path="userPassword" cssClass="error" />
                            </div>
                        </div>

                        <div class="col-lg-9 col-lg-offset-3">
                            <button class="btn btn-primary" >Login</button>
                        </div>

                    </fieldset>
                </form:form>
        </div>
    </div>
</div>

<script src="/assets/js/jquery-1.8.3.js"></script>

<script src="/assets/js/bootstrap.js"></script>
</body>
</html>