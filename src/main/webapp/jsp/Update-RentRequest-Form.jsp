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

Author:  under supervision of professor Nicola Ferro (ferro@dei.unipd.it)
Version: 1.0
Since: 1.0
-->
<%@ page contentType="text/html;charset=utf-8" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="utf-8">
    <title>Update Rent Request</title>
</head>

<body>
<div class="container-fluid mt-5 mb-5">
<div class="card">
    <div class="card-header"><i class="fas fa-home"></i> enter the request number and the status to be changed too </div>
    <div class ="card-body mt-5 mb-5">


<form  class="form mt-5 mb-5" method="POST" action="<c:url value="/Update-RentRequest-Landlord"/>">
    <div class="form-group">
    <label for="status">status:</label>
    <input name="status" type="text"/><br/><br/>
    </div>
    <div class="form-group">
    <label for="request_nr">request_nr:</label>
    <input name="request_nr" type="text"/><br/><br/>
    </div>
    <div class="form-group">
    <button type="submit">Submit</button><br/>
    <button type="reset">Reset the form</button>
    </div>
</form>
    </div>
</div>
</div>
</body>
</html>