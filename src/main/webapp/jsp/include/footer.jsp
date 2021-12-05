<!--
Copyright 2019 University of Padua, Italy

Licensed under the Apache License, Version 2.0 (the "License");
you may not use this file except in compliance with the License.
You may obtain a copy of the License at

http://www.apache.org/licenses/LICENSE-2.0

Unless required by applicable law or agreed to in writing, software
distributed under the License is distributed on an "AS IS" BASIS,
WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
See the License for the specific language governing permissions and
limitations under the License.

Author: Nicola Ferro (ferro@dei.unipd.it)
Version: 1.0
Since: 1.0
-->
<%@ page contentType="text/html;charset=UTF-8" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<footer class="mt-5 mb-5 ">

    <div class="row justify-content-center">
        <div class="col-md-8 text-center">
            <hr/>
        </div>
    </div>

    <div class="row justify-content-center align-items-center">
        <div class="col-md-1 text-center">
            <a href="http://www.unipd.it/" target="_blank">
                <img class="img-fluid" src="<c:url value="/media/logo-UNIPD.png"/>"
                     alt="logo University of Padua" style="width:100px !important;">
            </a>
        </div>
        <div class="col-md-4 text-center text-muted small">
            Copyright &copy; 2021, University of Padua, Italy
        </div>
        <div class="col-md-1 text-center">
            <a >
                <img class="img-fluid" src="<c:url value="/media/Housing.png"/>"
                     alt="logo Housing" style="width:100px !important;">
            </a>
        </div>
    </div>

</footer>