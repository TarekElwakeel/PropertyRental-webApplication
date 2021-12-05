
// function changeText() {
//     var span = document.getElementById("loggin_type");
//     var parentDiv = span.parentNode;
//     if( span.textContent == "Click for change to Landlord Loggin" ){
//         txt = document.createTextNode("Click for change to Student Loggin");
//         parentDiv.replaceChild(span, txt);
//         // span.empty();
//         // span.appendChild(txt);
//     }
//     else
//     {
//         txt = document.createTextNode("Click for change to Landlord Loggin");
//         parentDiv.replaceChild(span, txt);
//         // span.empty();
//         // span.appendChild(txt);
//     }
// };

// function submitSudent(){
//     var username = sanitize( document.forms["student"]["s_taxcode"].value );
//     var password = sanitize( document.forms["student"]["password"].value );
//     url = "http://localhost:8080/PropertyRental-1.00/Studnet-Logging";
//     var header ={ "s_taxcode":username, "s_password":password };
//     ajaxPost( url, header, (success)=>{
//         console.log(success);
//     }, (error)=>{
//         console.error(error);
//     } );
// };

