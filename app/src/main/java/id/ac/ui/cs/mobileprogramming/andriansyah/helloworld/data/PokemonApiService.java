package id.ac.ui.cs.mobileprogramming.andriansyah.helloworld.data;

import io.reactivex.Observable;
import retrofit2.http.GET;
import retrofit2.http.Url;

public interface PokemonApiService {
    @GET
    Observable<PokemonListApiResponse> fetchPokemonList(@Url String url);

    @GET
    Observable<PokemonDetailApiResponse> fetchPokemonDetail(@Url String url);
}
