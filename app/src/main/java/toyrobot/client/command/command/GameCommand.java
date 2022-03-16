package toyrobot.client.command.command;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

import toyrobot.domains.game.IGame;

public abstract class GameCommand implements IGameCommand {

    protected IGame game;
    protected Object[] params;
    protected Method method;

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
