package id.ac.ui.cs.mobileprogramming.andriansyah.helloworld.data;

import com.google.gson.annotations.SerializedName;

import java.util.List;

import id.ac.ui.cs.mobileprogramming.andriansyah.helloworld.models.Ability;
import id.ac.ui.cs.mobileprogramming.andriansyah.helloworld.models.Pokemon;
import id.ac.ui.cs.mobileprogramming.andriansyah.helloworld.models.Sprite;
import id.ac.ui.cs.mobileprogramming.andriansyah.helloworld.models.Stat;

public class PokemonDetailApiResponse {
    @SerializedName("abilities")
    private List<Ability> abilities;

    @SerializedName("base_experience")
    private int baseExp;

    @SerializedName("height")
    private int height;

    @SerializedName("name")
    private String name;

    @SerializedName("sprites")
    private Sprite sprites;

    @SerializedName("stats")
    private List<Stat> stat;

    @SerializedName("weight")
    private int weight;

//    private Pokemon pokemon = new Pokemon(abilities, baseExp, height, name, sprites, stat, weight);

    public Pokemon getPokemon() {
        return new Pokemon(abilities, baseExp, height, name, sprites, stat, weight);
    }
}
