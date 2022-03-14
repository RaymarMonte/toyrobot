package toyrobot.client.command;

import toyrobot.domains.game.IGame;

public class GameCommandFactory {
    
    public static IGameCommand createGameCommand(
        IGame game, String command, Object[] params) {
        return new GameCommand(game, command, params);
    }

}
