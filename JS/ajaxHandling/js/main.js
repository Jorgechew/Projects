 $(document).ready(function() {

    $('#firstInput').change (function() {
        console.log("click");
         fetchData(processResults);

    });


 });
    
        function fetchData(cb) {
            $.ajax({
                url: 'https://open.er-api.com/v6/latest',
                type: 'GET',
                dataType: 'json',
                success: function(results) { cb(null, results) },
                error: function(request, statusText, httpError) { cb(httpError || statusText) }
                
                })
        };
        

    // asynchronous callback
     function processResults(error, results) {
            

        if (error) {
            var badInput = ' ERROR FETCHING RATES';
            var container = $('#rate');

            container.html('<p>' + badInput + '</p>')
            
        } 

            var usd = results.rates.EUR;
            var convertValue = usd * $('#firstInput').val();
            var container = $('#rate');
            container.html('<p>' + $('#firstInput').val() +  ' EUR = ' + convertValue + ' usd </p>');
        }
    
    

    function errorCallback(request, status, error) {
        alert('Shit happens!');
        console.log('Shit happens!');
    }


     

        
 


