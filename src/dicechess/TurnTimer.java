/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dicechess;

import java.util.Timer;
import java.util.TimerTask;
import javafx.scene.control.Label;

public class TurnTimer extends Label{
    
    protected static Timer timer;
    protected static TimerTask task;
    private static int seconds = 60;
    private static int minutes;
    protected boolean running;
    protected static int color;
    
    public TurnTimer(int color){
        setId("turnTimer");
        setPrefSize(160,160);
        this.color = color;
        running = false;
        initializeTimer();
        timer.schedule(task,1);
    }
    
    public void initializeTimer(){
        timer = new Timer();
        task = new TimerTask(){
            @Override
            public void run(){
                if (running) {
                    if (seconds != 0) {
                        seconds--;
                    } 
                    else{
                        minutes--;
                        seconds = 59;
                    }
                }
                setText(minutes + " " + seconds);
            }
        };
    }
    
    public void setTimerMode(int mode){
        if(mode == 1)
            minutes = 10;
        else if(mode == 2)
            minutes = 15;
        else if(mode == 3)
            minutes = 30;
        else if(mode == 4)
            minutes = 40;
    }
}
