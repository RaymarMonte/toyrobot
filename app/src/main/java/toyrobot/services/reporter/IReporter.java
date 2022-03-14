package toyrobot.services.reporter;

import toyrobot.entities.CoordinatesWithDirection;

public interface IReporter {
    
    public void report(CoordinatesWithDirection toReport);

}
