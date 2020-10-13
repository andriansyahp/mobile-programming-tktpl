package id.ac.ui.cs.mobileprogramming.andriansyah.helloworld.viewmodels;

import android.content.Context;
import android.view.View;

import androidx.annotation.NonNull;
import androidx.databinding.ObservableField;
import androidx.databinding.ObservableInt;

import java.util.ArrayList;
import java.util.List;
import java.util.Observable;

import id.ac.ui.cs.mobileprogramming.andriansyah.helloworld.PokedexApplication;
import id.ac.ui.cs.mobileprogramming.andriansyah.helloworld.R;
import id.ac.ui.cs.mobileprogramming.andriansyah.helloworld.data.PokemonApiService;
import id.ac.ui.cs.mobileprogramming.andriansyah.helloworld.data.PokemonFactory;
import id.ac.ui.cs.mobileprogramming.andriansyah.helloworld.data.PokemonListApiResponse;
import id.ac.ui.cs.mobileprogramming.andriansyah.helloworld.models.Pokemons;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.disposables.CompositeDisposable;
import io.reactivex.disposables.Disposable;
import io.reactivex.functions.Consumer;

public class PokemonListViewModel extends Observable {
    public ObservableInt pokemonListProgress;
    public ObservableInt pokemonListRecycler;
    public ObservableInt pokemonLabel;
    public ObservableField<String> messageLabel;

    private List<Pokemons> pokemonList;
    private Context context;
    private CompositeDisposable compositeDisposable = new CompositeDisposable();

    public PokemonListViewModel(@NonNull Context context) {

        this.context = context;
        this.pokemonList = new ArrayList<>();
        pokemonListProgress = new ObservableInt(View.GONE);
        pokemonListRecycler = new ObservableInt(View.GONE);
        pokemonLabel = new ObservableInt(View.VISIBLE);
        messageLabel = new ObservableField<>(context.getString(R.string.default_loading_pokemon));
    }

    public void onClickFabLoad(View view) {
        initializeViews();
        fetchPokemonList();
    }

    //It is "public" to show an example of test
    public void initializeViews() {
        pokemonLabel.set(View.GONE);
        pokemonListRecycler.set(View.GONE);
        pokemonListProgress.set(View.VISIBLE);
    }

    // NOTE: This method can return the rx observer and just subscribe to it in the activity or fragment,
    // an Activity or Fragment needn't to implement from the Observer java class
    // (it was my first approach to avoid RX in UI now we can use LiveData instead)
    private void fetchPokemonList() {

        PokedexApplication pokedexApplication = PokedexApplication.create(context);
        PokemonApiService pokemonApiService = pokedexApplication.getPokemonService();

        Disposable disposable = pokemonApiService.fetchPokemonList("200")
                .subscribeOn(pokedexApplication.subscribeScheduler())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(new Consumer<PokemonListApiResponse>() {
                    @Override
                    public void accept(PokemonListApiResponse pokemonListApiResponse) {
                        changePokemonsDataSet(pokemonListApiResponse.getPokemonsList());
                        pokemonListProgress.set(View.GONE);
                        pokemonLabel.set(View.GONE);
                        pokemonListRecycler.set(View.VISIBLE);
                    }
                }, new Consumer<Throwable>() {
                    @Override
                    public void accept(Throwable throwable) {
                        messageLabel.set(context.getString(R.string.error_loading_pokemon));
                        pokemonListProgress.set(View.GONE);
                        pokemonLabel.set(View.VISIBLE);
                        pokemonListRecycler.set(View.GONE);
                        throwable.printStackTrace();
                    }
                });

        compositeDisposable.add(disposable);
    }

    private void changePokemonsDataSet(List<Pokemons> pokemons) {
        pokemonList.addAll(pokemons);
        setChanged();
        notifyObservers();
    }

    public List<Pokemons> getPokemonList() {
        return pokemonList;
    }

    public void reset() {
        compositeDisposable.dispose();
        compositeDisposable = null;
        context = null;
    }
}
