package toyrobot.game;

import java.util.Optional;

import toyrobot.entities.Coordinates;
import toyrobot.entities.CoordinatesFacingADirection;
import toyrobot.reporter.IReporter;
import toyrobot.toyrobot.IToyRobot;
import toyrobot.toyrobot.RobotFactory;

public class Game implements IGame {
    
    private static final int TABLE_DIMENSION_X = 5;
    private static final int TABLE_DIMENSION_Y = 5;

    private Optional<IToyRobot> robot;
    private IReporter reporter;

    public Game(IReporter reporter) {
        this.reporter = reporter;
        robot = Optional.empty();
    }

    @Override
    public void place(CoordinatesFacingADirection coordsFacingDirection) {
        if (isCoordinatesValid(coordsFacingDirection.getCoordinates())) {
            robot = Optional.of(RobotFactory.getRobot(coordsFacingDirection));
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
    public void report() {
        robot.ifPresent(placedRobot -> reporter.report(
            placedRobot.getDetails()));
    }

    private static boolean isCoordinatesValid(
        Coordinates coordinates) {
        if (coordinates.getX() < 0 ||
            coordinates.getX() >= TABLE_DIMENSION_X)
            return false;
        if (coordinates.getY() < 0 ||
            coordinates.getY() >= TABLE_DIMENSION_Y)
            return false;
        return true;
    }

}
