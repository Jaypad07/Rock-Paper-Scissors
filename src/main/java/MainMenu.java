import java.util.InputMismatchException;
import java.util.Scanner;

public class MainMenu {
    public static void main(String[] args) {
        MainMenu menu = new MainMenu();
        menu.menu();
    }

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
            int userInput = new Scanner(System.in).nextInt();
            Game game = new Game();
            game.startNewGame(userInput);
        }catch (InputMismatchException e) {
            System.out.println("Please select a valid number, you may choose again in:");
            restartCount();
        }
    }

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
            throw new RuntimeException(ex);
        }
    }
}
