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
    <meta charset="utf-8">
    <title>New apartment</title>
</head>

<body>

<div class="container">

    <div class="card">
        <div class="card-header"><i class="fas fa-info"></i> Please fill the Form </div>
        <div class ="card-body p-sm-2">


    <div class="form-row m-sm-2">

    <div class="form-group col-md-4">
        <label for="app_addresss"> Address : </label>
        <input type="text" class="form-control" name="app_address" id ="app_addresss" placeholder="Via Roma 33">
    </div>

    <div class="form-group col-md-4">
        <label for="p_code"> Zip : </label>
        <input type="number" class="form-control" name="p_code" id ="p_code" placeholder="15115">
    </div>

    </div>

    <div class="form-group m-sm-2">
    <label for="n_room">Number of rooms :</label>
    <input type="number" class="form-control" name="n_room" id ="n_room" placeholder="5">
    </div>

    <div class="form-group m-sm-2">
    <label for="n_bath">Number of shared bathrooms :</label>
    <input type="number" class="form-control" name="n_bath" id ="n_bath" placeholder="2">
    </div>

    <div class="form-group m-sm-2">
        <label for="s_kitchen">Kitchen :</label>
        <input type="text" class="form-control" name="s_kitchen" id="s_kitchen"  list="s_kitchen">
        <datalist  id="s_kitcheno">
            <option selected>Choose...</option>
            <option value="Yes">Yes</option>
            <option value="No">No</option>
        </datalist>
    </div>


    <div class="form-group m-sm-2">
        <label class="energy" for="energy_class">Energy Class :</label>
        <select class="custom-select energy" name="energy_class" id ="energy_class">
            <option selected>Choose...</option>
            <option value="A4">A4</option>
            <option value="A3">A3</option>
            <option value="A2">A2</option>
            <option value="A1">A1</option>
            <option value="B">B</option>
            <option value="C">C</option>
            <option value="D">D</option>
            <option value="E">E</option>
            <option value="F">F</option>
            <option value="G">G</option>
        </select>
    </div>

    <div class="form-group m-sm-2">
        <label for="totSquareMeter">Total Space by SquareMeter :</label>
        <input type="number" class="form-control" name="totSquareMeter" id ="totSquareMeter" placeholder="180">
    </div>

    <div class="form-group m-sm-2">
        <label for="ownership_proof">Ownership Proof Soft Copy :</label>
        <input type="file" class="form-control-file" name="ownership_proof" id ="ownership_proof">
    </div>

    <div class="form-group m-sm-2">
        <label for="extra_info">Others :</label>
        <textarea class="other" name="extra_info" id ="extra_info" rows="3" placeholder="Extra Info you want to add"> </textarea>
    </div>

    <div class="form-group m-sm-2">
        <button type="submit" class="btn btn-primary" onclick="Addapartmentlord()">Submit</button>
        <button type="reset" class="btn">Reset the form</button>
    </div>

        <div id="appdod">
        </div>
        </div>

   </div>

</div>

<%--<footer >--%>
<%--  <c:import url="/jsp/include/footer.jsp"/>--%>
<%--</footer>--%>

</body>

</html>