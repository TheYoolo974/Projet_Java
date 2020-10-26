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
public class Corrupted_trader extends Trader implements Outlaw {
    int bounty;
    boolean revealed;
    boolean corrupted;
    
    
    Corrupted_trader(String name){
        super(name);
        this.corrupted = true;
    }

    @Override
    public void trader_corru_attack(Corrupted_trader trader, Trader ship){
        
        trader.bounty += ship.treasure; 
        ship.treasure = 0;
        ship.sink = true;
        System.out.println("Attention ! " + trader.nom + " qui est corrompu a coulé " + ship.nom + " et remporte son butin");

    }
    
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

    @Override
    public void police_corru_attack(Corrupted_police police, Pirate ship) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void police_corru_attack(Corrupted_police police, Trader ship) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void police_corru_attack(Corrupted_police police, Corrupted_trader ship) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    
  
   
}
