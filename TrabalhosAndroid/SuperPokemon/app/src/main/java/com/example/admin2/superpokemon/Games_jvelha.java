package com.example.admin2.superpokemon;

/**
 * Created by Ruan on 04/06/2017.
 */

import java.util.ArrayList;
import java.util.List;

public class Games_jvelha {
    private List<Game_jvelha> gameJvelhas = new ArrayList<>();

    public Games_jvelha(Game_jvelha...gameJvelhas){
        for(Game_jvelha g : gameJvelhas ) this.gameJvelhas.add(g);
    }

    public Game_jvelha gamesAddSeries(int jogador){
        Game_jvelha g;
        for(Game_jvelha game_jvelha: gameJvelhas){
            g = game_jvelha.addSerie(jogador);
            if (g != null) return g;
        }
        return null;
    }

}
