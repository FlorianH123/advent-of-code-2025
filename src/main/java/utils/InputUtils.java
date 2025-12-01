package utils;

import jakarta.validation.*;

import java.io.IOException;
import java.io.InputStream;
import java.nio.charset.StandardCharsets;
import java.nio.file.Path;
import java.util.Arrays;
import java.util.List;
import java.util.Set;

public class InputUtils {
    public static <T> void validate(final List<T> objects) {
        try (final ValidatorFactory factory = Validation.buildDefaultValidatorFactory()) {
            for (final var object : objects) {
                final Validator validator = factory.getValidator();
                final Set<ConstraintViolation<Object>> violations = validator.validate(object);
                if (!violations.isEmpty()) {
                    throw new ConstraintViolationException(violations);
                }
            }
        }
    }

    public static String readInputFile(final Path path) throws IOException {
        try (final InputStream inputStream = Thread.currentThread().getContextClassLoader().getResourceAsStream(path.toString())) {
            if (inputStream == null) {
                throw new IllegalArgumentException("File not found!");
            }

            return new String(inputStream.readAllBytes(), StandardCharsets.UTF_8);
        }
    }

    public static List<String> splitIntoLines(final String input) {
        return Arrays.stream(input.split("\n")).toList();
    }
}
