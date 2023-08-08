/**
 * Create a developer person object with a code method
 * that delegates to the provided person object
 */
exports.createDelegate = function(person) {

    var developer = Object.create(person);
    developer.code = function(){
    }
    return developer;
};

/**
 * Borrow and invoke the person say method on top of the company object
 */
exports.borrowSayMethod = function(person, company) {
    return person.say.call(company);
    
};

/**
 * Iterate over all of the provided object own properties,
 * returning an array of key: value strings
 */
exports.iterate = function(obj) {

    const keyValueArray = [];

    for(const [key, value] of Object.entries(obj)) {
        keyValueArray.push(`${key}: ${value}`);
    }
    return keyValueArray;

    //return Object.keys(obj).map(key => `${key}: ${obj[key]}`);
};

/**
 * Add a repeatify method to all JavaScript Strings
 * 'string'.repeatify(3) should equal 'stringstringstring'
 * NOTE: This exercise exists for a pedagogic purpose only,
 * do not think doing stuff like this is a good idea...
 *
 * String already contains a repeat method, let's NOT use that one.
 */
exports.extendString = function() {


    if(!String.prototype.hasOwnProperty('repeatify')) {

    String.prototype.repeatify = function(n) {

        return this.repeat(n);
    };
}
}
  




