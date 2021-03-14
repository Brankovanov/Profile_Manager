<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
    <title>Simple Profile Manager</title>
</head>
<body>
<h1 class="title"><%= "Simple Profile Manager" %>
</h1>
<br/>
<div class="form">
    <div> <a href="/create_profile.jsp"><button  class="create" type="button">CREATE PROFILE</button></a></div>
    <div> <a href="/list"><button  class="create" type="button">SHOW ALL PROFILES</button></a></div>
</div>
<table class="table">
    <tr>
        <th>Firstname</th>
        <th>Lastname</th>
        <th>Date of Birth</th>
        <th>Phone Number</th>
        <th>E-mail Address</th>
    </tr>
    <c:forEach var="profiles" items="${listProfile}">
    <tr>
        <td class="column"><c:out value="${profiles.firstName}"/></td>
        <td class="column"><c:out value="${profiles.lastName}"/></td>
        <td class="column"><c:out value="${profiles.birthDate}"/></td>
        <td class="column"><c:out value="${profiles.telephone}"/></td>
        <td class="column"><c:out value="${profiles.email}"/></td>
        <th>
            <a href="/deleteServlet?id=<c:out value='${profiles.id}'/>"><button class="delete" type="button">DELETE PROFILE</button></a>
            <a href="/update?id=<c:out value='${profiles.id}'/>"><button class="edit" type="button">EDIT PROFILE</button></a>
        </th>
    </tr>
    </c:forEach>
</table>
<div class="btn-container">
    <div> <a href="/sortASCLastNameServlet"><button class="sort" type="button">SORT BY  LAST NAME ASC</button></a></div>
    <div> <a href="/sordDESCLastNameServlet"><button class="sort" type="button">SORT BY LAST NAME DESC</button></a></div>
    <div> <a href="/sortASCBirthDateServlet"><button class="sort" type="button">SORT BY DATE OF BIRTH ASC</button></a></div>
    <div> <a href="/sortDESCBirthDateServlet"><button class="sort" type="button">SORT BY DATE OF BIRTH DESC</button></a></div>
</div>
</body>

<div class="form">
    <form  action="/searchServlet" method="POST">
        <input type="text" id="term" name="term" placeholder="Search..."><br><br>
        <input type="submit" class="edit" value="SEARCH">
    </form>
</div>
</html>
<style>
    .table{
        border: #000000 solid 2px;
        width:90%;
        margin-left:auto;
        margin-right: auto;
    }
    .column{
        text-align: center;
    }
    .title{
        text-align: center;
    }
    .delete{
        color: #ff0000;
        border: #ff0000 solid;
        background-color: #ffffff;
        border-radius: 5px;
        outline:none;
        cursor:pointer;
    }
    .delete:hover{
        color: #ffffff;
        border: #ff0000 solid;
        background-color: #ff0000;
        border-radius: 5px;
        outline:none;
        cursor:pointer;
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
    .sort{
        color: #313231;
        border: #313231 solid;
        background-color: #ffffff;
        border-radius: 5px;
        outline:none;
        cursor:pointer;
        margin: 10px;

    }
    .sort:hover{
        color: #ffffff;
        border: #313231 solid;
        background-color: #313231;
        border-radius: 5px;
        outline:none;
        cursor:pointer;
        margin: 10px;
    }
    .form{
        padding-bottom: 20px;
        text-align: center;
    }
    .btn-container{
        display: flex;
        justify-content: center;
    }
</style>