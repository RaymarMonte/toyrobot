package toyrobot.toyrobot;

import toyrobot.entities.Coordinates;
import toyrobot.entities.CoordinatesFacingADirection;

public interface IToyRobot {
    
    public void move();
    public void rotateLeft();
    public void rotateRight();
    public Coordinates nextMovePosition();
    public CoordinatesFacingADirection getDetails();

}
