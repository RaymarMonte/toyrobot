package toyrobot.client;

import toyrobot.client.command.IGameCommand;
import toyrobot.domains.game.IGame;
import toyrobot.services.inputparser.IInputParser;
import toyrobot.services.inputsource.IInputSourceListener;

/**
 * Processes inputs into game commands.
 */
public class GameClient implements IInputSourceListener {
    
    private IGame game;
    private IInputParser inputParser;

    public GameClient(IGame game, IInputParser inputParser) {
        this.game = game;
        this.inputParser = inputParser;
    }

    @Override
    public void processInput(String input) {
        IGameCommand gameCommand = inputParser.parseCommand(input, game);
        executeGameCommand(gameCommand);
    }

    private void executeGameCommand(IGameCommand gameCommand) {
        gameCommand.execute();
    }

}
