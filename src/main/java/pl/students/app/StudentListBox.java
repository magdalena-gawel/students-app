package pl.students.app;

import java.util.ArrayList;

public class StudentListBox<T extends Student> {

    private ArrayList<T> content;

    public StudentListBox(ArrayList<T> content) {
        this.content = content;
    }

    public ArrayList<T> whatsInTheBox() {
        return content;
    }
}
