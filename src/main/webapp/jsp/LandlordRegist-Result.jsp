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
    <title>Add New Landlord</title>
</head>

<body>
<h1 class="lblue text-center">  Result Registration</h1>
<hr/>

<!-- display the message -->
<c:import url="/jsp/include/show-message.jsp"/>

<!-- display the just created Student, if any and no errors -->
<c:if test='${not empty LandlordRegist }'>
<div class="container-fluid">
    <ul>
        <li>Fiscal Code : <c:out value="${LandlordRegist.l_taxcode}"/></li>
        <li>Name : <c:out value="${LandlordRegist.l_name}"/></li>
    </ul>
    <div id="ResultRedirect" >
        <button id="Loggin" class="btn btn-sm btn-secondary m-1" onclick="$('#myModal').modal('hide');seeTemp();" >Login</button>
    </div>
<%--    <p><a href="http://localhost:8080/PropertyRental-1.00/jsp/Landlord-Logging-Form.jsp">log in <i class="fas fa-sign-in-alt"></a><p>--%>
</div>
</c:if>
</body>
</html>









