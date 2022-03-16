package toyrobot.client.command.command;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

import toyrobot.domains.game.IGame;

public abstract class GameCommand implements IGameCommand {

    protected IGame game = null;
    protected Object[] params = new Object[0];
    protected Method method = null;

    @Override
    public boolean execute() {
        try {
            method.invoke(game, params);
            return true;
        } catch (IllegalAccessException | IllegalArgumentException |
                 InvocationTargetException | NullPointerException e) {
            return false;
        }
    }
}
