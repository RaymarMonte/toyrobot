package toyrobot;

import static org.junit.jupiter.api.Assertions.assertEquals;
import org.junit.jupiter.api.Test;

import toyrobot.entities.Direction;

class DirectionTest {
    
    @Test void leftOfNorthShouldBeWest() {
        assertEquals(Direction.WEST, Direction.leftOf(Direction.NORTH));
    }
    
    @Test void rightOfWestShouldBeNorth() {
        assertEquals(Direction.NORTH, Direction.rightOf(Direction.WEST));
    }

}
