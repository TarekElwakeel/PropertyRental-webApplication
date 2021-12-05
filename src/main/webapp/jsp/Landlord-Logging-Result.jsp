<!--
Copyright 2021 University of Padua, Italy

Licensed under the Apache License, Version 2.0 (the "License");
you may not use this file except in compliance with the License.
You may obtain a copy of the License at

http://www.apache.org/licenses/LICENSE-2.0

Unless required by applicable law or agreed to in writing, software
distributed under the License is distributed on an "AS IS" BASIS,
WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
See the License for the specific language governing permissions and
limitations under the License.

Author: Tarek Elwakeel under supervision of professor Nicola Ferro (ferro@dei.unipd.it)
Version: 1.0
Since: 1.0
-->
<%@ page contentType="text/html;charset=utf-8" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>


<!DOCTYPE html>
<html lang="en">
<head>
    <c:import url="/jsp/include/head.jsp"/>
    <title>Landlord landing page</title>
    <script type="text/javascript" src="<c:url value="/js/Ajaxcalls.js"/>"></script>

</head>

<body>

<div class="container-fluid mt-5 mb-5">
<!-- display the message -->


<c:choose>
    <c:when test='${not empty LandlordsList}'>

        <c:forEach var="Landlordinfo" items="${LandlordsList}">

        </c:forEach>

            <div class="card">
                <div class="card-header blue" id="headingOne" aria-multiselectable="true">
                    <h5 class="mb-1">
                        <button class="accordion-button" type="button" data-toggle="collapse" data-target="#collapseOne" aria-expanded="true" >
                            <i class="fas fa-home"></i> My Proprieties
                        </button>
                    </h5>
                </div>

                <div id="collapseOne" class="accordion-collapse collapse" aria-labelledby="headingOne">
                    <div class="card-body">
                        <c:import url="http://localhost:8080/PropertyRental-1.00/jsp/View-MyProperty-Form.jsp"/>
                    </div>
                </div>
            </div>
            <div class="card">
                <div class="card-header blue" id="headingTwo" aria-multiselectable="true">
                    <h5 class="mb-1">
                        <button class="accordion-button" type="button" data-toggle="collapse" data-target="#collapseTwo" aria-expanded="true" >
                            <i class="fas fa-envelope"></i> My Requests
                        </button>
                    </h5>
                </div>
                <div id="collapseTwo" class="accordion-collapse collapse" aria-labelledby="headingTwo">
                    <div class="card-body">
                        <c:import url="http://localhost:8080/PropertyRental-1.00/jsp/View-RentRequest-Form.jsp"/>
                    </div>
                </div>
            </div>
            <div class="card">
                <div class="card-header blue" id="headingThree" aria-multiselectable="true">
                    <h5 class="mb-1">
                        <button class="accordion-button" type="button" data-toggle="collapse" data-target="#collapseThree" aria-expanded="true" >
                            <i class="fas fa-plus-circle"></i> New Apartment
                        </button>
                    </h5>
                </div>
                <div id="collapseThree" class="accordion-collapse collapse" aria-labelledby="headingThree">
                    <div class="card-body">
                        <c:import url="http://localhost:8080/PropertyRental-1.00/jsp/Add-NewApatment-Form.jsp"/>
                    </div>
                </div>
            </div>
            <div class="card">
                <div class="card-header blue" id="headingFour" aria-multiselectable="true">
                    <h5 class="mb-1">
                        <button class="accordion-button" type="button" data-toggle="collapse" data-target="#collapseFour" aria-expanded="true" >
                            <i class="fas fa-plus-circle"></i> New Room
                        </button>
                    </h5>
                </div>
                <div id="collapseFour" class="accordion-collapse collapse" aria-labelledby="headingThree">
                    <div class="card-body">
                        <c:import url="http://localhost:8080/PropertyRental-1.00/jsp/Add-NewRoom-Form.jsp"/>
                    </div>
                </div>
            </div>
        </div>



    </c:when>

    <c:otherwise>
        <div class="container text-center m-sm-5">
            <h5><c:out value="wrong user name or password. please try again"/></h5>
            <h5>Error : <c:import url="/jsp/include/show-message.jsp"/></h5>
        </div>

        </c:otherwise>

</c:choose>



<c:import url="/jsp/include/foot.jsp"/>

</body>
</html>

