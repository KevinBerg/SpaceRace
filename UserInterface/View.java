package UserInterface;

import Control.KeyListener;
import Figure.Enemy;
import Figure.Player;
import Config.GameConfig;
import Figure.Stats;

import javax.imageio.ImageIO;
import javax.swing.*;
import java.awt.*;
import java.io.File;
import java.io.IOException;

/**
 * Created by Kevin on 03.10.2015.
 */

/**
 * Class for the graphical user interface.
 * Draws all components.
 */
public class View extends JFrame {

    GameConfig config = GameConfig.getInstance();

    private Image dbImage = null; // DoubleBuffering
    private Graphics dbGraphics = null; // DoubleBuffering
    private Image bgImage;

    private Enemy enemies[];
    private Player player;
    private Stats stats;


    public View(int width, int height, Enemy enemies[], Player player, Stats stats){
        this.enemies = enemies;
        this.player = player;
        this.stats = stats;

        try {
            bgImage = ImageIO.read(new File(config.getCwd() + File.separator + "src" + File.separator + "Image"+ File.separator + "bg.jpg")); //TODO aus conf
        } catch (IOException e) {
            e.printStackTrace();
        }

        addKeyListener(new KeyListener(player));

        setSize(width, height);
        setLocationRelativeTo(null); // centre the frame on screen
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE); // program exit when closing the frame
        setTitle(config.getTitle());
        setUndecorated(true);
        setVisible(true);
    }


    private void drawPlayer(Graphics g){

        // get players location and size
        int loc[] = player.getLocation();
        int size[] = player.getSize();

        g.drawImage(player.getImage(), loc[0], loc[1], size[0], size[1], this);
    }

    private void drawBackground(Graphics g){
        g.drawImage(bgImage, 0, 0, config.getWindowWidth(), config.getWindowHeight(), this);
    }

    private void drawEnemies(Graphics g){
        for(int i=0; i < this.enemies.length; i++){

            // get enemy's location and size
            int loc[] = this.enemies[i].getLocation();
            int size[] = this.enemies[i].getSize();

            g.drawImage(enemies[i].getImage(), loc[0], loc[1], size[0], size[1], this);
        }
    }

    /**
     * Draws the current points of the player.
     * @param g
     */
    private void drawPoints(Graphics g){
        g.setFont(new Font("default", Font.BOLD, 16));
        g.setColor(Color.white);
        g.drawString(String.valueOf(config.getPointsPrefix() + stats.getPoints()), config.getPointLabelLocationX(), config.getPointLabelLocationY());
    }

    /**
     * DoubleBuffering
     * @param g
     */
    public void paint(Graphics g) {

        dbImage = createImage(getWidth(), getHeight());
        dbGraphics = dbImage.getGraphics();

        try {
            paintComponent(dbGraphics);
        } catch (IOException e) {
            e.printStackTrace();
        }

        g.drawImage(dbImage, 0, 0, this);
    }

    /**
     * Draws the components,
     * @param g
     * @throws IOException
     */
    public void paintComponent(Graphics g) throws IOException {
        drawBackground(g);
        drawPlayer(g);
        drawEnemies(g);
        drawPoints(g);
    }
} // class
