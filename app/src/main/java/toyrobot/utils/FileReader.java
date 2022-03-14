package toyrobot.utils;

import java.io.IOException;
import java.nio.file.FileSystems;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.stream.Stream;

/**
 * Utility class for reading a file.
 */
public class FileReader {
    
    public static String[] readFileToStringArray(String filePath) {
        String[] stringArray = new String[0];
        Path path = FileSystems.getDefault().getPath(filePath);
        try {
            Stream<String> lines = Files.lines(path);
            stringArray = (String[]) lines.toArray();
            lines.close();
        } catch (IOException e) {
            // Ignore
        }
        return stringArray;
    }

}
