<%--
  Created by IntelliJ IDEA.
  User: fran
  Date: 28/05/21
  Time: 19:02
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<div id="landingPage" class="container" >
    <div id="homepage-content"></div>
    <div id="loggin-area" ></div>

    <!-- header -->
    <header class="mt-5 mb-5">
        <div class="jumbotron jumbotron-fluid lblue">
            <div class="container lblue">
                <h2 class="display-4">Property Rental</h2>
                <p class="lead">will store rental advertisement in such a way that it is easier to search and
                    find what you are looking for, by applying specific filters and also digitalize all rent process. we aim
                    to create a safe environment for the two parties, students and landlords by bringing them together and
                    perform all the bureaucratic procedures.</p>
                <hr class="my-4">
                <p>we working according to italian housing role. we inform you with your rights and responsibilities when renting in Italy </p>
                <p class="lead">
                    <a class="btn btn-primary btn-lg" href="#" role="button">Learn more</a>
                </p>

            </div>
        </div>
    </header>

    <!-- body -->

    <div class="content mt-5 mb-5">

        <div class="card-deck">

            <!-- Start Landlord card-->
            <div class="card">
                <img src="<c:url value="/media/Property-Owner.jpg"/>" class="card-img-top" alt="Hello World card image">
                <div class="card-body">
                    <h5 class="card-title">Landlord</h5>
                    <p class="card-text text-center">
                        <a href="<c:url value="/jsp/LandlordRegist-Form.jsp"/>"><small class="font-weight-bold">Do you need more info</small><i class="fas fa-question align-middle ml-3"></i></a>
                    </p>
                    <p class="card-text">
                        <small class="text-muted">you can manage your account form here </small>
                    </p>
                </div>
            </div>
            <!-- End Landlord card-->

            <!-- Start Admin card-->
            <div class="card">
                <img src="<c:url value="/media/Admin.jpg"/>" class="card-img-top" alt="Get form card image">
                <div class="card-body">
                    <h5 class="card-title">Administrator</h5>
                    <p class="card-text text-center">
                        <code class="badge-pill badge-primary p-2">Log In</code>
                        <a href="<c:url value="/jsp/Admin-Logging-Form.jsp"/>"
                           title="Click to run the example"><i class="fas fa-sign-in-alt align-middle ml-3"></i></a>
                    </p>
                    <p class="card-text">
                        <small class="text-muted">here we manage the whole rent process to make sure it is safe
                        </small>
                    </p>
                </div>
            </div>
            <!-- End Admin card-->

            <!-- Start Student card-->
            <div class="card">
                <img src="<c:url value="/media/Students.jpg"/>" class="card-img-top" alt="Post form card image">
                <div class="card-body">
                    <h5 class="card-title">Student</h5>
                    <p class="card-text text-center">
                        <a href="<c:url value="/jsp/StudnetRegist-Form.jsp"/>"><small class="font-weight-bold">Do you need more info</small><i class="fas fa-question align-middle ml-3"></i></a>
                    </p>
                    <p class="card-text">
                        <small class="text-muted">only think about your studies and we the think about your accommodation
                        </small>
                    </p>
                </div>
            </div>
            <!-- End Student card-->

        </div> <!-- End Card Deck-->

    </div> <!-- End of Content-->
</div>
