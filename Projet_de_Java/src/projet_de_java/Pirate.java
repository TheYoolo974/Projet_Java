/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package projet_de_java;

/**
 *
 * @author Jimmy
 */
public class Pirate extends Ship{
    int bounty;
    
   
    public Pirate(String name){
        this.nom = name;
    }
    
    //Dans le cas où un pirate veut attaquer un trader
    public static void attack(Pirate pirate, Trader ship){

        if(ship.menace <= pirate.menace){ 
            pirate.bounty += ship.treasure; 
            ship.treasure = 0;
            ship.sink = true;
            System.out.println("Le " + ship + " s'est fait couler par " + pirate + " et remporte son butin");
        }
        else if(ship.menace > pirate.menace){
            ship.treasure += pirate.bounty;
            pirate.bounty = 0;
            pirate.sink = true;
            System.out.println("Incroyable ! " + ship + " a réussi à couler " + pirate + " et gagne son bounty");
        }
        
    }
    
    //Dans le cas où un pirate veut attaquer un trader et qu'il est en fait corrompu
    // la différence est que le trader corrompu aura 4 de menace alors que les traders basiques entre 0 et 2 compris
     public static void attack(Pirate pirate, Corrupted_trader ship){
        
        
        if(ship.menace <= pirate.menace ){
            pirate.bounty += ship.treasure; 
            ship.treasure = 0;
            ship.sink = true;
            System.out.println("Le " + ship + " qui était corrompu s'est fait couler par " + pirate + " et remporte son butin");

        }
        else if(ship.menace > pirate.menace){
            ship.treasure += pirate.bounty;
            pirate.bounty = 0;
            pirate.sink = true;
            System.out.println("Incroyable ! " + ship + " qui était corrompu a réussi à couler " + pirate + " et gagne son bounty");
        }
   
    }
    
    //Dans le cas où un pirate veut attaquer un autre pirate
    public static void attack(Pirate pirate, Pirate ship){
       
        if(ship.menace <= pirate.menace ){
            pirate.bounty += ship.bounty; 
            ship.bounty = 0;
            ship.sink = true;
            System.out.println(ship + " s'est fait couler par " + pirate + " et remporte son butin");

        }
        else if(ship.menace > pirate.menace){
            ship.bounty += pirate.bounty;
            pirate.bounty = 0;
            pirate.sink = true;
            System.out.println(pirate + " s'est fait couler par " + ship + " et remporte son butin");
        }
        
    }

}
   
