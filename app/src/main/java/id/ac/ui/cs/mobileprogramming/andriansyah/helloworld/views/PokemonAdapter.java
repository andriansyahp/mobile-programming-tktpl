package id.ac.ui.cs.mobileprogramming.andriansyah.helloworld.views;

import android.view.LayoutInflater;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.databinding.DataBindingUtil;
import androidx.recyclerview.widget.RecyclerView;

import java.util.Collections;
import java.util.List;

import id.ac.ui.cs.mobileprogramming.andriansyah.helloworld.R;
import id.ac.ui.cs.mobileprogramming.andriansyah.helloworld.models.Pokemons;
import id.ac.ui.cs.mobileprogramming.andriansyah.helloworld.viewmodels.ItemPokemonViewModel;

//public class PokemonAdapter extends RecyclerView.Adapter<PokemonAdapter.PokemonAdapterViewHolder> {
public class PokemonAdapter {
    private List<Pokemons> pokemons;

    PokemonAdapter() {
        this.pokemons = Collections.emptyList();
    }

//    @NonNull
//    @Override
//    public PokemonAdapterViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
////        ItemPokemonBinding itemPokemonBinding =
////                DataBindingUtil.inflate(LayoutInflater.from(parent.getContext()), R.layout.item_pokemon, parent, false);
////        return new PokemonAdapterViewHolder(itemPokemonBinding);
//    }

//    @Override
//    public void onBindViewHolder(PokemonAdapterViewHolder holder, int position) {
//        holder.bindPokemon(pokemons.get(position));
//    }

//    @Override
//    public int getItemCount() {
//        return pokemons.size();
//    }

//    void setPokemonList(List<Pokemons> pokemons) {
//        this.pokemons = pokemons;
//        notifyDataSetChanged();
//    }

//    static class PokemonAdapterViewHolder extends RecyclerView.ViewHolder {
////        ItemPokemonBinding binding;
//
////        PokemonAdapterViewHolder(ItemPokemonBinding binding) {
////            super(binding.itemPokemon);
////            this.binding = binding;
////        }
//
//        void bindPokemon(Pokemons pokemon) {
//            if (binding.getPokemonListViewModel() == null) {
//                binding.setPokemonListViewModel(new ItemPokemonViewModel(itemView.getContext(), pokemon));
//            } else {
//                binding.getPokemonListViewModel().setPokemon(pokemon);
//            }
//        }
//    }
}
