package day01;

import org.junit.jupiter.api.Test;
import utils.InputUtils;

import java.io.IOException;
import java.nio.file.Path;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class Day01Test {
    @Test
    void testResultPart1() throws IOException {
        final var input = InputUtils.readInputFile(Path.of("day01/example-input-part1.txt"));
        final var resultPart1 = Day01.solvePart1(input);

        assertEquals("3", resultPart1);
    }

    @Test
    void testResultPart2() throws IOException {
        final var input = InputUtils.readInputFile(Path.of("day01/example-input-part2.txt"));
        final var resultPart2 = Day01.solvePart2(input);

        assertEquals("6", resultPart2);
    }
}
