<%@ page language="java" contentType="text/html; charset=UTF-8"
	session="true"
	pageEncoding="UTF-8"%>

<%@taglib uri="http://java.sun.com/jstl/core_rt" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jstl/fmt_rt" prefix="fmt"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<!DOCTYPE html>
<html>

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


        <!-- Sidebar Start -->
        <div class="sidebar pe-4 pb-3">
            <nav class="navbar bg-light navbar-light">
                <a href="/admin/index" class="navbar-brand mx-4 mb-3">
                    <h3 class="text-primary"><i class="fa fa-hashtag me-2"></i>WIBU SHOP</h3>
                </a>
                <div class="d-flex align-items-center ms-4 mb-4">
                    <div class="position-relative">
                        <img class="rounded-circle" src="/static/admin/img/user.jpg" alt="" style="width: 40px; height: 40px;">
                        <div class="bg-success rounded-circle border border-2 border-white position-absolute end-0 bottom-0 p-1"></div>
                    </div>
                    <div class="ms-3">
                        <h6 class="mb-0">H??o cute</h6>
                        <span>Admin</span>
                    </div>
                </div>
                <div class="navbar-nav w-100">
                    <a href="/admin/index" class="nav-item nav-link"><i class="fa fa-tachometer-alt me-2"></i>Comicboard</a>
                    <div class="nav-item dropdown">
                        <a href="#" class="nav-link dropdown-toggle" data-bs-toggle="dropdown"><i class="fa fa-laptop me-2"></i>Qu???n tr???</a>
                        <div class="dropdown-menu bg-transparent border-0">
                            <a href="/admin/account" class="dropdown-item">T??i kho???n</a>
                            <a href="/admin/comics?pageNumber=0&&name=" class="dropdown-item">S???n ph???m</a>
                            <a href="/admin/integrated-statistics" class="dropdown-item">Th???ng k?? - T???ng h???p</a>
                       		<a href="/admin/order" class="dropdown-item">H??a ????n</a>
                            <a href="/admin/order-detail" class="dropdown-item">H??a ????n chi ti???t</a>
                        </div>
                    </div>
                    <a href="/admin/widget" class="nav-item nav-link"><i class="fa fa-th me-2"></i>Widgets</a>
                    <div class="nav-item dropdown">
                        <a href="#" class="nav-link dropdown-toggle" data-bs-toggle="dropdown"><i class="far fa-file-alt me-2"></i>Thao t??c t??i kho???n</a>
                        <div class="dropdown-menu bg-transparent border-0">
                            <a href="/signin" class="dropdown-item">Sign In</a>
                            <a href="/signup" class="dropdown-item">Sign Up</a>
                            <a href="/change-password" class="dropdown-item">Change Password</a>
                            <a href="/forgot-password" class="dropdown-item">Forgot Password</a>
                            <a href="/logout" class="dropdown-item">Log Out</a>
                        </div>
                    </div>
                </div>
            </nav>
        </div>
        <!-- Sidebar End -->



        <!-- Content Start -->
        <div class="content">
            <!-- Navbar Start -->
            <nav class="navbar navbar-expand bg-light navbar-light sticky-top px-4 py-0">
                <a href="index.html" class="navbar-brand d-flex d-lg-none me-4">
                    <h2 class="text-primary mb-0"><i class="fa fa-hashtag"></i></h2>
                </a>
                <a href="#" class="sidebar-toggler flex-shrink-0">
                    <i class="fa fa-bars"></i>
                </a>
                <form class="d-none d-md-flex ms-4">
                    <input class="form-control border-0" type="search" placeholder="Search">
                </form>
                <div class="navbar-nav align-items-center ms-auto">
                    <div class="nav-item dropdown">
                        <a href="#" class="nav-link dropdown-toggle" data-bs-toggle="dropdown">
                            <i class="fa fa-envelope me-lg-2"></i>
                            <span class="d-none d-lg-inline-flex">Message</span>
                        </a>
                        <div class="dropdown-menu dropdown-menu-end bg-light border-0 rounded-0 rounded-bottom m-0">
                            <a href="#" class="dropdown-item">
                                <div class="d-flex align-items-center">
                                    <img class="rounded-circle" src="img/user.jpg" alt="" style="width: 40px; height: 40px;">
                                    <div class="ms-2">
                                        <h6 class="fw-normal mb-0">Jhon send you a message</h6>
                                        <small>15 minutes ago</small>
                                    </div>
                                </div>
                            </a>
                            <hr class="dropdown-divider">
                            <a href="#" class="dropdown-item">
                                <div class="d-flex align-items-center">
                                    <img class="rounded-circle" src="img/user.jpg" alt="" style="width: 40px; height: 40px;">
                                    <div class="ms-2">
                                        <h6 class="fw-normal mb-0">Jhon send you a message</h6>
                                        <small>15 minutes ago</small>
                                    </div>
                                </div>
                            </a>
                            <hr class="dropdown-divider">
                            <a href="#" class="dropdown-item">
                                <div class="d-flex align-items-center">
                                    <img class="rounded-circle" src="img/user.jpg" alt="" style="width: 40px; height: 40px;">
                                    <div class="ms-2">
                                        <h6 class="fw-normal mb-0">Jhon send you a message</h6>
                                        <small>15 minutes ago</small>
                                    </div>
                                </div>
                            </a>
                            <hr class="dropdown-divider">
                            <a href="#" class="dropdown-item text-center">See all message</a>
                        </div>
                    </div>
                    <div class="nav-item dropdown">
                        <a href="#" class="nav-link dropdown-toggle" data-bs-toggle="dropdown">
                            <i class="fa fa-bell me-lg-2"></i>
                            <span class="d-none d-lg-inline-flex">Notificatin</span>
                        </a>
                        <div class="dropdown-menu dropdown-menu-end bg-light border-0 rounded-0 rounded-bottom m-0">
                            <a href="#" class="dropdown-item">
                                <h6 class="fw-normal mb-0">Profile updated</h6>
                                <small>15 minutes ago</small>
                            </a>
                            <hr class="dropdown-divider">
                            <a href="#" class="dropdown-item">
                                <h6 class="fw-normal mb-0">New user added</h6>
                                <small>15 minutes ago</small>
                            </a>
                            <hr class="dropdown-divider">
                            <a href="#" class="dropdown-item">
                                <h6 class="fw-normal mb-0">Password changed</h6>
                                <small>15 minutes ago</small>
                            </a>
                            <hr class="dropdown-divider">
                            <a href="#" class="dropdown-item text-center">See all notifications</a>
                        </div>
                    </div>
                    <div class="nav-item dropdown">
                        <a href="#" class="nav-link dropdown-toggle" data-bs-toggle="dropdown">
                            <img class="rounded-circle me-lg-2" src="/static/admin/img/user.jpg" alt="" style="width: 40px; height: 40px;">
                            <span class="d-none d-lg-inline-flex">H??o alone</span>
                        </a>
                        <div class="dropdown-menu dropdown-menu-end bg-light border-0 rounded-0 rounded-bottom m-0">
                            <a href="#" class="dropdown-item">My Profile</a>
                            <a href="#" class="dropdown-item">Settings</a>
                            <a href="#" class="dropdown-item">Log Out</a>
                        </div>
                    </div>
                </div>
            </nav>
            <!-- Navbar End -->


            <!-- Comic Management - Start -->
            
            <div class="container-fluid pt-4 px-4">
            	<div class="row g-4">
					<div class="col-12">
                        <div class="bg-light rounded h-100 p-4">
                            <h6 class="mb-4">S???a s???n ph???m</h6>
                            <div class="table-responsive">
                                <form:form method="POST"
									action="/admin/comics/update/${comic.comicId}" modelAttribute="comic">
								
									<div class="mb-3">
										<label for="ten" class="form-label">T??n truy???n</label> <input
											type="text" class="form-control" aria-describedby="tenHelp"
											name="comicName" value = "${comic.comicName }">
									</div>
								
									<div class="mb-3">
										<label for="currentQuantity" class="form-label">S??? l?????ng</label> <input
											type="number" class="form-control" name="currentQuantity" value = "${comic.currentQuantity }">
									</div>
								
									<div class="mb-3">
										<label for="currentPrice" class="form-label">????n gi?? </label> <input
											type="number" class="form-control" name="currentPrice" value ="${comic.currentPrice }">
									</div>
								
									<div class="mb-3">
										<label for="chapter" class="form-label">Ch????ng truy???n</label> <input
											type="text" class="form-control" name="chapter" value ="${comic.chapter }">
									</div>
								
									<div class="mb-3">
										<label for="author" class="form-label">T??c gi???</label> <input
											type="text" class="form-control" name="author" value ="${comic.author }">
									</div>
									
									<label for="category_id" class="form-label">Danh m???c</label> <select
											class="form-select form-select-lg mb-3"
											aria-label=".form-select-lg example" name="type">
											<c:forEach items="${arrType}" var="type">
												<option value="${type}">${type}</option>
											</c:forEach>
										</select>
										
									<div class="input-group mb-3">
										<input type="file" class="form-control" id="inputGroupFile02"
											name="image" value="${comic.image }"> <label class="input-group-text"
											for="inputGroupFile02">???nh b??? truy???n</label>
									</div>								
									
									<div class="form-floating mb-3">
										<textarea name="status" class="form-control" placeholder="Leave a comment here" id="status" style="height: 100px"></textarea>
										<label for="status"">Ch?? th??ch</label>
									</div>
																									
									<div class="d-grid gap-2 d-md-flex justify-content-md-end">
										<button class="btn btn-outline-dark me-md-2">C???p nh???t</button>
										<button class="btn btn-outline-dark me-md-2" type="reset">Tr???ng</button>											
									</div>
								</form:form>
                            </div>
                        </div>
                    </div>
                </div>
            </div>
            <!-- Comic Management - End -->


            <!-- Footer Start -->
            <div class="container-fluid pt-4 px-4">
                <div class="bg-light rounded-top p-4">
                    <div class="row">
                        <div class="col-12 col-sm-6 text-center text-sm-start">
                            &copy; <a href="#">Your Site Name</a>, All Right Reserved. 
                        </div>
                        <div class="col-12 col-sm-6 text-center text-sm-end">
                            <!--/*** This template is free as long as you keep the footer author??????s credit link/attribution link/backlink. If you'd like to use the template without the footer author??????s credit link/attribution link/backlink, you can purchase the Credit Removal License from "https://htmlcodex.com/credit-removal". Thank you for your support. ***/-->
                            Designed By <a href="https://htmlcodex.com">HTML Codex</a>
                        </div>
                    </div>
                </div>
            </div>
            <!-- Footer End -->
        </div>
        <!-- Content End -->


        <!-- Back to Top -->
        <a href="#" class="btn btn-lg btn-primary btn-lg-square back-to-top"><i class="bi bi-arrow-up"></i></a>
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