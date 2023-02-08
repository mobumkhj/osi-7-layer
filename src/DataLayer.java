public interface DataLayer {

    void send(byte[] b, int len);

    int receive(byte[] b, int len);
}
