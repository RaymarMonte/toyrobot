package toyrobot;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

import org.junit.jupiter.api.Test;

class TableTest {
    
    @Test void moveRobotWithoutPlacing() {
        Table table = new Table();
        assertThrows(RobotNotYetPlacedException.class,
            () -> table.moveRobot());
    }

    @Test void rotateLeftRobotWithoutPlacing() {
        Table table = new Table();
        assertThrows(RobotNotYetPlacedException.class,
            () -> table.rotateRobotToLeft());
    }

    @Test void rotateRightRobotWithoutPlacing() {
        Table table = new Table();
        assertThrows(RobotNotYetPlacedException.class,
            () -> table.rotateRobotToRight());
    }

    @Test void reportWithoutPlacingRobot() {
        Table table = new Table();
        assertThrows(RobotNotYetPlacedException.class,
            () -> table.report());
    }

    @Test void placingRobot() {
        Table table = new Table();
        table.placeRobot(0, 1, Direction.NORTH);
        Robot robot = table.report();
        assertEquals(0, robot.getPositionX());
        assertEquals(1, robot.getPositionY());
        assertEquals(Direction.NORTH, robot.getFacing());
    }

    @Test void movingRobot() {
        Table table = new Table();
        table.placeRobot(0, 0, Direction.NORTH);
        table.moveRobot();
        Robot robot = table.report();
        assertEquals(1, robot.getPositionY());
    }
    
    @Test void rotatingRobotToLeft() {
        Table table = new Table();
        table.placeRobot(0, 0, Direction.NORTH);
        table.rotateRobotToLeft();
        Robot robot = table.report();
        assertEquals(Direction.WEST, robot.getFacing());
    }

    @Test void rotatingRobotToRight() {
        Table table = new Table();
        table.placeRobot(0, 0, Direction.NORTH);
        table.rotateRobotToRight();
        Robot robot = table.report();
        assertEquals(Direction.EAST, robot.getFacing());
    }

    @Test void placingRobotOOB() { // OOB - Out of Bounds
        Table table = new Table();
        assertThrows(RobotOutOfBoundsException.class,
            () -> table.placeRobot(10, 10, Direction.NORTH));
    }

    @Test void movingRobotToOOB() { // OOB - Out of Bounds
        Table table = new Table();
        table.placeRobot(4, 4, Direction.NORTH);
        assertThrows(RobotOutOfBoundsException.class,
            () -> table.moveRobot());
    }
}
