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
    <title>Student check</title>
    <script type="text/javascript" src="<c:url value="/js/Ajaxcalls.js"/>"></script>

</head>

<body>

<div class="container-fluid mt-5 mb-5">

    <h3 class="lblue">Search Student result</h3>
    <hr/>


<!-- display the message -->
<c:import url="/jsp/include/show-message.jsp"/>

<!-- display the list of found Landlords, if any -->
<c:if test='${not empty AdminReviewStudentList}'>


    <table class="card-table table table-bordered table-condensed table-responsive">
        <thead class="thead-light">
        <tr>
            <th scope="col">Fiscal code</th><th scope="col">Name</th><th scope="col">Age</th>
            <th scope="col">Country</th><th scope="col">Foreign languages</th><th scope="col">Status</th>
        </tr>
        </thead>

        <tbody>
        <c:forEach var="AdminReviewStudent" items="${AdminReviewStudentList}">
            <tr>

                <td scope="row"><input type="checkbox" class="studiocheckbox" value="<c:out value="${AdminReviewStudent.s_taxcode}"/>"/> <c:out value="${AdminReviewStudent.s_taxcode}"/></td>
                <td scope="row"><c:out value="${AdminReviewStudent.s_name}"/></td>
                <td scope="row"><c:out value="${AdminReviewStudent.age}"/></td>
                <td scope="row"><c:out value="${AdminReviewStudent.country}"/></td>
                <td scope="row"><c:out value="${AdminReviewStudent.foreign_lang}"/></td>
                <td scope="row"><c:out value="${AdminReviewStudent.status}"/></td>

            </tr>
        </c:forEach>
        </tbody>
    </table>

    <div class="form row d-inline float-right">
        <select class="form-group column-4" name="status" id="studistatus">
            <option selected>Choose...</option>
            <option value="new">new</option>
            <option value="verified">verified</option>
            <option value="pending">pending</option>
        </select>
        <input class="form-group column-4 btn-primary active" type="button" value="Update" name="UpdatestudstatusServlet" id="callsstudi"/>
    </div>
    <div id="studista"></div>
</div>

</c:if>
</body>
</html>
