package Figure;

import Config.GameConfig;

import javax.imageio.ImageIO;
import java.io.File;
import java.io.IOException;
import java.awt.*;

/**
 * Created by Kevin on 03.10.2015.
 */
public class Player extends Figure{

    private GameConfig config = GameConfig.getInstance();
    private Image image; // TODO could be in the class Figure. (for a later version)

    public Player(int width, int height, int speed){
        super(width, height, speed);
        try {
            image = ImageIO.read(new File(config.getPlayerImagePath()));
        } catch (IOException e) {
            e.printStackTrace();
        }
        resetLocation(); // now set the right position
    }

    /**
     * Checks if moving is possible.
     * @param direction d = down, u = up, l = left, r = right
     * @return boolean
     */
    public boolean isMovePossible(String direction){

        int location[] = getLocation();
        int x = location[0];
        int y = location[1];

        if(direction.equals("l")){
            if( ! (x >= ((config.getPlayerWidth() / 2) - config.getPlayerSpeed()))){
                return false;
            } else {
                return true;
            }

        } else if(direction.equals("u")){

            if( ! (y >= ((config.getPlayerHeight() / 2) - config.getPlayerSpeed()))){
                return false;
            } else {
                return true;
            }

        } else if(direction.equals("d")){

            if((y + config.getPlayerSpeed()) > (config.getWindowHeight() - config.getPlayerHeight())){
                return false;
            } else {
                return true;
            }
        } else if(direction.equals("r")) {

            if ( x + config.getPlayerSpeed() > config.getWindowWidth() - config.getPlayerWidth()) {
                return false;
            } else {
                return true;
            }

        }
        return false;
    }

    /**
     * Sets the player to the startlocation
     */
    public void resetLocation(){
        setLocation(config.getPlayerStartPosX(), config.getPlayerStartPosY());
    }

    public Image getImage() {
        return image;
    }
} // class
