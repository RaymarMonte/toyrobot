package toyrobot.client.command.command.impl;

import java.util.ArrayList;

import toyrobot.client.command.command.GameCommand;
import toyrobot.domains.game.IGame;
import toyrobot.entities.CoordinatesWithDirection;
import toyrobot.entities.Direction;

/**
 * GameCommand for place.
 */
public class PlaceGameCommand extends GameCommand {

    private final static String PLACE_COMMAND = "place";

    public PlaceGameCommand(IGame game, String[] strParams) {
        this.game = game;
        if (isCoordinatesWithDirection(strParams)) {
            this.params = new Object[]{toCoordinatesWithDirection(strParams)};
        }
        ArrayList<Class> paramTypeList = new ArrayList<>();
        for (Object param : this.params) {
            paramTypeList.add(param.getClass());
        }
        try {
            this.method = game.getClass().getMethod(
                PLACE_COMMAND, paramTypeList.toArray(Class[]::new));
        } catch (NoSuchMethodException | SecurityException e) {
            // Ignore
        }
    }

    private static boolean isCoordinatesWithDirection(String[] params) {
        if (params == null)
            return false;
        if (params.length != 3)
            return false;
        try {
            Integer.parseInt(params[0]);
            Integer.parseInt(params[1]);
        } catch (NumberFormatException ex) {
            return false;
        }
        try {
            Direction.valueOf(params[2]);
        } catch (IllegalArgumentException ex) {
            return false;
        }
        return true;
    }

    private static CoordinatesWithDirection toCoordinatesWithDirection(
        String[] params) {
        return new CoordinatesWithDirection(
            Integer.parseInt(params[0]),
            Integer.parseInt(params[1]),
            Direction.valueOf(params[2])
        );
    }
    
}
