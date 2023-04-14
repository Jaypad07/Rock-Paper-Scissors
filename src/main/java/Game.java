import java.util.InputMismatchException;
import java.util.Scanner;

public class Game {
    private final Records record = new Records();
    private boolean playerRestart;


    public void startNewGame(int gameMode) throws InputMismatchException {

        switch (gameMode) {  //Starts game vs Computer
            case 1 -> playerVsComputer();
            case 2 -> playerVsPlayer(); //Starts TwoPlayer game
            case 3 -> record.displayRecords(); //Brings up records screen - This should read from file and display past records
            case 4 -> System.exit(0); // Terminates program with a "You have exited the game" message
            default -> {
                System.out.println("Please select a valid number, select a number 1-4");
                MainMenu.restartCount();
            }

        }
    }

    public void pickType(Player playerOne, Player playerTwo) {

        System.out.println(playerOne.getPlayerName() + " Choose: \n 1. Rock \n 2. Paper \n 3. Scissors");
        String playerPick = playerOne.playerChoice();

        if (!(playerTwo instanceof Computer)) {
            System.out.println(playerTwo.getPlayerName() + " Choose: \n 1. Rock \n 2. Paper \n 3. Scissors");
        }
        String player2Pick = playerTwo.playerChoice();

        if (playerPick.equals(player2Pick)) {
            record.recordDraw(playerOne, playerTwo, playerPick, player2Pick);
        }else switch (playerPick) {
            case "Rock" : if (player2Pick.equals("Scissors")) {
                playerOne.setPlayerPoints(1);
                record.recordWin(playerOne, playerTwo, playerPick, player2Pick);
            }else {
                playerTwo.setPlayerPoints(1);
                record.recordLoss(playerOne, playerTwo, playerPick, player2Pick);
            }
                break;
            case "Paper" : if (player2Pick.equals("Rock")) {
                playerOne.setPlayerPoints(1);
                record.recordWin(playerOne, playerTwo,playerPick, player2Pick);
            }else {
                playerTwo.setPlayerPoints(1);
                record.recordLoss(playerOne, playerTwo, playerPick, player2Pick);
            }
                break;
            case "Scissors" : if (player2Pick.equals("Paper")) {
                playerOne.setPlayerPoints(1);
                record.recordWin(playerOne, playerTwo, playerPick, player2Pick);
            }else {
                playerTwo.setPlayerPoints(1);
                record.recordLoss(playerOne, playerTwo, playerPick, player2Pick);
            }
                break;
        }
    }

    public void playerVsComputer() {
        if (playerRestart) {
            System.out.println("Your Cpu opponent is: " + Computer.computer.getCompName());
            pickType(HumanPlayer.humanPlayer.getHumanPlayer(), Computer.computer);
            displayPoints(HumanPlayer.humanPlayer, Computer.computer);
            playAgain(1);

        }else {
            System.out.println("Please enter player name");
            String playerName = new Scanner(System.in).nextLine();
            HumanPlayer humanPlayer = new HumanPlayer(playerName);
            humanPlayer.setHumanPlayer(humanPlayer);
            Computer computer = new Computer();
            computer.setComputer(computer);
            System.out.println("Your Cpu opponent is: " + computer.getCompName());
            pickType(humanPlayer, computer);
            displayPoints(HumanPlayer.humanPlayer, computer);
            playAgain(1);
        }
    }

    public void playerVsPlayer(){
        if (playerRestart) {
            pickType(HumanPlayer.humanPlayer.getHumanPlayer(), HumanPlayer.humanPlayer2.getHumanPlayer2());
            displayPoints(HumanPlayer.humanPlayer, HumanPlayer.humanPlayer2);
            playAgain(2);
        }else {
            System.out.println("Please enter player name");
            String playerName = new Scanner(System.in).nextLine();
            HumanPlayer humanPlayer = new HumanPlayer(playerName);
            humanPlayer.setHumanPlayer(humanPlayer);
            System.out.println("Please enter player2 name");
            String player2Name = new Scanner(System.in).nextLine();
            HumanPlayer humanPlayer2 = new HumanPlayer(player2Name);
            humanPlayer2.setHumanPlayer2(humanPlayer2);
            System.out.println("Your opponent is: " + humanPlayer2.getPlayerName());
            pickType(humanPlayer, humanPlayer2);
            displayPoints(HumanPlayer.humanPlayer, HumanPlayer.humanPlayer2);
            playAgain(2);
        }

    }

    public void playAgain(int gameMode) {
        playerRestart = true;
        System.out.println();
        System.out.println("Press 1 to play again or 2 go back to the main menu.");
        Scanner scanner = new Scanner(System.in);
        int num = scanner.nextInt();
        if (num == 1) {
            int count = 3;
            try {
                System.out.println("Game Starting in: ");
                while (count > 0) {
                    System.out.println(count);
                    Thread.sleep(1000);
                    count--;
                }
                startNewGame(gameMode);
            } catch (InterruptedException e) {
                System.out.println(e.getMessage());
            }
        } else {
            playerRestart = false;
            new MainMenu().menu();
        }
    }

    public void displayPoints(Player playerOne, Player playerTwo) {
        System.out.println(playerOne.getPlayerName() + " " + playerOne.getPlayerPoints());
        System.out.println(playerTwo.getPlayerName() + " " + playerTwo.getPlayerPoints());
    }
}