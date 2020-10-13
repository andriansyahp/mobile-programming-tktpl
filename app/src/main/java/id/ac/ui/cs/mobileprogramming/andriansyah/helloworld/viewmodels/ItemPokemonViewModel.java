package id.ac.ui.cs.mobileprogramming.andriansyah.helloworld.viewmodels;

import android.content.Context;
import android.util.Log;
import android.view.View;

import androidx.databinding.BaseObservable;

import java.util.List;

import id.ac.ui.cs.mobileprogramming.andriansyah.helloworld.PokedexApplication;
import id.ac.ui.cs.mobileprogramming.andriansyah.helloworld.R;
import id.ac.ui.cs.mobileprogramming.andriansyah.helloworld.data.PokemonApiService;
import id.ac.ui.cs.mobileprogramming.andriansyah.helloworld.data.PokemonDetailApiResponse;
import id.ac.ui.cs.mobileprogramming.andriansyah.helloworld.data.PokemonListApiResponse;
import id.ac.ui.cs.mobileprogramming.andriansyah.helloworld.models.Pokemon;
import id.ac.ui.cs.mobileprogramming.andriansyah.helloworld.models.Pokemons;
import id.ac.ui.cs.mobileprogramming.andriansyah.helloworld.views.PokemonDetailActivity;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.disposables.CompositeDisposable;
import io.reactivex.disposables.Disposable;
import io.reactivex.functions.Consumer;

import static android.content.ContentValues.TAG;

public class ItemPokemonViewModel extends BaseObservable {
    private final Context context;
    private Pokemons pokemon;
    private Pokemon pokemonDetail;
    private CompositeDisposable compositeDisposable = new CompositeDisposable();

    public ItemPokemonViewModel(Context context, Pokemons pokemon) {
        this.context = context;
        this.pokemon = pokemon;
    }

    public String getPokemonName() {
        return pokemon.getName();
    }

    public String getPokemonUrl() { return pokemon.getUrl();}

    public void onItemClick(View view) {
        fetchPokemonDetail();
        context.startActivity(PokemonDetailActivity.launchDetail(view.getContext(), pokemonDetail));
    }

    private void fetchPokemonDetail() {
        PokedexApplication pokedexApplication = PokedexApplication.create(context);
        PokemonApiService pokemonApiService = pokedexApplication.getPokemonService();

        Disposable disposable = pokemonApiService.fetchPokemonDetail(pokemon.getUrl())
                .subscribeOn(pokedexApplication.subscribeScheduler())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(new Consumer<PokemonDetailApiResponse>() {
                    @Override
                    public void accept(PokemonDetailApiResponse pokemonDetailApiResponse) {
                        Pokemon pokemon = pokemonDetailApiResponse.getPokemon();
                        changePokemonData(pokemon);
                        System.out.println("accept: "+pokemon.getName());
                    }
                }, new Consumer<Throwable>() {
                    @Override
                    public void accept(Throwable throwable) {
                        throwable.printStackTrace();
                    }
                });
        compositeDisposable.add(disposable);
    }

    private void changePokemonData(Pokemon pokemon) {
        this.pokemonDetail = pokemon;
        notifyChange();
    }

    public void setPokemon(Pokemons pokemon) {
        this.pokemon = pokemon;
        notifyChange();
    }
}
