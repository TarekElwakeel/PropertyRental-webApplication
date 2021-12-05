// var b = document.getElementById("Loggin");
//  b["onclick"] = function() { console.log("click Alert");
//   alert("Thanks for clicking me!"); };
// b.addEventListener("click", function() {
//  console.log("click Listener");
//  alert("Thanks again!"); });

var contextPath = 'http://localhost:8080/PropertyRental-1.00/'; // request work only for localhost NOT 172.0.0.1!
function seeTemp(){
    console.log("click Listener of Login");
    var login = new URL(contextPath+'html/Login.html');
        sendGenericGetRequest(login, loadLogin);
};

function openRegistration(){
    console.log("click openRegistration Loading Registration.html");
    var Registration = new URL(contextPath+'html/Registration.html');
    sendGenericGetRequest(Registration, loadRegistration);
}

function loadLogin(data){
    document.getElementById("dynamic-area").innerHTML = data;
    document.getElementById("submitStudent").addEventListener("click", submitStudent);
    document.getElementById("submitLandlord").addEventListener("click", submitLandlord);

};

function loadRegistration(data){
    document.getElementById("dynamic-area").innerHTML = data
}

function updateCorner(username, state){
    var unloggedState = "<div class=\"navbar  justify-content-end p-1\">\n" +
    "<button id=\"Registration\" class=\"btn btn-sm btn-secondary m-1\" onclick=\"openRegistration()\" >Registration</button>\n" +
    "<button id=\"Loggin\" class=\"btn btn-sm btn-secondary m-1\" onclick=\"seeTemp()\" >Login</button>\n" +
    "</div>";
    var loggedState = "<div class=\"navbar  justify-content-end p-1\" style=\"color: aliceblue;\">\n" +
        "            <i class=\"fas fa-user-circle fa-2x align-middle ml-4\" ></i>\n" +
        "            <div class=\"h4 p-sm-2\"> " + username +" </div>\n" +
        "        <button id=\"logout\" class=\"btn btn-sm btn-secondary m-1\" onclick=\"logout()\" >Logout</button>\n" +
        "        </div>"
    if(state){
        document.getElementById("top-right").innerHTML = loggedState;
        document.getElementById("submitStudent").addEventListener("click", logout);
    } else{
        document.getElementById("top-right").innerHTML = unloggedState;
    }
}

function logout(){
    updateCorner("",false);
    sessionStorage.removeItem("loggedIn");
    sessionStorage.removeItem("userEmail");
    sessionStorage.removeItem("userRole");
    var LandingPage = new URL(contextPath+'jsp/include/LandingPage.jsp');
    sendGenericGetRequest(LandingPage, loadTemplate);
}