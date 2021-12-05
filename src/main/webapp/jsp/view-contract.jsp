<%--
  Created by IntelliJ IDEA.
  User: fran
  Date: 22/04/21
  Time: 16:28
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<!DOCTYPE html>
<html lang="en">

<body>
<div class="container-fluid mt-5 mb-5">

<h1>View Contract</h1>
<hr/>

<c:import url="/jsp/include/show-message.jsp"/>
View pending request & Contract of user
  <!-- display the list of found employees, if any -->
  <c:if test='${not empty viewContracts}'>
    <span> Select one row or multiple then Press Send for sent a request to landlord <br> </span>
    <table class="card-table table table-bordered table-condensed table-responsive">
      <thead class="thead-light">
      <tr>
        <th scope="col">Request Number</th><th scope="col">stud</th><th scope="col">addr</th><th scope="col">badge</th>
        <th scope="col">start_req</th><th scope="col">status</th><th scope="col">dur</th><th scope="col">start_contr</th>
      </tr>
      </thead>

      <tbody>
      <c:forEach var="viewContract" items="${viewContracts}">
        <tr>
          <td scope="row"><c:out value="${viewContract.req_nb}"/></td>
          <td scope="row"><c:out value="${viewContract.stud}"/></td>
          <td scope="row"><c:out value="${viewContract.addr}"/></td>
          <td scope="row"><c:out value="${viewContract.badge}"/></td>
          <td scope="row"><c:out value="${viewContract.start_req}"/></td>
          <td scope="row"><c:out value="${viewContract.status}"/></td>
          <td scope="row"><c:out value="${viewContract.dur}"/></td>
          <td scope="row"><c:out value="${viewContract.start_contr}"/></td>
          </tr>
      </c:forEach>
      </tbody>
    </table>
  </c:if>
</div>
</body>
</html>
