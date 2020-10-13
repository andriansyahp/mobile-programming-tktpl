package id.ac.ui.cs.mobileprogramming.andriansyah.helloworld.views;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;

import androidx.appcompat.app.AppCompatActivity;
import androidx.databinding.DataBindingUtil;
import androidx.recyclerview.widget.RecyclerView;

import java.util.Observable;
import java.util.Observer;

import id.ac.ui.cs.mobileprogramming.andriansyah.helloworld.R;
import id.ac.ui.cs.mobileprogramming.andriansyah.helloworld.databinding.PokemonListActivityBinding;
import id.ac.ui.cs.mobileprogramming.andriansyah.helloworld.models.Pokemon;
import id.ac.ui.cs.mobileprogramming.andriansyah.helloworld.viewmodels.PokemonListViewModel;

public class PokemonListActivity extends AppCompatActivity implements Observer {
    private PokemonListViewModel pokemonListViewModel;

    private PokemonListActivityBinding binding;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        initDataBinding();
        setSupportActionBar(binding.toolbar);
        setupListPokemonView(binding.recyclerPokemon);
        setupObserver(pokemonListViewModel);
    }

    private void initDataBinding() {
        binding = DataBindingUtil.setContentView(this, R.layout.pokemon_list_activity);
        pokemonListViewModel = new PokemonListViewModel(this);
        binding.setMainViewModel(pokemonListViewModel);
    }

    private void setupListPokemonView(RecyclerView recyclerPokemon) {
        PokemonAdapter adapter = new PokemonAdapter();
        recyclerPokemon.setAdapter(adapter);
        recyclerPokemon.setHasFixedSize(true);
    }

    public void setupObserver(Observable observable) {
        observable.addObserver(this);
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        pokemonListViewModel.reset();
    }

    @Override
    public void update(Observable observable, Object data) {
        if (observable instanceof PokemonListViewModel) {
            PokemonAdapter pokemonAdapter = (PokemonAdapter) binding.recyclerPokemon.getAdapter();
            if (pokemonAdapter != null) {
                PokemonListViewModel pokemonListViewModel = (PokemonListViewModel) observable;
                pokemonAdapter.setPokemonList(pokemonListViewModel.getPokemonList());
            }
        }
    }
}
