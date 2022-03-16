package toyrobot.client.command.factory;

import toyrobot.client.command.command.IGameCommand;
import toyrobot.domains.game.IGame;

public interface IGameCommandFactory {
    
    public IGameCommand createGameCommand(IGame game, String[] params);

}
