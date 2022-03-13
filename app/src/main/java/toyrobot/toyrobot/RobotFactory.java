package toyrobot.toyrobot;

import toyrobot.entities.CoordinatesFacingADirection;

public class RobotFactory {

    public static IToyRobot getRobot(CoordinatesFacingADirection coordsFacingDirection) {
        return new ToyRobot(coordsFacingDirection);
    }
    
}
