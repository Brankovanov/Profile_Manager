<%--
  Created by IntelliJ IDEA.
  User: lenovo
  Date: 12.03.2021
  Time: 20:06
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <title>Edit Profile</title>
</head>
<body>
<h3 class="title"><%= "Edit Profile" %></h3>
<div class="form">
    <form  action="/edit" method="POST">
        <label for="firstname">First name:</label><br>
        <input type="text" id="firstname" name="firstname" placeholder="Name" value='<c:out value="${profile.firstName}"/>'><br>
        <label for="lastname">Last name:</label><br>
        <input type="text" id="lastname" name="lastname" placeholder="Last Name" value='<c:out value="${profile.lastName}"/>'><br>
        <label for="birthdate">Date of Birth:</label><br>
        <input type="date" id="birthdate" name="birthdate" placeholder="Birthdate" value='<c:out value="${profile.birthDate}"/>'><br>
        <label for="phone">Phone number:</label><br>
        <input type="tel" id="phone" name="phone" placeholder="Telephone" value='<c:out value="${profile.telephone}"/>'><br>
        <label for="email">E-mail:</label><br>
        <input type="email" id="email" name="email" placeholder="Email" value='<c:out value="${profile.email}"/>'><br>
        <input hidden type="number" id="id" name="id" placeholder="id" value='<c:out value="${profile.id}"/>'><br><br>
        <input type="submit" class="edit" value="EDIT PROFILE">
    </form>
</div>
</body>
</html>

<style>
    .title{
        text-align: center;
    }
    .edit{
        color: #ff6600;
        border: #ff6600 solid;
        background-color: #ffffff;
        border-radius: 5px;
        outline:none;
        cursor:pointer;
    }
    .edit:hover{
        color: #ffffff;
        border: #ff6600 solid;
        background-color: #ff6600;
        border-radius: 5px;
        outline:none;
        cursor:pointer;
    }
    .form{
        padding-bottom: 20px;
        text-align: center;
    }
</style>