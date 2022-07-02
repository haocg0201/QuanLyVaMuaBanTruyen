<%@ page language="java" contentType="text/html; charset=UTF-8"
	session="true"
	pageEncoding="UTF-8"%>

<%@taglib uri="http://java.sun.com/jstl/core_rt" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jstl/fmt_rt" prefix="fmt"%>
<!DOCTYPE html>
<html lang="en">

<head>
    <meta charset="utf-8">
    <title>HAOCUTE - Bootstrap Admin Template</title>
    <meta content="width=device-width, initial-scale=1.0" name="viewport">
    <meta content="" name="keywords">
    <meta content="" name="description">
    
    <meta charset="utf-8">
    <meta name="viewport" content="width=device-width, initial-scale=1">

    <link rel="apple-touch-icon" href="/static/site/img/apple-icon.png">
    <link rel="shortcut icon" type="image/x-icon" href="/static/site/img/favicon.ico">

    <link rel="stylesheet" href="/static/site/css/bootstrap.min.css">
    <link rel="stylesheet" href="/static/site/css/templatemo.css">
    <link rel="stylesheet" href="/static/site/css/custom.css">

    <!-- Load fonts style after rendering the layout styles -->
    <link rel="stylesheet" href="https://fonts.googleapis.com/css2?family=Roboto:wght@100;200;300;400;500;700;900&display=swap">
    <link rel="stylesheet" href="/static/site/css/fontawesome.min.css">

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
                        <h6 class="mb-0">Hào cute</h6>
                        <span>Admin</span>
                    </div>
                </div>
                <div class="navbar-nav w-100">
                    <a href="/admin/index" class="nav-item nav-link active"><i class="fa fa-tachometer-alt me-2"></i>Comicboard</a>
                    <div class="nav-item dropdown">
                        <a href="#" class="nav-link dropdown-toggle" data-bs-toggle="dropdown"><i class="fa fa-laptop me-2"></i>Quản trị</a>
                        <div class="dropdown-menu bg-transparent border-0">
                            <a href="/admin/account" class="dropdown-item">Tài khoản</a>
                            <a href="/admin/comics?pageNumber=0&&name=" class="dropdown-item">Sản phẩm</a>
                            <a href="/admin/integrated-statistics" class="dropdown-item">Thống kê - Tổng hợp</a>
                        	<a href="/admin/order" class="dropdown-item">Hóa đơn</a>
                            <a href="/admin/order-detail" class="dropdown-item">Hóa đơn chi tiết</a>
                        </div>
                    </div>
                    <a href="/admin/widget" class="nav-item nav-link"><i class="fa fa-th me-2"></i>Widgets</a>
                    <div class="nav-item dropdown">
                        <a href="#" class="nav-link dropdown-toggle" data-bs-toggle="dropdown"><i class="far fa-file-alt me-2"></i>Thao tác tài khoản</a>
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
                            <img class="rounded-circle me-lg-2" src="img/user.jpg" alt="" style="width: 40px; height: 40px;">
                            <span class="d-none d-lg-inline-flex">John Doe</span>
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


            <!-- Order Start -->
			<div class="container-fluid pt-4 px-4">
            	<div class="row g-4">
	            	<ul class="list-unstyled templatemo-accordion">
	                    <li class="pb-3">
	                        <a class="collapsed d-flex justify-content-between h3 text-decoration-none" href="#">
	                            Trạng thái hóa đơn
	                            <i class="pull-right fa fa-fw fa-chevron-circle-down mt-1"></i>
	                        </a>
	            			<ul id="collapseTwo" class="collapse list-unstyled pl-3">
	                            <li><a class="text-decoration-none" href="/admin/order?pageNumber=0&&status=0">Chờ xác nhận</a></li>
	                            <li><a class="text-decoration-none" href="/admin/order?pageNumber=0&&status=1">Đã xác nhận</a></li>
	                            <li><a class="text-decoration-none" href="/admin/order?pageNumber=0&&status=2">Đã hủy</a></li>
	                        </ul>
                        </li>
                      </ul>
         
					<div class="col-12">
                        <div class="bg-light rounded h-100 p-4">
                            <h6 class="mb-4">Hóa đơn</h6>
                            <div class="table-responsive">
                                <table class="table table-bordered border-info">
                                    <thead>
                                        <tr>
                                            <th scope="col">Id</th>
                                            <th scope="col">Nguời mua</th>
                                            <th scope="col">Số điện thoại</th>
                                            <th scope="col">Ngày đặt</th>
                                            <th scope="col">Tổng tiền</th>
                                            <th scope="col">Trạng thái</th>
                                            <th colspan="3" scope="col">Action</th>
                                        </tr>
                                    </thead>
                                    <tbody>
                                        <tr>
                                            <c:forEach items="${ page.getContent() }" var="order">
												<tr>
													<td>${ order.orderId }</td>
													<td>${ order.account.accountId }</td>
													<td>${ order.buyerPhone }</td>
													<td> <fmt:formatDate value="${ order.createdDate }" pattern="dd/MM/yyyy"/> </td>
													<td>${ order.amount }</td>
													<td>
														<c:choose>
															<c:when test="${order.status == 0 }">Chưa xác nhận</c:when>
															<c:when test="${order.status == 1 }">Đã xác nhận </c:when>
															<c:otherwise>Đã hủy</c:otherwise>
														</c:choose>
													</td>
													<td>
														<c:if test="${ order.status == 0 }">
															<a class="btn btn-info"
																href="/admin/order/edit/${ order.orderId }/1"> Xác nhận
															</a>
														</c:if>
														<c:if test="${ order.status == 1 }">
															<a class="btn btn-warning"
																href="/admin/order/edit/${ order.orderId }/2"> Hủy
															</a>
														</c:if>
													</td>
													<td>
														<c:if test="${ order.status == 2 }">
															<a class="btn btn-danger"
																href="/admin/order/delete/${ order.orderId }"> Xóa
															</a>
														</c:if>
													</td>	
												</tr>
											</c:forEach>
                                        </tr>                                       
                                    </tbody>
                                </table>
                                <p class="text-right">
						        	<c:if test="${page.getNumber() > 0 }">
						        		<a href="/admin/order?pageNumber=${page.getNumber() - 1}" class = "btn btn-primary">Previous</a>
						        	</c:if>
						        	<Strong class = "text-info"> ${ page.getNumber() + 1} </Strong> / ${page.getTotalPages() +1}
						        	<c:if test="${ page.getNumber() <= (page.getTotalPages() - 2) }">
						        		<a href="/admin/order?pageNumber=${page.getNumber() + 1}"  class = "btn btn-primary">Next</a>
				        			</c:if>
				        		</p>
                            </div>
                        </div>
                    </div>
                </div>
            </div>
            <!-- Order End -->


            <!-- Footer Start -->
            <div class="container-fluid pt-4 px-4">
                <div class="bg-light rounded-top p-4">
                    <div class="row">
                        <div class="col-12 col-sm-6 text-center text-sm-start">
                            &copy; <a href="#">Your Site Name</a>, All Right Reserved. 
                        </div>
                        <div class="col-12 col-sm-6 text-center text-sm-end">
                            <!--/*** This template is free as long as you keep the footer authorâs credit link/attribution link/backlink. If you'd like to use the template without the footer authorâs credit link/attribution link/backlink, you can purchase the Credit Removal License from "https://htmlcodex.com/credit-removal". Thank you for your support. ***/-->
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
    
    <!-- Start Script -->
    <script src="/static/site/js/jquery-1.11.0.min.js"></script>
    <script src="/static/site/js/jquery-migrate-1.2.1.min.js"></script>
    <script src="/static/site/js/bootstrap.bundle.min.js"></script>
    <script src="/static/site/js/templatemo.js"></script>
    <script src="/static/site/js/custom.js"></script>
    <!-- End Script -->
</body>

</html>