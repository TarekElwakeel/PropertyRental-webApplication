var contextPath = 'http://localhost:8080/PropertyRental-1.00/';
let state = false;
$(document).ready(function() {

    console.log("Load Dynamic Homepage");
    // var hpcontent = "<a>Prova</a>\n <div>Provae</div>";
    // $("#homepage-content").html(hpcontent);

    updateCorner("", state );
    var template = new URL(contextPath+'jsp/include/LandingPage.jsp');
    $("#dynamic-area").get( template );

    sendGenericGetRequest( template, loadTemplate);

});

function loadTemplate(data){
    document.getElementById("dynamic-area").innerHTML = data;
};
function redirectStudent(data){
    document.getElementById("dynamic-area").innerHTML = data;
}


function changeText(event,type) {
    var span = document.getElementById("loggin_type");
    // var parentDiv = span.parentNode;
    if( span.textContent != ("Click for change to Landlord "+type) ){
        span.innerHTML = ("Click for change to Student "+type);
        //"Click for change to Student Loggin";
        event.preventDefault()
        // txt = document.createTextNode("Click for change to Student Loggin");
        // parentDiv.replaceChild(span, txt);
        // span.empty();
        // span.appendChild(tx);
    }
    else
        // if( span.textContent != "Click for change to Student Loggin" )
    {
        span.innerHTML =("Click for change to Landlord "+type);
        event.preventDefault()
        // txt = document.createTextNode("Click for change to Landlord Loggin");
        // parentDiv.replaceChild(span, txt);
        // span.empty();
        // span.appendChild(txt);
    }
};
function submitStudent(){
        // e.preventDefault();
        // var username = sanitize( document.forms["student"]["s_taxcode"].value );
        // var password = sanitize( document.forms["student"]["password"].value );

    var username = sanitize( document.getElementsByName("s_taxcode")[0].value );
    var password = sanitize( document.getElementsByName("password")[0].value );
    url = "http://localhost:8080/PropertyRental-1.00/rest/login/student/";
    if( username!="" && password!="" )
        jQuery.get({
            url: url + username + "&" + password, //this is my servlet
            enctype: 'application/json;charset=utf-8',//contentType="text/html;charset=UTF-8"
            success: (info) => {
                result = info["resource-list"];
                if( result[0] != undefined ){
                    var name = result[0].Studentinfo.s_name;
                    console.log("NAME :", name );
                    sessionStorage.setItem("loggedIn", true);
                    sessionStorage.setItem("name", name);
                    sessionStorage.setItem("userRole", "student");
                    updateCorner( name, true);
                    // http://localhost:8080/PropertyRental-1.00/Studnet-Logging
                    var template = new URL(contextPath+'Studnet-Logging?s_password='+password+'&s_taxcode='+username);
                    $("#dynamic-area").get( template );

                    sendGenericGetRequest( template, redirectStudent);

                    //Do Something redirect to home, update information
                }else{
                    window.alert("There is an error somewhere!\n Controll the informations ");
                    console.log("Error FiscalCode or Password are wrong");
                }
            },
            error: (e) => {
                console.error("Server error",e);
            }
        });
    else{
        window.alert("Login not correct!\n Put the correct information");
    }
    }

function loadTemplate(data){
    document.getElementById("dynamic-area").innerHTML = data;
};

function loadTemplatewith(data){
    document.getElementById("dynamic-area").innerHTML = data;
    document.getElementById("callViewPro").addEventListener("click", viewapplord);
    document.getElementById("callviewRS").addEventListener("click", viewrentlord);
    document.getElementById("calladdroom").addEventListener("click", addroomlord);

};
    function submitLandlord() {
        // e.preventDefault();
        // var username = sanitize( document.forms["student"]["s_taxcode"].value );
        // var password = sanitize( document.forms["student"]["password"].value );

        var username = sanitize(document.getElementsByName("l_taxcode")[0].value);
        var password = sanitize(document.getElementsByName("spassword")[0].value);
        url = "http://localhost:8080/PropertyRental-1.00/rest/login/landlord/"+ username + "&" + password;

        if( username!="" && password!="" )
        jQuery.get({
            url: url , //this is my servlet
            enctype: 'application/json;charset=utf-8',//contentType="text/html;charset=UTF-8"
            success: (info) => {
                result = info["resource-list"];
                if (result[0] != undefined) {
                    var name = result[0].Landlordinfo.l_name
                    var code = result[0].Landlordinfo.la_taxcode
                    console.log("NAME :", name);
                    sessionStorage.setItem("loggedIn", true);
                    sessionStorage.setItem("name", name);
                    sessionStorage.setItem("code", code);
                    sessionStorage.setItem("userRole", "landlord");
                    updateCorner(name, true);
                    var template = new URL(contextPath+'Landlord-info?l_taxcode='+username+'&password='+password);
                    $("#dynamic-area").get( template );

                    sendGenericGetRequest( template, loadTemplatewith);
                    //Do Something redirect to home, update information
                } else {
                    window.alert("There is an error somewhere!\n Controll the informations ");
                    console.log("Error FiscalCode or Password are wrong");
                }
            },
            error: (e) => {
                console.error("Server error", e);
            }
        });
        else{
            window.alert("Some Fields of Information are empty or not correct!\n Please try again");
        }
    }
//     var username = sanitize( document.forms["student"]["s_taxcode"].value );
//     var password = sanitize( document.forms["student"]["password"].value );
//     url = "http://localhost:8080/PropertyRental-1.00/rest/login/student/";
//     // var header ={ "s_taxcode":username, "s_password":password };
//     $('#Student_form').submit(function(e){
//         e.preventDefault();
//         jQuery.get({
//         url: url + username + "&" + password, //this is my servlet
//         enctype: 'application/json;charset=utf-8',//contentType="text/html;charset=UTF-8"
//         success: (info) => {
//             console.log("info: ",info["resource-list"][0]);
//
//             if( info["resource-list"] != null ){
//                 console.log("RESULT :",info["resource-list"][0]);
//                 //Do Something redirect to home, update information
//             }else{
//                 window.alert("There is an error somewhere!\n Controll the informations ");
//                 console.log("Error FiscalCode or Password are wrong");
//             }
//
//         },
//         error: (e) => {
//             console.error("Server error",e);
//         }
//     });
//     });
//
// }

function loginLandlord(){
    console.log("click Redirect Login Landlord");
    var Login = new URL(contextPath+'html/Login.html');
    sendGenericGetRequest(Login, loadStudent);
    changeText(event,"Login");
};

function loadLandlord(data){
    document.getElementById("dynamic-area").innerHTML = data;
    // document.getElementsById("Student_form")
    // document.getElementById("submitLandlord").addEventListener("click", submitLandlord);

}

// function loadStudent(data){
    // document.getElementById("dynamic-area").innerHTML = data;
    // document.getElementsById("Student_form")
    // document.getElementById("submitStudent").addEventListener("click", submitStudent);
    // document.getElementById("submitLandlord").addEventListener("click", submitLandlord);

// };

// function loginStudent(){
//     console.log("click Redirect Login Student");
//     var Login = new URL(contextPath+'html/Login.html');
//     sendGenericGetRequest(Login, loadStudent);
// };
function studentRegistration(){
    var data = new FormData();
    var taxcode = sanitize(document.getElementsByName("s_taxcode")[0].value);
    var name = sanitize(document.getElementsByName("s_name")[0].value);
    var age = parseInt(document.getElementsByName("age")[0].value)
    var country = sanitize(document.getElementsByName("country")[0].value);
    var lang = sanitize(document.getElementsByName("foreign_lang")[0].value);
    var password = sanitize(document.getElementsByName("password")[0].value);
    var file = jQuery('#scannedID')[0].files;
    data.append('s_taxcode', taxcode);
    data.append('s_name', name);
    data.append('age', age);
    data.append('country', country);
    data.append('foreign_lang', lang);
    data.append('password', password);
    data.append('scannedID', file);

    url = "http://localhost:8080/PropertyRental-1.00/New-Studnet";
    if( taxcode!="" && name!="" && password!="" && age && country!="" && lang!="" )
        $.ajax({
            url: url,
            type: 'POST',
            data: data,
            contentType: false,
            processData: false,
            success: function(response){
                console.log(response);
                if(response != 0){
                    // var w = window.alert();
                    var myModal = '<div class="modal fade" id="myModals" role="dialog">'+
                        '<div class="modal-dialog">'+
                            '<!-- Modal content-->'+
                            '<div class="modal-content container-fluid">'+
                                '<div class="modal-header">'+
                                    '<button type="button" class="close" data-dismiss="modal">&times;</button>'+
                                    // '<h4 class="modal-title">Result</h4>'+
                                '</div>'+
                                // '<div class="modal-body">'+
                                response +
                                // '<p>Some text in the modal.</p>'+
                                // '</div>'+
                            '</div>'+
                        '</div>'+
                        '</div>';
                    document.getElementById('modalTarget').innerHTML = myModal;
                    console.log(myModal.search("error code:"));
                    if( myModal.search("error code:") !=-1 )
                        document.getElementById("ResultRedirect").innerHTML = null;
                    // else{
                    //     var template = new URL(contextPath+'jsp/include/LandingPage.jsp');
                    //     $("#dynamic-area").get( template );
                    //
                    //     sendGenericGetRequest( template, loadTemplate);
                    // }
                    // $(w.document.body).html(response);
                    $("#myModals").modal();
                    //window.show()// Display image element
                }else{
                    window.alert('file not uploaded');
                }
            },
            error: (error) => console.log(error)
        });
    else{
        window.alert("Some Fields of Information are empty or not correct!\n Please try again");
    }
};
function landlordRegistration(){
    var data = new FormData();
    var taxcode = sanitize(document.getElementsByName("l_taxcode")[0].value);
    var name = sanitize(document.getElementsByName("l_name")[0].value);
    var password = sanitize(document.getElementsByName("password")[1].value );
    var file = jQuery('#scannedID')[0].files;
    data.append('l_taxcode', taxcode);
    data.append('l_name', name);
    data.append('password', password);
    data.append('scannedID', file);

    url = "http://localhost:8080/PropertyRental-1.00/New-Landlord";
    if( taxcode!="" && name!="" && password!=""  )
        $.ajax({
        url: url,
        type: 'POST',
        data: data,
        contentType: false,
        processData: false,
        success: function(response){
            // console.log(response);
            if(response != 0){
                // var w = window.alert();
                var myModal = '<div class="modal fade" id="myModal" role="dialog">'+
                    '<div class="modal-dialog">'+
                    '<!-- Modal content-->'+
                        '<div class="modal-content container-fluid">'+
                            '<div class="modal-header">'+
                                '<button type="button" class="close" data-dismiss="modal">&times;</button>'+
                                // '<h4 class="modal-title">Result</h4>'+
                            '</div>'+
                            // '<div class="modal-body">'+
                            response +
                            // '<p>Some text in the modal.</p>'+
                            // '</div>'+
                        '</div>'+
                    '</div>'+
                    '</div>';
                document.getElementById('modalTarget').innerHTML = myModal;
                console.log(myModal.search("error code:"));
                if( myModal.search("error code:") !=-1 )
                    document.getElementById("ResultRedirect").innerHTML = null;
                // else{
                //     var template = new URL(contextPath+'jsp/include/LandingPage.jsp');
                //     $("#dynamic-area").get( template );
                //
                //     sendGenericGetRequest( template, loadTemplate);
                // }
                // $(w.document.body).html(response);
                $("#myModal").modal();
                //window.show()// Display image element
            }else{
                window.alert('file not uploaded');
            }
        },
    });
    else{
        window.alert("Some Fields of Information are empty or not correct!\n Please try again");
    }
};