package com.isep.rpg;

public abstract class Hero extends Combatant {

    public Hero(String n, int h) {
        super(n, h);
    }

    // Abstrait car n'importe quel hero peut prendre un objet mais son
    // utilisation dépend du type du héro (une arme n'est pas utile à un mage)
    public abstract void take(Item item);

    public abstract Weapon getWeapon();

    public abstract Food getFood();

    @Override
    public String toString(){
        return this.getName();
    }
}
