/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package projet_de_java;

import java.util.Scanner;
import java.util.List;
import java.util.ArrayList;
import java.util.InputMismatchException;


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
        int value = 0;
        
        // On demande le nombre de bateaux pirates à l'utilisateur ( MAX 10 )
      
        boolean valide = false;
        while (!valide) {
            try{
                System.out.println("Entrez le nombre de bateaux pirates (int between 2 and 10 please): ");
                System.out.print("---> ");
                value = keyboard.nextInt();
                if(value >=2 && value<=10){
                    valide = true;
                }
            }
            catch(InputMismatchException e){
                System.out.println("Alert exception found: --> UNEXPECTED INPUT");
                System.out.println("Try again please, (int between 2 and 10)"); 
                keyboard.nextLine();
            }
        }

        
        int nombre_pirate = value;
        
        System.out.println("Il y aura donc "+ nombre_pirate + " bateaux pirates");
        
        List<Pirate> pirates_dispo = new ArrayList<Pirate>();
        List<Pirate> tab_pirates = new ArrayList<Pirate>();
        
        Pirate jack = new Pirate("<Pirate> Jack");
        Pirate honorine = new Pirate("<Pirate> Honorine");
        Pirate geoffrey = new Pirate("<Pirate> Geoffrey");
        Pirate thibaud = new Pirate("<Pirate> Thibaud");
        Pirate alexandre = new Pirate("<Pirate> Alexandre");
        Pirate jeancharles = new Pirate("<Pirate> Jean-Charles");
        Pirate charles = new Pirate("<Pirate> Charles");
        Pirate eloy = new Pirate("<Pirate> Eloy");
        Pirate matthis = new Pirate("<Pirate> Matthis");
        Pirate pierrick = new Pirate("<Pirate> Pierrick");
        
        pirates_dispo.add(jack);
        pirates_dispo.add(honorine);
        pirates_dispo.add(geoffrey);
        pirates_dispo.add(thibaud);
        pirates_dispo.add(alexandre);
        pirates_dispo.add(jeancharles);
        pirates_dispo.add(charles);
        pirates_dispo.add(eloy);
        pirates_dispo.add(matthis);
        pirates_dispo.add(pierrick);
        
        
        for(int i = 0; i<nombre_pirate;i++){
            tab_pirates.add(pirates_dispo.get(i));
        }
        
        
        // On demande le nombre de bateaux marchands à l'utilisateur ( MAX 5 )
        
        boolean valide2 = false;
        while (!valide2) {
            try{
                System.out.println("Entrez le nombre de bateaux de traders (int between 1 and 8 please): ");
                System.out.print("---> ");
                value = keyboard.nextInt();
                if(value >=1 && value<=8){
                    valide2 = true;
                }
            }
            catch(InputMismatchException e){
                System.out.println("Alert exception found: --> UNEXPECTED INPUT");
                System.out.println("Try again please, (int between 1 and 8)"); 
                keyboard.nextLine();
            }
        }
        
        int nombre_trader =value;
        
        System.out.println("Il y aura donc "+ nombre_trader + " bateaux marchands");
        
        
        int nombre_trader_corru=0;
        
        if(nombre_trader>= 2 && nombre_trader<=4){
            nombre_trader_corru=1;
        }
        else if(nombre_trader>= 5 && nombre_trader<=7){
            nombre_trader_corru=2;
        }
        else{
            nombre_trader_corru=3;
        }
            
        nombre_trader -= nombre_trader_corru;
        
        
        //Génération des traders
        
        List<Trader> traders_dispo = new ArrayList<Trader>();
        List<Trader> tab_traders = new ArrayList<Trader>();
        
        Trader maxence = new Trader("<Trader> Maxence");
        Trader damien = new Trader("<Trader> Damien");
        Trader laura = new Trader("<Trader> Laura");
        Trader laetitia = new Trader("<Trader> Laetitia");
        Trader arnaud = new Trader("<Trader> Arnaud");
        Trader valentin = new Trader("<Trader> Valentin");
        Trader titouan = new Trader("<Trader> Titouan");
        Trader ginette = new Trader("<Trader> Ginette");
        
       
        
        traders_dispo.add(maxence);
        traders_dispo.add(damien);
        traders_dispo.add(laura);
        traders_dispo.add(laetitia);
        traders_dispo.add(arnaud);
        traders_dispo.add(valentin);
        traders_dispo.add(titouan);
        traders_dispo.add(ginette);
    
        
        for(int i = 0; i<nombre_trader;i++){
            tab_traders.add(traders_dispo.get(i));
        }

        
        
        //Génération des traders corrompus
        
        List<Corrupted_trader> traders_corru_dispo = new ArrayList<Corrupted_trader>();
        List<Corrupted_trader> tab_traders_corru = new ArrayList<Corrupted_trader>();
        
        Corrupted_trader hugo = new Corrupted_trader("<Trader_corrupt> Hugo");
        Corrupted_trader julien = new Corrupted_trader("<Trader_corrupt> Julien");
        Corrupted_trader amaury = new Corrupted_trader("<Trader_corrupt> Amaury");
       
        
        traders_corru_dispo.add(hugo);
        traders_corru_dispo.add(julien);
        traders_corru_dispo.add(amaury);
       
        for(int i = 0; i<nombre_trader_corru;i++){
            tab_traders_corru.add(traders_corru_dispo.get(i));
        }
       
        System.out.println("!!! " + nombre_trader_corru +" d'entre eux semblent corrompu(s) !!!");
        
        System.out.println("\n");
        
      
        
        //------------------------------------------------------------------------------------------------//
        //------------------------------------------------------------------------------------------------//
        //------------------------------------------------------------------------------------------------//
        //------------------------------------------------------------------------------------------------//
        //------------------------------------------------------------------------------------------------//
        
        //Génération des bateaux policiers en fonction des traders et des pirates
        System.out.println("Génération du nombre de bateaux de policiers ...");
        
        
        int nombre_policiers;
        int nombre_policiers_corru=0;
        
        if(nombre_pirate<=3){
            nombre_policiers=1;
        }
        else if((nombre_pirate + nombre_trader)>=4 && (nombre_pirate + nombre_trader)<=6){
            nombre_policiers=2;
        }
        else if((nombre_pirate + nombre_trader)>=7 && (nombre_pirate + nombre_trader)<=8){
            nombre_policiers=3;
            nombre_policiers_corru=1;
        }
        else{
            nombre_policiers=4;
            nombre_policiers_corru=1;
            if(nombre_pirate >= 6){
                nombre_policiers_corru=2;
            }
        }
        
        List<Police> policiers_dispo = new ArrayList<Police>();
        List<Police> tab_policiers = new ArrayList<Police>();
        
        Police ludovic = new Police("<Police> Ludovic");
        Police nicolas = new Police("<Police> Nicolas");
        Police axel = new Police("<Police> Axel");
        Police michael = new Police("<Police> Michael");
       
        
        policiers_dispo.add(ludovic);
        policiers_dispo.add(nicolas);
        policiers_dispo.add(axel);
        policiers_dispo.add(michael);
        
        for(int i = 0; i<nombre_policiers;i++){
            tab_policiers.add(policiers_dispo.get(i));
        }
        
        //Génération des policiers corrompus

        List<Corrupted_police> policiers_corru_dispo = new ArrayList<Corrupted_police>();
        List<Corrupted_police> tab_policiers_corru = new ArrayList<Corrupted_police>();
        
        
        Corrupted_police adrien = new Corrupted_police("<Police_corrupt> Adrien");
        Corrupted_police jimmy = new Corrupted_police("<Police_corrupt> Jimmy");
       
       
        
        policiers_corru_dispo.add(adrien);
        policiers_corru_dispo.add(jimmy);
        
       
        for(int i = 0; i<nombre_policiers_corru;i++){
            tab_policiers_corru.add(policiers_corru_dispo.get(i));
        }
       
        
        System.out.println("Bateaux de policiers générés: " + nombre_policiers);
        System.out.println("!!! " + nombre_policiers_corru +" d'entre eux semblent corrompu(s) !!!");
        
        //------------------------------------------------------------------------------------------------//
        //------------------------------------------------------------------------------------------------//
        //------------------------------------------------------------------------------------------------//
        //------------------------------------------------------------------------------------------------//
        //------------------------------------------------------------------------------------------------//
        
        System.out.println("\nIl y aura donc :");
        System.out.println("En pirates:");
        
        tab_pirates.forEach(elem -> {
            System.out.println(elem.nom);
        });
        
        
        System.out.println("\n");
        
        System.out.println("En traders:");
        
        tab_traders.forEach(elem -> {
            System.out.println(elem.nom);
        });
        
       
        
        System.out.println("\n");
        
        System.out.println("En traders corrompus:");
        
        tab_traders_corru.forEach(elem -> {
            System.out.println(elem.nom);
        });
        
        
        System.out.println("\n");
        
        System.out.println("En policiers:");
        
        tab_policiers.forEach(elem -> {
            System.out.println(elem.nom);
        });
        
        System.out.println("\n");
        
        System.out.println("En policiers corrompus:");
        
        tab_policiers_corru.forEach(elem -> {
            System.out.println(elem.nom);
        });
        
        System.out.println("\n");
        
        //------------------------------------------------------------------------------------------------//
        //------------------------------------------------------------------------------------------------//
        //------------------------------------------------------------------------------------------------//
        //------------------------------------------------------------------------------------------------//
        //------------------------------------------------------------------------------------------------//
        
       //Génération des menaces
        System.out.println("Génération des menaces des bateaux pirates et traders et policiers...\n");
        
        //TODO: GENERATION DES MENACES
        // 1< menace traders <= 3 / 1<= menace pirate<=5 / menace policier = 3 / menace corru = 4
        
        System.out.println("Récap des menaces:");
        System.out.println("Pour les pirates:");
        
        // 1<= menace pirate<=5
        for(int i = 0; i<tab_pirates.size();i++){
            int luck = 1 + (int)(Math.random() * 5);
            (tab_pirates.get(i)).menace = luck;
            System.out.print(tab_pirates.get(i).nom + " , menace: ");
            System.out.println(tab_pirates.get(i).menace);
        }
        
        
        System.out.println("\nPour les traders:");
        // 1<= menace trader <= 3
        for(int i = 0; i<tab_traders.size();i++){
            int luck = 1+(int)(Math.random()*2);
            (tab_traders.get(i)).menace = luck;
            System.out.print(tab_traders.get(i).nom + " , menace: ");
            System.out.println(tab_traders.get(i).menace);
        }
        
        System.out.println("\nPour les traders corrompus:");
        // menace trader corrompu = 4
        for(int i = 0; i<tab_traders_corru.size();i++){
            (tab_traders_corru.get(i)).menace = 4;
            System.out.print(tab_traders_corru.get(i).nom + " , menace: ");
            System.out.println(tab_traders_corru.get(i).menace);
        }
        
        System.out.println("\nPour les policers:");
        //menace policier = 3
        for(int i = 0; i<tab_policiers.size();i++){
            (tab_policiers.get(i)).menace = 3;
            System.out.print(tab_policiers.get(i).nom + " , menace: ");
            System.out.println(tab_policiers.get(i).menace);
        }
        
        System.out.println("\nPour les policers corrompus:");
        // menace policier corrompu = 4
        for(int i = 0; i<tab_policiers_corru.size();i++){
            (tab_policiers_corru.get(i)).menace = 4;
            System.out.print(tab_policiers_corru.get(i).nom + " , menace: ");
            System.out.println(tab_policiers_corru.get(i).menace);
        }
        
        
        //Génération bounty (entre 100 et 500) + treasures (entre 1000 et 1200)
        System.out.println("\nGénération des bounty et des treasures des bateaux...");
        
        System.out.println("Récap des bounty / treasures:\n");
        System.out.println("Pour les pirates:");
        //pirates
        for(int i = 0; i<tab_pirates.size();i++){
            switch ((tab_pirates.get(i)).menace) {
                case 1:
                    (tab_pirates.get(i)).bounty = 100;
                    break;
                case 2:
                    (tab_pirates.get(i)).bounty = 200;
                    break;
                case 3:
                    (tab_pirates.get(i)).bounty = 300;
                    break;
                case 4:
                    (tab_pirates.get(i)).bounty = 400;
                    break;
                case 5:
                    (tab_pirates.get(i)).bounty = 500;
                    break;
                default:
                    break;
            }
            
        System.out.print(tab_pirates.get(i).nom + " , bounty: ");
        System.out.println(tab_pirates.get(i).bounty);  
        }
        
        
        System.out.println("\nPour les traders:");
        //traders
        for(int i = 0; i<tab_traders.size();i++){
            switch ((tab_traders.get(i)).menace) {
                case 0:
                    (tab_traders.get(i)).treasure = 1000;
                    break;
                case 1:
                    (tab_traders.get(i)).treasure = 1100;
                    break;
                case 2:
                    (tab_traders.get(i)).treasure = 1200;
                    break;
                default:
                    break;
            }
        System.out.print(tab_traders.get(i).nom + " , treasure: ");
        System.out.println(tab_traders.get(i).treasure);
        }
        
        System.out.println("\nPour les traders corrompus:");
        //traders corrompus
        for(int i = 0; i<tab_traders_corru.size();i++){
            (tab_traders_corru.get(i)).treasure = 1200;
            (tab_traders_corru.get(i)).bounty = 400;
            
        System.out.print(tab_traders_corru.get(i).nom + " , bounty: ");
        System.out.print(tab_traders_corru.get(i).bounty);
        System.out.print(" , treasure: ");
        System.out.print(tab_traders_corru.get(i).treasure + "\n");
        }
        
        System.out.println("\n\nPour les policiers:");
        //policiers
        //Les policiers n'ont que l'argent récolté des taxes qui démarre donc de 0.
        System.out.println("Les policiers n'ont que l'argent récolté des taxes.");
        System.out.println("Taxes de départ  pour tout les policiers : 0\n");
        
        System.out.println("\nPour les policiers corrompus:\n");
        System.out.println("Taxes de départ  pour tout les policiers corrompus : 0");
        //policiers corrompus
        for(int i = 0; i<tab_policiers_corru.size();i++){
            (tab_policiers_corru.get(i)).bounty = 400; //+ les taxes d'un policier classique
                
        System.out.print(tab_policiers_corru.get(i).nom + " , bounty: ");
        System.out.println(tab_policiers_corru.get(i).bounty);
        }
        
      
        //------------------------------------------------------------------------------------------------//
        //------------------------------------------------------------------------------------------------//
        //------------------------------------------------------------------------------------------------//
        //------------------------------------------------------------------------------------------------//
        //------------------------------------------------------------------------------------------------//
        
        
        System.out.println("\nDébut -------------------------------------------------------");

        System.out.println("Les pirates se déplacent ...\n");
        
        
        
        //On fait jouer la premiere partie des pirates 
        //(cherche le bateau avec le plus de bounty / treasure)
        
        //int pirates_pas_joue=0;
        int p =0;
        for(int u = 0; u<tab_traders.size();u++){
        tab_pirates.get(p).attack(tab_pirates.get(p), tab_traders.get(u));
            if(tab_pirates.get(p).sink==true){
                tab_pirates.remove(p);
                if(p==tab_pirates.size()){
                    break;
                }
            }
            else if(tab_traders.get(u).sink == true){
                tab_traders.remove(u);
                u--;
                //pirates_pas_joue++; // on augmente cette variable dans le cas où des pirates on joué leur tour mais qu'il ne sont pas morts ( donc encore dans la liste )

                if(p==tab_pirates.size()-1){
                    break;
                }
                else{
                    p++;
                }
            }
        }
        
        System.out.println("\nLes policiers se déplacent pour venir arrêter les pirates...\n");
        
        
        //8 pirates 2 traders 2 policiers

        int m =0;
        for(int u =  0; u<tab_pirates.size();u++){
            tab_policiers.get(m).arrest(tab_policiers.get(m),tab_pirates.get(u));
            if(tab_policiers.get(m).sink==true){
                tab_policiers.remove(m);
                if(m==tab_policiers.size()){
                    break;
                }
            }
            else if(tab_pirates.get(u).sink == true){
                tab_pirates.remove(u);
                u--;

                if(m==tab_policiers.size()-1){
                    break;
                }
                else{
                    m++;
                }
            }
        }
        
        System.out.println("\nLes policiers décident de taxer les pauvres traders aux alentours ...\n");
        
        if(!tab_traders.isEmpty() && !tab_policiers.isEmpty()){
            int n =0;
            for(int u =  0; u<tab_traders.size();u++){
                tab_policiers.get(n).taxe(tab_policiers.get(n),tab_traders.get(u));
               
                if(n==tab_policiers.size()-1){
                    break;
                }
                else{
                    n++;
                }
            }
            
        }
        
        
        
        if(!tab_traders_corru.isEmpty() && !tab_policiers.isEmpty()){
            int l =0;
            for(int u =  0; u<tab_traders_corru.size();u++){
                tab_policiers.get(l).taxe(tab_policiers.get(l),tab_traders_corru.get(u));
                if(tab_policiers.get(l).sink==true){
                    tab_policiers.remove(l);
                    if(l==tab_policiers.size()){
                        break;
                    }
                }
                else if(tab_traders_corru.get(u).sink == true){
                    tab_traders_corru.remove(u);
                    u--;

                    if(l==tab_policiers.size()-1){
                        break;
                    }
                    else{
                        l++;
                    }
                }
            }
        }
       

        
        
        
        
        
        
        
        System.out.println("\nRécap:");
        System.out.println("Pour les pirates:");
        
        
        for(int i = 0; i<tab_pirates.size();i++){
            System.out.print(tab_pirates.get(i).nom + " , menace: ");
            System.out.print(tab_pirates.get(i).menace);
            System.out.println(" , bounty: " + tab_pirates.get(i).bounty);
        }
        
         System.out.println("\nPour les traders:");
        
        for(int i = 0; i<tab_traders.size();i++){
            System.out.print(tab_traders.get(i).nom + " , menace: ");
            System.out.print(tab_traders.get(i).menace);
            System.out.println(" , treasure: " + tab_traders.get(i).treasure);
        }
        
        System.out.println("\nPour les policiers:");
        
        for(int i = 0; i<tab_policiers.size();i++){
            System.out.print(tab_policiers.get(i).nom + " , menace: ");
            System.out.print(tab_policiers.get(i).menace);
            System.out.println(" , taxes: " + tab_policiers.get(i).taxes);
        }
        
        System.out.println("\nPour les traders corrompus:");
        
        for(int i = 0; i<tab_traders_corru.size();i++){
            System.out.print(tab_traders_corru.get(i).nom + " , menace: ");
            System.out.print(tab_traders_corru.get(i).menace);
            System.out.print(" , treasure: " + tab_traders_corru.get(i).treasure);
            System.out.println(" , bounty: " + tab_traders_corru.get(i).bounty);
        }
        
        //Si après les attaques , si il reste plus de la moitié des pirates au total on fait jouer les policiers
        //Sinon on fait jouer la deuxieme partie des policiers
        //On fait jouer les policiers
        //On arrête le jeu dans les cas suivants:
        //Si les policiers = 0 ou que policier restant = corrompu  // traders =0 ou alors trader restants = corrompus + nombre_pirate =nombre_pirate/2 // les pirates = 0
        //On affiche un récap des bateaux encore vivants et de leurs bounty/treasure/taxes
        
    }
    
}
