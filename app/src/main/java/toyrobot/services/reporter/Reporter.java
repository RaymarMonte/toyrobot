package toyrobot.services.reporter;

import toyrobot.entities.Coordinates;
import toyrobot.entities.CoordinatesWithDirection;

public class Reporter implements IReporter {

    @Override
    public void report(CoordinatesWithDirection toReport) {
        Coordinates coordinates = toReport.getCoordinates();
        String report = coordinates.getX() + "," + coordinates.getY() + 
            "," + toReport.getOrientation();
        System.out.println(report);
    }
    
}
