package toyrobot.services;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.Test;

import toyrobot.SysOutTest;
import toyrobot.entities.CoordinatesWithDirection;
import toyrobot.entities.Direction;
import toyrobot.services.reporter.Reporter;

public class ReporterTest extends SysOutTest {
    
    @Test void reportingPrintsToSystemOut() {
        Reporter reporter = new Reporter();
        reporter.report(new CoordinatesWithDirection(3, 3, Direction.WEST));
        assertEquals("3,3,WEST".trim(), outContent.toString().trim());
    }

}
