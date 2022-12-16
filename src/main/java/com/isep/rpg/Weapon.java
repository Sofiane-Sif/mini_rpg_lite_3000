package com.isep.rpg;

public class Weapon extends Item {

    public Weapon(String name, int damagePoints) {
        super(name);
        this.damagePoints = damagePoints;
    }

    public int getDamagePoints() {
        return damagePoints;
    }

    public void setDamagePoints(int damagePoints) {
        this.damagePoints = damagePoints;
    }

    // Une arme inflige des points de dégats
    private int damagePoints;
}
