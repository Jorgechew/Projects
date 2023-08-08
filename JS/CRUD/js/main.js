
var activeCustomerId;

$(document).ready(function () {


    function successCallback(response) {

        var usersTable = $('#users-table');


        response.forEach(function (element) {
            usersTable.append(

                "<tr><td>" + element.firstName + "</td>" +
                "<td>" + element.lastName + "</td>" +
                "<td>" + element.email + "</td>" +
                "<td>" + element.phone + "</td>" +
                "<td>" + "<button class='btn btn-success editButton' data-customer-id='" + element.id + "'>Edit</button>" + "</td>" +
                "<td>" + "<button class='btn btn-danger deleteButton' data-customer-id='" + element.id + "'>Delete</button>" + "</td></tr>"


            );


        });
    }

    function errorCallback(request, status, error) {
        alert('Shit happens!');
        console.log('Shit happens!');
    }
    
    $.ajax({
        url: 'http://localhost:8080/javabank5/api/customer',
        async: true,
        success: successCallback,
        error: errorCallback
    })
v


    addCustomer();
    deleteCustomer();
    reset();
    editCustomer();
    //updateCustomer();


});




//ADD Customer - AJAX POST
function addCustomer() {

    $('#addButton').click(function () {

        $.ajax({
            datatype: 'json',
            url: 'http://localhost:8080/javabank5/api/customer/',
            type: 'POST',
            data: JSON.stringify({
                firstName: $('#firstNameInput').val(),
                lastName: $('#lastNameInput').val(),
                email: $('#emailInput').val(),
                phone: $('#phoneInput').val(),
            }),

            async: true,
            contentType: 'application/json',
            success: function (response) {
                console.log('Customer updated successfully!', response);
                location.reload();
            },
            error: function (request, status, error) {
                console.error('Error adding customer:', error);
                alert('Error adding customer: ' + error);
            }

        })
    });

}


// AJAX delete Customer
function deleteCustomer(customerId, successCallback) {
    $.ajax({
        dataType: 'json',
        url: 'http://localhost:8080/javabank5/api/customer/' + customerId,
        type: 'DELETE',
        async: true,
        contentType: 'application/json',
        success: successCallback,
        error: function (request, status, error) {
            console.error('Error deleting customer:', error);
            //alert('Error deleting customer: ' + error);
        }
    });
}

// Attach the click event handler for the delete button
$(document).on('click', '.deleteButton', function () {
    var customerId = $(this).data('customer-id');
    var deleteButton = this; // Store reference to the button element
    deleteCustomer(customerId, function (response) {
        // Handle the success response if needed
        // For example, you can remove the row from the table after successful deletion
        $(deleteButton).closest('tr').remove();
    });
});


function reset() {

    $('#reset').click(function () {


        $('#firstNameInput').val('');
        $('#lastNameInput').val('');
        $('#emailInput').val('');
        $('#phoneInput').val('');

    });

}




function editCustomer(customerId) {

    $.ajax({
        dataType: 'json',
        url: 'http://localhost:8080/javabank5/api/customer/' + customerId,
        type: 'GET', // Use GET to fetch customer data
        async: true,
        contentType: 'application/json',
        success: function (response) {
            // Populate the input boxes with customer data
            $('#firstNameInput').val(response.firstName);
            $('#lastNameInput').val(response.lastName);
            $('#emailInput').val(response.email);
            $('#phoneInput').val(response.phone);

            activeCustomerId = customerId;
        },
        error: function (request, status, error) {
            console.error('Error fetching customer data:', error);
            // Handle the error if needed
        },
    });

}


$(document).on('click', '.editButton', function () {

    $('.editButton.active').removeClass('active');
    $(this).addClass('active');

    var customerId = $(this).data('customer-id');
    
    
    editCustomer(customerId);
});




function updateCustomer(customerId) {

if(!activeCustomerId) {
    console.log("Cannot update this customer!");
    return;
}

        $.ajax({
            dataType: 'json',
            url: 'http://localhost:8080/javabank5/api/customer/' + customerId,
            type: 'PUT',
            data: JSON.stringify({
                firstName: $('#firstNameInput').val(),
                lastName: $('#lastNameInput').val(),
                email: $('#emailInput').val(),
                phone: $('#phoneInput').val(),
            }),
            async: true,
            contentType: 'application/json',
            success: function (response) {
                console.log('Customer updated successfully!', response);
                location.reload();
            },
            error: function (request, status, error) {
                console.error('Error updating customer:', error);
                
            }

        });

}

$(document).on('click', '#update', function () {
    //var customerId = $('.editButton.active').data('customer-id');
    updateCustomer(activeCustomerId);
});









