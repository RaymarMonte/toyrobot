package toyrobot.robot;

import toyrobot.entities.Coordinates;
import toyrobot.entities.Vector;

public interface IRobot {
    
    public void move();
    public void rotateLeft();
    public void rotateRight();
    public Coordinates nextMovePosition();
    public Vector getDetails();

}
