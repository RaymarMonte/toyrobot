package toyrobot.robot;

public class RobotCoordinates {
    
    private int positionX;
    private int positionY;

    public RobotCoordinates(int positionX, int positionY) {
        this.positionX = positionX;
        this.positionY = positionY;
    }

    public int getPositionX() {
        return positionX;
    }

    public void setPositionX(int positionX) {
        this.positionX = positionX;
    }

    public int getPositionY() {
        return positionY;
    }
    
    public void setPositionY(int positionY) {
        this.positionY = positionY;
    }

    /**
     * Adds 2 coordinates and return the resulting RobotCoordinate.
     */
    public static RobotCoordinates addCoordinates(
        RobotCoordinates coordinate1, RobotCoordinates coordinate2) {
        return new RobotCoordinates(
            coordinate1.getPositionX() + coordinate2.getPositionX(),
            coordinate1.getPositionY() + coordinate2.getPositionY()
        );
    }

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + positionX;
        result = prime * result + positionY;
        return result;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj)
            return true;
        if (obj == null)
            return false;
        if (getClass() != obj.getClass())
            return false;
        RobotCoordinates other = (RobotCoordinates) obj;
        if (positionX != other.positionX)
            return false;
        if (positionY != other.positionY)
            return false;
        return true;
    }

}
