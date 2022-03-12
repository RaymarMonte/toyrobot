package toyrobot.robot;

import toyrobot.Direction;

public class RobotData {
    
    private RobotPosition position;
    /** The direction that the robot is facing. */
    private Direction facing;
    
    public RobotData(RobotPosition position, Direction facing) {
        this.position = position;
        this.facing = facing;
    }
    
    public RobotPosition getPosition() {
        return position;
    }

    public void setPosition(RobotPosition position) {
        this.position = position;
    }

    public Direction getFacing() {
        return facing;
    }
    
    public void setFacing(Direction facing) {
        this.facing = facing;
    }

}
