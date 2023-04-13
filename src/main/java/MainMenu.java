import java.util.Scanner;

public class MainMenu {
    public static void main(String[] args) {
        MainMenu menu = new MainMenu(); //Is it ok to shorten this?
        menu.menu();
    }

    public void menu() {
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

        int userInput = new Scanner(System.in).nextInt();  //Is this ok to do? Code readAbility
        Game game = new Game();
        game.startNewGame(userInput);
    }

}
