 // part 2 commit 6
import java.util.Scanner;
import java.util.ArrayList;

public class ChatApp {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Login loginObj = new Login("", "", "");
        ArrayList<Message> allMessages = new ArrayList<>();

        System.out.println("=== REGISTRATION ===");
        System.out.print("Enter username (must contain _ and max 5 chars): ");
        String username = scanner.nextLine();
        System.out.print("Enter password (8 chars, capital, number, special char): ");
        String password = scanner.nextLine();
        System.out.print("Enter cellphone (e.g. +2783123456): ");
        String cell = scanner.nextLine();

        String regResult = loginObj.registerUser(username, password, cell);
        System.out.println(regResult);

        if (!regResult.equals("User registered successfully.")) {
            System.out.println("Registration failed. Exiting.");
            scanner.close();
            return;
        }

        System.out.println("\n=== LOGIN ===");
        System.out.print("Enter username: ");
        String loginU = scanner.nextLine();
        System.out.print("Enter password: ");
        String loginP = scanner.nextLine();

        System.out.println(loginObj.returnLoginStatus(loginU, loginP));

        if (!loginObj.loginUser(loginU, loginP)) {
            scanner.close();
            return;
        }

        // PART 2 - QUICKCHAT
        System.out.println("\nWelcome to QuickChat.");
        System.out.print("How many messages do you wish to send? Enter number: ");
        int numMessages = Integer.parseInt(scanner.nextLine());

        // LOOP for sending messages
        for (int i = 0; i < numMessages; i++) {
            System.out.println("\n--- Message " + (i+1) + "/" + numMessages + " ---");
            
            System.out.print("Enter recipient cell (e.g. +2771234567, max 10 chars): ");
            String recipient = scanner.nextLine();

            System.out.print("Enter your message (max 250 chars): ");
            String text = scanner.nextLine();

            Message msg = new Message(recipient, text);

            // Check recipient - Learning Unit 5 if else
            if (!msg.checkRecipientCell()) {
                System.out.println("Cell phone number is incorrectly formatted or does not contain an international code, please correct the number and try again.");
                i--; // ask again
                continue;
            }

            // Check length
            String lengthCheck = msg.checkMessageLength();
            System.out.println(lengthCheck);

            if (lengthCheck.startsWith("Message exceeds")) {
                i--; // ask again
                continue;
            }

            // Display message details
            System.out.println("\nMessage Details:");
            System.out.println(msg.printMessage());

            System.out.println("\nWhat do you want to do?");
            System.out.println("1) Send Message");
            System.out.println("2) Disregard Message");
            System.out.println("3) Store Message to send later");
            System.out.print("Choose (1-3): ");
            String choice = scanner.nextLine();

            // Switch - Learning Unit 5
            switch (choice) {
                case "1":
                    allMessages.add(msg);
                    Message.incrementMessages();
                    System.out.println("Message successfully sent.");
                    break;
                case "2":
                    System.out.println("Press 0 to delete message.");
                    System.out.println("Message disregarded.");
                    break;
                case "3":
                    allMessages.add(msg);
                    System.out.println("Message successfully stored.");
                    break;
                default:
                    System.out.println("Invalid option, message disregarded.");
                    break;
            }
        }

        // Display all messages
        System.out.println("\n=== All Messages ===");
        for (Message m : allMessages) {
            System.out.println(m.printMessage());
            System.out.println("-------------------");
        }
        System.out.println("Total messages sent: " + Message.returnTotalMessages());

        scanner.close();
    }
}