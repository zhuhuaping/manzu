<%@ page language="java" contentType="text/html; charset=UTF-8"
  pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Register For manzu</title>
</head>
<body>
  <h3>Register For manzu</h3>
  <h4>${message}</h4>
  <form action="/user/registerDeal.do" method="post">
    <span>Name:</span> <input type="text" name="name" /><br> 
    <span>Password:</span><input type="password" name="password" /><br>
    <span>Gender:</span><input type="text" name="gender" /><br> 
    <span>Mobile:</span><input type="text" name="mobile" /><br>
    <span>Address:</span><input type="text" name="address" /><br> 
    <button>Submit</button>
  </form>
</body>
</html>