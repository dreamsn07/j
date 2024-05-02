import java.rmi.*;
import java.util.Scanner;

public class Client {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        try {
            String serverURL = "rmi://localhost/Server";
            Serverintf serverintf = (Serverintf) Naming.lookup(serverURL);
            System.out.print("Enter First Number: ");
            double num1 = sc.nextDouble();
            System.out.print("Enter Second Number: ");
            double num2 = sc.nextDouble();
            System.out.println("First Number is: " + num1);
            System.out.println("Second Number is: " + num2);
            System.out.println(" ------------------------------------- Results-");
            System.out.println("Addition is: " +
                    serverintf.addition(num1, num2));
            System.out.println("Subtraction is: " +
                    serverintf.subtraction(num1, num2));
            System.out.println("Multiplication is: " +
                    serverintf.multiplication(num1, num2));
            System.out.println("Division is: " +
                    serverintf.division(num1, num2));
        } catch (Exception e) {
            System.out.println("Exception Occurred at Client!" + e.getMessage());
        }
    }
}


//javac  *.java
//rmiregistry
//java Server
// java Client
