package toyrobot.entities;

/**
 * An entity that has coordinates and a direction it's facing.
 */
public class Vector {
    
    private Coordinates coordinates;
    private Direction orientation;
    
    public Vector(Coordinates position, Direction orientation) {
        this.coordinates = position;
        this.orientation = orientation;
    }

    public Vector(int x, int y, Direction orientation) {
        this(new Coordinates(x, y), orientation);
    }

    /** Copy constructor */
    public Vector(Vector toCopy) {
        this.coordinates = new Coordinates(toCopy.coordinates);
        this.orientation = toCopy.orientation;
    }

    public Coordinates getCoordinates() {
        return coordinates;
    }

    public void setCoordinates(Coordinates coordinates) {
        this.coordinates = coordinates;
    }

    public Direction getOrientation() {
        return orientation;
    }

    public void setOrientation(Direction orientation) {
        this.orientation = orientation;
    }

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + ((orientation == null) ? 0 : orientation.hashCode());
        result = prime * result + ((coordinates == null) ? 0 : coordinates.hashCode());
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
        Vector other = (Vector) obj;
        if (orientation != other.orientation)
            return false;
        if (coordinates == null) {
            if (other.coordinates != null)
                return false;
        } else if (!coordinates.equals(other.coordinates))
            return false;
        return true;
    }
    
}
