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
    <title>My Properties</title>
    <script type="text/javascript" src="<c:url value="/js/Ajaxcalls.js"/>"></script>
</head>

<body>
<div class="container-fluid mt-5 mb-5">

    <h3 class="lblue">Apartment Search Result</h3>
    <hr/>

    <c:import url="/jsp/include/show-message.jsp"/>
<!-- display the list of found Apartment, if any -->
<c:if test='${not empty MyPropertyList}'>


    <table class="card-table table table-bordered table-condensed table-responsive">
        <thead class="thead-light">
        <tr>
            <th scope="col">Address</th><th scope="col">Rooms</th><th scope="col">Bathrooms</th>
            <th scope="col">kitchen</th><th scope="col">Zip</th><th scope="col">Energy Class</th>
            <th scope="col">Total area</th><th scope="col">Status</th><th scope="col">Other</th>
        </tr>
        </thead>

        <tbody>
        <c:forEach var="MyProperty" items="${MyPropertyList}">
            <tr>

                <td scope="row"><input type="checkbox" class="addvaluecheck" value="<c:out value="${MyProperty.proaddress}"/>"/> <c:out value="${MyProperty.proaddress}"/></td>
                <td scope="row"><c:out value="${MyProperty.n_room}"/></td>
                <td scope="row"><c:out value="${MyProperty.n_bath}"/></td>
                <td scope="row"><c:out value="${MyProperty.s_kitchen}"/></td>
                <td scope="row"><c:out value="${MyProperty.p_code}"/></td>
                <td scope="row"><c:out value="${MyProperty.energy_class}"/></td>
                <td scope="row"><c:out value="${MyProperty.totSquareMeter}"/></td>
                <td scope="row"><c:out value="${MyProperty.appStatus}"/></td>
                <td scope="row"><c:out value="${MyProperty.extra_info}"/></td>

            </tr>
        </c:forEach>
        </tbody>

</table>

    <div class="form row d-inline float-right">
        <input class="form-group column-4 btn-primary active" type="button" value="View Rooms" name="SpecificPropertyServlet" id="callroom"/>
    </div>
    <div id="rooms"></div>

</c:if>


</body>
</html>
