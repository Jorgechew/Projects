define(function() {
    var internals = {
        handlers: {},
        elements: {}
    };

    var externals = {};

    internals.createButton = function() {
        return '<button class="random-pokemon">Click Me for a Random Pokemon</button>';
    };

    internals.createPokemonCard = function(pokemon) {
        return (
            '<div>' +
            '<p><strong>Pokemon: </strong>' +
            pokemon.name +
            '</p>' +
            '<p><strong>id: </strong>' +
            pokemon.id +
            '</p>' +
            '<p><strong>type: </strong>' +
            pokemon.type +
            '</p>' +
            '<img src="' +
            pokemon.img +
            '"></img>' +
            '</div>'
        );
    };

    internals.renderPokemon = function(pokemon) {
        if (internals.elements.pokemonCard) {
            internals.elements.pokemonCard.empty();
        }

        internals.elements.pokemonCard = $(internals.createPokemonCard(pokemon));
        internals.elements.app.append(internals.elements.pokemonCard);
    };

    internals.renderButton = function() {
        if (internals.elements.button) {
            return;
        }

        internals.elements.button = $(internals.createButton());
        internals.elements.button.click(internals.handlers['button']);
        internals.elements.app.append(internals.elements.button);
    };

    externals.bind = function(event, handler) {
        internals.handlers[event] = handler;
    };

    externals.render = function(pokemon) {
        internals.elements.app = $('#app');
        internals.renderButton();

        if (pokemon) {
            internals.renderPokemon(pokemon);
        }
    };

    return externals;
});
