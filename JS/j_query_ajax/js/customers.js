$(document).ready(function () {

    // perform an ajax http get request
    $.ajax({
        url: 'http://localhost:8080/javabank5/api/customer',
        async: true,
        success: successCallback,
        error: errorCallback
    });

});

function successCallback(response) {


    var elementStr;
    var customersTable = $("#customer-table");


    // do something with the data
    response.forEach(function (element) {
        elementStr =
            "<tr><td>" +
            element.firstName +
            "</td>" +

            "<td>" +
            element.lastName +
            "</td>" +

            "<td>" +
            element.email +
            "</td>" +

            "<td>" +
            element.phone +
            "</td>" +

            '<td><button type="button" id="edit-btn-' +
            element.id +
            '" class="edit-btn btn btn-success">edit</button></td>' +
            '<td><button type="button" id="remove-btn-' +
            element.id +
            '" class="remove-btn btn btn-danger">delete</button></td></tr>';

        $(elementStr).appendTo(customersTable);

    });
    console.log("Great Success!!!")

}


function errorCallback(request, status, error) {
    // do something with the error
    console.log("Error!!! try again!!!")
}







