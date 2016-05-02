package Figure;

import Config.GameConfig;

import javax.imageio.ImageIO;
import java.awt.*;
import java.io.File;
import java.io.IOException;
import java.util.Random;

/**
 * Created by Kevin on 03.10.2015.
 */
public class Enemy extends Figure {

    GameConfig config = GameConfig.getInstance();
    private Random randomizer = new Random();
    private Image image;  // TODO could be in the class Figure. (for a later version)


    public Enemy(int width, int height, int speed){
        super(width, height, speed);
        try {
            image = ImageIO.read(new File(config.getEnemyImagePath()));
        } catch (IOException e) {
            e.printStackTrace();
        }
        setStartLocation();
    }

    /**
     * sets the enemy rightwards out of the field
     * so that the enemy flies in the gamefield back.
     */
    public void resetLocationX(){
        setLocationX(config.getWindowWidth() + getWidth());
    }

    /**
     * Returns true when the enemy is out of the main frame.
     * @return bool
     */
    public boolean isOutOfField(){
        return getLocationX() <= -getWidth();
    }

    public void setLocationYToRand(){
        int possibleStartPosY = config.getWindowHeight();
        int y = (int) Math.round(Math.random() * possibleStartPosY);
        setLocationY(y);
    }

    /**
     * Sets the startlocation of the enemy.
     * TODO avoid two enemies at one loc (for a later version)
     */
    public void setStartLocation(){
        int min = config.getWindowWidth() / 2;
        int max = config.getWindowWidth();

        int x = min + randomizer.nextInt(max-min + 1);
        setLocationX(x);
        setLocationYToRand();
    }


    public void setNextLocation(float frameTime){

        int correctionTime = (int) (frameTime);;

        if(correctionTime == 0){
            correctionTime = 1;
        }

        int nextLocX = ( getLocationX() - getSpeed() ) / correctionTime;
        setLocationX(nextLocX);

        if(isOutOfField()){
            resetLocationX();
            setLocationYToRand();
        }
    }

    public Image getImage() {
        return image;
    }
} // class
