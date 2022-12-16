package com.isep.rpg;

public class Tauren extends Ennemy {

    public Tauren(String n) {
        // Le dragon possède 5 points de vie et inflige 3 points de dégats
        super(n, 5, 4);
    }

    // Implémentation de la méthode abstraite "fight" par le dragon
    @Override
    public void fight(Combatant combatant) {
        combatant.looseLife( getDamagePoints() );
    }
}
