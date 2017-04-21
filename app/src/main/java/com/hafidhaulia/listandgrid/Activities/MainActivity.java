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
        pokemonArrayList.add(new Pokemon("Pikachu",20,R.drawable.pikachu));
        pokemonArrayList.add(new Pokemon("Abra",22,R.drawable.abra));
        pokemonArrayList.add(new Pokemon("Bulbasaur",18,R.drawable.bullbasaur));
        pokemonArrayList.add(new Pokemon("Eevee",15,R.drawable.eevee));
        pokemonArrayList.add(new Pokemon("Jigglypuff",12,R.drawable.jigglypuff));
        pokemonArrayList.add(new Pokemon("Mankey",26,R.drawable.mankey));
        pokemonArrayList.add(new Pokemon("Meowth",13,R.drawable.meowth));
        pokemonArrayList.add(new Pokemon("Pidgey",16,R.drawable.pidgey));
        pokemonArrayList.add(new Pokemon("Psyduck",6,R.drawable.psyduck));
        pokemonArrayList.add(new Pokemon("Snorlax",30,R.drawable.snorlax));
        pokemonArrayList.add(new Pokemon("Venonat",15,R.drawable.venonat));
        pokemonArrayList.add(new Pokemon("Zubat",14,R.drawable.zubat));
        pokemonArrayList.add(new Pokemon("Weedle",17,R.drawable.weedle));
        pokemonArrayList.add(new Pokemon("Caterpie",14,R.drawable.caterpie));
        pokemonArrayList.add(new Pokemon("Rattata",15,R.drawable.rattata));
        pokemonArrayList.add(new Pokemon("Mew",8,R.drawable.mew));
        pokemonArrayList.add(new Pokemon("Bellsprout",16,R.drawable.bellsprout));
        pokemonArrayList.add(new Pokemon("Dratini",19,R.drawable.dratini));
        pokemonArrayList.add(new Pokemon("Squirtle",20,R.drawable.squirtle));
        pokemonArrayList.add(new Pokemon("Charmander",17,R.drawable.charmander));
        setCardData();
    }

    void setCardData() {
        pokemonAdapter.notifyDataSetChanged();
    }

    @Override
    public void onClick(View view) {
        switch (view.getId()) {
            case R.id.btn_view:
                if (isGrid) {
                    isGrid = false;
                    floatingActionButton.setImageResource(R.drawable.ic_grid_on);
                }
                else {
                    isGrid = true;
                    floatingActionButton.setImageResource(R.drawable.ic_list_on);
                }
                updateData();
                break;
        }
    }
}
