package toyrobot.table;

import java.util.Optional;

import toyrobot.robot.IRobot;
import toyrobot.robot.RobotFactory;
import toyrobot.util.Coordinates;
import toyrobot.util.Vector;

public class FixedDimensionsTable implements ITable {
    
    private static final int DIMENSION_X = 5;
    private static final int DIMENSION_Y = 5;

    private Optional<IRobot> robot;

    public FixedDimensionsTable() {
        robot = Optional.empty();
    }

    @Override
    public void place(Vector vector) {
        if (isCoordinatesValid(vector.getCoordinates())) {
            robot = Optional.of(RobotFactory.getRobot(vector));
        }
    }

    @Override
    public void move() {
        robot.ifPresent(placedRobot -> {
            if (isCoordinatesValid(placedRobot.nextMovePosition())) {
                placedRobot.move();
            }
        });
        
    }

    @Override
    public void left() {
        robot.ifPresent(placedRobot -> placedRobot.rotateLeft());
        
    }

    @Override
    public void right() {
        robot.ifPresent(placedRobot -> placedRobot.rotateRight());
        
    }

    @Override
    public Optional<Vector> report() {
        Optional<Vector> vector = Optional.empty();
        if (robot.isPresent()) {
            vector = Optional.of(robot.get().getDetails());
        }
        return vector;
    }

    private static boolean isCoordinatesValid(
        Coordinates coordinates) {
        if (coordinates.getX() < 0 ||
            coordinates.getX() >= DIMENSION_X)
            return false;
        if (coordinates.getY() < 0 ||
            coordinates.getY() >= DIMENSION_Y)
            return false;
        return true;
    }

}
