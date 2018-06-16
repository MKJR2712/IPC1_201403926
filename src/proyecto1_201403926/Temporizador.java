/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package proyecto1_201403926;
import java.util.TimerTask;
import java.util.Timer;

/**
 *
 * @author MKJR
 */
public class Temporizador {
    private int sec=0,min=0;
    private String tiempo;
    public Temporizador(Principal prin){
        Timer t = new Timer();
        TimerTask tarea = new TimerTask() {

            @Override
            public void run() {
                ++sec;
                if(sec==60){
                    sec=0;
                    ++min;
                }
                tiempo = (min<=9?"0":"") + min + " : "+ (sec<=9?"0":"") + sec;
                prin.timer.setText(tiempo);
                if(min==prin.tiempo){
                    t.cancel();
                    prin.juego=false;
                }
            }
        };
        t.schedule(tarea, 0, 1000);
        
    }
}