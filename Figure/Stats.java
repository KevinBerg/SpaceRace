package Figure;

/**
 * Created by Kevin on 03.10.2015.
 */

/**
 * class for the points of the player.
 */
public class Stats {

    private int points = 0;

    public Stats(){}

    public int getPoints() {
        return points;
    }

    public void increasePoints(int points){
        this.points += points;
    }

    public void decrasePoints(int points){
        this.points -= points;
    }

}
