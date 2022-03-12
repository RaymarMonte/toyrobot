package toyrobot.table;

import java.util.Optional;
import toyrobot.util.Vector;

public interface ITable {

    public void place(Vector vector);
    public void move();
    public void left();
    public void right();
    public Optional<Vector> report();

}
