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
public class Police extends Ship {
    int taxes =0;
    
    
    
    public Police(String name){
        this.nom = name;
    }
    
    
    public static void arrest(Police policier,Pirate pirate){
        if(policier.menace>=pirate.menace){
            policier.taxes+=pirate.bounty;
            pirate.bounty = 0;
            pirate.sink=true;
            System.out.println(policier + " a arrêté l'équipage de " + pirate + " et l'a donc coulé");
        }
        else if(policier.menace<pirate.menace){
            pirate.bounty+=policier.taxes;
            policier.taxes = 0;
            policier.sink=true;
            System.out.println("Misère ! " + pirate + " a coulé " + policier + " et récupère son contenu");
        }
    }
    
    public static void taxe(Police policier, Trader trader){
        policier.taxes+=0.4*trader.treasure;
        System.out.println("La taxe de " + policier + " par " + trader + " s'est bien passée");
    }
    
    public static void taxe(Police policier, Corrupted_trader trader){
        int luck = (int)(Math.random());
        if(luck==0){
            policier.taxes+=trader.treasure+trader.bounty;
            trader.revealed=true;
            trader.sink = true;
            System.out.println("Le " + trader + " était corrumpu et s'est fait couler par " + policier + " !");
        }
        else{
            policier.taxes += 0.4*trader.treasure;
            System.out.println("La taxe de " + policier + " par " + trader + " s'est bien passée");
        }
        
    }
}
