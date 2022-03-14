package toyrobot.domain;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.Test;

import toyrobot.domains.toyrobot.ToyRobot;
import toyrobot.entities.Coordinates;
import toyrobot.entities.Direction;
import toyrobot.entities.CoordinatesWithDirection;

class ToyRobotTest {

    @Test void toyRobotCanGiveInfoAboutNextMove() {
        ToyRobot robot = new ToyRobot(0, 0, Direction.NORTH);
        assertEquals(new Coordinates(0, 1), robot.nextMovePosition());
    }
    
    @Test void toyRobotMovesOneStepForward() {
        ToyRobot robot = new ToyRobot(1, 1, Direction.EAST);
        robot.move();
        assertEquals(
            new CoordinatesWithDirection(new Coordinates(2, 1), Direction.EAST),
            robot.getDetails());
    }

    @Test void toyRobotCanRotateLeft() {
        ToyRobot robot = new ToyRobot(2, 2, Direction.SOUTH);
        robot.rotateLeft();
        assertEquals(
            new CoordinatesWithDirection(new Coordinates(2, 2), Direction.EAST),
            robot.getDetails());
    }

    @Test void toyRobotCanRotateRight() {
        ToyRobot robot = new ToyRobot(3, 3, Direction.WEST);
        robot.rotateRight();
        assertEquals(
            new CoordinatesWithDirection(new Coordinates(3, 3), Direction.NORTH),
            robot.getDetails());
    }

}
