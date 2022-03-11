package toyrobot;

public class RobotNotYetPlacedException extends IllegalStateException {
    
    public RobotNotYetPlacedException() {
        super("Unable to do action while Robot is not yet placed.");
    }

}
