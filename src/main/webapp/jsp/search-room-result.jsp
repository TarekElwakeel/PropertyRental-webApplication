<%--
  Created by IntelliJ IDEA.
  User: fran
  Date: 21/04/21
  Time: 19:02
  To change this template use File | Settings | File Templates.
--%>

<%@ page contentType="text/html;charset=utf-8" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<!DOCTYPE html>
<html lang="en">
<head>
    <title>Search Rooms</title>
</head>

<body>
<div class="container-fluid mt-5 mb-5">

<h1 class="lblue">Search Room</h1>
<hr/>


<form class="form row d-inline" method="POST" action="<c:url value="/create-room-request"/>">
<!-- display the message -->

    <label for="s_taxcode">StudentID:</label>
    <input name="s_taxcode" type="text"/><br/><br/>
</form>

    <div class="container-fluid mt-5 mb-5">

        <h3>Search Student result</h3>
        <hr/>
        <c:import url="/jsp/include/show-message.jsp"/>
<!-- display the list of found employees, if any -->
<c:if test='${not empty roomList}'>
    <span> Select one row or multiple then Press Send for sent a request to landlord <br> </span>
        <table class="card-table table table-bordered table-condensed table-responsive">
            <thead class="thead-light">
        <tr>
            <th scope="col">#</th><th scope="col">Address</th><th scope="col">Zip</th><th scope="col">Energy Class</th>
            <th scope="col">Total Area</th><th scope="col">Number of rooms</th><th scope="col">Bathrooms</th><th scope="col">kitchen</th>
            <th scope="col">other</th><th scope="col">extra_info</th><th scope="col">Capacity of person</th>
        </tr>
        </thead>

        <tbody>
        <c:forEach var="room" items="${roomList}">
            <tr>
                <td scope="row"><input type="checkbox" id="id" name="selected" value="${room.address},${room.space_badge}"></td>
                <td scope="row"><c:out value="${room.address}"/></td>
                <td scope="row"><c:out value="${room.space_badge}"/></td>
                <td scope="row"><c:out value="${room.p_code}"/></td>
                <td scope="row"><c:out value="${room.energy_class}"/></td>
                <td scope="row"><c:out value="${room.totsquaremeter}"/></td>
                <td scope="row"><c:out value="${room.n_room}"/></td>
                <td scope="row"><c:out value="${room.n_bath}"/></td>
                <td scope="row"><c:out value="${room.s_kitchen}"/></td>
                <td scope="row"><c:out value="${room.other}"/></td>
                <td scope="row"><c:out value="${room.extra_info}"/></td>
                <td scope="row"><c:out value="${room.capacity_persons}"/></td>
            </tr>
        </c:forEach>
        </tbody>
    </table>
    </div>
</c:if>
    <span> </span>

    <button type="submit">Send Request</button><br/>

</div>
</body>
</html>
