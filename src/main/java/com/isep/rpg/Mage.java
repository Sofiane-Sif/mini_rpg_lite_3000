package com.isep.rpg;

public class Mage extends SpellCaster{

    private Weapon weapon;
    private int mana;
    private Food food;

    @Override
    public int getMana() {
        return mana;
    }

    @Override
    public void setMana(int mana) {
        this.mana = mana;
    }

    public Mage(String name, int mana){
        super(name, 6);
        this.mana = mana;
    }

    @Override
    public void fight(Combatant combatant){
        if(mana > 0) {
            combatant.looseLife(weapon.getDamagePoints());
            mana--;
        }
        else{
            System.out.println("Le mage n'a plus de Mana, il ne peut plus attaquer...");
        }
    }

    @Override
    public Food getFood(){
        return food;
    }

    @Override
    public void take(Item item) {
        if (item instanceof Weapon) {
            weapon = (Weapon) item;
        } else if (item instanceof Food) {
            food = (Food) item;
        } else {
            Game.displayMessage("Oups ! " + item.getName() + " est inutile...");
        }
    }

    @Override
    public Weapon getWeapon(){
        return weapon;
    }
}
