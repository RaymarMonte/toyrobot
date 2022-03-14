package toyrobot;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.Test;

import toyrobot.entities.CoordinatesWithDirection;
import toyrobot.entities.Direction;
import toyrobot.game.Game;
import toyrobot.reporter.IReporter;
import toyrobot.reporter.Reporter;

public class GameTest extends SysOutTest {
    
    /**
     * Using the Reporter implementation of IReporter as Game dependency
     * instead of mocking since its reporting is just a simple system out
     * printing.
     */
    private IReporter reporter = new Reporter();

    @Test void moveHaveNoEffectWithoutPlace() {
        Game game = new Game(reporter);
        game.move();
        game.report();
        assertEquals("".trim(), outContent.toString().trim());
    }
    
    @Test void leftHaveNoEffectWithoutPlace() {
        Game game = new Game(reporter);
        game.left();
        game.report();
        assertEquals("".trim(), outContent.toString().trim());
    }

    @Test void rightHaveNoEffectWithoutPlace() {
        Game game = new Game(reporter);
        game.right();
        game.report();
        assertEquals("".trim(), outContent.toString().trim());
    }
    
    @Test void reportHaveNoEffectWithoutPlace() {
        Game game = new Game(reporter);
        game.report();
        assertEquals("".trim(), outContent.toString().trim());
    }

    @Test void gameCanPlaceInsideBoard() {
        Game game = new Game(reporter);
        game.place(new CoordinatesWithDirection(0, 0, Direction.NORTH));
        game.report();
        assertEquals("0,0,NORTH".trim(), outContent.toString().trim());
    }

    @Test void gameCanMoveAfterPlace() {
        Game game = new Game(reporter);
        game.place(new CoordinatesWithDirection(1, 1, Direction.EAST));
        game.move();
        game.report();
        assertEquals("2,1,EAST".trim(), outContent.toString().trim());
    }

    @Test void gameCanLeftAfterPlace() {
        Game game = new Game(reporter);
        game.place(new CoordinatesWithDirection(2, 2, Direction.SOUTH));
        game.left();
        game.report();
        assertEquals("2,2,EAST".trim(), outContent.toString().trim());
    }

    @Test void gameCanRightAfterPlace() {
        Game game = new Game(reporter);
        game.place(new CoordinatesWithDirection(3, 3, Direction.WEST));
        game.right();
        game.report();
        assertEquals("3,3,NORTH".trim(), outContent.toString().trim());
    }

    @Test void gameCanReportAfterPlace() {
        Game game = new Game(reporter);
        game.place(new CoordinatesWithDirection(4, 4, Direction.NORTH));
        game.report();
        assertEquals("4,4,NORTH".trim(), outContent.toString().trim());
    }

    @Test void gameCantPlaceOutsideBoardDimensions() {
        Game game = new Game(reporter);
        game.place(new CoordinatesWithDirection(5, 5, Direction.EAST));
        game.report();
        assertEquals("".trim(), outContent.toString().trim());
    }

    @Test void gameCantMoveOutsideBoardDimensions() {
        Game game = new Game(reporter);
        game.place(new CoordinatesWithDirection(0, 0, Direction.SOUTH));
        game.move();
        game.report();
        assertEquals("0,0,SOUTH".trim(), outContent.toString().trim());
    }

}
