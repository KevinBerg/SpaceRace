package Config;

import java.io.File;

/**
 * Created by Kevin on 03.10.2015.
 * Static class for all configurations.
 * SINGLETON-PATTERN
 */
public class GameConfig {

    /**
     * the one and only instance
     */
    private static GameConfig gameConfig;

    /**
     * private constructor to avoid creating more instances.
     */
    private GameConfig(){}

    /**
     * returns the GameConfigInstance.
     * If the instance doesn't exists it creates the instance.
     * @return
     */
    public static GameConfig getInstance(){
        if(gameConfig != null){
            return gameConfig;
        } else {
            gameConfig = new GameConfig();
            return gameConfig;
        }
    }

    // ------------------ C O N F I G  V A R ' S : ------------------------------

    // current work directory
    private String cwd = new File("").getAbsolutePath();

    private long timerMillis = 30; // millis for the timer
    private int windowWidth = 600;
    private int windowHeight = 600;
    private int collisionPoints = 1000;
    private int pointLabelLocationX = 20;
    private int pointLabelLocationY = getWindowHeight() - 20;
    private String title = "Space Race";
    private String pointsPrefix = "Punkte: ";

    // -------------- E N E M Y ---------------------
    private int numberOfEnemies = 7;
    private int enemyWidth = 40;
    private int enemyHeight = 40;
    private int enemySpeed = 7;
    private String enemyImagePath = getCwd() + File.separator + "src" + File.separator + "Image" + File.separator + "spaceship_2.png";
    // -------------- E N E M Y ---------------------

    // -------------- P L A Y E R---------------------
    private int playerWidth = 40;
    private int playerHeight = 40;
    private int playerStartPosX = getPlayerWidth();
    private int playerStartPosY = (getWindowHeight() / 2) - (getPlayerHeight() / 2);
    private int playerSpeed = 10;
    private String playerImagePath = getCwd() + File.separator + "src" + File.separator + "Image" + File.separator + "spaceship_1.png";
    // -------------- P L A Y E R---------------------

    // -------------- S O U N D S --------------------
    private String backgroundSoundPath = getCwd() + File.separator + "src" + File.separator + "Audio" + File.separator + "bg.wav";
    private String collisionSoundPath = getCwd() + File.separator + "src" + File.separator + "Audio" + File.separator + "collision.wav";
    // -------------- S O U N D S --------------------


    // ------------------ G E T T E R S : ------------------------------

    public int getNumberOfEnemies() {
        return numberOfEnemies;
    }

    public long getTimerMillis() {
        return timerMillis;
    }

    public int getWindowWidth() {
        return windowWidth;
    }

    public int getWindowHeight() {
        return windowHeight;
    }

    public int getEnemyWidth() {
        return enemyWidth;
    }

    public int getEnemyHeight() {
        return enemyHeight;
    }

    public int getPlayerWidth() {
        return playerWidth;
    }

    public int getPlayerHeight() {
        return playerHeight;
    }

    public int getPlayerStartPosX() {
        return playerStartPosX;
    }

    public int getPlayerStartPosY() {
        return playerStartPosY;
    }

    public int getEnemySpeed() {
        return enemySpeed;
    }

    public int getPlayerSpeed() {
        return playerSpeed;
    }

    public String getTitle() {
        return title;
    }

    public String getCwd() {
        return cwd;
    }

    public String getPlayerImagePath() {
        return playerImagePath;
    }

    public String getEnemyImagePath() {
        return enemyImagePath;
    }

    public int getCollisionPoints() {
        return collisionPoints;
    }

    public int getPointLabelLocationY() {
        return pointLabelLocationY;
    }

    public int getPointLabelLocationX() {
        return pointLabelLocationX;
    }

    public String getPointsPrefix() {
        return pointsPrefix;
    }

    public String getCollisionSoundPath() {
        return collisionSoundPath;
    }

    public String getBackgroundSoundPath() {
        return backgroundSoundPath;
    }
} //class
