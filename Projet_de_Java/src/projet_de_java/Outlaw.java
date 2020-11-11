/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package projet_de_java;

/**
 * Interface décrivant les actions possibles des bateaux corrompus.
 * 
 * @see Corrupted_trader
 * @see Corrupted_police
 * 
 * @author Jimmy, Arnaud
 */
public interface Outlaw {
   

    //public void trader_corru_attack(Corrupted_trader trader, Trader ship);
    public void trader_corru_attack(Corrupted_trader trader, Police ship);
    public void trader_corru_attack(Corrupted_trader trader, Pirate ship);
  
   
    public void police_corru_attack(Corrupted_police police, Pirate ship);
    //public void police_corru_attack(Corrupted_police police, Trader ship);
    public void police_corru_attack(Corrupted_police police, Corrupted_trader ship);
}
    

    
