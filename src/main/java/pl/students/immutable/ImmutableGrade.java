package pl.students.immutable;

import java.time.LocalDateTime;

public final class ImmutableGrade {
    private final Double value;
    private final LocalDateTime announced;

    public ImmutableGrade(Double value, LocalDateTime announced) {
        this.value = new Double(value.doubleValue());
        this.announced = LocalDateTime.of(announced.getYear(), announced.getMonth(), announced.getDayOfMonth(), announced.getHour(), announced.getMinute(), announced.getSecond());
    }

    public String toString() {
        return announced.toString();
    }

    public double getValue() {
        return value;
    }

    public LocalDateTime getAnnounced() {
        return LocalDateTime.of(announced.getYear(), announced.getMonth(), announced.getDayOfMonth(), announced.getHour(), announced.getMinute(), announced.getSecond());
    }
}
