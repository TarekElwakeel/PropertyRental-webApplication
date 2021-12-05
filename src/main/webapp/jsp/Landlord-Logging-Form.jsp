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
    <meta charset="utf-8">
    <title>Landlord Logging Page</title>
    <c:import url="/jsp/include/head.jsp"/>
    <meta name="keywords" content="log in, landlord">
</head>

<body>

    <div class="container">
        <div class="card m-sm-5 ">
            <div class="card-header blue"> Landlord Logging </div>
            <div class ="card-body p-sm-5">

                <div class="new-user text-right">
                    <p class="h2">
                        <a class="d-inline " href="<c:url value="http://localhost:8080/PropertyRental-1.00/jsp/LandlordRegist-Form.jsp"/>">
                            <small class="font-weight-bold text-xl-left">New User</small><i class="fas fa-user-plus align-middle ml-3"></i></a>
                    <p>
                </div>

            <form class="form form mt-5 mb-5" method="POST" action="<c:url value="/Landlord-info"/>">

                <div class="form-group">
                    <p>Please enter your fiscal code and password </p>
                </div>

                <div class="form-group m-sm-5">

                            <div class="form-group m-sm-5">
                                <label for="l_taxcode">Fiscal Code :</label><br/>
                                <i class="fas fa-user-circle"> </i><input type="text" id="sostaxcode" class="form-control" name="l_taxcode" placeholder="MRTMTT91D08F205J">
                            </div>
                            <div class="form-group m-sm-5">
                                <label for="password">Password :</label><br/>
                                <i class="fas fa-lock"> </i><input type="password" class="form-control" name="spassword" id="password" placeholder="Pm***2***">
                            </div>

                        <div class="row">
                            <button type="submit" class="btn btn-primary">log in</button>
                            <button type="reset" class="btn">Clear</button>
                        </div>
                    </div>
            </form>

        </div>
    </div>
</div>

    <div>
    <c:import url="/jsp/include/footer.jsp"/>
    </div>

</body>

</html>