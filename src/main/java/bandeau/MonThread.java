/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package bandeau;

import java.util.List;

/**
 *
 * @author bdacosta
 */
public class MonThread extends Thread {
    Bandeau b;
    List<ScenarioElement> myElements;

    public MonThread(Bandeau b, List<ScenarioElement> myElements) {
        this.b = b;
        this.myElements = myElements;
    }
    
    public void run(){
        synchronized(b){
        for (ScenarioElement element : myElements) {
            for (int repeats = 0; repeats < element.repeats; repeats++) {
                element.effect.playOn(b);
            }
        }
    }
    }
}
