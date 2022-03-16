package toyrobot.services;

import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertNull;

import org.junit.jupiter.api.Test;
import org.mockito.Mockito;

import toyrobot.domains.game.IGame;
import toyrobot.services.inputparser.InputParser;

public class InputParserTest {
    
    private IGame game = Mockito.mock(IGame.class);

    @Test void parsingValidInputProducesGameCommand() {
        InputParser inputParser = new InputParser();
        assertNotNull(inputParser.parseCommand("PLACE 1,2,NORTH", game));
    }

    @Test void parsingInvalidInputDoesNotProduceGameCommand() {
        InputParser inputParser = new InputParser();
        assertNull(inputParser.parseCommand("MOVE 1", game));
    }

}
