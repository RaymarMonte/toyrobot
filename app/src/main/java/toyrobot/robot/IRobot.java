package toyrobot.robot;

import toyrobot.util.Coordinates;
import toyrobot.util.Vector;

public interface IRobot {
    
    public void move();
    public void rotateLeft();
    public void rotateRight();
    public Coordinates nextMovePosition();
    public Vector getDetails();

}
