import java.util.InputMismatchException;
import java.util.Scanner;

public class MainMenu {
    public static void main(String[] args) {
        MainMenu menu = new MainMenu();
        menu.menu();
    }

    /**
     * This method displays each game mode. It takes user input and passes that input to the
     * startGame method located in the Game class. If the user enters invalid input it will handle the exception,
     * inform the user of the accepted input and restart to the menu so the user may select again.
     */
    public void menu() {
        System.out.println();
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

        try {
            int userInput = new Scanner(System.in).nextInt(); //Creates a Scanner object to take in user input to select game mode
            Game game = new Game();
            game.startNewGame(userInput);
        }catch (InputMismatchException e) {
            System.out.println("Please select a valid number, you may choose again in:");
            restartCount();
        }
    }


    /**
     * This method will handle any bad input from the user. If the user enters a number outside the accepted range,
     * this method will wait 2 seconds, and then begin a countdown to restart the menu.
     */
    public static void restartCount() { //Handles bad input from player & restarts game
        try {
            int count = 3;
            Thread.sleep(2000);
            while (count > 0) {
                System.out.println(count);
                Thread.sleep(1000);
                count--;
            }
            new MainMenu().menu();
        } catch (InterruptedException ex) {
            System.out.println(ex.getMessage());
        }
    }
}