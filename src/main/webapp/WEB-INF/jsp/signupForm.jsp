<%@ include file="/WEB-INF/jsp/includes.jsp"%>


<!DOCTYPE html>
<html>

<head>
  <link rel="stylesheet" href="resources/loginformStyle.css">
</head>


<body>

<form:form action="signupForm" method="POST"  >


  <div class="container">
    <label><b>Username</b></label>
    <br>
    <input type="text" placeholder="Enter Username" name="UserName" required>
    <br>

    <label><b>Password</b></label>
    <br>
    <input type="password" placeholder="Enter Password" name="Password" required>
    <br>

    <label><b>Account Type</b></label>
    <br>
    
    
    <div class="radio">
      <label><input type="radio" name="Role" value="user" required>User</label>
    </div>
    <div class="radio">
      <label><input type="radio" name="Role" value="shop" required>Shop</label>
    </div>
    <br>
    <br>
        
    <button type="submit">Sign Up</button>
  </div>

  <div class="container" style="background-color:#f1f1f1">
    <button type="button" class="cancelbtn"  onclick="window.location.replace('\home')">Cancel</button>
  </div>

</form:form>


</body>

</html>
