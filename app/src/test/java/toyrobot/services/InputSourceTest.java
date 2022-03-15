package toyrobot.services;

import static org.junit.jupiter.api.Assertions.assertArrayEquals;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.Arrays;
import java.util.List;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.io.TempDir;
import org.mockito.Mockito;

import toyrobot.services.inputsource.IInputSourceListener;
import toyrobot.services.inputsource.InputSource;

public class InputSourceTest {
    
    private IInputSourceListener inputSourceListener =
        Mockito.mock(IInputSourceListener.class);

    @Test void gotInputsFromFileWithContent(@TempDir Path tempDir)
        throws IOException {
        Path fileWithContent = tempDir.resolve("file-with-content.txt");
        List<String> lines = Arrays.asList("1", "2", "3");
        Files.write(fileWithContent, lines);

        InputSource inputSource = new InputSource(inputSourceListener,
            new String[] {fileWithContent.toString()});
        String[] expected = new String[] {"1", "2", "3"};
        String[] inputs = inputSource.getInputs();
        assertArrayEquals(expected, inputs);
    }

    @Test void gotNoInputsFromEmptyFile(@TempDir Path tempDir)
        throws IOException {
        Path emptyFile = tempDir.resolve("empty-file.txt");
        Files.createFile(emptyFile);

        InputSource inputSource = new InputSource(inputSourceListener,
            new String[] {emptyFile.toString()});
        String[] expected = new String[0];
        String[] inputs = inputSource.getInputs();
        assertArrayEquals(expected, inputs);
    }

    @Test void gotNoInputsFromNonExistentFile() {
        InputSource inputSource = new InputSource(inputSourceListener,
            new String[] {"non-existent.txt"});
        String[] expected = new String[0];
        String[] inputs = inputSource.getInputs();
        assertArrayEquals(expected, inputs);
        
    }

}
