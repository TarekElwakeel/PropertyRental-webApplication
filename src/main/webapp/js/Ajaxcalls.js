// add apartment
function Addapartmentlord(){
    var data = new FormData();
    var taxcode = sessionStorage.getItem("code");
    var address = sanitize(document.getElementById("app_addresss").value);
    var zip = parseInt(document.getElementById("p_code").value);
    var room = parseInt(document.getElementById("n_room").value);
    var bathroom = parseInt(document.getElementById("n_bath").value);
    var kitchen = sanitize(document.getElementById("s_kitchen").value);
    var energy = sanitize(document.getElementById("energy_class").value);
    var area = parseInt(document.getElementById("totSquareMeter").value);
    var extra = sanitize(document.getElementById("extra_info").value);
    var file = jQuery('#ownership_proof')[0].files;
    data.append('landlord', taxcode);
    data.append('app_address', address);
    data.append('p_code', zip);
    data.append('n_room', room);
    data.append('n_bath', bathroom);
    data.append('s_kitchen', kitchen);
    data.append('energy_class', energy);
    data.append('totSquareMeter', area);
    data.append('extra_info', extra);
    data.append('ownership_proof', file);

    url = "http://localhost:8080/PropertyRental-1.00/New-Apartment-Landlord";
    if( taxcode!=undefined && address!=undefined && zip!=undefined  )
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
                    var myModal = '<div class="modal fade" id="myModala" role="dialog">'+
                        '<div class="modal-dialog">'+
                        '<!-- Modal content-->'+
                        '<div class="modal-content">'+
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
                    document.getElementById('appdod').innerHTML = myModal;
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
                    $("#myModala").modal();
                    //window.show()// Display image element
                }else{
                    alert('file not uploaded');
                }
            },
        });
    else{
        window.alert("Some Fields of Information are empty or not correct!\n Please try again");
    }
};


    // ajax call to add room //
    function addroomlord()
    {
    $.ajax({
        type: 'POST',
        url: "http://localhost:8080/PropertyRental-1.00/New-Room-Landlord", //this is my servlet
        data: { "app_address" : $('#app_address').val(),
            "capacity_persons" : $('#capacity_persons').val(),
            "other" : $('#other').val(),
        },
        success: function(response){
            if(response != 0){
                // var w = window.alert();
                var myModal = '<div class="modal fade" id="myModalr" role="dialog">'+
                    '<div class="modal-dialog">'+
                    '<!-- Modal content-->'+
                    '<div class="modal-content">'+
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
                document.getElementById('addroomss').innerHTML = myModal;
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
                $("#myModalr").modal();
                //window.show()// Display image element
            }else{
                alert('wrong input, please try again');
            }
        },
        error: function(jqXHR, textStatus, errorThrown)
        {
            console.log('Error :', jqXHR, textStatus, errorThrown);
        }
        });
    }

    // ajax call to view apartments //
    function viewapplord () {
        var landlordValue = sessionStorage.getItem("code");
        $.ajax({
            type: 'POST',
            url: "http://localhost:8080/PropertyRental-1.00/View-My-Property", //this is my servlet
            data: {"l_taxcode": landlordValue},
            success: function (response) {
                console.log("Call View Property");
                $('#output').empty().append(response);
            },
            error: function (jqXHR, textStatus, errorThrown) {
                console.log('Error :', jqXHR, textStatus, errorThrown);
            }
        });
    }

    // ajax call to view apartment rooms //
    $('#callroom').click(function ()
    {
        var addcheckedValue = $('.addvaluecheck:checked').val();

        $.ajax({
        type: 'POST',
        url: "http://localhost:8080/PropertyRental-1.00/View-SpecificProperty", //this is my servlet
        data: { "app_address" : addcheckedValue },
        success: function(response){
            console.log("Call SpecificProperty Servlet");
            $('#rooms').empty().append(response);
        },
        error: function(jqXHR, textStatus, errorThrown)
        {
            console.log('Error :', jqXHR, textStatus, errorThrown);
        }
        });
    });

    // ajax call to check requests //
    function viewrentlord () {
        var landlordValue = sessionStorage.getItem("code");
        $.ajax({
            type: 'POST',
            url: "http://localhost:8080/PropertyRental-1.00/View-RentRequest-Landlord", //this is my servlet
            data: {"l_taxcode": landlordValue},
            success: function (response) {
                console.log("Call View RentRequset");
                $('#outputr').empty().append(response);
            },
            error: function (jqXHR, textStatus, errorThrown) {
                console.log('Error :', jqXHR, textStatus, errorThrown);
            }
        });
    }

    // ajax call to update requests //
    $('#callUR').click(function ()
    {
        var RNcheckedValue = $('.RNcheckbox:checked').val();
    $.ajax({
        type: 'POST',
        url: "http://localhost:8080/PropertyRental-1.00/Update-RentRequest-Landlord", //this is my servlet
        data: { "request_nr" : RNcheckedValue,
            "status" : $('#status').val()
        },
        success: function(response){
            if(response != 0){
                // var w = window.alert();
                var myModal = '<div class="modal fade" id="myModalf" role="dialog">'+
                    '<div class="modal-dialog">'+
                    '<!-- Modal content-->'+
                    '<div class="modal-content">'+
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
                document.getElementById('UReq').innerHTML = myModal;
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
                $("#myModalf").modal();
                //window.show()// Display image element
            }else{
                alert('wrong input, please try again');
            }
        },
        error: function(jqXHR, textStatus, errorThrown)
        {
            console.log('Error :', jqXHR, textStatus, errorThrown);
        }
        });
    });

    // ajax call to check apartment //
    $('#callapstatus').click(function ()
    {
        $.ajax({
            type: 'POST',
            url: "http://localhost:8080/PropertyRental-1.00/Admin-ReviewApartment", //this is my servlet
            data: {"status" : $('#apstatus').val()
            },
            success: function(response){
                console.log("Call Update RentRequest Servlet");
                $('#appstatus').empty().append(response);
            },
            error: function(jqXHR, textStatus, errorThrown)
            {
                console.log('Error :', jqXHR, textStatus, errorThrown);
            }
        });
    });

    // ajax call to update apartment status //
    $('#callaps').click(function ()
    {
        var addrocheckedValue = $('.addocheckbox:checked').val();
        $.ajax({
            type: 'POST',
            url: "http://localhost:8080/PropertyRental-1.00/Admin-UpdateApartment", //this is my servlet
            data: { "address" : addrocheckedValue,
                     "status" : $('#apsstatus').val()
            },
            success: function(response){
                console.log("Call Update RentRequest Servlet");
                $('#apr').empty().append(response);
            },
            error: function(jqXHR, textStatus, errorThrown)
            {
                console.log('Error :', jqXHR, textStatus, errorThrown);
            }
        });
    });

    // ajax call to get landlord info //
    $('#calllorstatus').click(function ()
    {
        $.ajax({
            type: 'POST',
            url: "http://localhost:8080/PropertyRental-1.00/Admin-ReviewLandlord", //this is my servlet
            data: {"status" : $('#lordstatus').val()
            },
            success: function(response){
                console.log("Call Update RentRequest Servlet");
                $('#lorstatus').empty().append(response);
            },
            error: function(jqXHR, textStatus, errorThrown)
            {
                console.log('Error :', jqXHR, textStatus, errorThrown);
            }
        });
    });

    // ajax call to update landlord status //
    $('#callsland').click(function ()
    {
        var lordocheckedValue = $('.lordocheckbox:checked').val();

        $.ajax({
            type: 'POST',
            url: "http://localhost:8080/PropertyRental-1.00/Admin-UpdateLandlord", //this is my servlet
            data: { "l_taxcode" : lordocheckedValue,
                    "status" : $('#landstatus').val()
            },
            success: function(response){
                console.log("Call Update RentRequest Servlet");
                $('#landsta').empty().append(response);
            },
            error: function(jqXHR, textStatus, errorThrown)
            {
                console.log('Error :', jqXHR, textStatus, errorThrown);
            }
        });
    });

    // ajax call to get student info //
    $('#callstustatus').click(function ()
    {
        $.ajax({
            type: 'POST',
            url: "http://localhost:8080/PropertyRental-1.00/Admin-ReviewStudent", //this is my servlet
            data: {"status" : $('#sudstatus').val()
            },
            success: function(response){
                console.log("Call Update RentRequest Servlet");
                $('#studstatus').empty().append(response);
            },
            error: function(jqXHR, textStatus, errorThrown)
            {
                console.log('Error :', jqXHR, textStatus, errorThrown);
            }
        });
    });

    // ajax call to update Student status //
    $('#callsstudi').click(function ()
    {
        var studiocheckedValue = $('.studiocheckbox:checked').val();
        $.ajax({
            type: 'POST',
            url: "http://localhost:8080/PropertyRental-1.00/Admin-UpdateStudent", //this is my servlet
            data: { "s_taxcode" : studiocheckedValue,
                     "status" : $('#studistatus').val()
            },
            success: function(response){
                console.log("Call Update RentRequest Servlet");
                $('#studista').empty().append(response);
            },
            error: function(jqXHR, textStatus, errorThrown)
            {
                console.log('Error :', jqXHR, textStatus, errorThrown);
            }
        });
    });



