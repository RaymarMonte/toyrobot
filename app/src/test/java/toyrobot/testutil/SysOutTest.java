package toyrobot.testutil;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;

/**
 * Abstract class that takes care of setting up a test class for testing
 * behaviors that involve printing out to System.out.
 */
public abstract class SysOutTest {
    
    protected final ByteArrayOutputStream outContent = new ByteArrayOutputStream();
    private final PrintStream originalOut = System.out;

    @BeforeEach
    private void setUpStreams() {
        System.setOut(new PrintStream(outContent));
    }

    @AfterEach
    private void restoreStreams() {
        System.setOut(originalOut);
    }
    

}
