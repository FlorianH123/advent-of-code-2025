package day03;

import utils.InputUtils;

import java.io.IOException;
import java.nio.file.Path;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.stream.Collectors;

import static java.lang.IO.println;

public class Day03 {
    static void main() throws IOException {
        final var input = InputUtils.readInputFile(Path.of("day03/input.txt"));

        final var resultPart1 = Day03.solvePart1(input);
        println("Result of part one: " + resultPart1);

        final var resultPart2 = Day03.solvePart2(input);
        println("Result of part two: " + resultPart2);
    }

    public static String solvePart1(final String input) {
        return solve(input, 2);
    }

    public static String solvePart2(final String input) {
        return solve(input, 12);
    }

    private static String solve(final String input, final int joltageLength) {
        final var batteryBanks = InputUtils.splitIntoLines(input);
        final var maxBatteryJoltagePerBank = new ArrayList<Long>();

        for (final var bank : batteryBanks) {
            final var batteryJoltages = Arrays.stream(bank.split("")).map(Long::parseLong).toList();

            var lastJoltageIndex = -1;
            final var nextJoltages = new ArrayList<>();

            for (var i = 0; i < joltageLength; i++) {
                var maxJoltage = 0L;
                for (int y = lastJoltageIndex + 1; y < batteryJoltages.size() - (joltageLength - 1 - i); y++) {
                    long batteryJoltage = batteryJoltages.get(y);
                    if (batteryJoltage > maxJoltage) {
                        maxJoltage = batteryJoltage;
                        lastJoltageIndex = y;
                    }
                }

                nextJoltages.add(maxJoltage);
            }

            maxBatteryJoltagePerBank.add(Long.parseLong(nextJoltages.stream().map(String::valueOf).collect(Collectors.joining())));
        }

        return String.valueOf(maxBatteryJoltagePerBank.stream().mapToLong(Long::longValue).sum());
    }
}
