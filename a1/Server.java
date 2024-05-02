import java.rmi.*;

public class Server {
    public static void main(String[] args) {
        try {
        Serverimpl serverimpl = new Serverimpl();
        Naming.rebind("Server", serverimpl);
        System.out.println("Server started...");
        } catch (Exception e) {
        System.out.println("Eception Occurred at server!"
        + e.getMessage());
        }
        }
        }


