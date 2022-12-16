package com.isep.rpg;

public class Warrior extends Hero {

    public Warrior(String n) {
        // Le guerrier possède 5 points de vie
        super(n, 5);
    }

    // Implémentation de la méthode abstraite "fight" par le guerrier
    @Override
    public void fight(Combatant combatant) {
        combatant.looseLife( weapon.getDamagePoints() );
    }

    // Implémentation de la méthode abstraite "take" par le guerrier :
    //   Le guerrier ne peut utiliser que les objets de type "Weapon"
    @Override
    public void take(Item item) {
        if (item instanceof Weapon) {
            weapon = (Weapon) item;
        } else if (item instanceof  Food) {
            food = (Food) item;
        } else {
            Game.displayMessage("Oups ! " + item.getName() + " est inutile...");
        }
    }

    private Weapon weapon;
    private Food food;

    @Override
    public Weapon getWeapon(){
        return weapon;
    }

    @Override
    public Food getFood(){
        return food;
    }
}
