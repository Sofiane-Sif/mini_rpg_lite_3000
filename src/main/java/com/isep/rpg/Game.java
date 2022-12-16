package com.isep.rpg;

import com.isep.utils.InputParser;

import java.util.*;

public class Game {

    Scanner scanner = new Scanner(System.in);

    public Game(InputParser inputParser) {

        this.inputParser = inputParser;

        displayMessage("Bienvenue dans Mini RPG Lite 3000© ! Êtes-vous prêt à débuter l'aventure... C'est parti ! \n \n");

        // Liste contenant nos différents héros
        heros = new ArrayList<>();

        displayMessage("Avant tout, veuillez indiquer le nombre de héros souhaité (min : 1 héros, max : 5 héros) : ");

        boolean validNumber = false;
        int numberHero = 0;
        while (!validNumber) {
            try {
                numberHero = scanner.nextInt();
                while (numberHero > 5 || numberHero <= 0) {
                    System.out.println("Veuillez respecter les règles du jeu... (min : 1 héros, max : 5 héros)");
                    numberHero = scanner.nextInt();
                }
                validNumber = true;
            } catch (InputMismatchException e) {
                System.out.println("Veuillez saisir un numéro valide svp");
                scanner.nextLine();
            }
        }

        for (int i = 0; i < numberHero; i++) {

            // Demande à l'utilisateur avec quelles classes il veut jouer :
            if (i == 0) {
                displayMessage("Choisissez la classe de votre premier héros : (entrez le numéro correspondant)");
            } else {
                displayMessage("\nChoisissez la classe de votre " + (i + 1) + "-ème héros : (entrez le numéro correspondant)");
            }
            displayMessage("[1] Warrior (5 hp) \n[2] Hunter (6 hp) \n[3] Mage (6 hp) \n[4] Healer (8 hp)");

            // Sécurisation du scanner
            int firstHeroNumber = 0;
            boolean tmp = false;
            while (!tmp) {
                try {
                    firstHeroNumber = scanner.nextInt();
                    while (firstHeroNumber > 4 || firstHeroNumber <= 0) {
                        displayMessage("ATTENTION : Veuillez saisir un numéro valide !");
                        firstHeroNumber = scanner.nextInt();
                    }
                    tmp = true;
                } catch (InputMismatchException e) {
                    displayMessage("Vous devez saisir un numéro valide ! Choisissez la classe de votre " + (i + 1) + "-ème héros : (entrez le numéro correspondant)?");
                    scanner.nextLine();
                }
            }


            displayMessage("Quel nom souhaitez vous donner à votre héros ?");
            String firstHeroName = scanner.next();

            Hero firstHero = null;

            // Instanciation du hero choisi par le joueur
            switch (firstHeroNumber) {

                case 1:
                    firstHero = new Warrior(firstHeroName);
                    break;

                case 2:
                    firstHero = new Hunter(firstHeroName, 8);
                    break;

                case 3:
                    firstHero = new Mage(firstHeroName, 8);
                    break;

                case 4:
                    firstHero = new Healer(firstHeroName, 10, 3);
                    break;
            }

            // Choix de l'arme en fonction de la classe
            displayMessage("Vous allez maintenant devoir choisir une arme pour votre héros : ");
            int firstHeroWeapon = 0;
            switch (firstHeroNumber) {

                case 1:
                    displayMessage("Vous avez le choix entre deux armes : [1] Knife (3 points de dégâts) ou [2] AmericanPunch (2 points de dégâts). Entrez le numéro de votre arme : ");
                    boolean tmp1 = false;
                    while (!tmp1) {
                        try {
                            firstHeroWeapon = scanner.nextInt();
                            while (firstHeroWeapon > 2 || firstHeroWeapon <= 0) {
                                displayMessage("ATTENTION : Veuillez saisir un numéro valide !");
                                firstHeroWeapon = scanner.nextInt();
                            }
                            tmp1 = true;
                        } catch (InputMismatchException e) {
                            displayMessage("Vous devez saisir un numéro valide ! [1] Knife (3 points de dégâts) ou [2] AmericanPunch (2 points de dégâts). Entrez le numéro de votre arme : ");
                            scanner.nextLine();
                        }
                    }
                    if (firstHeroWeapon == 1) {
                        Weapon knife = new Weapon("Knife", 3);
                        firstHero.take(knife);
                        displayRecapitulatif(firstHero, "Knife", 3);
                    }
                    if (firstHeroWeapon == 2) {
                        Weapon americanPunch = new Weapon("AmericanPunch", 2);
                        firstHero.take(americanPunch);
                        displayRecapitulatif(firstHero, "AmericanPunch", 2);
                    }
                    break;

                case 2:
                    displayMessage("Vous avez le choix entre deux armes : [1] Arbalète (2 points de dégâts) ou [2] Arc (2 points de dégâts). Entrez le numéro de votre arme : ");
                    boolean tmp2 = false;
                    while (!tmp2) {
                        try {
                            firstHeroWeapon = scanner.nextInt();
                            while (firstHeroWeapon > 2 || firstHeroWeapon <= 0) {
                                displayMessage("ATTENTION : Veuillez saisir un numéro valide !");
                                firstHeroWeapon = scanner.nextInt();
                            }
                            tmp2 = true;
                        } catch (InputMismatchException e) {
                            displayMessage("Vous devez saisir un numéro valide ! [1] Arbalète (2 points de dégâts) ou [2] Arc (2 points de dégâts). Entrez le numéro de votre arme : ");
                            scanner.nextLine();
                        }
                    }

                    if (firstHeroWeapon == 1) {
                        firstHero.take(new Weapon("Arbalète", 2));
                        displayRecapitulatif(firstHero, "Arbalète", 2);
                    }
                    if (firstHeroWeapon == 2) {
                        firstHero.take(new Weapon("Arc", 2));
                        displayRecapitulatif(firstHero, "Arc", 2);
                    }
                    break;

                case 3:
                    displayMessage("Vous avez le choix entre deux armes : [1] Boule de feu (2 points de dégâts) ou [2] Stone (3 points de dégâts). Entrez le numéro de votre arme : ");
                    boolean tmp3 = false;
                    while (!tmp3) {
                        try {
                            firstHeroWeapon = scanner.nextInt();
                            while (firstHeroWeapon > 2 || firstHeroWeapon <= 0) {
                                displayMessage("ATTENTION : Veuillez saisir un numéro valide !");
                                firstHeroWeapon = scanner.nextInt();
                            }
                            tmp3 = true;
                        } catch (InputMismatchException e) {
                            displayMessage("Vous devez saisir un numéro valide ! [1] Boule de feu (2 points de dégâts) ou [2] Stone (3 points de dégâts). Entrez le numéro de votre arme : ");
                            scanner.nextLine();
                        }
                    }

                    if (firstHeroWeapon == 1) {
                        firstHero.take(new Weapon("Boule-de-feu", 2));
                        displayRecapitulatif(firstHero, "Boule-de-feu", 2);
                    }
                    if (firstHeroWeapon == 2) {
                        firstHero.take(new Weapon("Stone", 3));
                        displayRecapitulatif(firstHero, "Stone", 3);
                    }
                    break;

                case 4:
                    displayMessage("Le Healer ne possède pas d'arme : il soigne avec des sorts");
                    break;
            }

            heros.add(firstHero);
        }

        System.out.println("\n\t\t Voici la composition de votre équipe : " + heros);

        // Liste des ennemis :
        enemies = new ArrayList<>();
        enemies.add(new Dragon("Dracofeu"));
        enemies.add(new Orc("Lugnarz"));
        enemies.add(new Tauren("Hardy"));
        enemies.add(new Troll("Triller"));
        Collections.shuffle(enemies);         // Mélange de la liste pour que l'ordre des ennemies soit aléatoire
        enemies.add(new Boss("BOSS"));
    }

    public void start() {

        int nbr_tours = 1;

        // Chaque héros possède de la nourriture par défaut --> possible d'augmenter l'efficacité de la nourriture
        // si l'équipe gagne un combat.
        Food lemba_warrior = new Food("lemba",2);
        Food lemba_hunter = new Food("lemba",2);
        Food lemba_mage = new Food("lemba",2);
        Food lemba_healer = new Food("lemba",2);
        for(Hero c:heros){
            if(c instanceof Warrior) c.take(lemba_warrior);
            if(c instanceof Hunter) c.take(lemba_hunter);
            if(c instanceof Mage) c.take(lemba_mage);
            if(c instanceof Healer) c.take(lemba_healer);
        }

        // Boucle de jeu
        while (true) {
            displayMessage("\n------------ TOUR " + nbr_tours + " ------------\n");
            displayStatus(heros, enemies);

            //On génère un nombre aléatoire entre 0 et 1 pour savoir qui des héros ou des ennemis commencent à attaquer
            Random r = new Random();
            int firstAttacker = r.nextInt(2);
            if(firstAttacker == 0) displayMessage("Le hasard a frappé... Les héros commencent le combat !");
            else displayMessage("Attention, le hasard a frappé... Les ennemis commencent à attaquer !");

            // Choix du héros à controller au début du tour :
            int ixHero = 0;
            if(heros.size() == 1) ixHero = 1;   //s'il ne reste qu'un seul héros, pas besoin de demander quel héros choisir
            else {
                System.out.print("Saisissez la position du héros que vous souhaitez contrôler parmi les héros toujours en lice : ");
                System.out.println(heros);
                boolean tmp4 = false;
                while (!tmp4) {
                    try {
                        ixHero = scanner.nextInt();
                        while (ixHero > heros.toArray().length || ixHero <= 0) {
                            System.out.println("Veuillez saisir une position valide...");
                            ixHero = scanner.nextInt();
                        }
                        tmp4 = true;
                    } catch (InputMismatchException | IndexOutOfBoundsException e) {
                        displayMessage("Entrez une position valide. Le premier héros de la liste est en position 1 !");
                        scanner.nextLine();
                    }
                }
            }

            // On contrôle le héros en question
            Hero goodOne = heros.get(ixHero-1);

            // Les ennemis s'enchainent dans le sens de la liste
            Combatant badOne = enemies.get(0);

            switch (firstAttacker){

                // Les ennemies commencent à attaquer
                case 1:
                    // Attaque de l'ennemi
                    displayMessage("Le méchant " + badOne.getName()
                            + " attaque le gentil " + goodOne.getName() + "...");
                    badOne.fight(goodOne);
                    if (goodOne.getHealthPoint() <= 0) {
                        displayMessage("Le pauvre " + goodOne.getName() + " a été vaincu...");
                        heros.remove(ixHero-1);
                        ixHero--; // Correction : évite que le suivant perde son tour
                    }
                    else {

                        // Riposte du gentil, s'il n'est pas vaincu

                        // Si c'est un Healer : le joueur choisi qui soigner
                        if(goodOne instanceof Healer){

                            // Création d'une liste de héros qui ne sont pas de type Healer
                            notHealerList = new ArrayList<>();
                            for(Combatant healer: heros){
                                if(!(healer instanceof Healer)){
                                    notHealerList.add(healer);
                                }
                            }

                            //S'il ne reste plus que des Healer en lice, alors ils ne pourront soigner personne...
                            if(notHealerList.size() == 0) displayMessage("Il n'y a pas de héros à soigner : les Healer sont vulnérables...");

                            else if (notHealerList.size() == 1) {
                                displayMessage("Vous avez le choix entre :\n\t[1] Soigner un héros de votre équipe\n\t[2] Boire une potion (+ 2 points de Mana)");
                                int choix = 0;
                                boolean tmp = false;
                                while(!tmp){
                                    try {
                                        choix = scanner.nextInt();
                                        while (choix > 2 || choix <= 0) {
                                            System.out.println("Veuillez saisir une position valide...");
                                            choix = scanner.nextInt();
                                        }
                                        tmp = true;
                                    }
                                    catch (InputMismatchException e){
                                        displayMessage("Exception" + e + ". Veuillez entrer un numéro valide");
                                        scanner.nextLine();
                                    }
                                }

                                switch (choix){
                                    case 1:
                                        displayMessage("Le Healer " + goodOne.getName() + " soigne " + heros.get(0).getName());
                                        goodOne.fight(heros.get(0));
                                        displayMessage("\tIl ne reste plus que " + ((SpellCaster) goodOne).getMana() + " points de Mana à votre Healer " + goodOne);
                                        break;

                                    case 2:
                                        displayMessage("Votre Healer " + goodOne + " boit une potion... Sa Mana est restaurée de 2 points !");
                                        ((SpellCaster) goodOne).setMana((((SpellCaster) goodOne).getMana())+2);
                                        displayMessage("\t" + goodOne + " possède désormais : " + ((SpellCaster) goodOne).getMana() + " points de Mana\n");
                                        break;
                                }

                            }

                            else {
                                displayMessage("Vous avez le choix entre :\n\t[1] Soigner un héros de votre équipe\n\t[2] Boire une potion (+ 2 points de Mana)");
                                int choix = 0 ;
                                boolean tmp5 = false;
                                while(!tmp5) {
                                    try {
                                        choix = scanner.nextInt();
                                        while (choix > 2 || choix <= 0) {
                                            System.out.println("Veuillez saisir une position valide...");
                                            choix = scanner.nextInt();
                                        }
                                        tmp5 = true;
                                    } catch (InputMismatchException e) {
                                        displayMessage("Exception" + e + ". Veuillez entrer un numéro valide");
                                        scanner.nextLine();
                                    }
                                }

                                switch (choix){
                                    case 1:
                                        // On affiche uniquement la liste où il n'y a pas d'Healer (un Healer ne peut pas se soigner lui-même !)
                                        displayMessage("Saisissez la position du héros que vous souhaitez soigner : " + notHealerList);
                                        int heroPosition = 0;
                                        boolean tmp6 = false;
                                        while(!tmp6) {
                                            try {
                                                heroPosition = scanner.nextInt();
                                                while (heroPosition > notHealerList.toArray().length || heroPosition <= 0) {
                                                    System.out.println("Veuillez saisir une position valide...");
                                                    heroPosition = scanner.nextInt();
                                                }
                                                tmp6 = true;
                                            } catch (InputMismatchException e) {
                                                displayMessage("Exception" + e + ". Veuillez entrer un numéro valide !");
                                                scanner.nextLine();
                                            }
                                        }
                                        displayMessage("Le Healer " + goodOne.getName() + " soigne " + heros.get(heroPosition - 1).getName());
                                        goodOne.fight(heros.get(heroPosition - 1));
                                        displayMessage("\tIl ne reste plus que " + ((SpellCaster) goodOne).getMana() + " points de Mana à votre Healer " + goodOne);
                                        break;

                                    case 2:
                                        displayMessage("Votre Healer " + goodOne + " boit une potion... Sa Mana est restaurée de 2 points !");
                                        ((SpellCaster) goodOne).setMana((((SpellCaster) goodOne).getMana())+2);
                                        displayMessage("\t" + goodOne + " possède désormais : " + ((SpellCaster) goodOne).getMana() + " points de Mana\n");
                                        break;
                                }
                            }
                        }

                        // Sinon : riposte d'un des héros
                        else {
                            displayMessage("Vous avez le choix entre :\n\t[1] Attaquer l'ennemi\n\t[2] Manger du lembas (+ " + goodOne.getFood().getPointLife() + " hp)");
                            if(goodOne instanceof SpellCaster) displayMessage("\t[3] Boire une potion pour restaurer de la mana (+ 2 points de Mana)");
                            int choice = 0;
                            boolean tmp = false;
                            while(!tmp) {
                                try {
                                    choice = scanner.nextInt();
                                    if (goodOne instanceof SpellCaster) {
                                        while (choice > 3 || choice <= 0) {
                                            System.out.println("Veuillez saisir une position valide...");
                                            choice = scanner.nextInt();
                                        }
                                    } else {
                                        while (choice > 2 || choice <= 0) {
                                            System.out.println("Veuillez saisir une position valide...");
                                            choice = scanner.nextInt();
                                        }
                                    }
                                    tmp = true;
                                } catch (InputMismatchException e) {
                                    displayMessage("Exception " + e + ". Saisir un numéro valide !");
                                    scanner.nextLine();
                                }
                            }

                            switch (choice){

                                case 1:
                                    displayMessage("Le gentil " + goodOne.getName()
                                            + " attaque le méchant " + badOne.getName() + "...");
                                    goodOne.fight(badOne);
                                    if(goodOne instanceof Hunter) displayMessage("\tIl ne reste plus que " + ((Hunter) goodOne).getArrowsNumber() + " flèches à votre Hunter " + goodOne);
                                    if(goodOne instanceof SpellCaster) displayMessage("\tIl ne reste plus que " + ((SpellCaster) goodOne).getMana() + " points de Mana à votre SpellCaster " + goodOne);
                                    break;

                                case 2:
                                    if(goodOne instanceof Warrior){
                                        displayMessage("Le héros " + goodOne + " mange du lemba... Il récupère " + lemba_warrior.getPointLife() + " hp !");
                                        goodOne.winLife(lemba_warrior.getPointLife());
                                    }

                                    if(goodOne instanceof Hunter){
                                        displayMessage("Le héros " + goodOne + " mange du lemba... Il récupère " + lemba_hunter.getPointLife() + " hp !");
                                        goodOne.winLife(lemba_hunter.getPointLife());
                                    }

                                    if(goodOne instanceof Mage){
                                        displayMessage("Le héros " + goodOne + " mange du lemba... Il récupère " + lemba_mage.getPointLife() + " hp !");
                                        goodOne.winLife(lemba_mage.getPointLife());
                                    }

                                    if(goodOne instanceof Healer){
                                        displayMessage("Le héros " + goodOne + " mange du lemba... Il récupère " + lemba_healer.getPointLife() + " hp !");
                                        goodOne.winLife(lemba_healer.getPointLife());
                                    }

                                    break;

                                case 3:
                                    displayMessage("Votre SpellCaster " + goodOne + " boit une potion... Sa Mana est restaurée de 2 points !");
                                    assert goodOne instanceof SpellCaster;
                                    ((SpellCaster) goodOne).setMana((((SpellCaster) goodOne).getMana())+2);
                                    displayMessage("\t" + goodOne + " possède désormais : " + ((SpellCaster) goodOne).getMana() + " points de Mana\n");
                                    break;
                            }
                        if (badOne.getHealthPoint() <= 0) {
                            displayMessage("Bravo, " + goodOne.getName()
                                    + " a vaincu " + badOne.getName() + " !!!");
                            enemies.remove(0);

                            // Faire un système de récompense : augmenter points de vie ou points de dégâts ou nbr de flèches/mana
                            if(enemies.size() != 0)
                                recompense(heros);
                        }
                        }
                    }
                    break;

                // Les héros commencent à attaquer
                case 0:

                    // Riposte du gentil, s'il n'est pas vaincu

                    //s'il s'agit d'un healer : il soigne l'un de ses partenaires
                    if(goodOne instanceof Healer){

                        // Création d'une liste de héros qui ne sont pas de type Healer
                        notHealerList = new ArrayList<>();
                        for(Combatant healer: heros){
                            if(!(healer instanceof Healer)){
                                notHealerList.add(healer);
                            }
                        }

                        //S'il ne reste plus que des Healer en lice, alors ils ne pourront soigner personne...
                        if(notHealerList.size() == 0) displayMessage("Il n'y a pas de héros à soigner : les Healer sont vulnérables...");

                        else if (notHealerList.size() == 1) {
                            displayMessage("Vous avez le choix entre :\n\t[1] Soigner un héros de votre équipe\n\t[2] Boire une potion (+ 2 points de Mana)");
                            int choix = 0;
                            boolean tmp = false;
                            while(!tmp) {
                                try {
                                    choix = scanner.nextInt();
                                    while (choix > 2 || choix <= 0) {
                                        System.out.println("Veuillez saisir une position valide...");
                                        choix = scanner.nextInt();
                                    }
                                    tmp = true;
                                } catch (InputMismatchException e) {
                                    displayMessage("Exception" + e + ". Veuillez entrer un numéro valide");
                                    scanner.nextLine();
                                }
                            }

                            switch (choix){
                                case 1:
                                    displayMessage("Le Healer " + goodOne.getName() + " soigne " + heros.get(0).getName());
                                    goodOne.fight(heros.get(0));
                                    displayMessage("\tIl ne reste plus que " + ((SpellCaster) goodOne).getMana() + " points de Mana à votre Healer " + goodOne);
                                    break;

                                case 2:
                                    displayMessage("Votre Healer " + goodOne + " boit une potion... Sa Mana est restaurée de 2 points !");
                                    ((SpellCaster) goodOne).setMana((((SpellCaster) goodOne).getMana())+2);
                                    displayMessage("\t" + goodOne + " possède désormais : " + ((SpellCaster) goodOne).getMana() + " points de Mana\n");
                                    break;
                            }

                        }

                        else {
                            displayMessage("Vous avez le choix entre :\n\t[1] Soigner un héros de votre équipe\n\t[2] Boire une potion (+ 2 points de Mana)");
                            int choix = 0;
                            boolean tmp = false;
                            while(!tmp) {
                                try {
                                    choix = scanner.nextInt();
                                    while (choix > 2 || choix <= 0) {
                                        System.out.println("Veuillez saisir une position valide...");
                                        choix = scanner.nextInt();
                                    }
                                    tmp = true;
                                } catch (InputMismatchException e) {
                                    displayMessage("Exception" + e + ". Veuillez entrer un numéro valide");
                                    scanner.nextLine();
                                }
                            }

                            switch (choix){
                                case 1:
                                    // On affiche uniquement la liste où il n'y a pas d'Healer (un Healer ne peut pas se soigner lui-même !)
                                    displayMessage("Saisissez la position du héros que vous souhaitez soigner : " + notHealerList);
                                    int heroPosition = 0;
                                    boolean tmp6 = false;
                                    while(!tmp6) {
                                        try {
                                            heroPosition = scanner.nextInt();
                                            while (heroPosition > notHealerList.toArray().length || heroPosition <= 0) {
                                                System.out.println("Veuillez saisir une position valide...");
                                                heroPosition = scanner.nextInt();
                                            }
                                            tmp6 = true;
                                        } catch (InputMismatchException e) {
                                            displayMessage("Exception" + e + ". Veuillez entrer un numéro valide !");
                                            scanner.nextLine();
                                        }
                                    }
                                    displayMessage("Le Healer " + goodOne.getName() + " soigne " + heros.get(heroPosition - 1).getName());
                                    goodOne.fight(heros.get(heroPosition - 1));
                                    displayMessage("\tIl ne reste plus que " + ((SpellCaster) goodOne).getMana() + " points de Mana à votre Healer " + goodOne);
                                    break;

                                case 2:
                                    displayMessage("Votre Healer " + goodOne + " boit une potion... Sa Mana est restaurée de 2 points !");
                                    ((SpellCaster) goodOne).setMana((((SpellCaster) goodOne).getMana())+2);
                                    displayMessage("\t" + goodOne + " possède désormais : " + ((SpellCaster) goodOne).getMana() + " points de Mana\n");
                                    break;
                            }
                        }
                    }
                    // Sinon riposte classique d'un des héros
                    else{
                        displayMessage("Vous avez le choix entre :\n\t[1] Attaquer l'ennemi\n\t[2] Manger du lembas (+ " + goodOne.getFood().getPointLife() + " hp)");
                        if(goodOne instanceof SpellCaster) displayMessage("\t[3] Boire une potion pour restaurer de la mana");
                        int choice = 0;
                        boolean tmp = false;
                        while(!tmp) {
                            try {
                                choice = scanner.nextInt();
                                if (goodOne instanceof SpellCaster) {
                                    while (choice > 3 || choice <= 0) {
                                        System.out.println("Veuillez saisir une position valide...");
                                        choice = scanner.nextInt();
                                    }
                                } else {
                                    while (choice > 2 || choice <= 0) {
                                        System.out.println("Veuillez saisir une position valide...");
                                        choice = scanner.nextInt();
                                    }
                                }
                                tmp = true;
                            } catch (InputMismatchException e) {
                                displayMessage("Exception" + e + ". Veuillez entrer un numéro valide");
                                scanner.nextLine();
                            }
                        }

                        switch(choice) {

                            case 1:
                                displayMessage("Le gentil " + goodOne.getName()
                                        + " attaque le méchant " + badOne.getName() + "...");
                                goodOne.fight(badOne);
                                if(goodOne instanceof Hunter) displayMessage("\tIl ne reste plus que " + ((Hunter) goodOne).getArrowsNumber() + " flèches à votre Hunter " + goodOne);
                                if(goodOne instanceof SpellCaster) displayMessage("\tIl ne reste plus que " + ((SpellCaster) goodOne).getMana() + " points de Mana à votre SpellCaster " + goodOne);
                                break;

                            case 2:
                                if(goodOne instanceof Warrior){
                                    displayMessage("Le héros " + goodOne + " mange du lemba... Il récupère " + lemba_warrior.getPointLife() + " hp !");
                                    goodOne.winLife(lemba_warrior.getPointLife());
                                }

                                if(goodOne instanceof Hunter){
                                    displayMessage("Le héros " + goodOne + " mange du lemba... Il récupère " + lemba_hunter.getPointLife() + " hp !");
                                    goodOne.winLife(lemba_hunter.getPointLife());
                                }

                                if(goodOne instanceof Mage){
                                    displayMessage("Le héros " + goodOne + " mange du lemba... Il récupère " + lemba_mage.getPointLife() + " hp !");
                                    goodOne.winLife(lemba_mage.getPointLife());
                                }

                                if(goodOne instanceof Healer){
                                    displayMessage("Le héros " + goodOne + " mange du lemba... Il récupère " + lemba_healer.getPointLife() + " hp !");
                                    goodOne.winLife(lemba_healer.getPointLife());
                                }
                                break;

                            case 3:
                                displayMessage("Votre SpellCaster " + goodOne + " boit une potion... Sa Mana est restaurée de 2 points !");
                                assert goodOne instanceof SpellCaster;
                                ((SpellCaster) goodOne).setMana((((SpellCaster) goodOne).getMana())+2);
                                displayMessage("\t" + goodOne + " possède désormais : " + ((SpellCaster) goodOne).getMana() + " points de Mana\n");
                                break;
                        }
                    }

                    if (badOne.getHealthPoint() <= 0) {
                        displayMessage("Bravo, " + goodOne.getName() + " a vaincu " + badOne.getName() + " !!!");
                        enemies.remove(0);

                        // Système de récompense : augmenter points de vie ou points de dégâts ou nbr de flèches/mana
                        if(enemies.size() != 0)
                            recompense(heros);
                    }
                    else {

                        // Riposte du méchant, s'il n'est pas vaincu
                        displayMessage("Le méchant " + badOne.getName()
                                + " attaque le gentil " + goodOne.getName() + "...");
                        badOne.fight(goodOne);
                        if (goodOne.getHealthPoint() <= 0) {
                            displayMessage("Le pauvre " + goodOne.getName() + " a été vaincu...");
                            heros.remove(ixHero-1);
                            ixHero--; // Correction : évite que le suivant perde son tour
                        }
                    }
            }

            // Tests de fin du jeu
            if (heros.size() == 0) {
                displayMessage("Les héros ont perdu, c'est la fin du monde...");
                break;
            }
            if (enemies.size() == 0) {
                displayMessage("BRAVO, les héros ont gagné, le monde est sauvé !!!");
                break;
            }

            // Au tour du héros suivant
            ixHero = (ixHero + 1) % heros.size();
            nbr_tours++;
        }
    }


    private InputParser inputParser;

    private final List<Hero> heros;
    private List<Combatant> notHealerList;
    private final List<Combatant> enemies;

    // Attributs code ANSI pour couleur sur le texte en console
    public static final String ANSI_RESET = "\u001B[0m";
    public static final String ANSI_RED = "\u001B[31m";
    public static final String ANSI_GREEN = "\u001B[32m";



    // Méthodes d'affichage
    // (STATIQUES pour pouvoir les appeler depuis n'importe où dans le programme)
    //
    // => pourraient éventuellement être déplacées dans le package
    //    "com.isep.utils", en s'inspirant de "InputParser" (méthodes de saisie)

    public static void displayStatus(List<Hero> h, List<Combatant> e) {
        System.out.println("################################ S T A T U T ##################################");
        System.out.print(ANSI_GREEN + "HÉROS  : " + ANSI_RESET);
        for (Combatant c: h) {
            System.out.print(ANSI_GREEN + c.getName() + "(" + c.getHealthPoint() + " hp) " + ANSI_RESET);
        }
        System.out.println();
        System.out.print(ANSI_RED + "ENNEMIS : " + ANSI_RESET );
        for (Combatant c: e) {
            System.out.print(ANSI_RED + c.getName() + "(" + c.getHealthPoint() + " hp) " + ANSI_RESET);
        }
        System.out.println("\n###############################################################################\n");
    }

    public static void displayMessage(String message) {
        System.out.println(message);
    }

    public static void displayRecapitulatif(Hero hero, String arme, int degats){
        displayMessage("\t Vous venez de choisir " + hero.toString() + " avec l'arme " + arme + " qui inflige " + degats + " points de dégâts !");
    }

    public static void recompense(List<Hero> heros){
        displayMessage("\nVous avez remporté un combat ! Choisissez le numéro de la récompense souhaitée : ");
        displayMessage("\t[1] Augmenter de 1 hp la vie de tous les héros restants\n\t" +
                "[2] Rajouter 2 flèches à l'un des Hunter de l'équipe\n\t[3] Augmenter de 1 point de dégâts l'attaque d'un de vos héros" +
                "\n\t[4] Augmenter la mana des lanceurs de sorts \n\t[5] Augmenter l'efficacité de la nourriture (+1hp)");
        Scanner sc           = new Scanner(System.in);
        int choiceRecompense = 0;
        boolean tmp          = false;
        while(!tmp) {
            try {
                choiceRecompense = sc.nextInt();
                while (choiceRecompense > 5 || choiceRecompense <= 0) {
                    displayMessage("Saisissez un nombre valide pour récupérer votre récompense !");
                    choiceRecompense = sc.nextInt();
                }
                tmp = true;
            } catch (InputMismatchException e) {
                displayMessage("Exception :" + e + ". Saisissez un nombre valide svp");
                sc.nextLine();
            }
        }

        switch (choiceRecompense){
            case 1:
                for(Combatant c: heros){
                    c.winLife(1);
                }
                displayMessage("\tLa vie de tous vos héros est augmentée de 1 hp");
                break;

            case 2:
                List<Combatant> hunterList = new ArrayList<>();
                for(Combatant c: heros){
                    if(c instanceof Hunter) hunterList.add(c);
                }
                if(hunterList.size() == 0){
                    displayMessage("Il n'y a aucun Hunter dans votre équipe...");
                    recompense(heros);
                } else if (hunterList.size() == 1) {
                    ((Hunter) hunterList.get(0)).setArrowsNumber(((Hunter) hunterList.get(0)).getArrowsNumber() + 2);
                    System.out.println(("\t" + hunterList.get(0) + " possède désormais " + ((Hunter) hunterList.get(0)).getArrowsNumber() + " flèches !"));
                }
                else {
                    displayMessage("Quel Hunter choisissez vous ? Saisir sa position : " + hunterList);
                    int positionRecompense = sc.nextInt();
                    ((Hunter) hunterList.get(positionRecompense - 1)).setArrowsNumber(((Hunter) hunterList.get(positionRecompense - 1)).getArrowsNumber() + 2);
                    System.out.println(("\t" + hunterList.get(positionRecompense - 1) + " possède désormais " + ((Hunter) hunterList.get(positionRecompense - 1)).getArrowsNumber() + " flèches !"));
                }
                break;

            case 3:
                displayMessage("Quel héros choisissez vous ? Saisir sa position : " + heros);
                int positionHero = 0;
                boolean b = false;
                while(!b){
                    try{
                        positionHero = sc.nextInt();
                        while (positionHero > heros.toArray().length || positionHero <= 0) {
                            displayMessage("Saisissez un nombre valide pour récupérer votre récompense !");
                            positionHero = sc.nextInt();
                        }
                        b = true;
                    }
                    catch (InputMismatchException | IndexOutOfBoundsException e){
                        displayMessage("Saisissez un numéro valide svp");
                        sc.nextLine();
                    }
                }
                if(heros.get(positionHero-1) instanceof Healer){
                    ((Healer) heros.get(positionHero-1)).setCarePoints(((Healer) heros.get(positionHero-1)).getCarePoints()+1);
                    displayMessage("\tVotre Healer " + heros.get(positionHero - 1) + " soigne désormais de " + ((Healer) heros.get(positionHero-1)).getCarePoints() + " points !" );
                }
                else {
                    heros.get(positionHero - 1).getWeapon().setDamagePoints(heros.get(positionHero - 1).getWeapon().getDamagePoints() + 1);
                    displayMessage("\tVotre Héros " + heros.get(positionHero - 1) + " inflige désormais : " + heros.get(positionHero - 1).getWeapon().getDamagePoints() + " points de dégâts !");
                }
                break;

            case 4:
                List<Hero> spellCasterList = new ArrayList<>();
                for(Hero c: heros){
                    if(c instanceof SpellCaster) spellCasterList.add(c);
                }
                if(spellCasterList.size() == 0){
                    displayMessage("Il n'y a aucun lanceur de sorts dans votre équipe...");
                    recompense(heros);
                } else if (spellCasterList.size() == 1) {
                    ((SpellCaster) spellCasterList.get(0)).setMana(((SpellCaster) spellCasterList.get(0)).getMana() + 2);
                    System.out.println(("\t" + spellCasterList.get(0) + " possède désormais " + ((SpellCaster) spellCasterList.get(0)).getMana() + " de mana !"));
                }
                else {
                    displayMessage("Quel lanceur de sorts choisissez vous ? Saisir sa position : " + spellCasterList);
                    int positionRecompense;
                    boolean tmpp = false;
                    while (!tmpp) {
                        try {
                            positionRecompense = sc.nextInt();
                            while (positionRecompense <= 0 || positionRecompense > spellCasterList.toArray().length) {
                                displayMessage("Saisir une position valide svp");
                                positionRecompense = sc.nextInt();
                            }
                            ((SpellCaster) spellCasterList.get(positionRecompense - 1)).setMana(((SpellCaster) spellCasterList.get(0)).getMana() + 2);
                            displayMessage(("\t Votre SpellCaster " + spellCasterList.get(positionRecompense - 1) + " possède désormais " + ((SpellCaster) spellCasterList.get(positionRecompense - 1)).getMana() + " points de Mana !"));
                            tmpp = true;
                        } catch (InputMismatchException e) {
                            displayMessage("Exception : " + e + ". Saisissez une position valide !");
                            sc.nextLine();
                        }
                    }
                }
                break;

            case 5:
                displayMessage("Choisissez le héros pour  lequel vous voulez augmenter l'efficacité de la nourriture : " + heros);
                tmp = false;
                while(!tmp){
                    try{
                        int foodIncrease = sc.nextInt();
                        while(foodIncrease > heros.toArray().length || foodIncrease <= 0){
                            displayMessage("Choisissez un nombre valide svp !");
                            foodIncrease = sc.nextInt();
                        }
                        heros.get(foodIncrease-1).getFood().setPointLifeFood(heros.get(foodIncrease-1).getFood().getPointLife()+1);
                        displayMessage("Votre héros " + heros.get(foodIncrease-1) + " peut désormais gagner " + heros.get(foodIncrease-1).getFood().getPointLife() + " hp en mangeant du lemba !");
                        tmp = true;
                    }
                    catch (InputMismatchException e){
                        displayMessage("Saisissez un nombre valide svp ...");
                        sc.nextLine();
                    }
                }
                break;
        }
    }
}
