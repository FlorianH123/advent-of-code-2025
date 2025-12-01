package day01;

import utils.InputUtils;

import java.io.IOException;
import java.nio.file.Path;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import static java.lang.IO.println;

public class Day01 {
    static void main() throws IOException {
        final var input = InputUtils.readInputFile(Path.of("day01/input.txt"));

        final var resultPart1 = Day01.solvePart1(input);
        println("Result of part one: " + resultPart1);

        final var resultPart2 = Day01.solvePart2(input);
        println("Result of part two: " + resultPart2);
    }

    public static String solvePart1(final String input) {
        final var rotations = parse(input);
        var position = 50;
        var timesAtZeroPosition = 0;

        for (final var rotation : rotations) {
            position += (rotation.direction() == Rotation.Direction.LEFT ? -1 : 1) * rotation.distance();

            if (position < 0) {
                position += 100;
            }

            position = position % 100;

            if (position == 0) {
                timesAtZeroPosition++;
            }
        }

        return String.valueOf(timesAtZeroPosition);
    }

    public static String solvePart2(final String input) {
        final var rotations = parse(input);
        var position = 50;
        var timesAtZeroPosition = 0;

        for (final var rotation : rotations) {
            var newPosition = position + (rotation.direction() == Rotation.Direction.LEFT ? -1 : 1) * rotation.distance();

            if (newPosition < 0) {
                newPosition += 100;
            }

            newPosition = newPosition % 100;

            timesAtZeroPosition += countZerosDuringRotation(position, rotation.direction() == Rotation.Direction.LEFT ? -1 : 1, rotation.distance());
            position = newPosition;
        }

        return String.valueOf(timesAtZeroPosition);
    }

    private static int countZerosDuringRotation(int start, int dir, int dist) {
        // k ≡ -dir*start (mod 100)
        int k0 = (-dir * start) % 100;
        if (k0 < 1) k0 += 100;

        if (k0 > dist) {
            return 0; // first hit happens after the rotation ends
        }

        // Count hits: k0, k0+100, k0+200, ...
        return 1 + (dist - k0) / 100;
    }

    private static List<Rotation> parse(final String input) {
        final var lines = InputUtils.splitIntoLines(input);
        final var rotations = lines.stream().map((line) -> {
            final Pattern p = Pattern.compile("^(?<direction>[L,R])(?<distance>\\d+)$");
            final Matcher m = p.matcher(line);

            if (!m.find()) {
                throw new IllegalArgumentException(String.format("Line %s does not match the regex", line));
            }

            final var direction = m.group("direction").equals("L") ? Rotation.Direction.LEFT : Rotation.Direction.RIGHT;
            final var distance = Integer.parseInt(m.group("distance"));
            return new Rotation(direction, distance);
        }).toList();

        InputUtils.validate(rotations);

        return rotations;
    }
}
