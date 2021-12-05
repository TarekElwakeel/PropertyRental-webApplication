<%--
  Created by IntelliJ IDEA.
  User: fran
  Date: 17/05/21
  Time: 15:22
  To change this template use File | Settings | File Templates.
--%>

<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<script type="text/javascript" src="<c:url value="/js/toolbar.js"/>"></script>
<nav class="navbar navbar-expand-sm navbar-dark bg-dark sticky-top">
    <button class="navbar-toggler btn btn-sm btn-outline-secondary" type="button" data-toggle="collapse" data-target="#navbarCollapse" aria-controls="navbarCollapse" aria-expanded="false" aria-label="Toggle navigation">
        <i class="fas fa-bars fa-3x align-middle ml-3"></i>
        <%--<mat-icon class="" svgIcon="menu"></mat-icon>--%>
        <!-- <span class="navbar-toggler-icon"></span> -->
        <!-- <mat-icon class="mdi-rotate-90" svgIcon="menu"></mat-icon> -->
    </button>
    <div class="navbar-brand px-1">
        <%--<img src="../../assets/fire.svg" alt="Logo" style="height:30px;">--%>
        <a class="text-white align-middle mr-auto" ><i class="fab fa-product-hunt fa-2x align-middle ml-3"></i><i class="fas fa-registered fa-2x align-middle ml-3"></i></a>
    </div>
    <!-- <a class="navbar-brand" href="#">Top navbar</a> -->
    <!-- <button class="navbar-toggler" type="button" data-toggle="collapse" data-target="#navbarCollapse" aria-controls="navbarCollapse" aria-expanded="false" aria-label="Toggle navigation">
      <span class="navbar-toggler-icon"></span>
    </button> -->
    <div class="collapse navbar-collapse" id="navbarCollapse">
        <ul class="navbar-nav mr-auto">
            <li class="nav-item active d-inline px-auto px-lg-5">
                <a class="nav-link " href="http://localhost:8080/PropertyRental-1.00/"><i class="fas fa-home fa-2x align-middle ml-3"></i> Home </a>

                <%--<mat-icon class="" svgIcon="home"></mat-icon> --%>
                <!-- <a class="nav-link" href="#">Home <span class="sr-only">(current)</span></a> -->
            </li>
<%--            <li class="nav-item d-inline px-sm-1 px-lg-5">--%>
<%--                <a class="nav-link" href="about" id="About">About </a>--%>
<%--                <!-- <a class="nav-link" href="#">Link</a> -->--%>
<%--            </li>--%>
<%--            <li class="nav-item d-inline px-sm-1 px-lg-5">--%>
<%--                <a class="nav-link" href="photo"><mat-icon class="" svgIcon="camera"></mat-icon>Photo </a>--%>
<%--                <!-- <a class="nav-link" href="#">Link</a> -->--%>
<%--            </li>--%>
<%--            <li class="nav-item d-inline px-sm-1 px-lg-5">--%>
<%--                <a class="nav-link" href="party">Party </a>--%>
<%--                <!-- <a class="nav-link disabled" href="#" tabindex="-1" aria-disabled="true">Disabled</a> -->--%>
<%--            </li>--%>
        </ul>
        <!-- <form class="form-inline mt-2 mt-md-0"> -->
        <!-- <input class="form-control mr-sm-2" type="text" placeholder="Search" aria-label="Search"> -->
        <!-- <button class="btn btn-outline-success my-2 my-sm-0" type="submit">Search</button> -->
        <!-- </form> -->
    </div>
    <div id="top-right" ></div>

</nav>
