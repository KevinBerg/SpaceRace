package Control;

import Figure.Player;
import javafx.scene.input.KeyCode;

import java.awt.event.KeyEvent;

/**
 * Created by Kevin on 04.10.2015.
 */

/**
 * Class (Listener) for moving the player and quit the game.
 */
public class KeyListener implements java.awt.event.KeyListener {

    Player player;

    public KeyListener(Player player){
        this.player = player;
    }

    /**
     * Performed if a key was pressed.
     * @param e
     */
    @Override
    public void keyPressed(KeyEvent e) {

        int keyCode = e.getKeyCode();

        if(keyCode == KeyEvent.VK_DOWN){
            if( ! player.isMovePossible("d")) return; // checks if moving "d" = "down" is possible
            player.moveDown(player.getSpeed());
        }

        if(keyCode == KeyEvent.VK_UP){
            if( ! player.isMovePossible("u")) return;
            player.moveUp(player.getSpeed());
        }

        if(keyCode == KeyEvent.VK_LEFT){
            if( ! player.isMovePossible("l")) return;
            player.moveLeft(player.getSpeed());
        }

        if(keyCode == KeyEvent.VK_RIGHT){
            if( ! player.isMovePossible("r")) return;
            player.moveRight(player.getSpeed());
        }

        if(keyCode == KeyEvent.VK_ESCAPE){
            System.exit(0);
        }
    } // KeyPressed

    @Override
    public void keyReleased(KeyEvent e) {}

    @Override
    public void keyTyped(KeyEvent e) {}
} // class
