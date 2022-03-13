package toyrobot;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.Test;

import toyrobot.entities.Coordinates;
import toyrobot.entities.Direction;
import toyrobot.entities.Vector;
import toyrobot.robot.ToyRobot;

class RobotTest {

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
