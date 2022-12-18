package com.isep.rpg;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class DragonTest {
    @Test
    void bossTest() {
        Hunter h = new Hunter("Ron",4);
        Weapon sword = new Weapon("sword", 1);
        h.take(sword);
        Boss boss = new Boss("Boss");
        boss.fight(h);
        assertEquals(0, h.getHealthPoint());
        assertEquals("sword",sword.getName());
        sword.setDamagePoints(10);
        assertEquals(10, sword.getDamagePoints());
    }

    @Test
    void mageTake(){
        Mage m = new Mage("Mage",10);
        Weapon stone = new Weapon("Stone",3);
        m.take(stone);
        assertEquals(3,stone.getDamagePoints());
    }

    @Test
    void healerTake(){
        Healer h = new Healer("Healer",1,3);
        Potion potion = new Potion("Potion",2);
        h.take(potion);
        assertEquals(2,potion.getPointLife());
    }

    @Test
    void hunterTakePotion(){
        Warrior warrio = new Warrior("Warrio");
        Hunter hunter = new Hunter("Hunter",10);
        Mage mage = new Mage("Mage",10);
        Potion potion = new Potion("Potion",2);
        warrio.take(potion);
        hunter.take(potion);
        mage.take(potion);
        assertEquals(2,potion.getPointLife());
    }

    @Test
    void combatantName(){
        Healer healer = new Healer("Bobi",10,3);
        assertSame("Bobi", healer.getName());
    }

    @Test
    void fightTest(){
        Warrior w = new Warrior("Warrio");
        Weapon knife = new Weapon("Knife",3);
        w.take(knife);
        Dragon d = new Dragon("Dracofeu");
        d.fight(w);
        w.fight(d);
        assertTrue(d.getHealthPoint() == 2);
        assertEquals(2, w.getHealthPoint());
    }

    @Test
    void ennemiesFight(){
        Tauren tauren = new Tauren("Tauren");
        Mage mage = new Mage("Mage",10);
        Troll troll = new Troll("Troll");
        Warrior w = new Warrior("Warrio");
        tauren.fight(mage);
        troll.fight(w);
        assertEquals(2, mage.getHealthPoint());
        assertEquals(1, w.getHealthPoint());
    }

    @Test
    void fightTestHealer(){
        Healer h = new Healer("Jenea",10,3);
        Hunter hunter = new Hunter("Chasseur",5);
        h.fight(hunter);
        assertEquals(9, hunter.getHealthPoint());
        assertEquals(9, h.getMana());       //on teste que le Mana est descendue
        h.setMana(22);
        assertEquals(22, h.getMana());
        h.setMana(0);
        h.fight(hunter);
        assertEquals(9,hunter.getHealthPoint());
    }

    @Test
    void NoArrowsTest(){
        Hunter hunter = new Hunter("Chasseur",0);
        Orc orc = new Orc("Orc");
        hunter.fight(orc);
        assertEquals(6, orc.getHealthPoint());      //la vie de l'orc n'a pas été modifiée, car le chasseur n'a plus de flèches
        assertEquals(0,hunter.getArrowsNumber());
        hunter.setArrowsNumber(10);
        assertEquals(10,hunter.getArrowsNumber());
    }

    @Test
    void noManaTest(){
        Mage mage = new Mage("Mage",0);
        Tauren d = new Tauren("Tauren");
        mage.fight(d);
        assertEquals(5, d.getHealthPoint());      //la vie du Dragon n'a pas été modifiée, car le mage n'a plus de Mana
    }

    @Test
    void herotoStringTest(){
        Mage mage = new Mage("Mage",10);
        assertEquals("Mage",mage.toString());
    }

    @Test
    void ennemiesDamagePointsTest(){
        Orc orc = new Orc("Orc");
        Mage mage = new Mage("Mage",10);
        orc.fight(mage);
        assertEquals(3, orc.getDamagePoints());
        assertEquals(3, mage.getHealthPoint());
        mage.setMana(12);
        assertEquals(12, mage.getMana());
    }

    @Test
    void potionTest(){
        Potion potion = new Potion("Potion", 2);
        assertEquals(2,potion.getPointLife());
    }

    @Test
    void foodTest(){
        Food food = new Food("Baies", 3);
        assertEquals(3, food.getPointLife());
        food.setPointLifeFood(10);
        assertEquals(10, food.getPointLife());
    }
}