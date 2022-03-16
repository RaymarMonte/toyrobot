package toyrobot.client.command.command.impl;

import toyrobot.client.command.command.GameCommand;
import toyrobot.domains.game.IGame;
import toyrobot.entities.CoordinatesWithDirection;
import toyrobot.entities.Direction;

/**
 * GameCommand for place.
 */
public class PlaceGameCommand extends GameCommand {

    private final static String PLACE_COMMAND = "place";

    public PlaceGameCommand(IGame game, String[] params) {
        this.game = game;
        this.params = new Object[]{toCoordinatesWithDirection(params)};
        Class[] paramTypes = new Class[]{this.params[0].getClass()};
        try {
            this.method = game.getClass().getMethod(PLACE_COMMAND, paramTypes);
        } catch (NoSuchMethodException | SecurityException e) {
            // Ignore
        }
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
