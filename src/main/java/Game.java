import java.util.InputMismatchException;
import java.util.Scanner;

public class Game {
    private final Records record = new Records(); //An instance of the records class.
    private boolean playerRestart; //Boolean used to determine if a restart should be executed.


    /**
     * This method works in conjunction with the mainMenu method. It is used to select the correct method according to userInput.
     * @param gameMode An integer from the mainMenu is passed as an argument and used to determine the
     * correct game mode.
     * @throws InputMismatchException will be thrown if the user enters the wrong input. The exception will be thrown to the mainMenu and caught there.
     */
    public void startNewGame(int gameMode) throws InputMismatchException {

        switch (gameMode) {
            case 1 -> playerVsComputer(); //Starts game vs Computer
            case 2 -> playerVsPlayer(); //Starts TwoPlayer game
            case 3 -> record.displayRecords(); //Brings up records screen - This will read from file and display past records
            case 4 -> {
                System.out.println("You have exited the game.");
                System.exit(0); // Terminates program with a "You have exited the game" message
            }
            default -> {
                System.out.println("Please select a valid number, select a number 1-4");
                MainMenu.restartCount();
            }
        }
    }

    /**
     * This Method is the main game logic. It used to compare the types selected by the players and determine a winner.
     * Assisting methods: recordWin,Losses,and Draws are called fromm the Records class to record Wins, Losses, and Ties.
     * Assisting method: SetPlayerPoints is called to assign points to the winner.
     * @param playerOne Player reference is passed to be used in obtaining playerName, pick, and assigned game winning points.
     * @param playerTwo Player2 reference is passed to be used in obtaining playerName, pick, and assigned game winning points. Reference can be a HumanPlayer or Computer.
     */
    public void compareType(Player playerOne, Player playerTwo) {

        System.out.println(playerOne.getPlayerName() + " Choose: \n 1. Rock \n 2. Paper \n 3. Scissors");
        String playerPick = playerOne.playerChoice(); //Calls playerChoice method for PlayerOne and store result in the playerPick.

        if (!(playerTwo instanceof Computer)) { //If playerTwo is not a computer print out this message.
            System.out.println(playerTwo.getPlayerName() + " Choose: \n 1. Rock \n 2. Paper \n 3. Scissors");
        }
        String player2Pick = playerTwo.playerChoice(); //Calls playerChoice method on PlayerTwo and stores result in the playerPick.

        if (playerPick.equals(player2Pick)) {
            record.recordDraw(playerOne, playerTwo, playerPick, player2Pick); //Records draws to txtFile.
        }else switch (playerPick) {
            case "Rock" : if (player2Pick.equals("Scissors")) {
                playerOne.setPlayerPoints(1);
                record.recordWin(playerOne, playerTwo, playerPick, player2Pick); //Records wins to txtFile.
            }else {
                playerTwo.setPlayerPoints(1);
                record.recordLoss(playerOne, playerTwo, playerPick, player2Pick); //Records loss to txtFile.
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

    /**
     * This method creates the player object and a computer object. It will pass the player and computer reference to their respective classes
     * to be held in a static field variable. If the player decides to restart game, the same reference/object will be used again.
     * Assisting Method: compareType
     * Assisting Method: displayPoints, used to display each player's points.
     * Assisting Method: playAgain, allows the user to select play again option. This will keep their points and names current. The parameter
     * passed is a 1 to correctly select gameMode '1' for Player Vs Cpu.
     */
    public void playerVsComputer() {
        if (playerRestart) {
            System.out.println("Your Cpu opponent is: " + Computer.computer.getCompName());
            compareType(HumanPlayer.humanPlayer.getHumanPlayer(), Computer.computer);
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
            compareType(humanPlayer, computer);
            displayPoints(HumanPlayer.humanPlayer, computer);
            playAgain(1);
        }
    }

    /**
     * This method is used to create a second human player. Two Human player objects are created and their names
     * are set using the scanner object. This method will also pass the playerOne and playerTwo reference to their respective classes
     * to be held in a static field variable. If the player decides to restart game, the same reference/object will be used again.
     * Assisting Method: compareType
     * Assisting Method: displayPoints, used to display each player's points.
     * Assisting Method: playAgain, allows the user to select play again option. This will keep their points and names current. The parameter
     * passed is a 2 to correctly select gameMode '2' for Player Vs Player.
     */
    public void playerVsPlayer(){
        if (playerRestart) {
            compareType(HumanPlayer.humanPlayer.getHumanPlayer(), HumanPlayer.humanPlayer2.getHumanPlayer2());
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
            compareType(humanPlayer, humanPlayer2);
        }
        displayPoints(HumanPlayer.humanPlayer, HumanPlayer.humanPlayer2);
        playAgain(2);
    }

    /**
     * 
     * @param gameMode
     */
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
        System.out.println(playerOne.getPlayerName() + ": " + playerOne.getPlayerPoints());
        System.out.println(playerTwo.getPlayerName() + ": " + playerTwo.getPlayerPoints());
    }
}