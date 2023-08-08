/**
 * Creates a counter module with an initial value, zero if not provided
 */
exports.createCounter = function(counter) {

    var counterPrime = counter === undefined? 0 : counter;
    // creare a counter module with an initial value, zero if not provided 
    return {
        get: function(){                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                               
            return counterPrime;
        },

        increment: function(){
            counterPrime++;
            return this;
        },

        reset: function(){
            counterPrime = 0;
            return this;
        }
    };
}

/**
 * Creates a person module with name and age
 * An initial name value should be provided and
 * an exception thrown if not
 */
exports.createPerson = function(name) {

    //Create exception if name is not provided

    if (name === undefined || name === '') {
        throw new Error('Name is required');
    }

    var age = 0;

    // create the person module with name and age
    return {
        getName: function(){
            return name;
        },
        getAge: function() {
            return age;
        },

        setAge: function(myAge) {
            age = myAge;
            return age;
        }
    };

    
};
