package toyrobot.domains.game;

import toyrobot.entities.CoordinatesWithDirection;

public interface IGame {

    public void place(CoordinatesWithDirection coordsWithDirection);
    public void move();
    public void left();
    public void right();
    public CoordinatesWithDirection report();

}
