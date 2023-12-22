import java.util.Scanner;

public class HoneypotSystem {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.println("Welcome to the Honeypot System Simulation");

        while (true) {
            System.out.println("\nEnter your command (login/exit):");
            String command = scanner.nextLine();

            if (command.equalsIgnoreCase("exit")) {
                System.out.println("Exiting the Honeypot System Simulation");
                break;
            } else if (command.equalsIgnoreCase("login")) {
                System.out.println("Enter your username:");
                String username = scanner.nextLine();

                System.out.println("Enter your password:");
                String password = scanner.nextLine();

                // Simulate honeypot behavior
                if (isHoneypot(username, password)) {
                    System.out.println("WARNING: Unauthorized access detected!");
                    logHoneypotActivity(username);
                } else {
                    System.out.println("Welcome, " + username + "! This is a simulated safe system.");
                }
            } else {
                System.out.println("Invalid command. Please enter 'login' or 'exit'.");
            }
        }

        scanner.close();
    }

    private static boolean isHoneypot(String username, String password) {
        // Simulate honeypot conditions (e.g., checking for default credentials)
        return username.equals("admin") && password.equals("password");
    }

    private static void logHoneypotActivity(String username) {
        // Simulate logging honeypot activity
        System.out.println("Logging unauthorized access attempt by user: " + username);
        // Additional logging and notification mechanisms can be added in a real system
    }
}
