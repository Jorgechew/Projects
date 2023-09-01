   define(['views/pokemon-view', 'services/pokemon-service'],function (
    pokemonView,
    pokemonService
) {

var externals = {};
var internals = {};

externals.start =function() {
    internals.bindEvenHandlers();
    pokemonView.render();
};

internals.bindEvenHandlers = function() {
    pokemonView.bind('button', internals.buttonHandler);
};

internals.buttonHandler = function() {

    var pokedex = Math.floor(Math.random() * 151);

    pokemonService.getPokemons(pokedex, function(pokemon) {
      

        pokemonView.render(pokemon);

});
};

return externals;

});


