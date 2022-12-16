package com.isep.rpg;

public class Boss extends Ennemy{

    public Boss(String n) {
        // Le dragon possède 10 points de vie et inflige 6 points de dégats
        super(n, 10, 6);
    }

    // Implémentation de la méthode abstraite "fight" par le dragon
    @Override
    public void fight(Combatant combatant) {
        combatant.looseLife( getDamagePoints() );
    }
}


