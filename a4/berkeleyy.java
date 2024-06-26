import java.util.Date;
import java.util.Scanner;
import java.text.ParseException;
import java.text.SimpleDateFormat;
public class berkeleyy {
public static void berkeleyAlgo(String servertime, String time1, String time2) {
System.out.println("Server Clock = " + servertime);
System.out.println("Client Clock 1 = " + time1);
System.out.println("Client Clock 2 = " + time2);
SimpleDateFormat sdf = new SimpleDateFormat("mm:ss");
try {
/* Converting time to Milliseconds */
long s = sdf.parse(servertime).getTime();
long t1 = sdf.parse(time1).getTime();
long t2 = sdf.parse(time2).getTime();
/* Calcuating time differences w.r.t server */
long st1 = t1- s;
System.out.println("t1- s = "+st1/1000);
long st2 = t2- s;
System.out.println("t2- s = "+st2/1000);
/* Fault tolerant Average */
long aveg = (st1 + st2 + 0) / 3;
System.out.println("(st1 + st2 + 0)/3 = "+aveg/1000);
/* Adjustment */
long adjserver = aveg+s;
long adj_t1 = aveg-st1;
long adj_t2 = aveg-st2;
System.out.println("t1 adjustment = "+adj_t1/1000);
System.out.println("t2 adjustment = "+adj_t2/1000);
/* sync clock */
System.out.println("Synchronized Server Clock = "+sdf.format(new Date(adjserver)));
System.out.println("Synchronized Client1 Clock = "+sdf.format(new Date(t1+adj_t1)));
System.out.println("Synchronized Client2 Clock = "+sdf.format(new Date(t2+adj_t2)));
} catch (ParseException e) {
e.printStackTrace();
}
}
public static void main(String[] args) {
Scanner input = new Scanner(System.in);
System.out.print("Enter the number of clients: ");
int numClients = input.nextInt();
String[] clientTimes = new String[numClients];
for (int i = 0; i < numClients; i++) {
System.out.print("Enter client clock " + (i+1) + " (mm:ss): ");
clientTimes[i] = input.next();
}
System.out.print("Enter server time (mm:ss): ");
String servertime = input.next();
for (int i = 0; i < numClients; i++) {
berkeleyAlgo(servertime, clientTimes[i], clientTimes[(i+1)%numClients]);
}
input.close();
}
}