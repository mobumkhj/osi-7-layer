import java.io.Serializable;

public class Message implements Serializable {
    private int id;
    private String message;
    public Message(int id, String message) {
        this.id = id;
        this.message = message;
    }
}
