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
    <title>My Apartment Rooms</title>
</head>

<body>

<div class="container-fluid mt-5 mb-5">

    <h3 class="lblue">Rooms Search Result</h3>

<hr/>
<c:import url="/jsp/include/show-message.jsp"/>

<!-- display the list of found Rooms, if any -->
<c:if test='${not empty SpecificPropertyList}'>

    <!-- display the message -->

    <table class="card-table table table-bordered table-condensed table-responsive">
        <thead class="thead-light">
        <tr>
            <th scope="col">app_address</th><th scope="col">space_badge</th><th scope="col">capacity_persons</th>
            <th scope="col">other</th>
        </tr>
        </thead>

        <tbody>
        <c:forEach var="SpecificProperty" items="${SpecificPropertyList}">
            <tr>

                <td scope="row"><c:out value="${SpecificProperty.app_address}"/></td>
                <td scope="row"><c:out value="${SpecificProperty.space_badge}"/></td>
                <td scope="row"><c:out value="${SpecificProperty.capacity_persons}"/></td>
                <td scope="row"><c:out value="${SpecificProperty.other}"/></td>


            </tr>
        </c:forEach>
        </tbody>
    </table>

    </div>

</c:if>
</body>
</html>



