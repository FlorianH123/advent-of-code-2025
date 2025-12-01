package day01;

import jakarta.validation.constraints.Min;

public record Rotation(Direction direction, @Min(0) int distance) {
    public enum Direction {
        RIGHT,
        LEFT
    }
}
