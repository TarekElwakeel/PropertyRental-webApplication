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
    <title>Student logging</title>
</head>

<body>

<div class="container-fluid mt-5 mb-5">



<c:choose>
    <c:when test='${not empty StudnetinfoList}'>

    <c:forEach var="Studnetinfo" items="${StudnetinfoList}">
    </c:forEach>




    <div class="card">
        <div class="card-header" id="zheadingOne" aria-multiselectable="true">
            <h5 class="mb-1">
                <button class="accordion-button" type="button" data-toggle="collapse" data-target="#zcollapseOne" aria-expanded="true" >
                    <i class="fas fa-search"></i> Search Room
                </button>
            </h5>
        </div>

        <div id="zcollapseOne" class="accordion-collapse collapse show" aria-labelledby="zheadingOne">
            <div class="card-body">
                <c:import url="http://localhost:8080/PropertyRental-1.00/jsp/search-room-form.jsp"/>
            </div>
        </div>
    </div>
    <div class="card">
        <div class="card-header" id="zheadingTwo" aria-multiselectable="true">
            <h5 class="mb-1">
                <button class="accordion-button" type="button" data-toggle="collapse" data-target="#zcollapseTwo" aria-expanded="true" >
                    <i class="fas fa-envelope"></i> My Requests
                </button>
            </h5>
        </div>
        <div id="zcollapseTwo" class="accordion-collapse collapse" aria-labelledby="zheadingTwo">
            <div class="card-body">
                <c:import url="http://localhost:8080/PropertyRental-1.00/jsp/view-contract.jsp"/>
            </div>
        </div>
    </div>
    <div class="card">
        <div class="card-header" id="zheadingThree" aria-multiselectable="true">
            <h5 class="mb-1">
                <button class="accordion-button" type="button" data-toggle="collapse" data-target="#zcollapseThree" aria-expanded="true" >
                    <i class="fas fa-plus-circle"></i> New Apartment
                </button>
            </h5>
        </div>
        <div id="zcollapseThree" class="accordion-collapse collapse" aria-labelledby="zheadingThree">
            <div class="card-body">
                <c:import url="http://localhost:8080/PropertyRental-1.00/jsp/create-room-result.jsp"/>
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


</body>
</html>

