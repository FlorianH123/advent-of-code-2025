package day11;

import utils.InputUtils;

import java.io.IOException;
import java.nio.file.Path;

import static java.lang.IO.println;

public class Day11 {
    static void main() throws IOException {
        final var input = InputUtils.readInputFile(Path.of("day11/input.txt"));

        final var resultPart1 = Day11.solvePart1(input);
        println("Result of part one: " + resultPart1);

        final var resultPart2 = Day11.solvePart2(input);
        println("Result of part two: " + resultPart2);
    }

    public static String solvePart1(final String input) {
        return "";
    }

    public static String solvePart2(final String input) {
        return "";
    }
}
