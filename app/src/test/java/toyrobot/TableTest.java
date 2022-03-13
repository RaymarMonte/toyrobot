package toyrobot;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNull;

import org.junit.jupiter.api.Test;

import toyrobot.table.ITable;
import toyrobot.table.TableFactory;
import toyrobot.util.Direction;
import toyrobot.util.Vector;

class TableTest {
    
    @Test void moveWithoutPlacing() {
        ITable table = TableFactory.getTable();
        table.move();
        assertNull(table.report());
    }

    @Test void leftWithoutPlacing() {
        ITable table = TableFactory.getTable();
        table.left();
        assertNull(table.report());
    }

    @Test void rightWithoutPlacing() {
        ITable table = TableFactory.getTable();
        table.right();
        assertNull(table.report());
    }

    @Test void reportWithoutPlacing() {
        ITable table = TableFactory.getTable();
        assertNull(table.report());
    }

    @Test void placeThenReport() {
        ITable table = TableFactory.getTable();
        table.place(new Vector(0, 1, Direction.NORTH));
        assertEquals(new Vector(0, 1, Direction.NORTH),
            table.report());
    }

    @Test void moveThenReport() {
        ITable table = TableFactory.getTable();
        table.place(new Vector(2, 0, Direction.EAST));
        table.move();
        assertEquals(new Vector(3, 0, Direction.EAST),
            table.report());
    }
    
    @Test void leftThenReport() {
        ITable table = TableFactory.getTable();
        table.place(new Vector(1, 3, Direction.SOUTH));
        table.left();
        assertEquals(new Vector(1, 3, Direction.EAST),
            table.report());
    }

    @Test void rightThenReport() {
        ITable table = TableFactory.getTable();
        table.place(new Vector(4, 2, Direction.WEST));
        table.right();
        assertEquals(new Vector(4, 2, Direction.NORTH),
            table.report());
    }

    @Test void placingOOB() { // OOB - Out of Bounds
        ITable table = TableFactory.getTable();
        table.place(new Vector(5, 5, Direction.EAST));
        assertNull(table.report());
    }

    @Test void movingToOOB() { // OOB - Out of Bounds
        ITable table = TableFactory.getTable();
        table.place(new Vector(0, 0, Direction.SOUTH));
        table.move();
        assertEquals(new Vector(0, 0, Direction.SOUTH),
            table.report());
    }
}
