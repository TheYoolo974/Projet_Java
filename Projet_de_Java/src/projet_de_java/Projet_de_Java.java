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
import java.io.File;
import java.io.FileNotFoundException;


/**
 *
 * @author Jimmy, Arnaud
 */
public class Projet_de_Java {

    
    public static void wait(int ms){
        try
        {
            Thread.sleep(ms);
        }
        catch(InterruptedException ex)
        {
            Thread.currentThread().interrupt();
        }
    }
    
    public static void main(String[] args) {
        
        Scanner keyboard = new Scanner (System.in);
        int value = 0;
        
        // On demande le nombre de bateaux pirates à l'utilisateur ( MIN 5 MAX 20 )
      
        boolean valide = false;
        while (!valide) {
            try{
                System.out.println("Entrez le nombre de bateaux pirates (int between 5 and 20 please): ");
                System.out.print("---> ");
                value = keyboard.nextInt();
                if(value >=5 && value<=20){
                    valide = true;
                }
            }
            catch(InputMismatchException e){
                System.out.println("Alert exception found: --> UNEXPECTED INPUT");
                System.out.println("Try again please, (int between 5 and 20)"); 
                keyboard.nextLine();
            }
        }

        
        int nombre_pirate = value;
        
        System.out.println("Il y aura donc "+ nombre_pirate + " bateaux pirates.\n");
        
        //------------------------------------------------------------------------------------------------//
        //------------------------------------------------------------------------------------------------//
        //------------------------------------------------------------------------------------------------//
        //------------------------------------------------------------------------------------------------//
        //------------------------------------------------------------------------------------------------//
        
        System.out.println("Génération des pirates...");
        wait(2000);
        
        
        List<Pirate> pirates_dispo = new ArrayList<>();
        List<Pirate> tab_pirates = new ArrayList<>();
        
        try {
            Scanner scan_fichier = new Scanner(new File("noms_pirates.txt"));
            while(scan_fichier.hasNextLine())
            {
                String line = scan_fichier.nextLine();
                Pirate new_pirate = new Pirate(line);
                pirates_dispo.add(new_pirate);
            }
        } catch (FileNotFoundException e) {
            System.out.println("Fichier non trouvé");
        }
        
        for(int i = 0; i<nombre_pirate;i++){
            tab_pirates.add(pirates_dispo.get(i));
        }
        
        System.out.println("Pirates générés avec succès.\n");
        
        //------------------------------------------------------------------------------------------------//
        //------------------------------------------------------------------------------------------------//
        //------------------------------------------------------------------------------------------------//
        //------------------------------------------------------------------------------------------------//
        //------------------------------------------------------------------------------------------------//
        
        // On demande le nombre de bateaux marchands à l'utilisateur ( MIN 2 MAX 12 )
        
        boolean valide2 = false;
        while (!valide2) {
            try{
                System.out.println("Entrez le nombre de bateaux de traders (int between 2 and 12 please): ");
                System.out.print("---> ");
                value = keyboard.nextInt();
                if(value >=2 && value<=12){
                    valide2 = true;
                }
            }
            catch(InputMismatchException e){
                System.out.println("Alert exception found: --> UNEXPECTED INPUT");
                System.out.println("Try again please, (int between 2 and 12)"); 
                keyboard.nextLine();
            }
        }
        
        int nombre_trader =value;
        
        System.out.println("Il y aura donc "+ nombre_trader + " bateaux marchands.\n");
        
        //------------------------------------------------------------------------------------------------//
        //------------------------------------------------------------------------------------------------//
        //------------------------------------------------------------------------------------------------//
        //------------------------------------------------------------------------------------------------//
        //------------------------------------------------------------------------------------------------//
        
        System.out.println("Génération des traders...");
        wait(2000);
        
        //Génération des traders
        
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
        
        
        List<Trader> traders_dispo = new ArrayList<>();
        List<Trader> tab_traders = new ArrayList<>();
        
        try {
            Scanner scan_fichier = new Scanner(new File("noms_traders.txt"));
            while(scan_fichier.hasNextLine())
            {
                String line = scan_fichier.nextLine();
                Trader new_trader = new Trader(line);
                traders_dispo.add(new_trader);
            }
        } catch (FileNotFoundException e) {
            System.out.println("Fichier non trouvé");
        }
    
        
        for(int i = 0; i<nombre_trader;i++){
            tab_traders.add(traders_dispo.get(i));
        }

        System.out.println("Traders générés avec succès.\n");
        wait(1000);
        
        //------------------------------------------------------------------------------------------------//
        //------------------------------------------------------------------------------------------------//
        //------------------------------------------------------------------------------------------------//
        //------------------------------------------------------------------------------------------------//
        //------------------------------------------------------------------------------------------------//
        
        //Génération des traders corrompus
        
        List<Corrupted_trader> traders_corru_dispo = new ArrayList<>();
        List<Corrupted_trader> tab_traders_corru = new ArrayList<>();
        
        try {
            Scanner scan_fichier = new Scanner(new File("noms_traders_corrompus.txt"));
            while(scan_fichier.hasNextLine())
            {
                String line = scan_fichier.nextLine();
                Corrupted_trader new_corrupted_trader = new Corrupted_trader(line);
                traders_corru_dispo.add(new_corrupted_trader);
            }
        } catch (FileNotFoundException e) {
            System.out.println("Fichier non trouvé");
        }
       
        for(int i = 0; i<nombre_trader_corru;i++){
            tab_traders_corru.add(traders_corru_dispo.get(i));
        }
        
        if(nombre_trader_corru == 1){
           System.out.println("!!! " + nombre_trader_corru +" d'entre eux semble corrompu !!!\n");
        }
        else if(nombre_trader_corru != 0 && nombre_trader_corru>1){
            System.out.println("!!! " + nombre_trader_corru +" d'entre eux semblent corrompus !!!\n");
        }
        
        wait(1000);
        
       
        //------------------------------------------------------------------------------------------------//
        //------------------------------------------------------------------------------------------------//
        //------------------------------------------------------------------------------------------------//
        //------------------------------------------------------------------------------------------------//
        //------------------------------------------------------------------------------------------------//
        
        //Génération des bateaux policiers en fonction des traders et des pirates
        System.out.println("Génération du nombre de bateaux de policiers ...");
        wait(2000);
        
        
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
        
        List<Police> policiers_dispo = new ArrayList<>();
        List<Police> tab_policiers = new ArrayList<>();
        
        try {
           Scanner scan_fichier = new Scanner(new File("noms_policiers.txt"));
           while(scan_fichier.hasNextLine())
           {
               String line = scan_fichier.nextLine();
               Police new_policier = new Police(line);
               policiers_dispo.add(new_policier);
           }
        } catch (FileNotFoundException e) {
            System.out.println("Fichier non trouvé");
        }
        
        for(int i = 0; i<nombre_policiers;i++){
            tab_policiers.add(policiers_dispo.get(i));
        }
        
        System.out.println("Bateaux de policiers générés: " + nombre_policiers + "\n");
        
        //------------------------------------------------------------------------------------------------//
        //------------------------------------------------------------------------------------------------//
        //------------------------------------------------------------------------------------------------//
        //------------------------------------------------------------------------------------------------//
        //------------------------------------------------------------------------------------------------//
        
        //Génération des policiers corrompus

        List<Corrupted_police> policiers_corru_dispo = new ArrayList<>();
        List<Corrupted_police> tab_policiers_corru = new ArrayList<>();
        
        try {
           Scanner scan_fichier = new Scanner(new File("noms_policiers_corrompus.txt"));
           while(scan_fichier.hasNextLine())
           {
               String line = scan_fichier.nextLine();
               Corrupted_police new_corrupted_policier = new Corrupted_police(line);
               policiers_corru_dispo.add(new_corrupted_policier);
           }
        } catch (FileNotFoundException e) {
            System.out.println("Fichier non trouvé");
        }
        
        for(int i = 0; i<nombre_policiers_corru;i++){
            tab_policiers_corru.add(policiers_corru_dispo.get(i));
        }
       
        
        if(nombre_policiers_corru == 1){
            System.out.println("!!! " + nombre_policiers_corru +" policier corrompu rejoint les policiers !!!\n");
        }
        else if(nombre_policiers_corru != 0 && nombre_policiers_corru>1){
            System.out.println("!!! " + nombre_policiers_corru +" policiers corrompus rejoignent les policiers !!!\n");
        }
        
        wait(1000);
        
        //------------------------------------------------------------------------------------------------//
        //------------------------------------------------------------------------------------------------//
        //------------------------------------------------------------------------------------------------//
        //------------------------------------------------------------------------------------------------//
        //------------------------------------------------------------------------------------------------//
        
        
       //Génération des menaces
        System.out.println("Génération des menaces des bateaux pirates et traders et policiers...\n");
        wait(2000);
        
        // 1< menace traders <= 3 / 1<= menace pirate<=5 / menace policier = 3 / menace corru = 4
        
        // 1<= menace pirate<=5
        for(int i = 0; i<tab_pirates.size();i++){
            int luck = 1 + (int)(Math.random() * 5);
            (tab_pirates.get(i)).menace = luck;
        }
        
        
        // 1<= menace trader <= 3
        for(int i = 0; i<tab_traders.size();i++){
            int luck = 1+(int)(Math.random()*2);
            (tab_traders.get(i)).menace = luck;
        }
        
   
        // menace trader corrompu = 4
        for(int i = 0; i<tab_traders_corru.size();i++){
            (tab_traders_corru.get(i)).menace = 4;
        }
        
        //menace policier = 4
        for(int i = 0; i<tab_policiers.size();i++){
            (tab_policiers.get(i)).menace = 4;
        }
        
        // menace policier corrompu = 4
        for(int i = 0; i<tab_policiers_corru.size();i++){
            (tab_policiers_corru.get(i)).menace = 4;
        }
        
        System.out.println("Menaces générées avec succès.\n");
        wait(1000);
        
        //------------------------------------------------------------------------------------------------//
        //------------------------------------------------------------------------------------------------//
        //------------------------------------------------------------------------------------------------//
        //------------------------------------------------------------------------------------------------//
        //------------------------------------------------------------------------------------------------//
        
        System.out.println("\nGénération des bounty et des treasures des bateaux...");
        wait(2000);
        
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
        }
        
        
        
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
        }
        
       
        //traders corrompus
        for(int i = 0; i<tab_traders_corru.size();i++){
            (tab_traders_corru.get(i)).treasure = 1200;
            (tab_traders_corru.get(i)).bounty = 400;
        }
        
        
        //policiers
        //Les policiers n'ont que l'argent récolté des taxes qui démarre donc de 0.
        //System.out.println("Les policiers n'ont que l'argent récolté des taxes.");
        //System.out.println("Taxes de départ  pour tout les policiers : 0\n");
        
        
        
        //policiers corrompus
        //System.out.println("Taxes de départ  pour tout les policiers corrompus : 0");
        for(int i = 0; i<tab_policiers_corru.size();i++){
            (tab_policiers_corru.get(i)).bounty = 400; //+ les taxes d'un policier classique
        }
        
        System.out.println("Bounty/treasures générés avec succès.");
        wait(1000);
        
        //------------------------------------------------------------------------------------------------//
        //------------------------------------------------------------------------------------------------//
        //------------------------------------------------------------------------------------------------//
        //------------------------------------------------------------------------------------------------//
        //------------------------------------------------------------------------------------------------//
        
        System.out.println("\n-------------------------------------------------------Récap-------------------------------------------------------\n");
        
        System.out.println("Il y aura donc :\n");
        
        System.out.println("En pirates:");
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
       
        
        System.out.println("\nPour les policiers corrompus:");
        
        for(int i = 0; i<tab_policiers_corru.size();i++){
            System.out.print(tab_policiers_corru.get(i).nom + " , menace: ");
            System.out.print(tab_policiers_corru.get(i).menace);
            System.out.print(" , taxes: " + tab_policiers_corru.get(i).taxes);
            System.out.println(" , bounty: " + tab_policiers_corru.get(i).bounty);
        }
        
        wait(2000);
        
        //------------------------------------------------------------------------------------------------//
        //------------------------------------------------------------------------------------------------//
        //------------------------------------------------------------------------------------------------//
        //------------------------------------------------------------------------------------------------//
        //------------------------------------------------------------------------------------------------//
        
   
        System.out.println("\n-------------------------------------------------------Début-------------------------------------------------------");
        
        while(true){
            
            


            if(!tab_pirates.isEmpty() && !tab_traders.isEmpty()){
                System.out.println("Les pirates se déplacent ...\n");
                wait(1000);
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

                        if(p==tab_pirates.size()-1){
                            break;
                        }
                        else{
                            p++;
                        }
                    }
                }
            }

            
            
            if(!tab_policiers.isEmpty() && !tab_pirates.isEmpty()){
                System.out.println("\nLes policiers se déplacent pour venir arrêter les pirates...\n");
                wait(1000);
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
            }

            
            
            
            if(!tab_traders.isEmpty() && !tab_policiers.isEmpty()){
                System.out.println("\nLes policiers décident de taxer les pauvres traders aux alentours ...\n");
                wait(1000);
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
                System.out.println("\nLes policiers décident de taxer les traders corrompus...\n");
                wait(1000);
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

            
            
            
            if(!tab_policiers_corru.isEmpty() && !tab_traders_corru.isEmpty()){
                System.out.println("\nLes policiers corrompus décident d'éliminer la concurrence...\n");
                wait(1000);
                int o =0;
                for(int u =  0; u<tab_traders_corru.size();u++){
                    tab_policiers_corru.get(o).police_corru_attack(tab_policiers_corru.get(o), tab_traders_corru.get(u));
                    if(tab_policiers_corru.get(o).sink==true){
                        tab_policiers_corru.remove(o);
                        if(o==tab_policiers_corru.size()){
                            break;
                        }
                    }
                    else if(tab_traders_corru.get(u).sink == true){
                        tab_traders_corru.remove(u);
                        u--;

                        if(o==tab_policiers_corru.size()-1){
                            break;
                        }
                        else{
                            o++;
                        }
                    }
                }
            }

            
            
            if(tab_policiers_corru.size()>=tab_traders_corru.size() && !tab_pirates.isEmpty() && !tab_policiers_corru.isEmpty()){
                System.out.println("\nLes policiers corrompus décident de passer à l'attaque...\n");
                wait(1000);
                int q =0;
                for(int u =  0; u<tab_pirates.size();u++){
                    tab_policiers_corru.get(q).police_corru_attack(tab_policiers_corru.get(q),  tab_pirates.get(u));
                    if(tab_policiers_corru.get(q).sink==true){
                        tab_policiers_corru.remove(q);
                        if(q==tab_policiers_corru.size()){
                            break;
                        }
                    }
                    else if(tab_pirates.get(u).sink == true){
                        tab_pirates.remove(u);
                        u--;

                        if(q==tab_policiers_corru.size()-1){
                            break;
                        }
                        else{
                            q++;
                        }
                    }
                }
            }
            else if(tab_policiers_corru.size()<tab_traders_corru.size() && !tab_pirates.isEmpty() && !tab_traders_corru.isEmpty()){
                System.out.println("\nLes traders corrompus décident de passer à l'attaque...\n");
                wait(1000);
                int q =0;
                for(int u =  0; u<tab_pirates.size();u++){
                    tab_traders_corru.get(q).trader_corru_attack(tab_traders_corru.get(q), tab_pirates.get(u));
                    if(tab_traders_corru.get(q).sink==true){
                        tab_traders_corru.remove(q);
                        if(q==tab_traders_corru.size()){
                            break;
                        }
                    }
                    else if(tab_pirates.get(u).sink == true){
                        tab_pirates.remove(u);
                        u--;

                        if(q==tab_traders_corru.size()-1){
                            break;
                        }
                        else{
                            q++;
                        }
                    }
                }
            }

            
            if(tab_pirates.size() >= 2){
                System.out.println("\nLes pirates se décident de chasser leurs compères...\n");
                wait(1000);
         
                while(tab_pirates.size() >= 2){
                    int index = 1 + (int)(Math.random()*(tab_pirates.size()-2)); //index ]0;max_index_tab_pirate]
                    
                    tab_pirates.get(0).attack(tab_pirates.get(0), tab_pirates.get(index));
                    if(tab_pirates.get(0).sink==true){
                        tab_pirates.remove(0);
                    }
                    else if(tab_pirates.get(index).sink == true){
                        tab_pirates.remove(index); 
                    }
                }
            }
            
            int pirates_restants = tab_pirates.size();
            int traders_restants = tab_traders.size();
            int policiers_restants = tab_policiers.size();
            int corrupted_traders_restants = tab_traders_corru.size();
            int corrupted_policiers_restants = tab_policiers_corru.size();

            //On arrête le jeu
            if(pirates_restants == 1 || corrupted_traders_restants + corrupted_policiers_restants + traders_restants== 0){
                break;
            }
            
            
        }
        
        
        //------------------------------------------------------------------------------------------------//
        //------------------------------------------------------------------------------------------------//
        //------------------------------------------------------------------------------------------------//
        //------------------------------------------------------------------------------------------------//
        //------------------------------------------------------------------------------------------------//
        
        
        System.out.println("\n-------------------------------------------------------Fin de la partie !-------------------------------------------------------\n");
        
        wait(2000);
        
        System.out.println("\nRécap des bateaux restants:\n");
        System.out.println("Pour les pirates:");
        
        if(!tab_pirates.isEmpty()){
            for(int i = 0; i<tab_pirates.size();i++){
            System.out.print(tab_pirates.get(i).nom + " , menace: ");
            System.out.print(tab_pirates.get(i).menace);
            System.out.println(" , bounty: " + tab_pirates.get(i).bounty);
            }   
        }
        else{
            System.out.println("Tous les pirates sont coulés.");
        }
        
        
        System.out.println("\nPour les traders:");
        
        if(!tab_traders.isEmpty()){
            for(int i = 0; i<tab_traders.size();i++){
                System.out.print(tab_traders.get(i).nom + " , menace: ");
                System.out.print(tab_traders.get(i).menace);
                System.out.println(" , treasure: " + tab_traders.get(i).treasure);
            }
        }
        else{
            System.out.println("Tous les traders sont coulés.");
        }
        
        System.out.println("\nPour les policiers:");
        
        if(!tab_policiers.isEmpty()){
            for(int i = 0; i<tab_policiers.size();i++){
                System.out.print(tab_policiers.get(i).nom + " , menace: ");
                System.out.print(tab_policiers.get(i).menace);
                System.out.println(" , taxes: " + tab_policiers.get(i).taxes);
            }
        }
        else{
           System.out.println("Tous les policiers sont coulés."); 
        }
        
        System.out.println("\nPour les traders corrompus:");
        
        if(!tab_traders_corru.isEmpty()){
            for(int i = 0; i<tab_traders_corru.size();i++){
                System.out.print(tab_traders_corru.get(i).nom + " , menace: ");
                System.out.print(tab_traders_corru.get(i).menace);
                System.out.print(" , treasure: " + tab_traders_corru.get(i).treasure);
                System.out.println(" , bounty: " + tab_traders_corru.get(i).bounty);
            }
        }
        else{
           System.out.println("Tous les traders corrompus sont coulés."); 
        }
        
        System.out.println("\nPour les policiers corrompus:");
        
        if(!tab_policiers_corru.isEmpty()){
            for(int i = 0; i<tab_policiers_corru.size();i++){
                System.out.print(tab_policiers_corru.get(i).nom + " , menace: ");
                System.out.print(tab_policiers_corru.get(i).menace);
                System.out.print(" , taxes: " + tab_policiers_corru.get(i).taxes);
                System.out.println(" , bounty: " + tab_policiers_corru.get(i).bounty);
            }
        }
        else{
           System.out.println("Tous les policiers corrompus sont coulés."); 
        }
    }
    
}
