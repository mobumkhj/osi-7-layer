import java.io.*;

public class Main2 {
    public static void main(String[] args) {
        try {
            int INPUT_SIZE_MAX = 1000000;
            byte[] input = new byte[INPUT_SIZE_MAX];
            DataLayer dataLayer = new Layer6();
            dataLayer.receive(input, input.length);

            ByteArrayInputStream bis = new ByteArrayInputStream(input);
            ObjectInputStream ois = new ObjectInputStream (bis);

            Message message = (Message)ois.readObject();

            System.out.println("message: " + message.toString());

        } catch (IOException e) {
            throw new RuntimeException(e);
        } catch (ClassNotFoundException e) {
            throw new RuntimeException(e);
        }

    }
}