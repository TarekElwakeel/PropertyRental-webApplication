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
    <title>Student Registration</title>
    <meta name="keywords" content="Room, Student, italy, rent">
</head>

<body>

<div class="container-fluid">
    <div class="container">
    <header class=" mt-5 mb-5">
    <div class="container">
        <h1 class="blue"> what we offer to you as a Student </h1>
    </div>
        </header>
        <dl>
            <dt> management </dt>
            <dd>full mangement for the web site</dd>

            <dt>other</dt>
            <dd>
                <p>we offer you ....................................</p>
                <p>.................................................</p>
            </dd>

            <dt> documentation </dt>
            <dd>....................................</dd>

        </dl>
        </div>


    <div class="container">

    <div class="card">
        <div class="card-header blue" id="dheadingOne" aria-multiselectable="true">
            <h5 class="mb-1">
                <button class="accordion-button" type="button" data-toggle="collapse" data-target="#dcollapseOne" aria-expanded="false" >
                    <i class="fas fa-house-user"></i> Join us
                </button>
            </h5>
        </div>

        <div id="dcollapseOne" class="accordion-collapse collapse show" aria-labelledby="dheadingOne">
            <div class="card-body">

                <form class="form" method="POST" action="New-Studnet" enctype="multipart/form-data"/>

                <div class="form-group m-sm-5">
                    <label for="s_taxcode">Fiscal code:</label>
                    <input type="text" class="form-control" name="s_taxcode" id="s_taxcode" placeholder="MRTMTT91D08F205J">
                </div>

                <div class="form-group m-sm-5">
                    <label for="s_name">Name:</label>
                    <input type="text" class="form-control" name="s_name" id="s_name" placeholder=" Lastname  Firstname ">
                </div>

                <div class="form-group m-sm-5">
                    <label for="age">Age:</label>
                    <input type="number" class="form-control" name="age" id="age" placeholder="25">
                </div>

                <div class="form-group m-sm-5">
                    <label for="country">Country:</label>
                    <input type="text" class="form-control" name="country" id="country" placeholder="Italy">
                </div>

                <div class="form-group m-sm-5">
                    <label for="foreign_lang">Foreign language:</label>
                    <input type="text" class="form-control" name="foreign_lang" id="foreign_lang" placeholder="English">
                </div>

                <div class="form-group m-sm-5">
                    <label for="password">password:</label>
                    <input type="password" class="form-control" name="password" id="password" placeholder="Pm***2***">
                </div>

                <div class="form-group m-sm-5">
                    <label for="scannedID">ID Soft Copy :</label>
                    <input type="file" class="form-control-file" name="scannedID" id="scannedID">
                </div>

                <div class="form-group m-sm-5">
                    <button type="submit" class="btn btn-primary">Submit</button>
                    <button type="reset" class="btn">Reset the form</button>
                </div>

                </form>

            </div>
        </div>
    </div>

</div>

</div>


</body>


<footer >
    <c:import url="/jsp/include/footer.jsp"/>

</footer>

</html>