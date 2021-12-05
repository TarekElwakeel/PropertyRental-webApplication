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
<%@ page contentType="text/html;charset=utf-8" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<!DOCTYPE html>
<html lang="en">
<head>
    <c:import url="/jsp/include/head.jsp"/>
    <meta charset="utf-8">
    <title>Landlord Logging Page</title>
</head>

<body>



<div class="container">
    <div class="card m-sm-5 ">
        <div class="card-header blue"> Admin Logging </div>
        <div class ="card-body p-sm-5">


        <form class="form mt-5 mb-5" method="POST" action="<c:url value="/Admin-Logging"/>">


        <div class="form-group">
            <label for="username">Username:</label><br/>
            <i class="fas fa-user-circle"></i><input type="text" class="form-control" name="username" placeholder="your name">
        </div>

        <div class="form-group">
            <label for="password">password:</label><br/>
            <i class="fas fa-lock"></i><input type="password" class="form-control" name="password" placeholder="Pm***2***">
        </div>

        <div class="form-group">
            <button type="submit" class="btn btn-primary">log in</button>
            <button type="reset" class="btn">Clear</button>
        </div>
</form>

</div>

</div>


    <c:import url="/jsp/include/footer.jsp"/>

</div>
</body>

</html>