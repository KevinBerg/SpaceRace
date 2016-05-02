package Figure;

import java.awt.*;

/**
 * Created by Kevin on 03.10.2015.
 * Oberklasse sämtlicher Spielfiguren.
 */
public class Figure{

    private int speed;
    private int x;
    private int y;
    private int width;
    private int height;
    private Rectangle rectangle;

    public Figure(int width, int height, int speed){
        this.speed = speed;
        createRectangle();
        setSize(width, height);
    }

    public int getSpeed() {
        return speed;
    }

    public Rectangle getRectangle() {
        return rectangle;
    }

    public void createRectangle() {
        this.rectangle = new Rectangle(width, height, x, y);
    }

    public int getWidth() {
        return width;
    }

    public void setLocation(int x, int y){
        this.x = x;
        this.y = y;
        rectangle.setLocation(x, y);
    }

    public int[] getLocation(){
        int pos[] = {x, y};
        return pos;
    }

    public void setSize(int width, int height){
        this.width = width;
        this. height = height;
        rectangle.setSize(width, height);
    }

    public int[] getSize(){
        int size[] = {width, height};
        return size;
    }

    public void moveRight(int value){
        x += value;
        rectangle.setLocation(x, y);
    }

    public void moveLeft(int value){
        x -= value;
        rectangle.setLocation(x, y);
    }

    public void moveUp(int value){
        y -= value;
        rectangle.setLocation(x, y);
    }

    public void moveDown(int value){
        y += value;
        rectangle.setLocation(x, y);
    }

    public int getLocationX(){
        return this.x;
    }

    public void setLocationX(int x){
        this.x = x;
        rectangle.setLocation(x, this.y);
    }

    public void setLocationY(int y){
        this.y = y;
        rectangle.setLocation(this.x, y);
    }

}
