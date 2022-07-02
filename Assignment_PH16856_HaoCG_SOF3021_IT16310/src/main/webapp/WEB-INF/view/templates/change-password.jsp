<%@ page language="java" contentType="text/html; charset=UTF-8"
	session="true"
	pageEncoding="UTF-8"%>

<%@taglib uri="http://java.sun.com/jstl/core_rt" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jstl/fmt_rt" prefix="fmt"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<!DOCTYPE html>
<html lang="en">

<head>
    <meta charset="utf-8">
    <title>HAOCUTE - Bootstrap Admin Template</title>
    <meta content="width=device-width, initial-scale=1.0" name="viewport">
    <meta content="" name="keywords">
    <meta content="" name="description">

    <!-- Favicon -->
    <link href="/static/admin/img/favicon.ico" rel="icon">

    <!-- Google Web Fonts -->
    <link rel="preconnect" href="https://fonts.googleapis.com">
    <link rel="preconnect" href="https://fonts.gstatic.com" crossorigin>
    <link href="https://fonts.googleapis.com/css2?family=Heebo:wght@400;500;600;700&display=swap" rel="stylesheet">
    
    <!-- Icon Font Stylesheet -->
    <link href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/5.10.0/css/all.min.css" rel="stylesheet">
    <link href="https://cdn.jsdelivr.net/npm/bootstrap-icons@1.4.1/font/bootstrap-icons.css" rel="stylesheet">

    <!-- Libraries Stylesheet -->
    <link href="/static/admin/lib/owlcarousel/assets/owl.carousel.min.css" rel="stylesheet">
    <link href="/static/admin/lib/tempusdominus/css/tempusdominus-bootstrap-4.min.css" rel="stylesheet" />

    <!-- Customized Bootstrap Stylesheet -->
    <link href="/static/admin/css/bootstrap.min.css" rel="stylesheet">

    <!-- Template Stylesheet -->
    <link href="/static/admin/css/style.css" rel="stylesheet">
</head>

<body>
    <div class="container-xxl position-relative bg-white d-flex p-0">
        <!-- Spinner Start -->
        <div id="spinner" class="show bg-white position-fixed translate-middle w-100 vh-100 top-50 start-50 d-flex align-items-center justify-content-center">
            <div class="spinner-border text-primary" style="width: 3rem; height: 3rem;" role="status">
                <span class="sr-only">Loading...</span>
            </div>
        </div>
        <!-- Spinner End -->


        <!-- Sign In Start -->
        <div class="container-fluid">
            <div class="row h-100 align-items-center justify-content-center" style="min-height: 100vh;">
                <div class="col-12 col-sm-8 col-md-6 col-lg-5 col-xl-4">
                    <div class="bg-light rounded p-4 p-sm-5 my-4 mx-3">
                        <div class="d-flex align-items-center justify-content-between mb-3">
                            <a href="/home/index" class="">
                                <h3 class="text-primary"><i class="fa fa-hashtag me-2"></i>${ account.username }</h3>
                            </a> 
                        </div>
                        <div class="d-flex align-items-center justify-content-between mb-3">
                        	<h3>Change password</h3>
                        </div>
                        <div class="d-flex align-items-center justify-content-between mb-3">
                        	<c:if test="${ !empty sessionScope.error }">
								<div class="alert alert-danger">
									${ sessionScope.error }
								</div>
								<c:remove var="error" scope="session"/>
							</c:if>
							<c:if test="${ !empty sessionScope.message }">
								<div class="alert alert-success">
									${ sessionScope.message }
								</div>
								<c:remove var="message" scope="session"/>
							</c:if>
                        </div>
                        <form:form action="/change" method="Post" modelAttribute="account">
	                        <div class="form-floating mb-3">
	                            <input type="password" name = "oldpassword" class="form-control" id="floatingInput" placeholder="Old Password">
	                            <label for="floatingInput">Old Password</label>
	                        </div>
	                        <div class="form-floating mb-4">
	                            <input type="password" name = "newpassword" class="form-control" id="floatingPassword" placeholder="New Password">
	                            <label for="floatingPassword">New Password</label>
	                        </div>
	                        <div class="form-floating mb-4">
	                            <input type="password" name = "confirm" class="form-control" id="floatingPassword" placeholder="Confirm">
	                            <label for="floatingPassword">Confirm Password</label>
	                        </div>
	                        <div class="d-flex align-items-center justify-content-between mb-4">
	                            <a href="/forgot-password">Forgot Password</a>
	                        </div>
	                        <button type="submit" class="btn btn-primary py-3 w-100 mb-4">Sign In</button>
                    	</form:form>
                    </div>
                </div>
            </div>
        </div>
        <!-- Sign In End -->
    </div>
     <!-- JavaScript Libraries -->
     <script src="https://code.jquery.com/jquery-3.4.1.min.js"></script>
     <script src="https://cdn.jsdelivr.net/npm/bootstrap@5.0.0/dist/js/bootstrap.bundle.min.js"></script>
     <script src="/static/admin/lib/chart/chart.min.js"></script>
     <script src="/static/admin/lib/easing/easing.min.js"></script>
     <script src="/static/admin/lib/waypoints/waypoints.min.js"></script>
     <script src="/static/admin/lib/owlcarousel/owl.carousel.min.js"></script>
     <script src="/static/admin/lib/tempusdominus/js/moment.min.js"></script>
     <script src="/static/admin/lib/tempusdominus/js/moment-timezone.min.js"></script>
     <script src="/static/admin/lib/tempusdominus/js/tempusdominus-bootstrap-4.min.js"></script>
 
     <!-- Template Javascript -->
     <script src="/static/admin/js/main.js"></script>
</body>

</html>