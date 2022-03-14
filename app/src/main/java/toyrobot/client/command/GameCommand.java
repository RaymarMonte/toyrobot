package toyrobot.client.command;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.HashMap;

import toyrobot.entities.Direction;
import toyrobot.domains.game.IGame;
import toyrobot.entities.CoordinatesWithDirection;

public class GameCommand implements IGameCommand {
    
    private static HashMap<String, String> commandMap =
        createCommandMap();

    private Object[] params;
    private IGame game;
    private Method method;

    public GameCommand(IGame game, String command, Object[] params) {
        this.game = game;
        if (isCoordinatesWithDirection(params)) {
            this.params = new Object[] {toCoordinatesWithDirection(params)};
        } else {
            this.params = params;
        }
        Class[] paramTypes = new Class[params.length];
        for (int i = 0; i < params.length; i++) {
            paramTypes[i] = params[i].getClass();
        }
        try {
            method = game.getClass().getMethod(commandMap.get(command), paramTypes);
        } catch (NoSuchMethodException | SecurityException | NullPointerException e) {
            // Ignore
        }
    }

    @Override
    public void execute() {
        try {
            method.invoke(game, params);
        } catch (IllegalAccessException | IllegalArgumentException | InvocationTargetException | NullPointerException e) {
            // Ignore
        }
    }

    private static HashMap<String, String> createCommandMap() {
        HashMap<String, String> commandMap = new HashMap<>();
        commandMap.put("PLACE", "place");
        commandMap.put("MOVE", "move");
        commandMap.put("LEFT", "left");
        commandMap.put("RIGHT", "right");
        commandMap.put("REPORT", "report");
        return commandMap;
    }

    private static boolean isCoordinatesWithDirection(Object[] params) {
        if (params.length != 3)
            return false;
        try {
            Integer.parseInt((String) params[0]);
            Integer.parseInt((String) params[1]);
        } catch (NumberFormatException ex) {
            return false;
        }
        if (Direction.valueOf((String) params[2]) == null)
            return false;
        return true;
    }

    private static CoordinatesWithDirection toCoordinatesWithDirection(
        Object[] params) {
        return new CoordinatesWithDirection(
            Integer.parseInt((String) params[0]),
            Integer.parseInt((String) params[1]),
            Direction.valueOf((String) params[2])
        );
    }
}
