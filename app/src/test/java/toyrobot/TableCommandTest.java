package toyrobot;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNull;

import org.junit.jupiter.api.Test;

import toyrobot.entities.Direction;
import toyrobot.entities.Vector;
import toyrobot.table.ITable;
import toyrobot.table.TableFactory;

public class TableCommandTest {
    
    @Test void executeAnInvalidCommand() {
        ITable table = TableFactory.getTable();
        TableCommand tableCommand = new TableCommand(table, "JUMP", new Object[0]);
        assertNull(tableCommand.execute());
    }

    @Test void executeCommandWithNoReturn() {
        ITable table = TableFactory.getTable();
        TableCommand tableCommand = new TableCommand(table, "MOVE", new Object[0]);
        assertNull(tableCommand.execute());
    }

    @Test void executeCommandWithReturn() {
        ITable table = TableFactory.getTable();
        TableCommand placeCommand = new TableCommand(table, "PLACE",
            new Object[] {new Vector(0, 0, Direction.NORTH)});
        placeCommand.execute();
        TableCommand reportCommand = new TableCommand(table, "REPORT", new Object[0]);
        assertEquals(new Vector(0, 0, Direction.NORTH), reportCommand.execute());
    }

    @Test void executeCommandWithParams() {
        ITable table = TableFactory.getTable();
        TableCommand tableCommand = new TableCommand(table, "PLACE",
            new Object[] {new Vector(0, 0, Direction.NORTH)});
        tableCommand.execute();
        assertEquals(new Vector(0, 0, Direction.NORTH), table.report());
    }

}
