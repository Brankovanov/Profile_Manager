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
    <form  action="">
        <label for="firstname">First name:</label><br>
        <input type="text" id="firstname" name="firstname" placeholder="Name" ><br>
        <label for="lastname">Last name:</label><br>
        <input type="text" id="lastname" name="lastname" placeholder="Last Name"><br>
        <label for="birthdate">Date of Birth:</label><br>
        <input type="date" id="birthdate" name="birthdate" placeholder="Birthdate"><br>
        <label for="phone">Phone number:</label><br>
        <input type="tel" id="phone" name="phone" placeholder="Telephone"><br>
        <label for="email">E-mail:</label><br>
        <input type="email" id="email" name="email" placeholder="Email"><br>
        <input type="submit" class="create" value="CREATE PROFILE">
    </form>
</div>
</body>
</html>
