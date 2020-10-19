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
public abstract class Crew extends Boats implements Recruitment {
    String crew_name;
    int nomber;
    boolean all_dead;
    
    
    public void speak(String say){
        System.out.println(crew_name + " : " + say);
    }
    
    public void introduce(){
        speak("Hello, we are " + crew_name + " and we love cacao");
    }
        
    
}
