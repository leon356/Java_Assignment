import java.util.*;

public class Main {
    public static void main(String[] args) {
        MessageHandler myMessageHandler = new MessageHandler();
        Random rand = new Random();
        int desktopId;
        
        // Test creating desktop storers
        for (int j = 0; j < 1000; j++) {
            desktopId = rand.nextInt(3); // random from 0–9
            myMessageHandler.storeMessage("Message number: " + j, desktopId);
        }

        // Print messages for each desktop
        for (int id = 0; id < 3; id++) {
            System.out.println("Recent for Desktop " + id + ":");
            System.out.println(myMessageHandler.getRecentMessages(id));

            System.out.println("History for Desktop " + id + ":");
            System.out.println(myMessageHandler.getHistoryMessages(id));
        }

        // Test overflow
        myMessageHandler = new MessageHandler();
        desktopId = 1;

        for (int j = 0; j < 1010; j++) {
            myMessageHandler.storeMessage("Message number: " + j, desktopId);
        }

        System.out.println("After overflow - Desktop 1 Recent:");
        System.out.println(myMessageHandler.getRecentMessages(desktopId));
        System.out.println("After overflow - Desktop 1 History:");
        System.out.println(myMessageHandler.getHistoryMessages(desktopId));
    }
}
