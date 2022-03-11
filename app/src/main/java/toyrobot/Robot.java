package toyrobot;

/**
 * Represents a robot that has an x and y position and faces a particular
 * direction.
 */
public class Robot {
    
    private int positionX;
    private int positionY;
    /** The direction that the robot is facing. */
    private Direction facing;
    
    public Robot(int positionX, int positionY, Direction facing) {
        this.positionX = positionX;
        this.positionY = positionY;
        this.facing = facing;
    }

    public int getPositionX() {
        return positionX;
    }

    public void setPositionX(int positionX) {
        this.positionX = positionX;
    }

    public int getPositionY() {
        return positionY;
    }

    public void setPositionY(int positionY) {
        this.positionY = positionY;
    }

    public Direction getFacing() {
        return facing;
    }

    public void setFacing(Direction facing) {
        this.facing = facing;
    }

}
