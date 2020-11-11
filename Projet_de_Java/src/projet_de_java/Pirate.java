/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package projet_de_java;

/**
 * Classe définissant un type de bateau comme étant un pirate.
 * Un pirate a donc un bounty et hérite des mêmes attributs que la classe Ship.
 * 
 * @see Ship
 * 
 * @author Jimmy, Arnaud
 */
public class Pirate extends Ship{

    /**
     * Bounty est la variable qui contient la prime d'un bateau pirate.
     * Bounty passe à 0 quand le bateau en question est coulé.
     */
    protected int bounty;
    
    /**
     * Contructeur de la classe Pirate contenant le nom du pirate.
     * 
     * @param name
     *      le nom du pirate
     */
    protected Pirate(String name){
        this.nom = name;
    }
    

    /**
     * Méthode permettant à un pirate d'attaquer un trader.
     * 
     * @param pirate
     *      le pirate qui déclare l'attaque
     * @param ship
     *      le trader victime de l'attaque
     * 
     * @see Trader
     */
    protected void attack(Pirate pirate, Trader ship){

        if(ship.menace < pirate.menace){ 
            pirate.bounty += ship.treasure; 
            ship.treasure = 0;
            ship.sink = true;
            System.out.println("Le " + ship.nom + " s'est fait couler par " + pirate.nom + " et remporte son butin");
        }
        else if(ship.menace >= pirate.menace){
            ship.treasure += pirate.bounty;
            pirate.bounty = 0;
            pirate.sink = true;
            System.out.println("Incroyable ! " + ship.nom + " a réussi à couler " + pirate.nom + " et gagne son bounty");
        }
        
    }
    
    //Dans le cas où un pirate veut attaquer un trader et qu'il est en fait corrompu
    // la différence est que le trader corrompu aura 4 de menace alors que les traders basiques entre 0 et 2 compris
    /*protected void attack(Pirate pirate, Corrupted_trader ship){
        
        
        if(ship.menace <= pirate.menace ){
            pirate.bounty += ship.treasure; 
            ship.treasure = 0;
            ship.sink = true;
            System.out.println("Le " + ship.nom + " qui était corrompu s'est fait couler par " + pirate.nom + " et remporte son butin");

        }
        else if(ship.menace > pirate.menace){
            ship.treasure += pirate.bounty;
            pirate.bounty = 0;
            pirate.sink = true;
            System.out.println("Incroyable ! " + ship.nom + " qui était corrompu a réussi à couler " + pirate.nom + " et gagne son bounty");
        }
   
    }*/
    

    /**
     * Méthode permettant à un pirate d'attaquer un autre pirate.
     * 
     * @param pirate
     *      le pirate qui déclare l'attaque
     * @param ship
     *      le pirate victime de l'attaque
     */
    protected void attack(Pirate pirate, Pirate ship){
       
        if(ship.menace < pirate.menace ){
            pirate.bounty += ship.bounty; 
            ship.bounty = 0;
            ship.sink = true;
            System.out.println(ship.nom + " s'est fait couler par " + pirate.nom + " et remporte son butin");

        }
        else if(ship.menace > pirate.menace){
            ship.bounty += pirate.bounty;
            pirate.bounty = 0;
            pirate.sink = true;
            System.out.println(pirate.nom + " s'est fait couler par " + ship.nom + " et remporte son butin");
        }
        else{
            int luck = (int)(Math.random()*2);
            if(luck==0){
                pirate.bounty += ship.bounty; 
                ship.bounty = 0;
                ship.sink = true;
                System.out.println(ship.nom + " s'est fait couler par " + pirate.nom + " et remporte son butin alors qu'il était tout aussi menaçant");
            }
            else{
                ship.bounty += pirate.bounty;
                pirate.bounty = 0;
                pirate.sink = true;
                System.out.println(pirate.nom + " s'est fait couler par " + ship.nom + " et remporte son butin alors qu'il était tout aussi menaçant");
            }
            
        }   
    }
}
   
