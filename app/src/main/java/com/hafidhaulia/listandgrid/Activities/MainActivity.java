package com.hafidhaulia.listandgrid.Activities;

import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.DefaultItemAnimator;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.ImageView;

import com.daimajia.androidanimations.library.Techniques;
import com.daimajia.androidanimations.library.YoYo;
import com.hafidhaulia.listandgrid.Adapter.PokemonAdapter;
import com.hafidhaulia.listandgrid.Entities.Pokemon;
import com.hafidhaulia.listandgrid.Listener.RecyclerTouchListener;
import com.hafidhaulia.listandgrid.R;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {

    private Toolbar toolbar;
    private RecyclerView recyclerView;
    private FloatingActionButton floatingActionButton;

    private ArrayList<Pokemon> pokemonArrayList;
    private PokemonAdapter pokemonAdapter;
    private Boolean isGrid = false;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        retrieveView();

        setBar();

        setListener();

    }

    @Override
    protected void onResume() {
        super.onResume();
        updateData();
    }

    private void retrieveView(){
        toolbar              = (Toolbar) findViewById(R.id.toolbar);
        recyclerView         = (RecyclerView) findViewById(R.id.recycler_pokemon);
        floatingActionButton = (FloatingActionButton) findViewById(R.id.btn_view);
    }

    private void setBar(){
        setSupportActionBar(toolbar);
    }

    private void setListener() {
        floatingActionButton.setOnClickListener(this);
        recyclerView.addOnItemTouchListener(
                new RecyclerTouchListener(getApplicationContext(), recyclerView ,new RecyclerTouchListener.OnItemClickListener() {
                    @Override public void onItemClick(View view, int position) {
                        YoYo.with(Techniques.Tada)
                                .duration(700)
                                .repeat(1)
                                .playOn(view.findViewById(R.id.thumbnail));
                    }

                    @Override public void onLongItemClick(View view, int position) {
                    }
                })
        );
    }

    public void updateData() {
        pokemonArrayList = new ArrayList<>();

        setAdapter();

        getData();
    }

    void setAdapter() {
        pokemonAdapter = new PokemonAdapter(isGrid,pokemonArrayList);
        RecyclerView.LayoutManager linearLayoutManager = new LinearLayoutManager(getApplicationContext());
        RecyclerView.LayoutManager gridLayoutManager = new GridLayoutManager(getApplicationContext(),2);
        if (isGrid) {
            recyclerView.setLayoutManager(gridLayoutManager);
        }
        else {
            recyclerView.setLayoutManager(linearLayoutManager);
        }
        recyclerView.setItemAnimator(new DefaultItemAnimator());
        recyclerView.setAdapter(pokemonAdapter);
    }

    void getData() {
        Pokemon pokemon;
        pokemon = new Pokemon("Pikachu",20,R.drawable.pikachu);
        pokemonArrayList.add(pokemon);
        pokemon = new Pokemon("Abra",22,R.drawable.abra);
        pokemonArrayList.add(pokemon);
        pokemon = new Pokemon("Bulbasaur",18,R.drawable.bullbasaur);
        pokemonArrayList.add(pokemon);
        pokemon = new Pokemon("Eevee",15,R.drawable.eevee);
        pokemonArrayList.add(pokemon);
        pokemon = new Pokemon("Jigglypuff",12,R.drawable.jigglypuff);
        pokemonArrayList.add(pokemon);
        pokemon = new Pokemon("Mankey",26,R.drawable.mankey);
        pokemonArrayList.add(pokemon);
        pokemon = new Pokemon("Meowth",13,R.drawable.meowth);
        pokemonArrayList.add(pokemon);
        pokemon = new Pokemon("Pidgey",16,R.drawable.pidgey);
        pokemonArrayList.add(pokemon);
        pokemon = new Pokemon("Psyduck",6,R.drawable.psyduck);
        pokemonArrayList.add(pokemon);
        pokemon = new Pokemon("Snorlax",30,R.drawable.snorlax);
        pokemonArrayList.add(pokemon);
        pokemon = new Pokemon("Venonat",15,R.drawable.venonat);
        pokemonArrayList.add(pokemon);
        pokemon = new Pokemon("Zubat",14,R.drawable.zubat);
        pokemonArrayList.add(pokemon);
        setCardData();
    }

    void setCardData() {
        pokemonAdapter.notifyDataSetChanged();
    }

    @Override
    public void onClick(View view) {
        switch (view.getId()) {
            case R.id.btn_view:
                isGrid = !isGrid;
                updateData();
                break;
        }
    }
}
