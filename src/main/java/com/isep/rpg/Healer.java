package com.isep.rpg;

public class Healer extends SpellCaster{

    @Override
    public int getMana() {
        return mana;
    }

    @Override
    public void setMana(int mana) {
        this.mana = mana;
    }

    private int mana;

    public int getCarePoints() {
        return carePoints;
    }

    public void setCarePoints(int carePoints) {
        this.carePoints = carePoints;
    }

    private int carePoints;

    public Healer(String name, int mana, int carePoints){
        super(name, 8);
        this.mana = mana;
        this.carePoints = carePoints;
    }

    @Override
    public void fight(Combatant combatant){
        if(mana > 0) {
            combatant.winLife(this.carePoints);       // Le healer soigne les combattants de 3hp
            mana--;
        }
        else{
            System.out.println("Votre Healer n'a plus de Mana, il ne peut plus soigner ses camarades...");
        }
    }

    private Potion potion;
    private Food food;

    @Override
    public Food getFood(){
        return food;
    }

    @Override
    public void take(Item item) {
        if (item instanceof Potion) {
            potion = (Potion) item;
        } else if (item instanceof Food) {
            food = (Food) item;
        } else {
            Game.displayMessage("Oups ! " + item.getName() + " est inutile...");
        }
    }

    @Override
    public Weapon getWeapon(){
        return null;
    }
}
