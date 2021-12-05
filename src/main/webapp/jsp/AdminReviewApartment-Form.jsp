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
    <title> apartment check </title>
    <script type="text/javascript" src="<c:url value="/js/Ajaxcalls.js"/>"></script>
</head>

<body>

<div class="form row d-inline float-right">
        <select class="form-group column-4" name="status" id="apstatus">
            <option selected>Choose...</option>
            <option value="new">new</option>
            <option value="verified">verified</option>
            <option value="pending">pending</option>
        </select>
        <input class="form-group column-4 btn-primary active" type="button" value="Search" name="apstatusServlet" id="callapstatus"/>
    </div>
<div id="appstatus"></div>

</body>
</html>