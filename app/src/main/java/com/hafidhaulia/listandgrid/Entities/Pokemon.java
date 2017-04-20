package com.hafidhaulia.listandgrid.Entities;

public class Pokemon {
    private String pokemonName;
    private int pokemonAttack;
    private int pokemonIcon;

    public Pokemon(String pokemonName, int pokemonAttack, int pokemonIcon) {
        this.pokemonName   = pokemonName;
        this.pokemonAttack = pokemonAttack;
        this.pokemonIcon   = pokemonIcon;
    }

    public String getPokemonName() {
        return pokemonName;
    }

    public void setPokemonName(String pokemonName) {
        this.pokemonName = pokemonName;
    }

    public int getPokemonAttack() {
        return pokemonAttack;
    }

    public void setPokemonAttack(int pokemonAttack) {
        this.pokemonAttack = pokemonAttack;
    }

    public int getPokemonIcon() {
        return pokemonIcon;
    }

    public void setPokemonIcon(int pokemonIcon) {
        this.pokemonIcon = pokemonIcon;
    }
}