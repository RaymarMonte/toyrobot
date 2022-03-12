package toyrobot;

public interface Robot {
    
    public void move();
    public void rotateLeft();
    public void rotateRight();
    public RobotPosition nextMovePosition();
    public RobotData getCurrentData();

}
