package toyrobot;

import toyrobot.client.GameClient;
import toyrobot.domains.game.Game;
import toyrobot.domains.game.IGame;
import toyrobot.services.inputparser.IInputParser;
import toyrobot.services.inputparser.InputParser;
import toyrobot.services.inputsource.IInputSource;
import toyrobot.services.inputsource.InputSource;
import toyrobot.services.reporter.IReporter;
import toyrobot.services.reporter.Reporter;

/**
 * Initializes the Toy Robot Application.
 */
public class ToyRobotApp {
    
    private IInputSource inputSource;

    public ToyRobotApp(String[] args) {
        IReporter reporter = new Reporter();
        IGame game = new Game(reporter);
        IInputParser inputParser = new InputParser();
        GameClient gameClient = new GameClient(game, inputParser);
        this.inputSource = new InputSource(gameClient, args);
    }

    public void run() {
        inputSource.getInputs();
    }



}
