package pl.students.app;

import java.util.*;

import static java.util.stream.Collectors.toList;

class Students {

    List<Student> students = new ArrayList<Student>();

    public static <T> boolean listEqualsNoOrder(List<Grade> l1, List<Grade> l2) {
        final Set<Grade> s1 = new HashSet<>(l1);
        final Set<Grade> s2 = new HashSet<>(l2);
        return s1.equals(s2);
    }

    public void addStudent(Student student) {
        students.add(student);
    }

    public List<Student> getStudents() {
        return students;
    }

    /**
     * Sort list of students by average grade, ascending
     *
     * @return List<Student>
     */
    public List<Student> sortByGrade() {
        Comparator<Student> byGrade = Comparator.comparingDouble(Student::calculateAverageGrade);
        return students.stream()
                .sorted(byGrade)
                .collect(toList());

//        Collections.sort(students, (a, b) -> a.calculateAverageGrade() < b.calculateAverageGrade() ? -1 : a.calculateAverageGrade() == b.calculateAverageGrade() ? 0 : 1);
//        return students;
    }


    /**
     * Return list of students with name starting with letter passed as param
     *
     * @param letter
     * @return List<Student>
     */
    public List<Student> getStudentsWithNameStartingWith(Character letter) {
        if (letter == null) {
            throw new IllegalArgumentException("Argument cannot be null");
        }
        return students.stream()
                .filter(t -> t.getName().startsWith(letter.toString().toUpperCase()))
                .collect(toList());

//        ArrayList<Student> found = new ArrayList<Student>();
//        for (Student student : students) {
//            if (student.getName().startsWith(letter.toUpperCase())) {
//                found.add(student);
//            }
//        }
//        return found;
    }

    /**
     * Remove all students with name ended with letter passed as param
     * from the list
     *
     * @param letter
     * @return List<Student>
     */
    public List<Student> getStudentsWithSurnameNotEnded(Character letter) {
        if (letter == null) {
            throw new IllegalArgumentException("Argument cannot be null");
        }
        return students.stream()
                .filter(t -> !t.getSurname().toLowerCase().endsWith(letter.toString().toLowerCase()))
                .collect(toList());

//        //TODO: use streams instead
//        ListIterator<Student> iter = students.listIterator();
//        while (iter.hasNext()) {
//            Student current = iter.next();
//            if (current.getSurname().toLowerCase().endsWith(letter.toString().toLowerCase())) {
//                iter.remove();
//            }
//        }
//        return students;
    }

}
