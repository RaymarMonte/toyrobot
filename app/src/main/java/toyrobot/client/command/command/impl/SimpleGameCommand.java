package toyrobot.client.command.command.impl;

import toyrobot.client.command.command.GameCommand;
import toyrobot.domains.game.IGame;

/**
 * GameCommand that has no parameter.
 */
public class SimpleGameCommand extends GameCommand {

    public SimpleGameCommand(IGame game, String command) {
        this.game = game;
        this.params = new Object[0];
        try {
            this.method = game.getClass().getMethod(command);
        } catch (NoSuchMethodException | SecurityException e) {
            // Ignore
        }
    }
    
}
