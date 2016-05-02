package Control;

import java.util.Observable;
import java.util.Observer;

/**
 * Created by Kevin on 03.10.2015.
 * Ist dafür zuständig, wann das "Spiel" neu berechnet wird.
 * OBSERVER-PATTERN
 */
public class Timer extends Observable implements Runnable{
    
    long sleepTime;

    long lastFrame; // Berechnungsgeschwindigkeit des letzten Frames
    float timeSinceLastFrame; // Aktuelle Systemzeit wird hier gespeichert

    public Timer(long sleepTime){
        this.sleepTime = sleepTime;
    }


    private void calculateFrameTime(){
        long thisFrame = System.currentTimeMillis();
        this.timeSinceLastFrame = (float)(thisFrame - this.lastFrame) / 1000f;
        this.lastFrame = thisFrame;
    }


    public float getTimeSinceLastFrame(){
        return this.timeSinceLastFrame; // Dieser Wert muss mit allen Koordinatenänderungen von beweglichen Figuren multipliziert werden!
    }


    @Override
    public void addObserver(Observer o) {
        super.addObserver(o);
    }

    @Override
    public void run() {

        while(true){
            try {
                Thread.sleep(this.sleepTime);
                calculateFrameTime(); //Berechnung der Systemzeit
                setChanged();
                notifyObservers(getTimeSinceLastFrame());

            } catch (InterruptedException e) {
                System.err.println("Error in Timer.java");
            }

        } // while
    } // run
} //class
