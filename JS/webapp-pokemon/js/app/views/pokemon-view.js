define(function () {
    var internals = {
        handlers: {},
        elements: {}
    };

    var externals = {};

    internals.createButton = function () {
        return '<button class="random-pokemon" id="button">Random Pokemon</button>';
    };

    internals.createPokemonCard = function (pokemon) {
        return (
            '<div class="view">' +
            '<h1> Pokédex</h1>' +
            '<div id="tela"> ' + '<img src="' + pokemon.img + '" id="img"></img>' +'</div> ' +
            '<div class="card-body">' +'<h3 class="card-title"> ' + '#' + pokemon.id + ' ' + pokemon.name + ' ||  ' + pokemon.type + ' </h3>' + '</div>' +
            '<div class ="indexPokemon">' + '<p><strong> ' + pokemon.name + ': ' + ' </strong>' + pokemon.desc +  '</p>' +'</div>' +
            '</div>'
        );
    };

    internals.renderPokemon = function (pokemon) {
        if (internals.elements.pokemonCard) {
            internals.elements.pokemonCard.empty();
            internals.elements.pokemonCard.remove();
        }

        internals.elements.pokemonCard = $(internals.createPokemonCard(pokemon));
        internals.elements.app.append(internals.elements.pokemonCard);
    };

    internals.renderButton = function () {
        if (internals.elements.button) {
            internals.elements.button.remove();
        }
        internals.elements.button = $(internals.createButton());
        internals.elements.button.click(internals.handlers['button']);
        internals.elements.app.append(internals.elements.button);
    };

    externals.bind = function (event, handler) {
        internals.handlers[event] = handler;
    };

    externals.render = function (pokemon) {
        internals.elements.app = $('#app');
        if (pokemon) {
            internals.renderPokemon(pokemon);
        } 
        internals.renderButton();
    };
    
    return externals;
});
