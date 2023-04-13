import java.util.Scanner;

public class Game {
    public Game() {
    }

    public void startNewGame(int gameMode) {
        System.out.println("Please enter player name");
        String playerName = new Scanner(System.in).nextLine();
        HumanPlayer humanPlayer = new HumanPlayer(playerName);
        Computer comp = new Computer();

        //if statement that chooses cpu or other player?
        if (gameMode == 1) {
            System.out.println("Your Cpu opponent is: " + comp.getCompName());
            pickType(humanPlayer, comp);
        }
    }

    public void pickType(Player playerOne, Player playerTwo) {
        System.out.println("Choose: \n 1. Rock \n 2. Paper \n 3. Scissors");
        String playerPick = playerOne.playerChoice();
        String player2Pick = playerTwo.playerChoice();
        if (playerPick.equals(player2Pick)) {
            System.out.println("Draw!");
        }else switch (playerPick) {
            case "Rock" : if (player2Pick.equals("Scissors")) {
                System.out.println(playerOne.getPlayerName() + " Wins!");
            }else System.out.println(playerTwo.getPlayerName() + " Wins!");
                break;
            case "Paper" : if (player2Pick.equals("Rock")) {
                System.out.println(playerOne.getPlayerName() + " Wins!");
            }else System.out.println(playerTwo.getPlayerName() + " Wins!");
                break;
            case "Scissors" : if (player2Pick.equals("Paper")) {
                System.out.println(playerOne.getPlayerName() + " Wins!");
            }else System.out.println(playerTwo.getPlayerName() + " Wins!");
                break;
        }
    }
}