import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.Assertions;

import java.io.*;

class TestLayer implements DataLayer {

    public void send(byte[] b, int len) {
    }

    public int receive(byte[] b, int len) {
        DataLayer dataLayer = new Layer6();

        try {

            ByteArrayOutputStream bos = new ByteArrayOutputStream();
            ObjectOutputStream oos = new ObjectOutputStream(bos);
            Message message = new Message(2, "test data");
            oos.writeObject(message);
            oos.flush();
            b = bos.toByteArray();
        } catch (IOException e) {
            throw new RuntimeException(e);
        }

        return b.length;
    }
}

class Layer6Test {
    private DataLayer target;

    @BeforeEach
    void setUp() {
        target = new TestLayer();
    }

    @Test
    void send() {
    }

    @Test
    void receive() throws IOException, ClassNotFoundException {
        int INPUT_SIZE_MAX = 1000000;
        byte[] input = new byte[INPUT_SIZE_MAX];
        int size = target.receive(input, input.length);

        Assertions.assertTrue(size > 0);

        ByteArrayInputStream bis = new ByteArrayInputStream(input);
        ObjectInputStream ois = new ObjectInputStream (bis);

        Message message = (Message)ois.readObject();

        Assertions.assertEquals(2, message.id);
    }
}