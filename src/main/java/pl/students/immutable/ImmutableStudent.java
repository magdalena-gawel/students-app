package pl.students.immutable;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public final class ImmutableStudent {
    private String name;
    private String surname;
    private List<ImmutableGrade> grades;

    ImmutableStudent(String name, String surname, List<ImmutableGrade> graades) {
        this.name = name.substring(0, 1).toUpperCase() + name.substring(1).toLowerCase();
        this.surname = surname.substring(0, 1).toUpperCase() + surname.substring(1).toLowerCase();
        this.grades = Collections.unmodifiableList(graades);
        //http://stackoverflow.com/questions/3650701/why-can-we-change-the-unmodifiable-list-if-we-have-the-original-one
    }

    public String getName() {
        return name;
    }

    public String getSurname() {
        return surname;
    }

    public List<ImmutableGrade> getGrades() {
        return grades;
    }

    @Override
    public String toString() {
        return name + " " + surname + " " + calculateAverageGrade();
    }

    /**
     * Calculate student's average grade
     *
     * @return double
     */
    public double calculateAverageGrade() {
        double sum = 0.0;
        if (!this.grades.isEmpty()) {
            for (ImmutableGrade grade : this.grades) {
                sum += grade.getValue();
            }
            return sum / this.grades.size();
        }
        return 0.0;
    }


}
