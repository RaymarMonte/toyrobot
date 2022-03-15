package toyrobot;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.Arrays;
import java.util.List;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.io.TempDir;

import toyrobot.testutil.SysOutTest;

public class EndToEndTest extends SysOutTest {
    
    @Test void usingAllCommandsCorrectly(@TempDir Path tempDir)
        throws IOException {
        Path usingAllComands = tempDir.resolve("using-all-commands.txt");
        List<String> lines = Arrays.asList(
            "PLACE 3,4,WEST",
            "LEFT",
            "MOVE",
            "RIGHT",
            "REPORT");
        Files.write(usingAllComands, lines);
        
        ToyRobotApp toyRobotApp = new ToyRobotApp(
            new String[]{usingAllComands.toString()});
        toyRobotApp.run();
        assertEquals("3,3,WEST".trim(), outContent.toString().trim());
    }
    
    @Test void allCommandsButWithGarbageInBetween(@TempDir Path tempDir)
        throws IOException {
        Path usingAllComands = tempDir.resolve("using-all-commands.txt");
        List<String> lines = Arrays.asList(
            "PLACE 2,2,EAST",
            "",
            "MOVE",
            "PLACE 2,EAST",
            "RIGHT",
            "RIGHT",
            "MOVE 1,2,WEST",
            "fjfkjiof 324r 0u rjt o",
            "RIGHT",
            "REPORT");
        Files.write(usingAllComands, lines);
        
        ToyRobotApp toyRobotApp = new ToyRobotApp(
            new String[]{usingAllComands.toString()});
        toyRobotApp.run();
        assertEquals("3,2,NORTH".trim(), outContent.toString().trim());
    }

}
