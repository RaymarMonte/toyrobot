package toyrobot;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNull;

import org.junit.jupiter.api.Test;
import org.mockito.Mockito;

import toyrobot.domains.game.Game;
import toyrobot.entities.CoordinatesWithDirection;
import toyrobot.entities.Direction;
import toyrobot.services.reporter.IReporter;

public class GameTest extends SysOutTest {
    
    private IReporter reporter = Mockito.mock(IReporter.class);

    @Test void moveHaveNoEffectWithoutPlace() {
        Game game = new Game(reporter);
        game.move();
        assertNull(game.report());
    }
    
    @Test void leftHaveNoEffectWithoutPlace() {
        Game game = new Game(reporter);
        game.left();
        assertNull(game.report());
    }

    @Test void rightHaveNoEffectWithoutPlace() {
        Game game = new Game(reporter);
        game.right();
        assertNull(game.report());
    }
    
    @Test void reportHaveNoEffectWithoutPlace() {
        Game game = new Game(reporter);
        assertNull(game.report());
    }

    @Test void gameCanPlaceInsideBoard() {
        Game game = new Game(reporter);
        game.place(new CoordinatesWithDirection(0, 0, Direction.NORTH));
        assertEquals(new CoordinatesWithDirection(0, 0, Direction.NORTH),
            game.report());
    }

    @Test void gameCanMoveAfterPlace() {
        Game game = new Game(reporter);
        game.place(new CoordinatesWithDirection(1, 1, Direction.EAST));
        game.move();
        assertEquals(new CoordinatesWithDirection(2, 1, Direction.EAST),
            game.report());
    }

    @Test void gameCanLeftAfterPlace() {
        Game game = new Game(reporter);
        game.place(new CoordinatesWithDirection(2, 2, Direction.SOUTH));
        game.left();
        assertEquals(new CoordinatesWithDirection(2, 2, Direction.EAST),
            game.report());
    }

    @Test void gameCanRightAfterPlace() {
        Game game = new Game(reporter);
        game.place(new CoordinatesWithDirection(3, 3, Direction.WEST));
        game.right();
        assertEquals(new CoordinatesWithDirection(3, 3, Direction.NORTH),
            game.report());
    }

    @Test void gameCanReportAfterPlace() {
        Game game = new Game(reporter);
        game.place(new CoordinatesWithDirection(4, 4, Direction.NORTH));
        assertEquals(new CoordinatesWithDirection(4, 4, Direction.NORTH),
            game.report());
    }

    @Test void gameCantPlaceOutsideBoardDimensions() {
        Game game = new Game(reporter);
        game.place(new CoordinatesWithDirection(5, 5, Direction.EAST));
        assertNull(game.report());
    }

    @Test void gameCantMoveOutsideBoardDimensions() {
        Game game = new Game(reporter);
        game.place(new CoordinatesWithDirection(0, 0, Direction.SOUTH));
        game.move();
        assertEquals(new CoordinatesWithDirection(0, 0, Direction.SOUTH),
            game.report());
    }

}
