package toyrobot.domains.toyrobot;

import toyrobot.entities.CoordinatesWithDirection;

public class ToyRobotFactory {

    public static IToyRobot createRobot(CoordinatesWithDirection coordsWithDirection) {
        return new ToyRobot(coordsWithDirection);
    }
    
}
