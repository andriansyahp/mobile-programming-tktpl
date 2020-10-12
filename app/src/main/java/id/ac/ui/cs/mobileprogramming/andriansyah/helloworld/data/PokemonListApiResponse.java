package id.ac.ui.cs.mobileprogramming.andriansyah.helloworld.data;

import com.google.gson.annotations.SerializedName;

import java.util.List;

import id.ac.ui.cs.mobileprogramming.andriansyah.helloworld.models.Pokemons;

public class PokemonListApiResponse {
    @SerializedName("results")
    private List<Pokemons> pokemonsList;

    public List<Pokemons> getPokemonsList() {
        return pokemonsList;
    }
}
