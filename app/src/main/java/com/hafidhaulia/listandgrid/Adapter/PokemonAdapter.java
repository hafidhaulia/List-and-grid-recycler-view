package com.hafidhaulia.listandgrid.Adapter;

import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.hafidhaulia.listandgrid.Entities.Pokemon;
import com.hafidhaulia.listandgrid.R;

import java.util.List;

public class PokemonAdapter extends RecyclerView.Adapter<PokemonAdapter.MyViewHolder> {

    private List<Pokemon> pokemonList;
    private Boolean isGrid;

    public PokemonAdapter(Boolean isGrid, List<Pokemon> pokemonList) {
        this.pokemonList = pokemonList;
        this.isGrid      = isGrid;
    }

    class MyViewHolder extends RecyclerView.ViewHolder {
        TextView textPokemonName, textPokemonAttack;
        ImageView ivThumbnail;

        MyViewHolder(View view) {
            super(view);
            textPokemonName   = (TextView) view.findViewById(R.id.text_name);
            textPokemonAttack = (TextView) view.findViewById(R.id.text_attack);
            ivThumbnail       = (ImageView) view.findViewById(R.id.thumbnail);
        }
    }

    @Override
    public MyViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view;
        if (isGrid) {
            view = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_for_grid, parent, false);
        }
        else {
            view = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_for_list, parent, false);
        }

        return new MyViewHolder(view);
    }

    @Override
    public void onBindViewHolder(MyViewHolder holder, int position) {
        Pokemon pokemon = pokemonList.get(position);
        holder.textPokemonName.setText(pokemon.getPokemonName());
        holder.textPokemonAttack.setText("Attack : "+String.valueOf(pokemon.getPokemonAttack()));
        holder.ivThumbnail.setImageResource(pokemon.getPokemonIcon());
    }

    @Override
    public int getItemCount() {
        return pokemonList.size();
    }

}