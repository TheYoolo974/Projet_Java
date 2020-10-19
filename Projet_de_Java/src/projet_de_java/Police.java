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
    int react_time;
    static int taxes;
    boolean corrupt;
    public static void arrest(Pirate pirate){
        if(Police.menace>pirate.menace){
            taxes+=pirate.bounty;
            pirate.sink=true;
        }
        else if(Police.menace<=pirate.menace){
            pirate.bounty+=taxes;
            Police.sink=true;
        }
    }
    
    public static void taxe(Trader trader){
        int luck;
        if(trader.corrupted==false){
            taxes+=0.4*trader.treasure;
        }
        else{
            luck = (int)(Math.random());
            if(luck==0){
                taxes+=trader.treasure+Corrupted_trader.bounty;
                Corrupted_trader.revealed=true;
            }
        }
    }
}
