package Programm;
import java.io.FileWriter;
import java.io.IOException;

public class Generator {
    public static void generateTickets(String fileName) {
        int totalTickets = 0;
        int maxNumber = 999999;
        try {
            FileWriter writer = new FileWriter(fileName);

            for (int ticketNumber = 0; ticketNumber <= maxNumber; ticketNumber++) {
                int sum1 = 0;
                int sum2 = 0;

                int num = ticketNumber;

                for (int i = 0; i < 3; i++) {
                    sum1 += num % 10;
                    num /= 10;
                }

                for (int i = 0; i < 3; i++) {
                    sum2 += num % 10;
                    num /= 10;
                }

                if (sum1 == sum2) {
                    String ticket = String.format("%06d", ticketNumber);
                    writer.write(ticket + "\n");
                    totalTickets++;
                }
            }

            writer.close();
        } catch (IOException e) {
            System.err.println("File writer error: " + e.getMessage());
        }

        System.out.println(totalTickets + " was genereted in " + fileName);
    }
}