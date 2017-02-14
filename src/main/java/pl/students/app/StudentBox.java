package pl.students.app;

public class StudentBox<T extends Student> {

    private T content;

    public StudentBox(T content) {
        this.content = content;
    }

    public T whatsInTheBox() {
        return content;
    }

    public boolean isPresent() {
        return(content != null);
    }
}
