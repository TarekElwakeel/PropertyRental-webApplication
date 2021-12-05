function sanitize(str) {
    return String(str).replace(/&/g, '&amp;').replace(/</g, '&lt;').replace(/>/g, '&gt;').replace(/"/g, '&quot;');
};

function sendGenericGetRequest(url, callback){
    var httpRequest = new XMLHttpRequest();
    if (!httpRequest) {
        alert('Cannot create an XMLHTTP instance');
        return false;
    }
    httpRequest.onreadystatechange = function () {
        if (httpRequest.readyState === XMLHttpRequest.DONE) {
            if (httpRequest.status == 200) {
                callback(httpRequest.responseText)
            } else {
                console.log(req.responseText);
                alert("problem processing the request");
            }
        }
    };
    httpRequest.open('GET', url);
    httpRequest.send();
};

function ajaxPost( url, header, success, error ){
    $.ajax({
        type: 'POST',
        url: url, //this is my servlet
        enctype: 'multipart/form-data',//contentType="text/html;charset=UTF-8"
        data: headers,
        processData: false,
        contentType: false,
        cache: false,
        timeout: 600000,
        success,
        error
    });
}