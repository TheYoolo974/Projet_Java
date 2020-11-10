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
public class Trader extends Ship{
    protected int treasure;
    protected boolean escaped = false;
    
    protected Trader(String name){
        this.nom = name;
    }
    
    /*public void runaway(){
        if(escaped == true){
            System.out.println("Le trader a réussi à s'échapper !");
        }
        else{
            System.out.println("Le trader n'a pas réussi à s'échapper !");
        }
    }*/
   
}
