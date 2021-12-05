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
    <title>Rent Requests</title>
    <script type="text/javascript" src="<c:url value="/js/Ajaxcalls.js"/>"></script>
</head>

<body>
<div class="container-fluid mt-5 mb-5">

    <h3 class="lblue">Rent Requests search Result</h3>
    <hr/>

<!-- display the message -->
<c:import url="/jsp/include/show-message.jsp"/>

<!-- display the list of found Rent Requests, if any -->
<c:if test='${not empty RentRequestList}'>

    <table class="card-table table table-bordered table-condensed table-responsive">
        <thead class="thead-light">
        <tr>
            <th scope="col">Request Number</th><th scope="col">Student</th><th scope="col">RoomAddress</th>
            <th scope="col">RoomBadge</th><th scope="col">Time</th><th scope="col">Status</th>
        </tr>
        </thead>

        <tbody>
        <c:forEach var="RentRequest" items="${RentRequestList}">
            <tr>

                <td scope="row"><input type="checkbox" class="RNcheckbox" value="<c:out value="${RentRequest.requestnr}"/>"/> <c:out value="${RentRequest.requestnr}"/></td>
                <td scope="row"><c:out value="${RentRequest.student}"/></td>
                <td scope="row"><c:out value="${RentRequest.roomaddress}"/></td>
                <td scope="row"><c:out value="${RentRequest.roomBadge}"/></td>
                <td scope="row"><c:out value="${RentRequest.rtime}"/></td>
                <td scope="row"><c:out value="${RentRequest.status}"/></td>


            </tr>
        </c:forEach>
        </tbody>
    </table>


    <div class="float-right">
    <select class="form-group column-4 " name="status" id="status">
        <option selected>Choose...</option>
        <option value="confirmed">confirmed</option>
        <option value="approved">approved</option>
        <option value="rejected">rejected</option>
        </select>
    <input class="form-group column-4 btn-primary active" type="button" value="Update" name="UpdateRentRequestServlet" id="callUR"/>
    </div >
        <div id="UReq"></div>

</div >

</c:if>
</body>
</html>







