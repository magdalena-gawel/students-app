package pl.students.app;

import java.time.LocalDateTime;
import java.util.Objects;

class Grade {
    private Double value;
    private LocalDateTime announced;

    public Grade(Double value, LocalDateTime announced) {
        this.value = value;
        this.announced = announced;
    }

    public String toString() {
        return announced.toString();
    } //stupid implementation, but enough for now

    public Double getValue() {
        return value;
    }

    public LocalDateTime getAnnounced() {
        return announced;
    }

    @Override
    public boolean equals(Object o) {

        if (o == this) return true;
        if (o == null || !(o instanceof Grade)) {
            return false;
        }
        Grade grade = (Grade) o;

        return Objects.equals(value, grade.value) &&
                Objects.equals(announced, grade.announced);
    }

    @Override
    public int hashCode() {
        return Objects.hash(value, announced);
    }
}
