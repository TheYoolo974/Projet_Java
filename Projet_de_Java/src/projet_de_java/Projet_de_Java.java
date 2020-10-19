/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package projet_de_java;

import java.util.Scanner;

/**
 *
 * @author Jimmy
 */
public class Projet_de_Java {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        
        Scanner keyboard = new Scanner (System.in);
        String value = "";
        
        // On demande le nombre de bateaux pirates à l'utilisateur
        System.out.println("Entrez le nombre de bateaux pirates: ");
        System.out.print("---> ");
        
        value = keyboard.nextLine();
        int nombre_pirate = Integer.parseInt(value); // on stock le nombre de pirate
        
        System.out.println("Il y aura donc "+ value + " bateaux pirates");
        
        
        // On demande le nombre de bateaux marchands à l'utilisateur
        
        System.out.println("Entrez le nombre de bateaux de traders: ");
        System.out.print("---> ");
        
        value = keyboard.nextLine();
        int nombre_trader = Integer.parseInt(value); // on stock le nombre de pirate
        
        //TODO : EN FONCTION DU NOMBRE DE TRADERS, ON GENERE LES CORROMPUS (30% de chance d'être corrompu)
        //------------------------------------------------------------------------------------------------//
        //------------------------------------------------------------------------------------------------//
        //------------------------------------------------------------------------------------------------//
        //------------------------------------------------------------------------------------------------//
        //------------------------------------------------------------------------------------------------//
        
        int trader_corrupt=0;
        
        System.out.println("Il y aura donc "+ value + " bateaux marchands");
        System.out.println("!!! " + trader_corrupt +" d'entre eux semblent corrompu(s) !!!");
        
        //Génération des bateaux policiers en fonction des traders et des pirates
        System.out.println("Génération du nombre de bateaux de policiers ...");
        
        //TODO : CODE GENERATION POLICIERS + POLICERS CORROMPUS (30% de chance d'être corrupt)
        //------------------------------------------------------------------------------------------------//
        //------------------------------------------------------------------------------------------------//
        //------------------------------------------------------------------------------------------------//
        //------------------------------------------------------------------------------------------------//
        //------------------------------------------------------------------------------------------------//
        
        String policier="";
        int policier_corrupt=0;
        
        System.out.println("Bateaux de policiers générés: " + policier);
        System.out.println("!!! " + policier_corrupt +" d'entre eux semblent corrompu(s) !!!");
        
        
        //Génération bounty + treasures
        System.out.println("Génération des bounty et des treasures des bateaux...");
        
        //TODO: GENERATION DES BOUNTY ET TREASURES
        //------------------------------------------------------------------------------------------------//
        //------------------------------------------------------------------------------------------------//
        //------------------------------------------------------------------------------------------------//
        //------------------------------------------------------------------------------------------------//
        //------------------------------------------------------------------------------------------------//
        
        
        //Génération des menaces
        System.out.println("Génération des menaces des bateaux pirates et traders et policiers...");
        
        //TODO: GENERATION DES MENACES
        // 0< menace traders <= 2 / 1<= menace pirate<=5 / menace policier = 3
        
        
        System.out.println("Début -------------------------------------------------------");

        System.out.println("Les pirates se déplacent ...");
        //(cherche le bateau avec le plus de bounty / treasure)
        //etc
    }
    
}
