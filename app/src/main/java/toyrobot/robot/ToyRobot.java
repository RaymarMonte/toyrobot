package toyrobot.robot;

import java.util.EnumMap;

import toyrobot.entities.Coordinates;
import toyrobot.entities.Direction;
import toyrobot.entities.Vector;

/**
 * Implementation of a robot that gets placed on a table, can move one step
 * on the direction it's facing, can face left, and can face right.
 */
public class ToyRobot implements IRobot {

    private Vector details;

    /** 
     * Map of the forward displacement that will be done depending on the
     * direction that is being faced.
     */
    private static final EnumMap<Direction, Coordinates> movementMap =
        createMovementMap();

    public ToyRobot(Vector details) {
        this.details = details;
    }

    public ToyRobot(int x, int y, Direction orientation) {
        details = new Vector(x, y, orientation);
    }

    @Override
    public void move() {
        details.setCoordinates(nextMovePosition());
    }

    @Override
    public void rotateLeft() {
        details.setOrientation(Direction.leftOf(details.getOrientation()));
    }

    @Override
    public void rotateRight() {
        details.setOrientation(Direction.rightOf(details.getOrientation()));
        
    }

    @Override
    public Coordinates nextMovePosition() {
        Coordinates movement = movementMap.get(details.getOrientation());
        return Coordinates.addCoordinates(
            details.getCoordinates(), movement);
    }

    /**
     * Returns a copy of the the current details of the robot.
     */
    @Override
    public Vector getDetails() {
        return new Vector(details);
    }
    
    private static EnumMap<Direction, Coordinates> createMovementMap() {
        EnumMap<Direction, Coordinates> movementMap = new EnumMap<>(Direction.class);
        movementMap.put(Direction.NORTH, new Coordinates(0, 1));
        movementMap.put(Direction.EAST, new Coordinates(1, 0));
        movementMap.put(Direction.SOUTH, new Coordinates(0, -1));
        movementMap.put(Direction.WEST, new Coordinates(-1, 0));
        return movementMap;
    }

}
