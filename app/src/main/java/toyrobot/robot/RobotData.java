package toyrobot.robot;

import toyrobot.Direction;

public class RobotData {
    
    private RobotCoordinates position;
    /** The direction that the robot is facing. */
    private Direction facing;
    
    public RobotData(RobotCoordinates position, Direction facing) {
        this.position = position;
        this.facing = facing;
    }
    
    public RobotCoordinates getPosition() {
        return position;
    }

    public void setPosition(RobotCoordinates position) {
        this.position = position;
    }

    public Direction getFacing() {
        return facing;
    }
    
    public void setFacing(Direction facing) {
        this.facing = facing;
    }

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + ((facing == null) ? 0 : facing.hashCode());
        result = prime * result + ((position == null) ? 0 : position.hashCode());
        return result;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj)
            return true;
        if (obj == null)
            return false;
        if (getClass() != obj.getClass())
            return false;
        RobotData other = (RobotData) obj;
        if (facing != other.facing)
            return false;
        if (position == null) {
            if (other.position != null)
                return false;
        } else if (!position.equals(other.position))
            return false;
        return true;
    }
    
}
