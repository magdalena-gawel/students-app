package pl.students.app;

import java.util.*;

class Students {

    ArrayList<Student> students = new ArrayList<Student>();

    public static <T> boolean listEqualsNoOrder(List<Grade> l1, List<Grade> l2) {
        final Set<Grade> s1 = new HashSet<>(l1);
        final Set<Grade> s2 = new HashSet<>(l2);
        return s1.equals(s2);
    }

    public void addStudent(Student student) {
        students.add(student);
    }

    public ArrayList<Student> getStudents() {
        return students;
    }

    /**
     * Sort list of students by average grade, ascending
     *
     * @return ArrayList<Student>
     */
    public ArrayList<Student> sortByGrade() {
        //TODO: use streams instead
        Collections.sort(students, (a, b) -> a.calculateAverageGrade() < b.calculateAverageGrade() ? -1 : a.calculateAverageGrade() == b.calculateAverageGrade() ? 0 : 1);
        return students;
    }

    /**
     * Return list of students with name starting with letter passed as param
     *
     * @param letter
     * @return ArrayList<Student>
     */
    public ArrayList<Student> getStudentsWithNameStartingWith(String letter) {
        if (letter.length() != 1) {
            throw new IllegalArgumentException("Only one letter allowed.");
        }
        //TODO: use streams instead
        ArrayList<Student> found = new ArrayList<Student>();
        for (Student student : students) {
            if (student.getName().startsWith(letter.toUpperCase())) {
                found.add(student);
            }
        }
        return found;
    }

    /**
     * Remove all students with name ended with letter passed as param
     * from the list
     *
     * @param letter
     * @return ArrayList<Student>
     */
    public ArrayList<Student> getStudentsWithSurnameNotEndedWith(Character letter) { //Character = 1 letter
        if (letter == null) {
            throw new IllegalArgumentException("Only one letter allowed.");
        }
        //TODO: use streams instead
        ListIterator<Student> iter = students.listIterator();
        while (iter.hasNext()) {
            Student current = iter.next();
            if (current.getSurname().toLowerCase().endsWith(letter.toString().toLowerCase())) {
                iter.remove();
            }
        }
        return students;
    }

}
