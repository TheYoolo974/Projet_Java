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
    static int bounty;
   
    
    
    public static void attack(Trader ship){
        
        if(ship.flag == "trader"){
            if(ship.corrupted == true){
                ship.treasure -=0.7*ship.treasure;
                bounty += 0.7*ship.treasure;           
            }
            else{
                if(ship.treasure >= 30 && ship.menace < Pirate.menace){ //treasure [0 ... 100]
                    ship.sink = true;
                }
                
            }
        }
    }
    
    public static void attack(Pirate ship){
        if(ship.menace>Pirate.menace){
            ship.bounty+=bounty;
            Pirate.sink=true;            
        }
        else if(ship.menace>Pirate.menace){
            bounty+=ship.bounty;
            ship.sink=true;
        }
        
    }
    
       
       
    
    
}
   
