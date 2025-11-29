package day04;

import org.junit.jupiter.api.Test;
import utils.InputUtils;

import java.io.IOException;
import java.nio.file.Path;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class Day04Test {
    @Test
    void testResultPart1() throws IOException {
        final var input = InputUtils.readInputFile(Path.of("day04/example-input-part1.txt"));
        final var resultPart1 = Day04.solvePart1(input);

        assertEquals("", resultPart1);
    }

    @Test
    void testResultPart2() throws IOException {
        final var input = InputUtils.readInputFile(Path.of("day04/example-input-part2.txt"));
        final var resultPart2 = Day04.solvePart2(input);

        assertEquals("", resultPart2);
    }
}
