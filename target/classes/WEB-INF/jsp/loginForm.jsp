<%@ include file="/WEB-INF/jsp/includes.jsp"%>


<!DOCTYPE html>
<html>

<head>
  <link rel="stylesheet" href="resources/loginformStyle.css">
</head>

<body>

<form:form action="loginForm" method="POST"  >

<div class="imgcontainer">
    <img src="resources/images/img_avatar2.png" alt="Avatar" class="avatar">
  </div>

  <div class="container">
    <label><b>Username</b></label>
    <br>
    <input type="text" placeholder="Enter Username" name="UserName" required>
    <br>

    <label><b>Password</b></label>
    <br>
    <input type="password" placeholder="Enter Password" name="Password" required>
    
    <br>

        
    <button type="submit">Login</button>
  </div>

  <div class="container" style="background-color:#f1f1f1">
    <button type="button" class="cancelbtn"  onclick="window.location.replace('\home')">Cancel</button>
  </div>

</form:form>


</body>
</html>
