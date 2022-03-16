package toyrobot.command;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

import org.junit.jupiter.api.Test;
import org.mockito.Mockito;

import toyrobot.client.command.command.GameCommand;
import toyrobot.client.command.command.impl.PlaceGameCommand;
import toyrobot.domains.game.IGame;


public class PlaceGameCommandTest {

    private static IGame game = Mockito.mock(IGame.class);

    @Test void passingValidParametersExecutesSuccessfully() {
        GameCommand gameCommand = new PlaceGameCommand(
            game, new String[] {"1", "2", "NORTH"});
        assertTrue(gameCommand.execute());
    }

    @Test void passingIncompleteParametersFailsExecution() {
        GameCommand gameCommand = new PlaceGameCommand(
            game, new String[] {"1", "NORTH"});
        assertFalse(gameCommand.execute());
    }

    @Test void passingInvalidParametersFailsExecution() {
        GameCommand gameCommand = new PlaceGameCommand(
            game, new String[] {"1", "2", "NORTHH"});
        assertFalse(gameCommand.execute());
    }

}
