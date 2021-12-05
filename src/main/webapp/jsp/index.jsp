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

Author: professor Nicola Ferro (ferro@dei.unipd.it)
Version: 1.0
Since: 1.0
-->
<%@ page contentType="text/html;charset=UTF-8" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<!DOCTYPE html>
<html lang="en">
<head>

    <c:import url="/jsp/include/head.jsp"/>

    <title>Property Rental Web service</title>
<%--    <base href="http://localhost:8080/PropertyRental-1.00">--%>
    <c:choose>
        <c:when test="${!empty sessionScope.email}">
            <script>
                sessionStorage.setItem("loggedIn", true);
                sessionStorage.setItem("userEmail", "${sessionScope.email}");
                sessionStorage.setItem("userRole", "${sessionScope.role}");
            </script>
        </c:when>
        <c:otherwise>
            <script>
                sessionStorage.removeItem("loggedIn");
                sessionStorage.removeItem("userEmail");
                sessionStorage.removeItem("userRole");
            </script>
        </c:otherwise>
    </c:choose>
    <script type="text/javascript" src="<c:url value="/js/Ajaxcalls.js"/>"></script>
    <script type="text/javascript" src="<c:url value="/js/Utils.js"/>"></script>
    <script type="text/javascript" src="<c:url value="/js/Homepage.js"/>"></script>
</head>

<body>

<c:import url="/jsp/include/toolbar.jsp"/>

<div id="dynamic-area" ></div>

<c:import url="/jsp/include/foot.jsp"/>
<c:import url="/jsp/include/footer.jsp"/>
</body>
</html>
