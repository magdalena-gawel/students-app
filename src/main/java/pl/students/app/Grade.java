package pl.students.app;

import java.util.Date;
import java.util.Objects;

class Grade {
    private double value;
    private Date announced;

    Grade(double value, Date announced) {
        this.value = value;
        this.announced = announced;
    }

    public String toString() {
        return announced.toString();
    } //stupid implementation, but enough for now

    public double getValue() {
        return value;
    }

    public Date getAnnounced() {
        return announced;
    }

    @Override
    public boolean equals(Object o) {

        if (o == this) return true;
        if (o == null || !(o instanceof Grade)) {
            return false;
        }
        Grade grade = (Grade) o;

        return value == grade.value &&
                Objects.equals(announced, grade.announced);
    }

    @Override
    public int hashCode() {
        return Objects.hash(value, announced);
    }
}
