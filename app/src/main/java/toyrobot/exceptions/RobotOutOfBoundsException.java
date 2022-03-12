package toyrobot.exceptions;

public class RobotOutOfBoundsException extends IllegalArgumentException {
    
    public RobotOutOfBoundsException() {
        super("Unable to do action that will put Robot out of bounds.");
    }

}
