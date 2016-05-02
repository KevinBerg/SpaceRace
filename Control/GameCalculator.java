package Control;

import Config.GameConfig;
import Figure.Enemy;
import Figure.Player;
import Figure.Stats;
import UserInterface.View;
import UserInterface.Audio;

import java.util.Observable;
import java.util.Observer;

/**
 * Created by Kevin on 03.10.2015.
 * Übernimmt Berechnung von Positionen und Kollisionen.
 * OBSERVER-PATTERN
 */
public class GameCalculator implements Observer{

    private GameConfig config = GameConfig.getInstance();
    private Stats stats = new Stats();
    private View frame;

    private Player player = new Player(
            config.getPlayerWidth(),
            config.getPlayerHeight(),
            config.getPlayerSpeed()
    );

    private Enemy enemies[] = new Enemy[config.getNumberOfEnemies()];
    private Timer timer = new Timer(config.getTimerMillis());


    public GameCalculator(){
        initEnemies();
        player.setLocation(config.getPlayerStartPosX(), config.getPlayerStartPosY());
        frame = new View(config.getWindowWidth(), config.getWindowHeight(), enemies, player, stats);
        timer.addObserver(this);
        timer.run();
        new Audio(config.getBackgroundSoundPath()).start();
    }

    private void initEnemies(){
        for(int i=0; i < enemies.length; i++){
            enemies[i] = new Enemy(
                    config.getEnemyWidth(),
                    config.getEnemyHeight(),
                    config.getEnemySpeed()
            );
        }
    }

    private boolean isCollision(){
        for(int i=0; i < enemies.length; i++){
            if(player.getRectangle().intersects(enemies[i].getRectangle())){
                new Audio(config.getCollisionSoundPath(), 1).start();
                return true;
            }
        }
        return false;
    }

    /**
     * calculates the next location of all enemies.
     * @param frameTime
     */
    private void setNextEnemyLocations(float frameTime){
        for(int i=0;i<enemies.length;i++){
            enemies[i].setNextLocation(frameTime);
        }
    }

    /**
     * Sets the startlocation of all enemies.
     */
    private void resetEnemyLocations(){
        for(int i=0;i<enemies.length;i++){
            enemies[i].setStartLocation();
        }
    }

    private void calculatePoints(){
        stats.increasePoints( (player.getLocationX() / 100) );
    }

    @Override
    public void update(Observable o, Object arg) {

        frame.repaint();

        if(isCollision()){
            player.resetLocation(); // set the player to his startlocation
            resetEnemyLocations(); // set all enemies to a new locaion
            stats.decrasePoints(config.getCollisionPoints()); // reduce the points of the player
        }

        calculatePoints();

        float systemTime = (Float)arg;
        setNextEnemyLocations(systemTime);
    }
}
