import java.io.*;

public class Main {
    public static void main(String[] args) {
        try {
            PresentationLayer presentationLayer = new PresentationLayer();

            ByteArrayOutputStream bos = new ByteArrayOutputStream();
            ObjectOutputStream oos = new ObjectOutputStream(bos);
            Message message = new Message(1, "test");
            oos.writeObject(message);
            oos.flush();
            byte[] output = bos.toByteArray();
            presentationLayer.send(output, output.length);
/*
            ByteArrayInputStream bis = new ByteArrayInputStream(output);
            ObjectInputStream ois = new ObjectInputStream (bis);

            Message message2 = (Message)ois.readObject();

            System.out.println("message: " + message2.toString());
*/
        } catch (IOException e) {
            throw new RuntimeException(e);
        }/* catch (ClassNotFoundException e) {
            throw new RuntimeException(e);
        }
*/
    }
}