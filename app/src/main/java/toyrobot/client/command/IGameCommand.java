package toyrobot.client.command;

public interface IGameCommand {
    
    /**
     * Executes the command.
     * @return Whether or not the execution was a success.
     */
    public boolean execute();

}
