package toyrobot;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.Test;

import toyrobot.robot.RobotData;
import toyrobot.robot.RobotPosition;
import toyrobot.robot.TableRobot;

class TableRobotTest {

    @Test void predictNextPositionAfterMoving() {
        TableRobot robot = new TableRobot(0, 0, Direction.NORTH);
        assertEquals(new RobotPosition(0, 1), robot.nextMovePosition());
    }
    
    @Test void movingRobot() {
        TableRobot robot = new TableRobot(1, 1, Direction.EAST);
        robot.move();
        assertEquals(
            new RobotData(new RobotPosition(2, 1), Direction.EAST),
            robot.getCurrentData());
    }

    @Test void rotatingRobotToLeft() {
        TableRobot robot = new TableRobot(2, 2, Direction.SOUTH);
        robot.rotateLeft();
        assertEquals(
            new RobotData(new RobotPosition(2, 2), Direction.EAST),
            robot.getCurrentData());
    }

    @Test void rotatingRobotToRight() {
        TableRobot robot = new TableRobot(3, 3, Direction.WEST);
        robot.rotateRight();
        assertEquals(
            new RobotData(new RobotPosition(3, 3), Direction.NORTH),
            robot.getCurrentData());
    }

}
