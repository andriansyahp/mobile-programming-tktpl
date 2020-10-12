package id.ac.ui.cs.mobileprogramming.andriansyah.helloworld.viewmodels;

import android.content.Context;
import android.view.View;

import androidx.databinding.BaseObservable;

import id.ac.ui.cs.mobileprogramming.andriansyah.helloworld.models.Pokemon;
import id.ac.ui.cs.mobileprogramming.andriansyah.helloworld.views.PokemonDetailActivity;

public class ItemPokemonViewModel extends BaseObservable {
    private final Context context;
    private Pokemon pokemon;

    public ItemPokemonViewModel(Context context, Pokemon pokemon) {
        this.context = context;
        this.pokemon = pokemon;
    }

    public String getPokemonName() {
        return pokemon.getName();
    }

    public void onItemClick(View view) {
        context.startActivity(PokemonDetailActivity.launchDetail(view.getContext(), pokemon));
    }

    public void setPokemon(Pokemon pok) {
        this.pokemon = pokemon;
        notifyChange();
    }
}
