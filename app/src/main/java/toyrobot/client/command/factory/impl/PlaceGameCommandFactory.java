package toyrobot.client.command.factory.impl;

import toyrobot.client.command.command.IGameCommand;
import toyrobot.client.command.command.impl.PlaceGameCommand;
import toyrobot.client.command.factory.GameCommandFactory;
import toyrobot.domains.game.IGame;

public class PlaceGameCommandFactory extends GameCommandFactory {

    public IGameCommand createGameCommand(IGame game, String[] params) {
        return new PlaceGameCommand(game, params);
    }

}
