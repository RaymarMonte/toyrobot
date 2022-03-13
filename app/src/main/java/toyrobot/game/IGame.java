package toyrobot.game;

import toyrobot.entities.CoordinatesFacingADirection;

public interface IGame {

    public void place(CoordinatesFacingADirection coordsFacingDirection);
    public void move();
    public void left();
    public void right();
    public void report();

}
