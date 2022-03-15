package toyrobot.services.inputsource;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.stream.Stream;

/**
 * Implementation of InputSource with a file being the source.
 */
public class InputSource implements IInputSource {

    private IInputSourceListener inputListener;
    private String[] args;

    public InputSource(IInputSourceListener inputListener, String[] args) {
        this.inputListener = inputListener;
        this.args = args;
    }

    @Override
    public String[] getInputs() {
        String[] inputArray = new String[0];
        // args to String
        if (args.length == 0)
            return inputArray;
        String filePath = args[0];
        // String to File representation
        Path path = Paths.get(filePath);
        // File representation to input array
        inputArray = getInputArray(path);
        // Send each input to listener
        for(String input : inputArray) {
            inputListener.processInput(input);
        }
        // Return input array
        return inputArray;
    }

    private String[] getInputArray(Path path) {
        try {
            Stream<String> lines = Files.lines(path);
            String[] inputArray = lines.toArray(String[]::new);
            lines.close();
            return inputArray;
        } catch (IOException e) {
            return new String[0];
        }
    }
    
}
