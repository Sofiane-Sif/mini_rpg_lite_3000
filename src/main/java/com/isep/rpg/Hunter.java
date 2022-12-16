package com.isep.rpg;

public class Hunter extends Hero{

    private int arrowsNumber;
    private Weapon weapon;
    private Food food;

    public int getArrowsNumber() {
        return arrowsNumber;
    }

    public void setArrowsNumber(int arrowsNumber) {
        this.arrowsNumber = arrowsNumber;
    }

    public Hunter(String name, int arrowsNumber){
        super(name, 6);
        this.arrowsNumber = arrowsNumber;
    }

    @Override
    public void fight(Combatant combatant){
        if(arrowsNumber > 0){
            combatant.looseLife(weapon.getDamagePoints());
            arrowsNumber--;     //on décremente le nombre de flèches à chaque attaque
        }
        else{
            System.out.println("Le chasseur n'a plus de flèches...");
        }
    }

    // Implémentation de la méthode abstraite "take" par le chasseur :
    //   Le chasseur ne peut utiliser que les objets de type "Weapon"
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

    @Override
    public Food getFood(){
        return food;
    }
}
