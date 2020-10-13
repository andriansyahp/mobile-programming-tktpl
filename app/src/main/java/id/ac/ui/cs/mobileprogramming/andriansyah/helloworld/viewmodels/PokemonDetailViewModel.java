package id.ac.ui.cs.mobileprogramming.andriansyah.helloworld.viewmodels;

import java.util.List;

import id.ac.ui.cs.mobileprogramming.andriansyah.helloworld.models.Ability;
import id.ac.ui.cs.mobileprogramming.andriansyah.helloworld.models.Pokemon;
import id.ac.ui.cs.mobileprogramming.andriansyah.helloworld.models.Stat;

public class PokemonDetailViewModel {
    private final Pokemon pokemon;

    public PokemonDetailViewModel(Pokemon pokemon) {
        this.pokemon = pokemon;
    }

    public String getPokemonName() {
        return pokemon.getName();
    }

    public int getPokemonBaseExp() {
        return pokemon.getBaseExp();
    }

    public int getPokemonHeight() {
        return pokemon.getHeight();
    }

    public int getPokemonWeight() {
        return pokemon.getWeight();
    }

    public String getPokemonPicture() {
        return pokemon.getSprites().getPicture();
    }

    public List<Ability> getPokemonAbilities() {
        return pokemon.getAbilities();
    }

    public List<Stat> getPokemonStats() {
        return pokemon.getStat();
    }
}
