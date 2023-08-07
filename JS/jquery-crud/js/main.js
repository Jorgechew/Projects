
var currentCustomerId;
$(document).ready(function () {

    getAjax();

 $("#buttonAdd").click(function(){
    addCustomer();
    getAjax();
  });

  $('#buttonUpdate').click(function () {

    updateCustomer(currentCustomerId);   
});


  $("#buttonReset").click(function(){
    resetCamps();
  });


  $(document).on('click', '.deleteButton', function () {

    var id = $(this).data('customer-id');
    var deleteButton = this; // Store reference to the button element
    deleteCustomer(id, function (response) {
        // Handle the success response if needed
        // For example, you can remove the row from the table after successful deletion
        $(deleteButton).closest('tr').remove();
    });
    });         


  $(document).on('click', '.editButton', function () {

        var id = $(this).data('customer-id');
        editCustomer(id);
        });

});   



    function getAjax(){  
    // perform an ajax http get request
    $.ajax({
        url: 'http://localhost:8080/javabank5/api/customer',
        async: true,
        success: successCallback,
        error: errorCallback
    });
    }


   /* function postAjax(){

$.ajax({
    url: 'http://localhost:8080/javabank5/api/customer',
    type: 'POST',
    data: JSON.stringify({
        firstName: 'ferrao',
        lastName: 'master',
        email: 'rui.ferrao@academiadecodigo.org',
        phone: '919579919'
    }),
    async: true,
    contentType: 'application/json',
    success: successCallback,
    error: errorCallback
});

}*/

function resetCamps(){

            $('#firstName').val(''),
            $('#lastName').val(''),
            $('#email').val(''),
            $('#phone').val('')
    
}

function addCustomer(){

    $.ajax({
        url: 'http://localhost:8080/javabank5/api/customer' ,
        type: 'POST',
        data: JSON.stringify({
            firstName: $('#firstName').val(),
            lastName:$('#lastName').val(),
            email: $('#email').val(),
            phone: $('#phone').val()
        }),
        async: true,
        contentType: 'application/json',
        success: getAjax,
        error: errorCallback
    });

}

function deleteCustomer(id, successCallback) {

    $.ajax({
        url: 'http://localhost:8080/javabank5/api/customer/' + id,
        type: 'DELETE',
        async: true,
        contentType: 'application/json',
        success: successCallback,
        error: errorCallback
    });

}
 
function editCustomer(id) {
    $.ajax({
        dataType: 'json',
        url: 'http://localhost:8080/javabank5/api/customer/' + id,
        type: 'GET',
        async: true,
        contentType: 'application/json',
        success: function (response) {
            $('#firstName').val(response.firstName),
            $('#lastName').val(response.lastName),
            $('#email').val(response.email),
            $('#phone').val(response.phone)
            currentCustomerId = id; // Armazena o ID do cliente atual na variável global
        },
        error: errorCallback
    });
}

function updateCustomer(id) {
    if (currentCustomerId!= id) {
        console.log("Não é possível atualizar um cliente que não é o mesmo ");
        return;
    }
    $.ajax({
        url: 'http://localhost:8080/javabank5/api/customer/' + id,
        type: 'PUT',
        async: true,
        contentType: 'application/json',
        data: JSON.stringify({
            firstName: $('#firstName').val(),
            lastName:$('#lastName').val(),
            email: $('#email').val(),
            phone: $('#phone').val()
            }),

            success: function (response) {
                currentCustomerId = null; // Reseta o ID do cliente após a atualização bem-sucedida
                getAjax();
            },
            error: errorCallback
        });
}




function successCallback(response) {

    $('#customer-table').empty();

    var customersTable = $("#customer-table");

    

    var elementStr;
    // do something with the data
    response.forEach(function (element) {
        elementStr =
            "<tr><td>" + element.firstName + "</td>" +

            "<td>" + element.lastName + "</td>" +

            "<td>" + element.email +"</td>" +

            "<td>" + element.phone + "</td>" +

            "<td>" + "<button class='btn btn-success editButton' data-customer-id='" + element.id + "'>Edit</button>" + "</td>" +

            "<td>" + "<button class='btn btn-danger deleteButton' data-customer-id='" + element.id + "'>Delete</button>" + "</td></tr>"

        $(elementStr).appendTo(customersTable);

       
    });
 

}


function errorCallback(request, status, error) {
    // do something with the error
    console.log("Error!!! try again!!!")
}
