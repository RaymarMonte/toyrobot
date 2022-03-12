package toyrobot.robot;

import java.util.EnumMap;
import toyrobot.Direction;

/**
 * Implementation of a robot that gets placed on a table, can move one step
 * on the direction it's facing, can face left, and can face right.
 */
public class TableRobot implements Robot {

    private RobotData data;

    /** 
     * Map of the forward displacement that will be done depending on the
     * direction that is being faced.
     */
    private static final EnumMap<Direction, RobotCoordinates> movementMap =
        createMovementMap();

    public TableRobot(int x, int y, Direction facing) {
        RobotCoordinates position = new RobotCoordinates(x, y);
        data = new RobotData(position, facing);

    }

    @Override
    public void move() {
        data.setPosition(nextMovePosition());
    }

    @Override
    public void rotateLeft() {
        data.setFacing(Direction.leftOf(data.getFacing()));
    }

    @Override
    public void rotateRight() {
        data.setFacing(Direction.rightOf(data.getFacing()));
        
    }

    @Override
    public RobotCoordinates nextMovePosition() {
        RobotCoordinates movement = movementMap.get(data.getFacing());
        return RobotCoordinates.addCoordinates(
            data.getPosition(), movement);
    }

    /**
     * Returns a copy of the the current data of the robot.
     */
    @Override
    public RobotData getCurrentData() {
        return new RobotData(
            new RobotCoordinates(
                data.getPosition().getPositionX(), 
                data.getPosition().getPositionY()),
            data.getFacing()
        );
    }
    
    private static EnumMap<Direction, RobotCoordinates> createMovementMap() {
        EnumMap<Direction, RobotCoordinates> movementMap = new EnumMap<>(Direction.class);
        movementMap.put(Direction.NORTH, new RobotCoordinates(0, 1));
        movementMap.put(Direction.EAST, new RobotCoordinates(1, 0));
        movementMap.put(Direction.SOUTH, new RobotCoordinates(0, -1));
        movementMap.put(Direction.WEST, new RobotCoordinates(-1, 0));
        return movementMap;
    }

}
