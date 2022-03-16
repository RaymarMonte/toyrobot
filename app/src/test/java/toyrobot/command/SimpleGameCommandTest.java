package toyrobot.command;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

import org.junit.jupiter.api.Test;
import org.mockito.Mockito;

import toyrobot.client.command.command.GameCommand;
import toyrobot.client.command.command.impl.SimpleGameCommand;
import toyrobot.domains.game.IGame;

public class SimpleGameCommandTest {

    private static IGame game = Mockito.mock(IGame.class);

    @Test void PassingValidCommandExecutesSuccessfully() {
        GameCommand gameCommand = new SimpleGameCommand(game, "move");
        assertTrue(gameCommand.execute());
    }

    @Test void PassingInvalidCommandFailsExecution() {
        GameCommand gameCommand = new SimpleGameCommand(game, "jump");
        assertFalse(gameCommand.execute());
    }
}
