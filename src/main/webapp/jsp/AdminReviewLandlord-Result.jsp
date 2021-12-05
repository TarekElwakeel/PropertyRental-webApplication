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
    <title>Landlord</title>
    <script type="text/javascript" src="<c:url value="/js/Ajaxcalls.js"/>"></script>
</head>

<body>

<div class="container-fluid mt-5 mb-5">

    <h3 class="lblue">Search Landlord result</h3>

<hr/>

<!-- display the message -->
<c:import url="/jsp/include/show-message.jsp"/>

<!-- display the list of found Landlords, if any -->
<c:if test='${not empty AdminReviewLandlordList}'>

    <table class="card-table table table-bordered table-responsive table-hover container-fluid">
        <thead class="thead-light">
        <tr>
            <th scope="col">Fiscal code</th><th scope="col">Name</th><th scope="col">Status</th>
        </tr>
        </thead>

        <tbody>
        <c:forEach var="AdminReviewLandlord" items="${AdminReviewLandlordList}">
            <tr>
                <td scope="row"><input type="checkbox" class="lordocheckbox" value="<c:out value="${AdminReviewLandlord.l_taxcode}"/>"/> <c:out value="${AdminReviewLandlord.l_taxcode}"/></td>
                <td scope="row"><c:out value="${AdminReviewLandlord.l_name}"/></td>
                <td scope="row"><c:out value="${AdminReviewLandlord.status}"/></td>

            </tr>
        </c:forEach>
        </tbody>
    </table>

    <div class="form row d-inline float-right">
        <select class="form-group column-4" name="status" id="landstatus">
            <option selected>Choose...</option>
            <option value="new">new</option>
            <option value="verified">verified</option>
            <option value="pending">pending</option>
        </select>
        <input class="form-group column-4 btn-primary active" type="button" value="Update" name="Call Update landstatusServlet" id="callsland"/>
    </div>
    <div id="landsta"></div>
</div>

</c:if>
</body>
</html>
