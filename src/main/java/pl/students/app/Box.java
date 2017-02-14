package pl.students.app;

public class Box<T> {

    private T content;

    public Box(T content) {
        this.content = content;
    }

    public T whatsInTheBox() {
        return content;
    }

    public boolean isPresent() {
        return(content != null);
    }
}
