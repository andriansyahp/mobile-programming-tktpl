package id.ac.ui.cs.mobileprogramming.andriansyah.helloworld.data;

import retrofit2.Retrofit;
import retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory;
import retrofit2.converter.gson.GsonConverterFactory;

public class PokemonFactory {
    public final static String BASE_URL = "https://pokeapi.co/api/v2/";
    public final static String RANDOM_USER_URL = "https://api.randomuser.me/?results=10&nat=en";
    public final static String PROJECT_URL = "https://github.com/erikjhordan-rey/People-MVVM";

    public static PokemonApiService create() {
        Retrofit retrofit = new Retrofit.Builder().baseUrl(BASE_URL)
                .addConverterFactory(GsonConverterFactory.create())
                .addCallAdapterFactory(RxJava2CallAdapterFactory.create())
                .build();
        return retrofit.create(PokemonApiService.class);
    }
}
