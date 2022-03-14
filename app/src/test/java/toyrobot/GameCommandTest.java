package toyrobot;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.mockito.Mockito.when;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;

import toyrobot.client.command.GameCommand;
import toyrobot.domains.game.IGame;


public class GameCommandTest extends SysOutTest {

    private static IGame game = Mockito.mock(IGame.class);

    @BeforeAll
    private static void setupGameMock() {
        when(game.report()).thenReturn(null);
    }

    @Test void passingValidCommandWithCorrectParamsExecutesSuccessfully() {
        GameCommand gameCommand = new GameCommand(
            game, "REPORT", new String[]{});
        assertTrue(gameCommand.execute());
    }

    @Test void passingInvalidCommandFailsExecution() {
        GameCommand gameCommand = new GameCommand(
            game, "JUMP", new String[]{});
        assertFalse(gameCommand.execute());
    }

    @Test void pasingValidCommandWithInvalidParamsFailsExecution() {
        GameCommand gameCommand = new GameCommand(
            game, "REPORT", new String[]{"1", "2", "NORTH"});
        assertFalse(gameCommand.execute());
    }

}
