
//ALL OF THESE ARE NECESSARY, EVEN THE ONES IT SAYS ARE NOT BEING USED

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Scanner;
import javax.swing.*;
import java.util.Random;
import javax.swing.BorderFactory;
import java.awt.Color;
import javax.swing.border.Border;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import javax.imageio.ImageIO;
import javax.swing.BorderFactory;
import java.awt.Color;
import javax.swing.border.Border;
import javax.swing.JOptionPane;
import java.util.*;


public class DungeonTest {

    //just getting basic variables initialized
    Random rand = new Random();
    public int heroX = 210;
    public int heroY = 200;
    public String[] forestMonsters = new String[10];
    public int[] forestAttackStrengths = new int[10];
    public int[] forestLootDrops = new int[10];
    public String[] lootDropCorrespondanceForest = new String[100];

    public int playerClassNum;
    public String[] classes = new String[6];
    public int loot1 = 0;


    public static void main(String[] args) {
        new DungeonTest();
    }

    public DungeonTest() {
        start();
    }

    public void start() {

        //gets the class of ONE player (EXPAND SOMEHOW) also gonna need more loot# tags and a way to switch them somehow

        String[] buttons = {"Cleric", "Fighter", "Rogue", "Wizard"};
        playerClassNum = JOptionPane.showOptionDialog(null, "Narrative", "Narrative",
                JOptionPane.INFORMATION_MESSAGE, 0, null, buttons, buttons[0]);






        forestMonsters[0] = "Rodent of Unusual Size";
        forestMonsters[1] = "Venomous Snake";
        forestMonsters[2] = "Goblin Scout";
        forestMonsters[3] = "Goblin";

        //numbers mean cleric, fighter, rogue, wizard, fireball, lightning bolt fight strength
        //all are minus four so I can get 13s

        forestAttackStrengths[0] = 213300;
        forestAttackStrengths[1] = 431201;
        forestAttackStrengths[2] = 432301;
        forestAttackStrengths[3] = 333300;

        forestLootDrops[0] = 5;
        forestLootDrops[1] = 5;
        forestLootDrops[2] = 10;
        forestLootDrops[3] = 10;
        forestLootDrops[4] = 10;
        forestLootDrops[5] = 15;
        forestLootDrops[6] = 15;
        forestLootDrops[7] = 20;
        forestLootDrops[8] = 25;
        forestLootDrops[9] = 30;
        forestLootDrops[9] = 50;

        lootDropCorrespondanceForest[5] = "pelt";

        lootDropCorrespondanceForest[10] = "hunting trophy";

        lootDropCorrespondanceForest[15] = "brass necklace";

        lootDropCorrespondanceForest[20] = "worn bracer";

        lootDropCorrespondanceForest[25] = "silver ring";

        lootDropCorrespondanceForest[30] = "brass headpiece";

        //add 35, 40, 45

        lootDropCorrespondanceForest[50] = "noble's cape";


        classes[0] = "Cleric";
        classes[1] = "Fighter";
        classes[2] = "Rogue";
        classes[3] = "Wizard";


        //this gets all the menus working
        JFrame mapBase=new JFrame("Dungeon!");
        mapBase.setSize(600,600);
        mapBase.setLayout(null);
        mapBase.setVisible(true);


        JLayeredPane mapStacks = new JLayeredPane();
        mapStacks.setSize(600,600);
        mapStacks.setVisible(true);
        mapBase.add(mapStacks);

        JLabel player1Loot = new JLabel("");
        player1Loot.setBounds(495,5,100,85);
        player1Loot.setLayout(null);
        player1Loot.setVisible(true);
        Border scoreBoardBorder = BorderFactory.createLineBorder(Color.BLACK, 3);
        player1Loot.setBorder(scoreBoardBorder);
        mapStacks.add(player1Loot);

        JLabel playerOneTitle = new JLabel(" Player One");
        playerOneTitle.setBounds(5,5,80,20);
        Border winsDisplay = BorderFactory.createLineBorder(Color.GRAY, 1);
        playerOneTitle.setBorder(winsDisplay);
        player1Loot.add(playerOneTitle);
        playerOneTitle.setLayout(null);
        playerOneTitle.setVisible(true);

        JLabel playerOneClass = new JLabel(" " + classes[playerClassNum]);
        playerOneClass.setBounds(5,30,80,20);
        playerOneClass.setBorder(winsDisplay);
        player1Loot.add(playerOneClass);
        playerOneClass.setLayout(null);
        playerOneClass.setVisible(true);

        JLabel playerOneLOOTDISPLAY = new JLabel(" " + loot1 + " gp");
        playerOneLOOTDISPLAY.setBounds(5,55,80,20);
        playerOneLOOTDISPLAY.setBorder(winsDisplay);
        player1Loot.add(playerOneLOOTDISPLAY);
        playerOneLOOTDISPLAY.setLayout(null);
        playerOneLOOTDISPLAY.setVisible(true);

        //set names to null so that they can be used
        BufferedImage village = null;
        BufferedImage road = null;
        BufferedImage hero = null;
        BufferedImage forest = null;

        //gets the images working.
            //TO INSERT A NEW IMAGE: get the file path of the new object in folder, set it as a name using the below method,
            // then do a    ImageIcon NEW_NAME_FOR_ICON = new ImageIcon(ICON_NAME_AS_SUBMITTED);
            //oh yeah, also set the name to null beforehand.
        try
        {
            village = ImageIO.read(new File("/Users/graham/IdeaProjects/Dungeon!/src/Village.jpeg"));
            road = ImageIO.read(new File("/Users/graham/IdeaProjects/Dungeon!/src/Road.png"));
            hero = ImageIO.read(new File("/Users/graham/IdeaProjects/Dungeon!/src/hero.jpg"));
            forest = ImageIO.read(new File("/Users/graham/IdeaProjects/Dungeon!/src/Forest.png"));


        }
        catch (Exception e)
        {
            e.printStackTrace();
            System.exit(1);
        }


        //all of these have locator text: int 1 -5 is x, int 2 -5 is y, char 3 is type of tile

        ImageIcon villageIcon = new ImageIcon(village);
        JButton villageButton = new JButton("5_5 v");
        villageButton.setIcon(villageIcon);
        villageButton.setBounds(200,200,50,50);
        Border buttonBorder = BorderFactory.createLineBorder(Color.BLACK, 3);
        villageButton.setBorder(buttonBorder);
        mapStacks.add(villageButton);

        ImageIcon roadIcon = new ImageIcon(road);
        JButton roadButton1_0 = new JButton("6_5 r");
        roadButton1_0.setIcon(roadIcon);
        roadButton1_0.setBounds(255,200,50,50);
        roadButton1_0.setBorder(buttonBorder);
        mapStacks.add(roadButton1_0);


        JButton roadButton2_0 = new JButton("7_5 r");
        roadButton2_0.setIcon(roadIcon);
        roadButton2_0.setBounds(310,200,50,50);
        roadButton2_0.setBorder(buttonBorder);
        mapStacks.add(roadButton2_0);

        JButton roadButton2_2 = new JButton("7_7 r");
        roadButton2_2.setIcon(roadIcon);
        roadButton2_2.setBounds(310,310,50,50);
        roadButton2_2.setBorder(buttonBorder);
        mapStacks.add(roadButton2_2);

        JButton roadButton0_1 = new JButton("5_6 r");
        roadButton0_1.setIcon(roadIcon);
        roadButton0_1.setBounds(200,255,50,50);
        roadButton0_1.setBorder(buttonBorder);
        mapStacks.add(roadButton0_1);

        JButton roadButton0_2 = new JButton("5_7 r");
        roadButton0_2.setIcon(roadIcon);
        roadButton0_2.setBounds(200,310,50,50);
        roadButton0_2.setBorder(buttonBorder);
        mapStacks.add(roadButton0_2);

        JButton roadButton0_3 = new JButton("5_8 r");
        roadButton0_3.setIcon(roadIcon);
        roadButton0_3.setBounds(200,365,50,50);
        roadButton0_3.setBorder(buttonBorder);
        mapStacks.add(roadButton0_3);

        ImageIcon forestIcon = new ImageIcon(forest);
        JButton forestButton2_1 = new JButton("7_6 f");
        forestButton2_1.setIcon(forestIcon);
        forestButton2_1.setBounds(310,255,50,50);
        forestButton2_1.setBorder(buttonBorder);
        mapStacks.add(forestButton2_1);

        //DungeonTest ROUS = new DungeonTest();
        //char defenseF.ROUS =s

        ImageIcon heroIcon = new ImageIcon(hero);
        JLabel heroPlace = new JLabel();
        heroPlace.setIcon(heroIcon);
        heroPlace.setBounds(210,200,50,50);
        mapStacks.add(heroPlace);


        //all the actionlisteners must be enabled
        roadButton1_0.addActionListener(roadClicked);
        roadButton2_0.addActionListener(roadClicked);
        roadButton2_2.addActionListener(roadClicked);
        roadButton0_1.addActionListener(roadClicked);
        roadButton0_2.addActionListener(roadClicked);
        roadButton0_3.addActionListener(roadClicked);

        villageButton.addActionListener(roadClicked);

        forestButton2_1.addActionListener(roadClicked);




        while (1 == 1) {

            //every quarter second it checks and updates stuff
            try {
                Thread.sleep(250);
            } catch (InterruptedException ex) {
                // Stop immediately and go home
            }

            heroPlace.setBounds(heroX,heroY,50,50);
            mapStacks.moveToFront(heroPlace);
            playerOneLOOTDISPLAY.setText(" " + loot1 + " gp");
            //heroPlace.setLayer('1');
        }







    }

    ActionListener roadClicked = new ActionListener() {
        public void actionPerformed(ActionEvent clicked) {

            //converts movement of clicked tile using the two integers in the names that relate to position
            int movingWorks = 0;

            int newX = clicked.getActionCommand().charAt(0);
            newX = newX - 53;
            newX = newX * 55;
            newX = newX + 210;
            System.out.println(newX);
            if (heroX + 55 == newX || heroX - 55 == newX || heroX == newX) {
                movingWorks++;
            }


            int newY = clicked.getActionCommand().charAt(2);
            newY = newY - 53;
            newY = newY * 55;
            newY= newY + 200;
            System.out.println(newY);
            if (heroY + 55 == newY || heroY - 55 == newY || heroY == newY) {
                movingWorks++;
            }


            //this next bit makes it so that it cannot cut corners by checking if it would move both
            //along the Y and the X. Does the same to prevent players sitting on a square and farming.
            if (heroY + 55 == newY && heroX + 55 == newX) {
                movingWorks--;
            }
            if (heroY - 55 == newY && heroX - 55 == newX) {
                movingWorks--;
            }
            if (heroY + 55 == newY && heroX - 55 == newX) {
                movingWorks--;
            }
            if (heroY - 55 == newY && heroX + 55 == newX) {
                movingWorks--;
            }
            if (heroY - 55 == newY && heroX + 55 == newX) {
                movingWorks--;
            }
            if (heroY == newY && heroX == newX) {
                movingWorks--;
            }

            //if everything is operational, it lets the piece move.
            if (movingWorks == 2) {
                heroY = newY;
                heroX = newX;
                char locationType = clicked.getActionCommand().charAt(4);
                battle(locationType);
            }


            //just in case
            movingWorks = 0;





        }

    };

    public void battle(char locationType) {


        if (locationType == 'f') {
            int forestMonster = rand.nextInt(4);
            String attacker = forestMonsters[forestMonster];
            JOptionPane.showMessageDialog(null,
                    "You are attacked by a " + attacker + "!",
                    "Battle!",
                    JOptionPane.QUESTION_MESSAGE
            );


            int attackStrength = forestAttackStrengths[forestMonster];
            String attackConverterSTAGEONE = attackStrength + "";
            //extracts their class from the array.
            char attackConverter = attackConverterSTAGEONE.charAt(playerClassNum);
            attackStrength = attackConverter - '0';
            //adds in four so that I can get 13, ie impossible difficulty, in one char.
            attackStrength = attackStrength + 4;
            //rolls 2d6 and compares it to your attack strength vs. the monsters. From there, either you win and it rolls
            //to check for loot, or you lose and you roll to lose loot.
            int result = roll2d6();

            //if you win, it gives you a Victory! popup and rolls on the loot table
            if (result > attackStrength) {
                JOptionPane.showMessageDialog(null,
                        "You slay the " + attacker + "!",
                        "Victory!",
                        JOptionPane.INFORMATION_MESSAGE
                );

                int reward = forestLootDrops[rand.nextInt(10)];

                //loot drop correspondance is a table that has a name based on GP worth count
                JOptionPane.showMessageDialog(null,
                        "You find a " + lootDropCorrespondanceForest[reward] + " worth " + reward + " gold pieces!",
                        "Loot",
                        JOptionPane.INFORMATION_MESSAGE
                );

                loot1 = loot1 + reward;

            }
            //if you fail to fight, it gives you a Defeat! message and rolls on the damage table
            else {
                JOptionPane.showMessageDialog(null,
                        "The " + attacker + " eats your face!",
                        "Defeat!",
                        JOptionPane.ERROR_MESSAGE
                );

                damage();
            }


        }
    }

    //rolls 2d6
    public int roll2d6() {
        int result = (rand.nextInt(6) + 1) + (rand.nextInt(6) + 1);
        return result;
    }

    //rolls on the damage table if you fail to fight
    public void damage() {
        int roll = roll2d6();


        //While I know the damage table does not accurately represent that from the game, unless you want to make a backlog
        //of loot, (Which you could) it isn't going to really capture the losing random crap dynamic from the game.

        //On a similiar note, some of these have features yet unimplemented due to needing multiplayer to function.

        String hitTitle = "There has been a horrible mistake.";
        String hitDialogue = "There has been a horrible mistake.";
        int losses = 0;

        if (roll < 6) {
            hitTitle = "Miss!";
            hitDialogue = "No effect.";
        }

        if (roll > 5 && roll < 8) {
            hitTitle = "Stunned!";
            hitDialogue = "Drop some of your treasure.";
            losses = rand.nextInt(loot1 - 10);
        }

        if (roll > 7 && roll < 11) {
            hitTitle = "Wounded!";
            hitDialogue = "Drop some treasure, be pushed back a square, and lose your next turn.";
            losses = rand.nextInt(loot1 - 5);
        }

        if (roll > 10 && roll < 12) {
            hitTitle = "Seriously Wounded!";
            hitDialogue = "Drop a lot of your treasure and move back to the village.";
            losses = rand.nextInt(loot1);
            heroX = 200;
            heroY = 200;
        }

        if (roll == 12) {
            hitTitle = "Killed!";
            hitDialogue = "You are dead. Drop all your treasure, return to the village, and choose a new character.";
            loot1 = 0;
            heroX = 200;
            heroY = 200;
        }

        //little popup with the text based on die roll to tell you what just happened
        JOptionPane.showMessageDialog(null,
                hitDialogue,
                hitTitle,
                JOptionPane.ERROR_MESSAGE
        );

        loot1 = loot1 - losses;
        if (loot1 < 0) {
            loot1 = 0;
        }

    }


}
