package toyrobot.client.command.factory;

import java.util.HashMap;
import java.util.Set;

import toyrobot.client.command.command.IGameCommand;
import toyrobot.client.command.factory.impl.PlaceGameCommandFactory;
import toyrobot.client.command.factory.impl.SimpleGameCommandFactory;
import toyrobot.domains.game.IGame;

public abstract class GameCommandFactory implements IGameCommandFactory {
    
    /**
     * Map of regex patterns that dictate a valid input and the corresponding
     * GameCommandFactory that will be used to produce the appropriate
     * GameCommand for the given vaid input.
     */
    private static HashMap<String, IGameCommandFactory> commandFactoryMap =
        createCommandFactoryMap();

    public static IGameCommand createGameCommand(String matchedPattern, IGame game, String[] params) {
        IGameCommandFactory gameCommandFactory = commandFactoryMap.get(matchedPattern);
        if (gameCommandFactory != null) {
            return gameCommandFactory.createGameCommand(game, params);
        }
        return null;
    }

    private static HashMap<String, IGameCommandFactory> createCommandFactoryMap() {
        HashMap<String, IGameCommandFactory> commandFactoryMap = new HashMap<>();
        commandFactoryMap.put("^PLACE (\\d+),(\\d+),(NORTH|EAST|SOUTH|WEST)$",
            new PlaceGameCommandFactory());
        commandFactoryMap.put("^MOVE$", new SimpleGameCommandFactory("move"));
        commandFactoryMap.put("^LEFT$", new SimpleGameCommandFactory("left"));
        commandFactoryMap.put("^RIGHT$", new SimpleGameCommandFactory("right"));
        commandFactoryMap.put("^REPORT$", new SimpleGameCommandFactory("report"));
        return commandFactoryMap;
    }

    public static Set<String> getValidPatterns() {
        return commandFactoryMap.keySet();
    }

}
