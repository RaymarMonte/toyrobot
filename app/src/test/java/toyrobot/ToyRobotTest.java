package toyrobot;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.Test;

import toyrobot.robot.ToyRobot;
import toyrobot.util.Coordinates;
import toyrobot.util.Direction;
import toyrobot.util.Vector;

class ToyRobotTest {

    @Test void predictNextPositionAfterMoving() {
        ToyRobot robot = new ToyRobot(0, 0, Direction.NORTH);
        assertEquals(new Coordinates(0, 1), robot.nextMovePosition());
    }
    
    @Test void movingRobot() {
        ToyRobot robot = new ToyRobot(1, 1, Direction.EAST);
        robot.move();
        assertEquals(
            new Vector(new Coordinates(2, 1), Direction.EAST),
            robot.getDetails());
    }

    @Test void rotatingRobotToLeft() {
        ToyRobot robot = new ToyRobot(2, 2, Direction.SOUTH);
        robot.rotateLeft();
        assertEquals(
            new Vector(new Coordinates(2, 2), Direction.EAST),
            robot.getDetails());
    }

    @Test void rotatingRobotToRight() {
        ToyRobot robot = new ToyRobot(3, 3, Direction.WEST);
        robot.rotateRight();
        assertEquals(
            new Vector(new Coordinates(3, 3), Direction.NORTH),
            robot.getDetails());
    }

}
