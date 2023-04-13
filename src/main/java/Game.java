import java.util.Scanner;

public class Game {

    public Game() {
    }



    public static void startNewGame(int gameMode) {
        System.out.println("Please enter player name");
        Scanner scanner = new Scanner(System.in);
        String playerName = scanner.nextLine();
        HumanPlayer humanPlayer = new HumanPlayer(playerName);
        //if statement that chooses cpu or other player?
        if (gameMode == 1) {
            System.out.println("Your Cpu Opponent is: " + Computer.createCpu().getCpuName());
            startGame(humanPlayer);
        }
    }

    public static void startGame(HumanPlayer humanPlayer) {
        System.out.println("Choose: \n 1. Rock \n 2. Paper \n 3. Scissors");
        Scanner scanner = new Scanner(System.in);
        String str = scanner.nextLine();
        System.out.println(humanPlayer.getPlayerName() + "chose " + str);
    }
}
