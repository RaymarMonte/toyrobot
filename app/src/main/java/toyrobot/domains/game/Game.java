package toyrobot.domains.game;

import java.util.Optional;

import toyrobot.domains.toyrobot.IToyRobot;
import toyrobot.domains.toyrobot.ToyRobotFactory;
import toyrobot.entities.Coordinates;
import toyrobot.entities.CoordinatesWithDirection;
import toyrobot.services.reporter.IReporter;

public class Game implements IGame {
    
    private static final int BOARD_DIMENSION_X = 5;
    private static final int BOARD_DIMENSION_Y = 5;

    private Optional<IToyRobot> robot;
    private IReporter reporter;

    public Game(IReporter reporter) {
        this.reporter = reporter;
        robot = Optional.empty();
    }

    @Override
    public void place(CoordinatesWithDirection coordsWithDirection) {
        if (isCoordinatesValid(coordsWithDirection.getCoordinates())) {
            robot = Optional.of(ToyRobotFactory.createRobot(coordsWithDirection));
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
    public CoordinatesWithDirection report() {
        if (robot.isPresent()) {
            CoordinatesWithDirection coordsWithDirection =
                robot.get().getDetails();
            reporter.report(coordsWithDirection);
            return coordsWithDirection;
        }
        return null;
    }

    private static boolean isCoordinatesValid(
        Coordinates coordinates) {
        if (coordinates.getX() < 0 ||
            coordinates.getX() >= BOARD_DIMENSION_X)
            return false;
        if (coordinates.getY() < 0 ||
            coordinates.getY() >= BOARD_DIMENSION_Y)
            return false;
        return true;
    }

}
