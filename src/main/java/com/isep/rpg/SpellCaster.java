package com.isep.rpg;

public abstract class SpellCaster extends Hero {

    public int mana;

    public int getMana() {
        return mana;
    }

    public void setMana(int mana) {
        this.mana = mana;
    }


    public SpellCaster(String name, int hp){
        super(name, hp);
    }

}
