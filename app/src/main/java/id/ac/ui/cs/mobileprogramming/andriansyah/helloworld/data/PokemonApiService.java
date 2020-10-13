package id.ac.ui.cs.mobileprogramming.andriansyah.helloworld.data;

import io.reactivex.Observable;
import retrofit2.http.GET;
import retrofit2.http.Query;
import retrofit2.http.Url;

import static id.ac.ui.cs.mobileprogramming.andriansyah.helloworld.data.PokemonFactory.BASE_URL;

public interface PokemonApiService {
    @GET(BASE_URL+"pokemon?")
    Observable<PokemonListApiResponse> fetchPokemonList(@Query("limit") String limit);

    @GET
    Observable<PokemonDetailApiResponse> fetchPokemonDetail(@Url String url);
}
