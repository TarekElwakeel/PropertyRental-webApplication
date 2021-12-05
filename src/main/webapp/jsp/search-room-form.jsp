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
    <meta charset="utf-8">
    <title>Search Room Form</title>
</head>

<body>

<div class="container-fluid">


<form class="form in-line mt-5 mb-5" method="POST" action="<c:url value="/search-room-result"/>">
    <div class="form-group">
    <label for="capacity_persons">Max persons:</label>
    <input name="capacity_persons" type="text"/><br/><br/>
    </div>

    <div class="form-group">
    <label for="n_bath">Min bath:</label>
    <input name="n_bath" type="text"/><br/><br/>
    </div>

    <div class="form-group">
    <button type="submit">Submit</button><br/>
    <button type="reset">Reset the form</button>
    </div>
</form>
        </div>
</body>
</html>
