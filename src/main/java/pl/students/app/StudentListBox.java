package pl.students.app;

import java.util.List;

public class StudentListBox<T extends Student> {

    private List<T> content;

    public StudentListBox(List<T> content) {
        this.content = content;
    }

    public List<T> whatsInTheBox() {
        return content;
    }
}
