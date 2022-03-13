package toyrobot.table;

public class TableFactory {

    public static ITable getTable() {
        return new FixedDimensionsTable();
    }
}
