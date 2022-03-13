package toyrobot.robot;

import toyrobot.entities.Vector;

public class RobotFactory {

    public static IRobot getRobot(Vector vector) {
        return new ToyRobot(vector);
    }
    
}
