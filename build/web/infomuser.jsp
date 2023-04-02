<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>


<!DOCTYPE html>
<html lang="en">

    <head>
        <meta charset="utf-8">
        <meta content="width=device-width, initial-scale=1.0" name="viewport">

        <title>DiaryOnline</title>
        <meta content="" name="description">
        <meta content="" name="keywords">

        <!-- Favicons -->
        <link href="assets/img/favicon.png" rel="icon">
        <link href="assets/img/apple-touch-icon.png" rel="apple-touch-icon">

        <!-- Google Fonts -->
        <link href="https://fonts.gstatic.com" rel="preconnect">
        <link
            href="https://fonts.googleapis.com/css?family=Open+Sans:300,300i,400,400i,600,600i,700,700i|Nunito:300,300i,400,400i,600,600i,700,700i|Poppins:300,300i,400,400i,500,500i,600,600i,700,700i"
            rel="stylesheet">

        <!-- Vendor CSS Files -->
        <link href="assets/vendor/bootstrap/css/bootstrap.min.css" rel="stylesheet">
        <link href="assets/vendor/bootstrap-icons/bootstrap-icons.css" rel="stylesheet">
        <link href="assets/vendor/boxicons/css/boxicons.min.css" rel="stylesheet">
        <link href="assets/vendor/quill/quill.snow.css" rel="stylesheet">
        <link href="assets/vendor/quill/quill.bubble.css" rel="stylesheet">
        <link href="assets/vendor/remixicon/remixicon.css" rel="stylesheet">
        <link href="assets/vendor/simple-datatables/style.css" rel="stylesheet">
        <link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/flatpickr/dist/flatpickr.min.css">

        <!-- Template Main CSS File -->
        <link href="assets/css/style.css" rel="stylesheet">
        <link rel="stylesheet" href="assets/css/main.css"/>


        <!-- =======================================================
        * Template Name: NiceAdmin - v2.5.0
        * Template URL: https://bootstrapmade.com/nice-admin-bootstrap-admin-html-template/
        * Author: BootstrapMade.com
        * License: https://bootstrapmade.com/license/
        ======================================================== -->
    </head>

    <body>

        <!-- ======= Header ======= -->
        <header id="header" class="header fixed-top d-flex align-items-center">

            <div class="d-flex align-items-center justify-content-between">
                <a href="#" class="logo d-flex align-items-center">
                    <img src="assets/img/logo1.png" alt="">
                    <span class="d-none d-lg-block">DiaryOnline</span>
                </a>
                <i class="bi bi-list toggle-sidebar-btn"></i>
            </div><!-- End Logo -->

            <div class="search-bar">
                <form class="search-form d-flex align-items-center" method="POST" action="#">
                    <input type="text" name="query" placeholder="Search" title="Enter search keyword">
                    <button type="submit" title="Search"><i class="bi bi-search"></i></button>
                </form>
            </div><!-- End Search Bar -->

            <nav class="header-nav ms-auto">
                <ul class="d-flex align-items-center">

                    <li class="nav-item d-block d-lg-none">
                        <a class="nav-link nav-icon search-bar-toggle " href="#">
                            <i class="bi bi-search"></i>
                        </a>
                    </li><!-- End Search Icon-->

                    <section class="row flex">

                        <ul class="header__top-list" >             
                            <c:if test="${sessionScope.acc == null}">
                                <li class="header__top-item" style="margin-left: 20px">
                                    <a href="login.jsp" class="header__top-link">Đăng nhập</a>
                                </li>
                            </c:if>
                            <c:if test="${sessionScope.acc != null}">

                                <li class="nav-item dropdown pe-3">

                                    <a class="nav-link nav-profile d-flex align-items-center pe-0" href="#" data-bs-toggle="dropdown">
                                        <img alt="Gravatar for minhtnhe161392@fpt.edu.vn" src="//www.gravatar.com/avatar/589e47159568f5492f5dcc2dc79a7fea?d=retro&amp;r=g&amp;s=40" srcset="//www.gravatar.com/avatar/589e47159568f5492f5dcc2dc79a7fea?d=retro&amp;r=g&amp;s=80 2x" height="40" width="40" class="react-gravatar img-avatar">
                                        <span class="d-none d-md-block dropdown-toggle ps-2">${sessionScope.acc.usename}</span>
                                    </a><!-- End Profile Iamge Icon -->

                                    <ul class="dropdown-menu dropdown-menu-end dropdown-menu-arrow profile">
                                        <li class="dropdown-header">
                                            <h6>${sessionScope.acc.usename}</h6>

                                        </li>
                                        <li>
                                            <hr class="dropdown-divider">
                                        </li>

                                        <li>
                                            <a class="dropdown-item d-flex align-items-center" href="updateinfom?sid=${sessionScope.acc.getId()}">
                                                <i class="bi bi-person"></i>
                                                <span>My Profile</span>
                                            </a>
                                        </li>
                                        <li>
                                            <hr class="dropdown-divider">
                                        </li>

                                        <li>
                                            <a class="dropdown-item d-flex align-items-center" href="logout">
                                                <i class="bi bi-box-arrow-right"></i>
                                                <span>Sign Out</span>
                                            </a>
                                        </li>
                                    </ul><!-- End Profile Dropdown Items -->
                                </li><!-- End Profile Nav -->
                            </c:if>
                        </ul>
                    </section>

                </ul>
            </nav><!-- End Icons Navigation -->

        </header><!-- End Header -->

        <!-- ======= Sidebar ======= -->
        <aside id="sidebar" class="sidebar">

            <ul class="sidebar-nav" id="sidebar-nav">

                <li class="nav-item">
                    <a class="nav-link " href="home.jsp">
                        <i class="bi bi-house-fill"></i>
                        <span>Trang chủ</span>
                    </a>
                </li><!-- End Dashboard Nav -->

                <li class="nav-item">
                    <a class="nav-link " href="home?aid=${sessionScope.acc.getId()}">
                        <i class="bi bi-menu-button-wide"></i>
                        <span>Nhật ký</span>
                    </a>
                </li><!-- End Dashboard Nav -->
<!--                <li class="nav-item">
                    <a class="nav-link collapsed" data-bs-target="#components-nav1" data-bs-toggle="collapse" href="#">
                        <i class="bi bi-cash"></i><span>Quản lý thanh toán</span><i class="bi bi-chevron-down ms-auto"></i>
                    </a>
                    <ul id="components-nav1" class="nav-content collapse " data-bs-parent="#sidebar-nav">
                        <li>
                            <a href="card.jsp">
                                <i class="bi bi-circle"></i><span>Nạp tiền</span>
                            </a>
                        </li>
                        <li>
                            <a href="components-accordion.html">
                                <i class="bi bi-circle"></i><span>Lịch sử giao dịch</span>
                            </a>
                        </li>

                    </ul>-->
                </li><!-- End Components Nav -->
                <li class="nav-heading">Pages</li>
                <li class="nav-item">
                    <a class="nav-link collapsed" href="updateinfom?sid=${sessionScope.acc.getId()}">
                        <i class="bi bi-person"></i>
                        <span>Profile</span>
                    </a>
                </li><!-- End Profile Page Nav -->

                <li class="nav-item">
                    <a class="nav-link collapsed" href="#">
                        <i class="bi bi-question-circle"></i>
                        <span>F.A.Q</span>
                    </a>
                </li><!-- End F.A.Q Page Nav -->

                <li class="nav-item">
                    <a class="nav-link collapsed" href="#">
                        <i class="bi bi-envelope"></i>
                        <span>Contact</span>
                    </a>
                </li><!-- End Contact Page Nav -->

            </ul>

        </aside><!-- End Sidebarr-->


        <main id="main" class="main">
            <div class="mt-4 container-fluid">
                
                <c:if test="${sessionScope.acc == null}">
                    <div class="pagetitle">
                        <h3>
                            Chào mừng bạn đến với
                            <i>DiaryOnline</i>
                        </h3>
                    </div>
                </c:if>
                <c:if test="${sessionScope.acc != null}">
                    <c:set value="${requestScope.data}" var="o"/>
                    <section class="section">
                        <div class="row">
                            <div class="">

                                <div class="card">

                                    <div class="card-header bg-light">
                                        <div class="row">
                                            <h4 class="col-md-10"><b>Thông tin người dùng</b></h4>
                                            <button type="button" class="btn-close" data-bs-dismiss="modal" aria-label="Close"></button>
                                        </div>
                                    </div>


                                    <div class="card-body">


                                        <form action="updateinfom" method="post">

                                        
                                            <c:forEach items="${requestScope.listA}" var="o"> 
                                            <div class="form-group row">
                                                <label name="id" class="col-md-2 col-form-label"><b>ID:</b></label>
                                                <div class="col-sm-10">
                                                    <input type="number" name="id" class="form-control col-md-9" id="txtid" disabled="" value="${o.getId()}">
                                                    
                                                </div>
                                            </div>

                                            <div class="form-group row">
                                                <label class="col-md-2 col-form-label"><b>Họ và tên: </b> </label>
                                                <div class="col-sm-10">
                                                    <input type="text" name="fullname" class="form-control col-md-9" id="txtname" value="${o.getFullname()}">
                                                </div>
                                            </div>


                                            <div class="form-group row">
                                                <label class="col-md-2 col-form-label"><b>SĐT:</b></label>
                                                <div class="col-sm-10">
                                                    <input type="number" name="phone_num" class="form-control col-md-9" id="txtsdt" value="${o.getPhone_num()}" >

                                                </div>
                                            </div>
                                            <div class="form-group row">
                                                <label  class="col-md-2 col-form-label"><b>Email:</b></label>
                                                <div class="col-sm-10">
                                                    <input type="email" class="form-control" id="txtemail" disabled="" value="${o.getEmail()}" >
                                                </div>
                                            </div>
                                            <div class="form-group row">
                                                <label class="col-md-2 col-form-label"><b>Giới thiệu:</b></label>
                                                <div class="col-sm-10">
                                                    <textarea rows="8" name="description" placeholder="" class="form-control" >${o.getDescription()}</textarea>
                                                </div>
                                            </div>
                                            <div style="display: flex; justify-content: center; align-items: center;">
                                                <button type="submit" name="submit" class="btn btn-primary"><i class="bi bi-upload"></i>Cập nhật</button>
                                                
                                            </div>
                                            </c:forEach>

                                        </form>



                                    </div>

                                </div>

                            </div>
                        </div>
                    </section>
                </c:if>
            </div>

        </main>


        <!-- Vendor JS Files -->
        <script src="assets/vendor/apexcharts/apexcharts.min.js"></script>
        <script src="assets/vendor/bootstrap/js/bootstrap.bundle.min.js"></script>
        <script src="assets/vendor/chart.js/chart.umd.js"></script>
        <script src="assets/vendor/echarts/echarts.min.js"></script>
        <script src="assets/vendor/quill/quill.min.js"></script>
        <script src="assets/vendor/simple-datatables/simple-datatables.js"></script>
        <script src="assets/vendor/tinymce/tinymce.min.js"></script>
        <script src="assets/vendor/php-email-form/validate.js"></script>

        <!-- Template Main JS File -->
        <script src="assets/js/main.js"></script>


    </body>

</html>