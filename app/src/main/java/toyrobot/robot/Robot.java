package toyrobot.robot;

public interface Robot {
    
    public void move();
    public void rotateLeft();
    public void rotateRight();
    public RobotCoordinates nextMovePosition();
    public RobotData getCurrentData();

}
