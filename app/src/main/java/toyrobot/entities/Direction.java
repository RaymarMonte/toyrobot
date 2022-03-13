package toyrobot.entities;

/**
 * Represents directions commonly found in compasses. The order in which
 * these directions are laid out follows their equivalent value in degrees,
 * starting with North which has the value of 0 degrees.
 */
public enum Direction {
    NORTH,
    EAST,
    SOUTH,
    WEST;

    public static Direction leftOf(Direction direction) {
        int index = direction.ordinal();
        int leftIndex = index - 1;
        return Direction.values()[normalizeIndex(leftIndex)];
    }

    public static Direction rightOf(Direction direction) {
        int index = direction.ordinal();
        int leftIndex = index + 1;
        return Direction.values()[normalizeIndex(leftIndex)];
    }

    /** 
     * Normalizes a computed index in a circular manner.
     * Values larger than max length loops back to near 0.
     * Negative values loops back to near max length.
     */
    private static int normalizeIndex(int index) {
        int directionCount = Direction.values().length;
        return (index + directionCount) % directionCount;
    }
    
}
