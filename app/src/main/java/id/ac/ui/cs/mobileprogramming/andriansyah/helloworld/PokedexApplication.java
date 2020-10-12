package id.ac.ui.cs.mobileprogramming.andriansyah.helloworld;

import android.content.Context;

import id.ac.ui.cs.mobileprogramming.andriansyah.helloworld.data.PokemonApiService;
import id.ac.ui.cs.mobileprogramming.andriansyah.helloworld.data.PokemonFactory;
import io.reactivex.Scheduler;
import io.reactivex.schedulers.Schedulers;
import androidx.multidex.MultiDexApplication;

public class PokedexApplication extends MultiDexApplication {
    private PokemonApiService peopleService;
    private Scheduler scheduler;

    private static PokedexApplication get(Context context) {
        return PokedexApplication.get(context.getApplicationContext());
    }

    public static PokedexApplication create(Context context) {
        return PokedexApplication.get(context);
    }

    public PokemonApiService getPokemonService() {
        if (peopleService == null) {
            peopleService = PokemonFactory.create();
        }

        return peopleService;
    }

    public Scheduler subscribeScheduler() {
        if (scheduler == null) {
            scheduler = Schedulers.io();
        }
        return scheduler;
    }
}
