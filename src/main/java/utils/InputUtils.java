package utils;

import java.io.IOException;
import java.io.InputStream;
import java.nio.charset.StandardCharsets;
import java.nio.file.Path;

public class InputUtils {
    public static String readInputFile(final Path path) throws IOException {
        try (final InputStream inputStream = Thread.currentThread().getContextClassLoader().getResourceAsStream(path.toString())) {
            if (inputStream == null) {
                throw new IllegalArgumentException("File not found!");
            }

            return new String(inputStream.readAllBytes(), StandardCharsets.UTF_8);
        }
    }
}
