package toyrobot.services.inputparser;

import toyrobot.client.command.IGameCommand;
import toyrobot.domains.game.IGame;

public interface IInputParser {
    
    /**
     * Parses a string input into a GameCommand.
     */
    public IGameCommand parseCommand(String input, IGame game);
}
