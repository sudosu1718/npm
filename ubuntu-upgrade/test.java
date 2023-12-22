import java.util.Scanner;

public class test {

    private static boolean isHoneypot(String username, String password){
        if(username.equals("admin") && password.equals("password")){
            return true;
        }
        else{
            return false;
        }
    }

    private static void logHoneypotActivity(String username){
        System.out.println("Logging unauthorized access attempt");
    }
    
    public static void main(String args[]){
        Scanner sc = new Scanner(System.in);
        System.out.println("Welcome to Honeypot system!");

        while(true){
            System.out.print("Enter your command (login/exit): ");
            String command = sc.nextLine();

            if (command.equalsIgnoreCase("exit")){
                System.out.println("Exiting Honeypot system");
                break;
            }
            else if(command.equalsIgnoreCase("login")){
                System.out.print("Username: ");
                String username = sc.nextLine();
                
                System.out.print("Password: ");
                String password = sc.nextLine();
                
                if(isHoneypot(username, password)){
                    System.out.println("Warning! Unauthorized access detected!");
                    logHoneypotActivity(username);
                }
                else{
                    System.out.println("Welcome "+ username + "!\nThis is a simulated safe honeypot system");
                }
            }
            else{
                System.out.println("Invalid Command");
            }
        }

        sc.close();
    }
}
