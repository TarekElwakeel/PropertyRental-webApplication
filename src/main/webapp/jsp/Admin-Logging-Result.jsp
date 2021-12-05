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

Author: under supervision of professor Nicola Ferro (ferro@dei.unipd.it)
Version: 1.0
Since: 1.0
-->
<%@ page contentType="text/html;charset=utf-8" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>


<!DOCTYPE html>
<html lang="en">
<head>
    <c:import url="/jsp/include/head.jsp"/>
    <title>Admin landing page</title>
</head>

<body>
<div class="container-fluid mt-5 mb-5">

<h3 class="blue">Admin landing Result</h3>
<hr/>

<c:import url="/jsp/include/show-message.jsp"/>

<c:choose>
    <c:when test='${not empty AdmininfoList}'>

            <div class="card">
                <div class="card-header blue" id="AheadingOne" aria-multiselectable="true">
                    <h5 class="mb-1">
                        <button class="accordion-button" type="button" data-toggle="collapse" data-target="#AcollapseOne" aria-expanded="true" >
                            <i class="fas fa-search"></i> Search Apartment
                        </button>
                    </h5>
                </div>

                <div id="AcollapseOne" class="accordion-collapse collapse show" aria-labelledby="AheadingOne">
                    <div class="card-body">
                        <c:import url="http://localhost:8080/PropertyRental-1.00/jsp/AdminReviewApartment-Form.jsp"/>
                    </div>
                </div>
            </div>
            <div class="card">
                <div class="card-header blue" id="AheadingTwo" aria-multiselectable="true">
                    <h5 class="mb-1">
                        <button class="accordion-button" type="button" data-toggle="collapse" data-target="#AcollapseTwo" aria-expanded="true" >
                            <i class="fas fa-search"></i> Search Landlord
                        </button>
                    </h5>
                </div>
                <div id="AcollapseTwo" class="accordion-collapse collapse show" aria-labelledby="AheadingTwo">
                    <div class="card-body">
                        <c:import url="http://localhost:8080/PropertyRental-1.00/jsp/AdminReviewLandlord-Form.jsp"/>
                    </div>
                </div>
            </div>
            <div class="card">
                <div class="card-header blue" id="AheadingThree" aria-multiselectable="true">
                    <h5 class="mb-1">
                        <button class="accordion-button" type="button" data-toggle="collapse" data-target="#AcollapseThree" aria-expanded="true" >
                            <i class="fas fa-search"></i> Search Student
                        </button>
                    </h5>
                </div>
                <div id="AcollapseThree" class="accordion-collapse collapse show" aria-labelledby="AheadingThree">
                    <div class="card-body">
                        <c:import url="http://localhost:8080/PropertyRental-1.00/jsp/AdminReviewStudent-Form.jsp"/>
                    </div>
                </div>
            </div>



    </c:when>

    <c:otherwise>

        <td><c:out value="wrong user name or password. please try again"/></td>

    </c:otherwise>

</c:choose>


</body>
</html>

