package pl.students.immutable;

import java.util.Date;

final class ImmutableGrade {
    private double value;
    private Date announced;

    ImmutableGrade(double value, Date announced) {
        this.value = value;
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
