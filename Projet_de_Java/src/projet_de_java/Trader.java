/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package projet_de_java;

/**
 * Classe définissant un type de bateau comme étant un trader.
 * Un trader a donc un trésor et hérite des mêmes attributs que la classe Ship.
 * 
 * @see Ship
 * 
 * @author Jimmy, Arnaud
 */
public class Trader extends Ship{

    /**
     * La variable treasure contient le trésor contenu dans les bateaux de traders.
     * Quand un bateau de trader coule, treasure passe à 0.
     */
    protected int treasure;
    
    /**
     * Contructeur de la classe Trader contenant le nom du trader.
     * 
     * @param name
     *      le nom du trader
     */
    protected Trader(String name){
        this.nom = name;
    }
}
