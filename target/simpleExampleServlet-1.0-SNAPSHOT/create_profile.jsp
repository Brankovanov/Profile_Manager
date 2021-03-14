<%--
  Created by IntelliJ IDEA.
  User: lenovo
  Date: 12.03.2021
  Time: 20:04
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Create New Profile</title>
</head>
<body>
<h3 class="title"><%= "Create New Profile" %></h3>
<div class="form">
    <form   action="/insertServlet" method="POST">
        <label for="firstname">First name:</label><br>
        <input type="text" id="firstname" name="firstname" placeholder="Name" ><br>
        <label for="lastname">Last name:</label><br>
        <input type="text" id="lastname" name="lastname" placeholder="Last Name"><br>
        <label for="birthdate">Date of Birth:</label><br>
        <input type="date" id="birthdate" name="birthdate" placeholder="Birthdate"><br>
        <label for="phone">Phone number:</label><br>
        <input type="tel" id="phone" name="phone" placeholder="Telephone"><br>
        <label for="email">E-mail:</label><br>
        <input type="email" id="email" name="email" placeholder="Email"><br><br>
        <input type="submit" class="create" value="CREATE PROFILE">
    </form>
</div>
</body>
</html>
<style>
    .title{
        text-align: center;
    }
    .create{
        color: #023c03;
        border: #023c03 solid;
        background-color: #ffffff;
        border-radius: 5px;
        outline:none;
        cursor:pointer;
        margin-top: 10px;
    }
    .create:hover{
        color: #ffffff;
        border: #023c03 solid;
        background-color: #023c03;
        border-radius: 5px;
        outline:none;
        cursor:pointer;
        margin-top: 10px;
    }
    .form{
        padding-bottom: 20px;
        text-align: center;
    }
</style>