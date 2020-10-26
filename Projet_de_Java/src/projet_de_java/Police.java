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
    
    
    public void arrest(Police policier,Pirate pirate){
        if(policier.menace>=pirate.menace){
            policier.taxes+=pirate.bounty;
            pirate.bounty = 0;
            pirate.sink=true;
            System.out.println(policier.nom + " a arrêté l'équipage de " + pirate.nom + " et l'a donc coulé");
        }
        else if(policier.menace<pirate.menace){
            pirate.bounty+=policier.taxes;
            policier.taxes = 0;
            policier.sink=true;
            System.out.println("Misère ! " + pirate.nom + " a coulé " + policier.nom + " et récupère son contenu");
        }
    }
    
    public void taxe(Police policier, Trader trader){
        policier.taxes+=0.4*trader.treasure;
        System.out.println("La taxe de " + policier.nom + " par " + trader.nom + " s'est bien passée");
    }
    
    public void taxe(Police policier, Corrupted_trader trader){
        int luck = (int)(Math.random()*3);
        if(luck==0){
            policier.taxes+=trader.treasure+trader.bounty;
            trader.revealed=true;
            trader.sink = true;
            System.out.println(trader.nom + " était corrumpu et s'est fait couler par " + policier.nom + " !");
        }
        else{
            System.out.println("La taxe de " + trader.nom + " par " + policier.nom + " s'est mal passée !");
            System.out.println(trader.nom + " essaye d'attaquer " + policier.nom);
            trader.trader_corru_attack(trader, policier);
        }
        
    }
}
