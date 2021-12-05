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
    <title>Apartment search result</title>
    <script type="text/javascript" src="<c:url value="/js/Ajaxcalls.js"/>"></script>
</head>

<body>

<div class="container-fluid mt-5 mb-5">

    <h3 class="lblue">Search Apartment result</h3>


<hr/>


<!-- display the message -->
<c:import url="/jsp/include/show-message.jsp"/>

<!-- display the list of found Apartments, if any -->
<c:if test='${not empty AdminReviewApartmentList}'>

    <table class="card-table table table-bordered table-condensed table-responsive">
        <thead class="thead-light">
        <tr>
            <th scope="col">address</th><th scope="col">Rooms</th><th scope="col">Bathrooms</th>
            <th scope="col">kitchen</th><th scope="col">Zip</th><th scope="col">Energy Class</th>
            <th scope="col">Area</th><th scope="col">Status</th><th scope="col">Others</th>

        </tr>
        </thead>

        <tbody>
        <c:forEach var="AdminReviewApartment" items="${AdminReviewApartmentList}">
            <tr>

                <td scope="row"><input type="checkbox" class="addocheckbox" value="<c:out value="${AdminReviewApartment.address}"/>"/> <c:out value="${AdminReviewApartment.address}"/></td>
                <td scope="row"><c:out value="${AdminReviewApartment.n_room}"/></td>
                <td scope="row"><c:out value="${AdminReviewApartment.n_bath}"/></td>
                <td scope="row"><c:out value="${AdminReviewApartment.s_kitchen}"/></td>
                <td scope="row"><c:out value="${AdminReviewApartment.p_code}"/></td>
                <td scope="row"><c:out value="${AdminReviewApartment.energy_class}"/></td>
                <td scope="row"><c:out value="${AdminReviewApartment.totSquareMeter}"/></td>
                <td scope="row"><c:out value="${AdminReviewApartment.status}"/></td>
                <td scope="row"><c:out value="${AdminReviewApartment.extra_info}"/></td>

            </tr>
        </c:forEach>
        </tbody>
    </table>

    <div class="form row d-inline float-right">
        <select class="form-group column-4" name="status" id="apsstatus">
            <option selected>Choose...</option>
            <option value="new">new</option>
            <option value="verified">verified</option>
            <option value="pending">pending</option>
        </select>
        <input class="form-group column-4 btn-primary active" type="button" value="Update" name="UpdateapstatusServlet" id="callaps"/>
    </div>
    <div id="apr"></div>
</div>

</c:if>
</body>
</html>
