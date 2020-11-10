/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package projet_de_java;

/**
 *
 * @author Jimmy, Arnaud
 */
public class Corrupted_police extends Police implements Outlaw{
    protected int bounty;
    protected boolean revealed;
    protected boolean corrupted;
    
    
    protected Corrupted_police(String name){
        super(name);
        this.corrupted = true;
    }
    
    @Override
    public void police_corru_attack(Corrupted_police police, Pirate ship){
         if(police.menace>=ship.menace){
            police.bounty+=ship.bounty;
            ship.bounty = 0;
            ship.sink=true;
            System.out.println(police.nom + " qui était corrompu a arrêté l'équipage de " + ship.nom + " et l'a donc coulé");
        }
        else if(police.menace<ship.menace){
            ship.bounty+=police.taxes;
            police.taxes = 0;
            police.sink=true;
            System.out.println(ship.nom + " a coulé " + police.nom + " qui était en fait corrompu et récupère son contenu");
        }
    }
    
    /*@Override
    public void police_corru_attack(Corrupted_police police, Trader ship){
        police.taxes+=ship.treasure;
        ship.treasure = 0;
        ship.sink=true;
        System.out.println(police.nom + " qui était malheuresement corrompu a coulé " + ship.nom + " et a récolté son contenu!");
        

    }*/
    
    @Override
    public void police_corru_attack(Corrupted_police police, Corrupted_trader ship){
        int luck = (int)(Math.random());
        if(luck==0){
            police.taxes+=ship.treasure;
            police.bounty += ship.bounty;
            police.revealed = true;
            ship.treasure = 0;
            ship.bounty = 0;
            ship.sink = true;
            System.out.println(ship.nom + " qui était corrumpu s'est fait couler par " + police.nom + " qui était lui aussi corrompu !");
        }
        else{
            ship.bounty += police.taxes + police.bounty;
            ship.revealed = true;
            police.taxes = 0;
            police.bounty = 0;
            police.sink = true;
            System.out.println(police.nom + " qui était corrumpu s'est fait couler par " + ship.nom + " qui était lui aussi corrompu !");
        }
    }

    /*@Override
    public void trader_corru_attack(Corrupted_trader trader, Trader ship) {
        throw new UnsupportedOperationException("Not supported yet."); 
    }*/

    @Override
    public void trader_corru_attack(Corrupted_trader trader, Police ship) {
        throw new UnsupportedOperationException("Not supported yet."); 
    }

    @Override
    public void trader_corru_attack(Corrupted_trader trader, Pirate ship) {
        throw new UnsupportedOperationException("Not supported yet."); 
    }
   
}
