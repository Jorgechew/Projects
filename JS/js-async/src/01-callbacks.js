/**
 * Invoke the callback and return the amount of time in miliseconds it took to execute
 */
exports.profileFunc = function(cb) {

     // Registra o tempo de início antes de invocar o retorno de chamada.
var start = new Date().getTime();

// Invoca o retorno de chamada fornecido.
cb();

// Registra o tempo de término após a execução do retorno de chamada.
var end = new Date().getTime();

// Calcula e retorna a diferença entre o tempo de início e o tempo de término em milissegundos.
return end - start;

};

/**
 * Invoke the async callback with the provided value after some delay
 */
exports.returnWithDelay = function(value, delay, cb) {

setTimeout (function() {
    cb (null ,value)
}, delay);

};

/**
 * Invoke the async callback with an error after some delay
 */
exports.failWithDelay = function(delay, cb) {

// Define um temporizador que executará a função após o atraso especificado.
    setTimeout (function() {

        // Chama o retorno de chamada (cb) com um novo objeto de erro contendo a mensagem 'fail'.
        cb (new Error('fail'))
    }, delay);
};

/**
 * Return a promise that resolves after the specified delay
 * or rejects if the delay is negative or non-existent
 */
exports.promiseBasedDelay = function(delay) {

    return new Promise(function(resolve ,reject) {

        // Verificar se o delay esta negativo  ou se nao esta definido
        if (delay < 0) {
            reject(new Error('Negative delay'));
        }
        // Aguardar o tempo especificado antes de resolver a promessa
        setTimeout(function() {
            // Verificar
            resolve(delay);
            
        }, delay);
});
}
/**
 * Use fetch to grab the contents of both urls and return
 * a promise resolving to the payload concatenation
 */
exports.concatBodies = function(url1, url2) {

     // Faz uma solicitação fetch para a primeira URL e guarda a promessa resultante em fetch1.
    var fetch1 = fetch(url1);
    var fetch2 = fetch(url2);

    // Aguarda até que ambas as promessas (fetch1 e fetch2) sejam resolvidas usando Promise.all.
    return Promise.all([fetch1, fetch2]).then(function(responses) {

         // A função de retorno do then é executada com um array de respostas.
        // Concatena os conteúdos das respostas em uma única string e retorna o resultado.
        return responses.join('');
    });

};
