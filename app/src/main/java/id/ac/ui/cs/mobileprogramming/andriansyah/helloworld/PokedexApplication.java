package id.ac.ui.cs.mobileprogramming.andriansyah.helloworld;

import android.content.Context;

import id.ac.ui.cs.mobileprogramming.andriansyah.helloworld.data.PokemonApiService;
import id.ac.ui.cs.mobileprogramming.andriansyah.helloworld.data.PokemonFactory;
import io.reactivex.Scheduler;
import io.reactivex.schedulers.Schedulers;
import androidx.multidex.MultiDexApplication;

public class PokedexApplication extends MultiDexApplication {
    private PokemonApiService pokemonApiService;
    private Scheduler scheduler;

    private static PokedexApplication get(Context context) {
        return (PokedexApplication) context.getApplicationContext();
    }

    public static PokedexApplication create(Context context) {
        return PokedexApplication.get(context);
    }

    public PokemonApiService getPokemonService() {
        if (pokemonApiService == null) {
            pokemonApiService = PokemonFactory.create();
        }

        return pokemonApiService;
    }

    public Scheduler subscribeScheduler() {
        if (scheduler == null) {
            scheduler = Schedulers.io();
        }
        return scheduler;
    }
}
