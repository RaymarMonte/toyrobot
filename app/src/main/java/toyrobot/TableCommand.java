package toyrobot;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.HashMap;

import toyrobot.table.ITable;
import toyrobot.util.Direction;
import toyrobot.util.Vector;

public class TableCommand {
    
    private static HashMap<String, String> commandMap =
        createCommandMap();

    private Object[] params;
    private ITable table;
    private Method method;

    public TableCommand(ITable table, String command, Object[] params) {
        this.table = table;
        if (isVector(params)) {
            this.params = new Object[] {toVector(params)};
        } else {
            this.params = params;
        }
        Class[] paramTypes = new Class[params.length];
        for (int i = 0; i < params.length; i++) {
            paramTypes[i] = params[i].getClass();
        }
        try {
            method = table.getClass().getMethod(commandMap.get(command), paramTypes);
        } catch (NoSuchMethodException | SecurityException | NullPointerException e) {
            // Ignore
        }
    }

    public Object execute() {
        try {
            return method.invoke(table, params);
        } catch (IllegalAccessException | IllegalArgumentException | InvocationTargetException | NullPointerException e) {
            // Ignore
        }
        return null;
    }

    private static HashMap<String, String> createCommandMap() {
        HashMap<String, String> commandMap = new HashMap<>();
        commandMap.put("PLACE", "place");
        commandMap.put("MOVE", "move");
        commandMap.put("LEFT", "left");
        commandMap.put("RIGHT", "right");
        commandMap.put("REPORT", "report");
        return commandMap;
    }

    private static boolean isVector(Object[] params) {
        if (params.length != 3)
            return false;
        try {
            Integer.parseInt((String) params[0]);
            Integer.parseInt((String) params[1]);
        } catch (NumberFormatException ex) {
            return false;
        }
        if (Direction.valueOf((String) params[2]) == null)
            return false;
        return true;
    }

    private static Vector toVector(Object[] params) {
        return new Vector(
            Integer.parseInt((String) params[0]),
            Integer.parseInt((String) params[1]),
            Direction.valueOf((String) params[2])
        );
    }
}
