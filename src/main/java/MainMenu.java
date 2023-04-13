import java.util.Scanner;

public class MainMenu {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Welcome to Rock Paper Scissors!");
        System.out.println();
        System.out.println("MAIN MENU");
        System.out.println("==========");
        System.out.println("1. Single Player");
        System.out.println("2. Two Players");
        System.out.println("3. Records");
        System.out.println("4. Quit Game");
        System.out.println();
        System.out.println("Please select an option by pressing 1-4");
        int userInput = scanner.nextInt();


        switch (userInput) {
            case 1 : Game.startNewGame(userInput); //Starts game vs Computer
                break;
            case 2 : //Starts game vs Player
                break;
            case 3 : //Brings up records screen - This should read from file and display past records
                break;
            case 4 : // Terminates program with a "You have exited the game" message
        }
    }
}
