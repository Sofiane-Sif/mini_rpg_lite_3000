package com;

import com.isep.rpg.Game;

public class Main {
    public static void main(String[] args) {
        // Il faudra initialiser un "InputParser"...
        Game game = new Game(null);
        game.start();
    }
}