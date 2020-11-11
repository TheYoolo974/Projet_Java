/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package projet_de_java;

/**
 * Classe définissant un type de bateau comme étant un trader corrompu.
 * Un trader corrompu a donc un bounty et une variable donnant l'information de si il a était découvert par les autres bateaux.
 * Il hérite des mêmes attributs que la classe Trader et donc Ship.
 * 
 * @see Ship
 * @see Trader
 * 
 * Il est aussi relié à l'interface Outlaw.
 * 
 * @see Outlaw
 * 
 * @author Jimmy, Arnaud
 */
public class Corrupted_trader extends Trader implements Outlaw {

    /**
     * Bounty est la variable qui contient la prime d'un trader corrompu.
     * Bounty passe à 0 quand le bateau en question est coulé.
     */
    protected int bounty;

    /**
     * La variable revealed permet de savoir si un bateau corrompu a était découvert par les autres bateaux.
     * Quand un bateau corrompu loupe son attaque, revealed passe à True et provoque des conséquences sur ses prochaines interactions avec les autres bateaux.
     * De base, revealed vaut False.
     */
    protected boolean revealed = false;

    
    /**
     * Contructeur de la classe Corrupted_trader contenant le nom du trader corrompu.
     * 
     * @param name
     *      le nom du trader corrompu
     */
    protected Corrupted_trader(String name){
        super(name);
    }

    /*@Override
    public void trader_corru_attack(Corrupted_trader trader, Trader ship){
        
        trader.bounty += ship.treasure; 
        ship.treasure = 0;
        ship.sink = true;
        System.out.println("Attention ! " + trader.nom + " qui est corrompu a coulé " + ship.nom + " et remporte son butin");

    }*/

    /**
     * Méthode permettant à un trader corrompu d'attaquer un policier.
     * 
     * @param trader
     *      le trader corrompu qui déclare l'attaque
     * @param ship
     *      le policier victime de l'attaque
     * 
     * @see Police
     */
    @Override
    public void trader_corru_attack(Corrupted_trader trader, Police ship){
        int luck = (int)(Math.random());
        if(luck == 0){
            trader.bounty += ship.taxes; 
            ship.taxes = 0;
            ship.sink = true;
            System.out.println("Attention ! " + trader.nom + " qui est corrompu a coulé " + ship.nom + " et remporte son butin"); 
        }
        else{
            trader.revealed = true;
            System.out.println(trader.nom + " n'a pas réussi à couler " + ship.nom + " et donne l'information qu'il est corrompu"); 
        }
    }
    
    /**
     * Méthode permettant à un trader corrompu d'attaquer un pirate.
     * 
     * @param trader
     *      le trader corrompu qui déclare l'attaque
     * @param ship
     *      le pirate victime de l'attaque
     * 
     * @see Pirate
     */
    @Override
    public void trader_corru_attack(Corrupted_trader trader, Pirate ship){
        if(trader.menace>ship.menace){
            trader.bounty += ship.bounty; 
            ship.bounty = 0;
            ship.sink = true;
            trader.revealed = true;
            System.out.println("Attention ! " + trader.nom + " qui est corrompu a coulé " + ship.nom + " et remporte son butin"); 
        }
        else if(trader.menace<ship.menace){
            ship.bounty += trader.bounty + trader.treasure; 
            trader.bounty = 0;
            trader.treasure = 0;
            trader.sink = true;
            System.out.println(trader.nom + " n'a pas réussi à couler " + ship.nom + " et sombre dans les abysses."); 
        }
        else{
            if(trader.revealed == true){
                ship.bounty += trader.bounty + trader.treasure; 
                trader.bounty = 0;
                trader.treasure = 0;
                trader.sink = true;
                System.out.println(trader.nom + " n'a pas réussi à couler " + ship.nom + " car " + ship.nom + " savait que " + trader.nom + " était corrompu, il sombre donc dans les abysses.");
            }
            else{
                trader.bounty += ship.bounty; 
                ship.bounty = 0;
                ship.sink = true;
                trader.revealed = true;
                System.out.println(trader.nom + " a réussi à couler " + ship.nom + " et donne l'information qu'il est corrompu"); 
            }
        }
    }

    @Override
    public void police_corru_attack(Corrupted_police police, Pirate ship) {
        throw new UnsupportedOperationException("Not supported yet."); 
    }

    /*@Override
    public void police_corru_attack(Corrupted_police police, Trader ship) {
        throw new UnsupportedOperationException("Not supported yet."); 
    }*/

    @Override
    public void police_corru_attack(Corrupted_police police, Corrupted_trader ship) {
        throw new UnsupportedOperationException("Not supported yet."); 
    }

}
