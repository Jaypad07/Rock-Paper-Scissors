import java.util.InputMismatchException;
import java.util.Scanner;

public class Game {
    Records record = new Records();

    public void startNewGame(int gameMode) throws InputMismatchException {

        switch (gameMode) {  //Starts game vs Computer
            case 1 -> {
                System.out.println("Please enter player name");
                String playerName = new Scanner(System.in).nextLine();
                HumanPlayer humanPlayer = new HumanPlayer(playerName);
                Computer comp = new Computer();
                System.out.println("Your Cpu opponent is: " + comp.getCompName());
                pickType(humanPlayer, comp);

            }
            case 2 -> { //Starts TwoPlayer game
                System.out.println("Please enter player name");
                String playerName = new Scanner(System.in).nextLine();
                HumanPlayer humanPlayer = new HumanPlayer(playerName);
                System.out.println("Please enter player2 name");
                String player2Name = new Scanner(System.in).nextLine();
                Player humanPlayer2 = new HumanPlayer(player2Name);
                System.out.println("Your opponent is: " + humanPlayer2.getPlayerName());
                pickType(humanPlayer, humanPlayer2);
            }
            case 3  -> { //Brings up records screen - This should read from file and display past records
                record.displayRecords();
            }

            case 4  -> { // Terminates program with a "You have exited the game" message
                System.exit(0);
            }
            default -> System.out.println("Please select a valid number, select a number 1-4");
        }
    }

    public void pickType(Player playerOne, Player playerTwo) {
        System.out.println(playerOne.getPlayerName() + " Choose: \n 1. Rock \n 2. Paper \n 3. Scissors");
        String playerPick = playerOne.playerChoice();

        if (!(playerTwo instanceof Computer)) {
            System.out.println(playerTwo.getPlayerName() + " Choose: \n 1. Rock \n 2. Paper \n 3. Scissors");
        }
        String player2Pick = playerTwo.playerChoice(); //May store results in player object and call in records from there

        if (playerPick.equals(player2Pick)) {
            record.recordDraw(playerOne, playerTwo, playerPick, player2Pick);
        }else switch (playerPick) {
            case "Rock" : if (player2Pick.equals("Scissors")) {
                record.recordWin(playerOne, playerTwo, playerPick, player2Pick);
            }else record.recordLoss(playerOne, playerTwo, playerPick, player2Pick);
                break;
            case "Paper" : if (player2Pick.equals("Rock")) {
                record.recordWin(playerOne, playerTwo,playerPick, player2Pick);
            }else  record.recordLoss(playerOne, playerTwo, playerPick, player2Pick);
                break;
            case "Scissors" : if (player2Pick.equals("Paper")) {
                record.recordWin(playerOne, playerTwo, playerPick, player2Pick);
            }else  record.recordLoss(playerOne, playerTwo, playerPick, player2Pick);
                break;
        }
    }

    public void restartGame() {
        System.out.println("Do you want to play again? (Y/N)");
        Scanner scanner = new Scanner(System.in);
        String str = scanner.nextLine();
        if (str.equalsIgnoreCase("y")) MainMenu.restartCount();
        else System.exit(0);
    }
}