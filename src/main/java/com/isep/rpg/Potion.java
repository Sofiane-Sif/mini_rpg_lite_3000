package com.isep.rpg;

public class Potion extends Consumable{

    private int pointLife;

    public int getPointLife() {
        return pointLife;
    }

    public Potion(String name, int pointLife){
        super(name);
        this.pointLife = pointLife;
    }
}
