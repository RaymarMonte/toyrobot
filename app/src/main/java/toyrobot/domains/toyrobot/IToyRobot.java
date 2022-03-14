package toyrobot.domains.toyrobot;

import toyrobot.entities.Coordinates;
import toyrobot.entities.CoordinatesWithDirection;

public interface IToyRobot {
    
    public void move();
    public void rotateLeft();
    public void rotateRight();
    public Coordinates nextMovePosition();
    public CoordinatesWithDirection getDetails();

}
