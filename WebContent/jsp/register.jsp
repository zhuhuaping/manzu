<%@ page language="java" contentType="text/html; charset=UTF-8"
  pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="utf-8">

<title>Register For manzu</title>

<!-- Bootstrap -->
<link href="../vendors/bootstrap/dist/css/bootstrap.min.css"
  rel="stylesheet">
<!-- Font Awesome -->
<link href="../vendors/font-awesome/css/font-awesome.min.css"
  rel="stylesheet">
<!-- NProgress -->
<link href="../vendors/nprogress/nprogress.css" rel="stylesheet">
<!-- Animate.css -->
<link href="https://colorlib.com/polygon/gentelella/css/animate.min.css"
  rel="stylesheet">

<!-- Custom Theme Style -->
<link href="../build/css/custom.min.css" rel="stylesheet">
</head>

<body class="login">
  <div>
    <h2>${message}</h2>
    <div class="login_wrapper">
      <div id="register" class="animate form registration_form">
        <section class="login_content">
          <form action="/user/registerDeal.do" method="post">
            <h1>Create Account</h1>
            <div>
              <input type="text" class="form-control"
                placeholder="Username" required="" name="name" />
            </div>
            <div>
              <input type="password" class="form-control"
                placeholder="Password" required="" name="password" />
            </div>
            <div>
              <input type="text" class="form-control"
                placeholder="Gender" required="" name="gender" />
            </div>
            <div>
              <input type="text" class="form-control"
                placeholder="Mobile" required="" name="mobile" />
            </div>
            <div>
              <input type="text" class="form-control"
                placeholder="Address" required="" name="address" />
            </div>
            <div>
              <button class="btn btn-default">Submit</button>
            </div>

            <div class="clearfix"></div>

            <div class="separator">
              <p class="change_link">
                Already a member ? <a href="/user/login.do"
                  class="to_register"> Log in </a>
              </p>

              <div class="clearfix"></div>
              <br />

              <div>
                <h1>
                  <i class="fa fa-paw"></i> Manzu Zoe!
                </h1>
              </div>
            </div>
          </form>
        </section>
      </div>
    </div>
  </div>
</body>
</html>