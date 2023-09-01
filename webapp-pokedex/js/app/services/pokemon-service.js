const pokedex = {};
define(function () {
    var internals = {}; // internal state
    var externals = {}; // external api



    externals.getPokemons = function (num, callback) {
        const url = `https://pokeapi.co/api/v2/pokemon/?offset=0&limit=151`;
        fetch(url)
            .then(function (response) {

                console.log(response);
                return response.json();

            }).then(function (pokemonData) {


                console.log(pokemonData);

                fetch(pokemonData.results[num].url)
                    .then(function (response) {
                        return response.json();
                    }).then(pokemon => {
                        var pokemonName = pokemon.name.toUpperCase();
                        var pokemonId = pokemon.id;
                        var pokemonType = pokemon.types.map(function (type) {
                            return type.type.name;
                        });


                        var pokemonMoves = pokemon.moves.map(function (move) {
                            return move.move.name;
                        });



                        var pokemonImg = pokemon.sprites.front_default;
                        fetch(pokemon.species.url)
                            .then(function (response) {
                                return response.json();
                            })
                            .then(pokemon => {
                                var pokeDesc = pokemon.flavor_text_entries[6].flavor_text;
                                pokedex[num] = { "name": pokemonName, "type": pokemonType, "id": pokemonId, "img": pokemonImg, "moves": pokemonMoves, "desc": pokeDesc};
                                
                                callback(pokedex[num]);
                            });
                    })


            })

    }

    return externals;
});









/*var pokedex = {};
    externals.getPokemons = function(num, callback) {
        var url = "https://pokeapi.co/api/v2/pokemon/" + num.toString();
        fetch(url)
            .then(function(response) {
                return response.json();
            })
            .then(function(pokemon) {
                var pokemonName = pokemon.name;
                var pokemonType = pokemon.types.map(function(type) {
                    return type.type.name;
                });
                var pokemonImg = pokemon.sprites.front_default;
                fetch(pokemon.species.url)
               .then(function(response)  {
                return response.json();
               })
               .then(function(pokemon) {
                var pokeDesc = pokemon.flavor_text_entries[6].flavor_text;
                console.log(pokemon);
                pokedex[num] = { "name": pokemonName, "type": pokemonType, "img": pokemonImg, "Desc": pokeDesc};
                callback(pokedex[num]); // Pass the fetched data to the callback function
            })
            .catch(function(err) {
                console.log(err);
            });
    })};
    return externals;
});
*/
