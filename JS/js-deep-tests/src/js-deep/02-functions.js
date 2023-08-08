/**
 * Return result of calling function with arguments as present in array
 */
exports.argsAsArray = function(fn, arr) {

    return fn.apply(null,arr);
};

/**
 * Return the result of calling a function with the provided obj as context
 * for the implicit argument this
 */
exports.speak = function(fn, obj) {

    // call pass the fn of the obj
    return fn.call(obj);
};

/**
 * Return a prefixer function that concatenates a string argument with a prfix
 */
exports.stringPrefixer = function(prefix) {

    function prefixerFunction(string){
        return prefix + string;        
    }
    
    return  prefixerFunction;
};

/**
 * Create an array of functions, each producing a result obtained
 * from applying the transform function to an argument from values array
 */
exports.makeResultFunctions = function(values, transform) {

    /*const transformFunctions = [];

    for (const value of values) {
        const transformFunction = () => transform(value);
        transformFunctions.push(transformFunction);
    }

    return transformFunctions;*/

    var myArray = [];

    // i faz parte do scope da função toda
    for (let i = 0; i < values.length ; i++){

        myArray.push(function(){          
           return transform(values[i]);
         });
    }
    return myArray;
};


/**
 * From a function which receives three arguments,
 * of which only two are available, create a new function
 * which wraps the original one with the missing argument
 */
exports.createWrapperFunction = function(fn, arg1, arg2) {

    return function(arg3) {
        return fn(arg1, arg2, arg3);
    };
};

/**
 * Return the sum of all arguments
 */
exports.sumArguments = function() {

    let sum = 0;

    for (let i = 0; i < arguments.length; i++) {
            sum += arguments[i];
        }
    return sum;


};

/**\
 * Execute the function, passing it all the provided arguments
 */ 

exports.callIt = function(fn) {
   // Extracts the provided arguments, excluding the first argument (which is the fn function)
   // Extrai os argumentos fornecidos, excluindo o primeiro argumento (que é a função fn)
    let args = Array.prototype.slice.call(arguments, 1);


    // Executa a função fn com os argumentos extraídos usando o método apply
    // O valor this é definido como null, o que significa que o contexto global será usado
    return fn.apply(null,args);
};

/**
 * From a function which receives a variable number of arguments,
 * return a wrapper function which adds additional argumens to the ones
 * available and calls the original function
 */
exports.createAddArgumentsFunction = function(fn, ...args) {

    return function (...newArgs) {
        // Concatenate the additional arguments with the existing arguments
        const allArgs = [...args, ...newArgs];
        // Call the original function with the combined arguments
        return fn(...allArgs);
    };
    


};

