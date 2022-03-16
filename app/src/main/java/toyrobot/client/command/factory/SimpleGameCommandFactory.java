package toyrobot.client.command.factory;

import toyrobot.client.command.command.IGameCommand;
import toyrobot.client.command.command.impl.SimpleGameCommand;
import toyrobot.client.command.factory.impl.GameCommandFactory;
import toyrobot.domains.game.IGame;

public class SimpleGameCommandFactory extends GameCommandFactory {
    
    String command;

    public SimpleGameCommandFactory(String command) {
        this.command = command;
    }

    @Override
    public IGameCommand createGameCommand(IGame game, String[] params) {
        return new SimpleGameCommand(game, command);
    }

}
