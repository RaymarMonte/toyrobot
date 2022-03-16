package toyrobot.client.command.factory.impl;

import java.util.HashMap;
import java.util.Set;

import toyrobot.client.command.command.IGameCommand;
import toyrobot.client.command.factory.IGameCommandFactory;
import toyrobot.client.command.factory.SimpleGameCommandFactory;
import toyrobot.domains.game.IGame;

public abstract class GameCommandFactory implements IGameCommandFactory {
    
    /**
     * Map of regex patterns that dictate a valid input and the corresponding
     * GameCommandFactory that will be used to produce the appropriate
     * GameCommand for the given vaid input.
     */
    private static HashMap<String, IGameCommandFactory> commandFactoryMap =
        createCommandMap();

    public static IGameCommand createGameCommand(String matchedPattern, IGame game, String[] params) {
        IGameCommandFactory gameCommandFactory = commandFactoryMap.get(matchedPattern);
        return gameCommandFactory.createGameCommand(game, params);
    }

    private static HashMap<String, IGameCommandFactory> createCommandMap() {
        HashMap<String, IGameCommandFactory> commandMap = new HashMap<>();
        commandMap.put("^(PLACE) (\\d+),(\\d+),(NORTH|EAST|SOUTH|WEST)$",
            new PlaceGameCommandFactory());
        commandMap.put("^(MOVE)$", new SimpleGameCommandFactory("move"));
        commandMap.put("^(LEFT)$", new SimpleGameCommandFactory("left"));
        commandMap.put("^(RIGHT)$", new SimpleGameCommandFactory("right"));
        commandMap.put("^(REPORT)$", new SimpleGameCommandFactory("report"));
        return commandMap;
    }

    public static Set<String> getValidPatterns() {
        return commandFactoryMap.keySet();
    }

}
