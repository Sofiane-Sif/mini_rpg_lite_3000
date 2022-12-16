package com.isep.rpg;

public abstract class Combatant {

    public Combatant(String n, int h) {
        name = n;
        healthPoint = h;
    }

    public String getName() {
        return name;
    }

    public int getHealthPoint() {
        return healthPoint;
    }

    public void looseLife(int hp) {
        healthPoint -= hp;
        // ... équivalant à : healthPoint = healthPoint - hp;
    }

    public void winLife(int hp) {
        healthPoint += hp;
    }

    // Chaque "vrai" combatant (non "abstract") implémente un code différent
    // pour la méthode "fight"
    public abstract void fight(Combatant combatant);

    private String name;
    private int healthPoint;
}
