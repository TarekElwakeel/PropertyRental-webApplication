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
    <c:import url="/jsp/include/head.jsp"/>
    <meta charset="utf-8">
    <title>Adding New Room</title>
</head>

<body>
<div class="container">
    <div class="form-row-flex m-sm-2">
    <input class="form-group col-md-4" id="app_address" type="text" name="app_address" placeholder="Address"/>
    <input class="form-group col-md-4" id="capacity_persons" type="number" name="capacity_persons" placeholder="Persons per room"/>
    <textarea class="form-group col-md-4" name="other" id ="other" rows="1" placeholder="more Info"></textarea>
    <input class="form-group col-md-4 btn-primary active" type="button" value="Add Room" name="AddRoomServlet" id="calladdroom"/>
    </div>
<div id="addroomss"></div>

</div>
</body>
</html>