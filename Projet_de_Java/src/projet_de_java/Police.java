/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package projet_de_java;

/**
 * Classe définissant un type de bateau comme étant un policier.
 * Un policier récolte des taxes et hérite des mêmes attributs que la classe Ship.
 * 
 * @see Ship
 * 
 * @author Jimmy, Arnaud
 */
public class Police extends Ship {

    /**
     * La variable taxes contient l'argent récolté des taxes effectuées par les policiers.
     * De base, taxes vaut 0.
     */
    protected int taxes =0;
    
    /**
     * Contructeur de la classe Police contenant le nom du policier.
     * 
     * @param name
     *      le nom du policier
     */
    protected Police(String name){
        this.nom = name;
    }
    
    /**
     * Méthode permettant à un policier d'arrêter un pirate.
     * 
     * @param policier
     *      le policier qui déclare l'arrestation
     * @param pirate
     *      le pirate qui est victime de l'arrestation
     * 
     * @see Pirate
     */
    protected void arrest(Police policier,Pirate pirate){
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
    
    /**
     * Méthode permettant à un policier de taxer un trader.
     * 
     * @param policier
     *      le policier qui décide de taxer le trader
     * @param trader
     *      le trader qui est victime de la taxe
     * 
     * @see Trader
     */
    protected void taxe(Police policier, Trader trader){
        policier.taxes+=0.4*trader.treasure;
        System.out.println("La taxe de " + policier.nom + " par " + trader.nom + " s'est bien passée");
    }
    
    /**
     * Méthode permettant à un policier d'attaquer un pirate.
     * 
     * @param policier
     *      le policier qui décide de taxer le trader
     * @param trader
     *      le trader corrompu qui est victime de la taxe
     * 
     * @see Corrupted_trader
     */
    protected void taxe(Police policier, Corrupted_trader trader){
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
