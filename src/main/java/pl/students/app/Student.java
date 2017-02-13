package pl.students.app;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import java.util.stream.Collectors;

public class Student {
    private String name;
    private String surname;
    private List<Grade> grades;

    Student(String name, String surname) {
        this.name = name.substring(0, 1).toUpperCase() + name.substring(1).toLowerCase();
        this.surname = surname.substring(0, 1).toUpperCase() + surname.substring(1).toLowerCase();
        grades = new ArrayList<Grade>();
    }

    public List<Grade> getGrades() {
        return grades;
    }

    public void setGrades(List<Grade> grades) {
        this.grades = grades;
    }

    public String getName() {
        return name;
    }

    public String getSurname() {
        return surname;
    }

    @Override
    public String toString() {
        return name + " " + surname + " " + calculateAverageGrade();
    }

    @Override
    public boolean equals(Object o) {

        if (o == this) return true;
        if (o == null || !(o instanceof Student)) {
            return false;
        }
        Student student = (Student) o;

        return Objects.equals(name, student.name) &&
                Objects.equals(surname, student.surname) && Students.listEqualsNoOrder(student.getGrades(), grades);
    }

    @Override
    public int hashCode() {
        return Objects.hash(name, surname);
    }

    /**
     * Calculate student's average grade
     *
     * @return double
     */
    public double calculateAverageGrade() {
        double sum = 0.0;
        if (!grades.isEmpty()) { //this.grades is not needed
            for (Grade grade : grades) {
                sum += grade.getValue();
            }
            return sum / grades.size();
        }
        return 0.0;
    }

    public double calculateAverageGradeStream() {
        return grades.stream().collect(Collectors.averagingDouble(Grade::getValue));
    }

    /**
     * TODO: write my own collector to calculate average grade
     */

}
