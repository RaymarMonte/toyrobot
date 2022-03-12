package toyrobot.robot;

import toyrobot.util.Direction;

public class RobotFactory {

    public static IRobot getRobot(int x, int y, Direction face) {
        return new ToyRobot(x, y, face);
    }
    
}
