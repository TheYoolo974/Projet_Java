/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package projet_de_java;


/**
 * Classe définissant un bateau.
 * Un bateau a donc une menace, un nom et une information sur si il est coulé ou non (sink).
 * 
 * @author Jimmy, Arnaud
 */
public class Ship {
    
    /**
     * La variable sink passe à True si le bateau en question est coulé.
     * De base, sink vaut False.
     */
    protected boolean sink=false;

    /**
     * La variable menace décrit la dangerosité d'un bateau, plus elle est élevée plus le bateau est fort.
     */
    protected int menace;

    /**
     * La variable nom définit le nom du bateau.
     * Le nom dépend du type de bateau.
     */
    protected String nom;
    
}

