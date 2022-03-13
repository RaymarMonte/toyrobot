package toyrobot.entities;

public class Coordinates {
    
    private int x;
    private int y;

    public Coordinates(int X, int Y) {
        this.x = X;
        this.y = Y;
    }

    /** Copy constructor */
    public Coordinates(Coordinates toCopy) {
        this.x = toCopy.x;
        this.y = toCopy.y;
    }

    public int getX() {
        return x;
    }

    public void setX(int x) {
        this.x = x;
    }

    public int getY() {
        return y;
    }

    public void setY(int y) {
        this.y = y;
    }

    /**
     * Adds 2 coordinates and return the resulting Coordinate.
     */
    public static Coordinates addCoordinates(
        Coordinates coordinate1, Coordinates coordinate2) {
        return new Coordinates(
            coordinate1.getX() + coordinate2.getX(),
            coordinate1.getY() + coordinate2.getY()
        );
    }

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + x;
        result = prime * result + y;
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
        Coordinates other = (Coordinates) obj;
        if (x != other.x)
            return false;
        if (y != other.y)
            return false;
        return true;
    }

}
