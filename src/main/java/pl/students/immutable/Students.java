package pl.students.immutable;

import pl.students.app.Student;

import java.util.*;

import static java.util.stream.Collectors.toList;

class Students {

    ArrayList<ImmutableStudent> students = new ArrayList<ImmutableStudent>();

    public void addStudent(ImmutableStudent student) {
        students.add(student);
        System.out.println("Added to collection!");
    }

    public ArrayList<ImmutableStudent> getStudents() {
        return students;
    }

    /**
     * Sort list of students by average grade, ascending
     *
     * @return List<ImmutableStudent>
     */
    public List<ImmutableStudent> sortByGrade() {
        Comparator<ImmutableStudent> byGrade = (e1, e2) -> Double.compare(e1.calculateAverageGrade(), e2.calculateAverageGrade());
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
     * @return ArrayList<ImmutableStudent>
     */
    public ArrayList<ImmutableStudent> getStudentsWithNameStartingWith(String letter) {
        if (letter.length() != 1) {
            throw new IllegalArgumentException("Only one letter allowed.");
        }
        ArrayList<ImmutableStudent> found = new ArrayList<ImmutableStudent>();
        for (ImmutableStudent student : students) {
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
     * @return ArrayList<ImmutableStudent>
     */
    public ArrayList<ImmutableStudent> removeStudentsWithSurnameEndedWith(String letter) {
        if (letter.length() != 1) {
            throw new IllegalArgumentException("Only one letter allowed.");
        }
        ListIterator<ImmutableStudent> iter = students.listIterator();
        while (iter.hasNext()) {
            ImmutableStudent current = iter.next();
            if (current.getSurname().endsWith(letter.toUpperCase()) || current.getSurname().endsWith(letter.toLowerCase())) {
                iter.remove();
            }
        }
        return students;
    }

}
