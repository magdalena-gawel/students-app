package pl.students.immutable;

import java.util.Date;

public final class ImmutableGrade {
    private final Double value;
    private final Date announced;

    public ImmutableGrade(Double value, Date announced) {
        this.value = new Double(value.doubleValue());
        this.announced = new Date(announced.getTime());
    }

    public String toString() {
        return announced.toString();
    }

    public double getValue() {
        return value;
    }

    public Date getAnnounced() {
        return new Date(announced.getTime());
    }
}
