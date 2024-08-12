<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>User List</title>
<link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/purecss@3.0.0/build/pure-min.css" />
</head>
    <body style= "padding: 15px">
    <div class="pure-form">
    <fieldset>
       <legend>使用者名單</legend>
       使用者ID:  <input type="number" id="userId" name="userid" required="required" /><p />
       使用者姓名:  <input type="text" id="userName" name="userName" required="required" /><p />
       使用者Email: <input type="text" id="userEmail" name="userEmail" required="required" /><p />
       使用者密碼: <input type="number" id="userPassword" name="userPassword" required="required" /><p />
       <button type="submit" class="pure-button pure-button-primary">送出</button>   
    </body>
</html>