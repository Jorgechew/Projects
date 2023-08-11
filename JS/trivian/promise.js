function promiseHandler(resolver, reject) {

    setTimeout(function() {
        
        //resolver("Hey - that was successful!");
        reject("Failure");
     }, 2000 );
}

//testing
//console.log("Promise is starting")


/*const promise = new Promise(promiseHandler);
// then is used for after the promise has been fulfilled
promise.then(function(message ){
    console.log("Promise has resolved with: ", message);

});

//catch is used for after the promise has been rejected
promise.catch(function(err) {
    console.log("Promise hit an error: ", err);
});

//finally is used for a handler that runs after promise has settled
promise.finally(function() {

    console.log("Promise is done and has either fullfilled or rejected.");
});*/

/*new Promise(promiseHandler)
  .then(function(message){
       console.log("Promise has resolved with: ", message);
    })
    .catch(function(err) {
        console.log("Promise hit an error: ", err);
    })
    .finally(function() {
        console.log("Promise is done and has either fullfilled or rejected.");
    });*/

    function wait(ms){
        return new Promise(function(resolve, reject){
            if(ms <0)
            {
                reject('Invalid wait time "${ms}".');
            } else {
                const startTime = performance.now();
                setTimeout(function() {
                const elapsedTime = performance.now(); - startTime;
                resolve(elapsedTime);
            }, ms);
        }
    });
}

wait(1000)
.then((elapsedTime) => console.log('Timer 1 is done! It took ${elapsedTime}ms.'))
.then(() => {
    return wait(-500);
})
.then((elapsedTime) => console.log('Timer 2 is done! It took ${elapsedTime}ms.'))
.then(() => wait(1500))
.then((elapsedTime) => console.log('Timer 3 is done! It took ${elapsedTime}ms.'))
.catch((err) => console.log('An error occurred: ${err}.'))
.finally(() => console.log('Timer is done!'));








