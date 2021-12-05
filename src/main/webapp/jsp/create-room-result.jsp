<%--
  Created by IntelliJ IDEA.
  User: fran
  Date: 22/04/21
  Time: 13:56
  To change this template use File | Settings | File Templates.
--%>

<%@ page contentType="text/html;charset=utf-8" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<!DOCTYPE html>
<html lang="en">
<head>
    <title>View all request</title>
</head>

<body>
<h1>Create rentrequest</h1>
<hr/>

<!-- display the message -->
<c:import url="/jsp/include/show-message.jsp"/>

<iframe src="view-contract?s_taxcode=${s_taxcode}" style="width:100%;"></iframe>

<!-- display the just created employee, if any and no errors -->
Insert in rent request
<c:if test='${not empty rentrequest }'>
    <ul>
        <li>badge: <c:out value="${rentrequest.badge}"/></li>
        <li>student: <c:out value="${rentrequest.student}"/></li>
        <li>address: <c:out value="${rentrequest.address}"/></li>
    </ul>
</c:if>
</body>
</html>
