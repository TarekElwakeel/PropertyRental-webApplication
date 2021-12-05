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
    <title>New Apartment result</title>
</head>

<body>

<div class="container-fluid mt-5 mb-5">
<h3 class="lblue">Adding New Apartment result</h3>
<hr/>

<!-- display the message -->
<c:import url="/jsp/include/show-message.jsp"/>

<!-- display the just created Apartment, if any and no errors -->
<c:if test='${not empty NewApartment }'>

    <ul>
        <li>address: <c:out value="${NewApartment.address}"/></li>
        <li>n_room: <c:out value="${NewApartment.n_room}"/></li>
        <li>n_bath: <c:out value="${NewApartment.n_bath}"/></li>
        <li>s_kitchen: <c:out value="${NewApartment.s_kitchen}"/></li>
        <li>p_code: <c:out value="${NewApartment.p_code}"/></li>
        <li>energy_class: <c:out value="${NewApartment.energy_class}"/></li>
        <li>totSquareMeter: <c:out value="${NewApartment.totSquareMeter}"/></li>
        <li>extra_info: <c:out value="${NewApartment.extra_info}"/></li>
    </ul>

</div>
</c:if>
</body>
</html>









