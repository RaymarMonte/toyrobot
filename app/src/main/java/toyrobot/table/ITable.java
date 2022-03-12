package toyrobot.table;

import toyrobot.util.Vector;

public interface ITable {

    public void place(Vector vector);
    public void move();
    public void left();
    public void right();
    public Vector report();

}
