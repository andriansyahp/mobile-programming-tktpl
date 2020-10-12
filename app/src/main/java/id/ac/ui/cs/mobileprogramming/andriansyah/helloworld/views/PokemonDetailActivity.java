package id.ac.ui.cs.mobileprogramming.andriansyah.helloworld.views;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;

import androidx.appcompat.app.ActionBar;
import androidx.appcompat.app.AppCompatActivity;
import androidx.databinding.DataBindingUtil;

import id.ac.ui.cs.mobileprogramming.andriansyah.helloworld.R;
import id.ac.ui.cs.mobileprogramming.andriansyah.helloworld.models.Pokemon;
import id.ac.ui.cs.mobileprogramming.andriansyah.helloworld.viewmodels.PokemonDetailViewModel;

public class PokemonDetailActivity extends AppCompatActivity {
//    private static final String EXTRA_PEOPLE = "EXTRA_PEOPLE";
//
//    private PokemonDetailActivityBinding binding;

    @Override protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
//        binding = DataBindingUtil.setContentView(this, R.layout.pokemon_detail_activity);
//        setSupportActionBar(binding.toolbar);
        displayHomeAsUpEnabled();
        getExtrasFromIntent();
    }

    public static Intent launchDetail(Context context, Pokemon pokemon) {
        Intent intent = new Intent(context, PokemonDetailActivity.class);
//        intent.putExtra(EXTRA_PEOPLE, pokemon);
        return intent;
    }

    private void displayHomeAsUpEnabled() {
        ActionBar actionBar = getSupportActionBar();
        if (actionBar != null) {
            actionBar.setDisplayHomeAsUpEnabled(true);
        }
    }

    private void getExtrasFromIntent() {
//        Pokemon pokemon = (Pokemon) getIntent().getSerializableExtra(EXTRA_PEOPLE);
//        PokemonDetailViewModel peopleDetailViewModel = new PokemonDetailViewModel(pokemon);
//        binding.setPokemonDetailViewModel(peopleDetailViewModel);
//        setTitle(pokemon.getName());
    }
}
