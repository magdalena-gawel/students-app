package pl.students.app;

import java.util.ArrayList;
import java.util.Objects;

public class StudentIncorrectEqualsAndHash {
    private String name;
    private String surname;
    private ArrayList<Grade> grades = new ArrayList<Grade>();

    StudentIncorrectEqualsAndHash(String name, String surname) {
        this.name = name.substring(0, 1).toUpperCase() + name.substring(1).toLowerCase();
        this.surname = surname.substring(0, 1).toUpperCase() + surname.substring(1).toLowerCase();
    }

    public ArrayList<Grade> getGrades() {
        return grades;
    }

    public void setGrades(ArrayList<Grade> grades) {
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
        return true; //incorrect equals
    }

    @Override
    public int hashCode() {
        return Objects.hash(name); //incorrect hashcode
    }

    /**
     * Calculate student's average grade
     *
     * @return double
     */
    public double calculateAverageGrade() {
        double sum = 0.0;
        if (!this.grades.isEmpty()) {
            for (Grade grade : this.grades) {
                sum += grade.getValue();
            }
            return sum / this.grades.size();
        }
        return 0.0;
    }


}
