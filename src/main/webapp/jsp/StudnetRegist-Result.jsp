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
    <title>Registration</title>
</head>

<body>
<%--<div class="container-fluid ">--%>

    <h3 class="lblue text-center"> New Student Result</h3>
    <hr/>

<!-- display the message -->
<c:import url="/jsp/include/show-message.jsp"/>

<!-- display the just created Student, if any and no errors -->
<c:if test='${not empty StudnetRegist }'>
<div class="container-fluid">
    <ul>
        <li>Fiscal Code: <c:out value="${StudnetRegist.s_taxcode}"/></li>
        <li>Name: <c:out value="${StudnetRegist.s_name}"/></li>
        <li>Age: <c:out value="${StudnetRegist.age}"/></li>
        <li>Country: <c:out value="${StudnetRegist.country}"/></li>
        <li>Foreign language: <c:out value="${StudnetRegist.foreign_lang}"/></li>
    </ul>
    <div id="ResultRedirect" >
        <button id="Loggin" class="btn btn-sm btn-secondary m-1" onclick="$('#myModals').modal('hide');seeTemp();" >Login</button>
    </div>

</div>
</c:if>
</body>
</html>









