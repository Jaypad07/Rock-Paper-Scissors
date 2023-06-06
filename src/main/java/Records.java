import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;

/**

 The Records class is responsible for recording game results and displaying them.
 */
public class Records {

    /**

     Records a win in the game.
     @param playerOne The first player.
     @param playerTwo The second player.
     @param playerPick The choice of the first player.
     @param playerTwoPick The choice of the second player.
     */
    public void recordWin(Player playerOne, Player playerTwo, String playerPick, String playerTwoPick) {
        try(FileWriter fileWriter = new FileWriter("records.txt", true)) {
            System.out.println(playerOne.getPlayerName() + " Wins!");
            fileWriter.write("WIN: " + playerOne.getPlayerName() + " chose " + playerPick + ", " + playerTwo.getPlayerName() + " chose " + playerTwoPick + "\n");
        }catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }
    /**

     Records a loss in the game.
     @param playerOne The first player.
     @param playerTwo The second player.
     @param playerPick The choice of the first player.
     @param playerTwoPick The choice of the second player.
     */
    public void recordLoss(Player playerOne, Player playerTwo, String playerPick, String playerTwoPick) {
        try(FileWriter fileWriter = new FileWriter("records.txt", true)) {
            System.out.println(playerOne.getPlayerName() + " Lost!");
            fileWriter.write("LOSS: " + playerOne.getPlayerName() + " chose " + playerPick + ", " + playerTwo.getPlayerName() + " chose " + playerTwoPick + "\n");
        }catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }
    /**

     Records a draw in the game.
     @param playerOne The first player.
     @param playerTwo The second player.
     @param playerPick The choice of the first player.
     @param playerTwoPick The choice of the second player.
     */
    public void recordDraw(Player playerOne, Player playerTwo, String playerPick, String playerTwoPick) {
        try(BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter("records.txt", true))) {
            System.out.println(playerOne.getPlayerName() + " Draw!");
            bufferedWriter.write("DRAW: " + playerOne.getPlayerName() + " chose " + playerPick + ", " + playerTwo.getPlayerName() + " chose " + playerTwoPick + "\n");
        }catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }
    /**

     Displays the recorded game results.
     */
    public void displayRecords() {
        try(BufferedReader bufferedReader = new BufferedReader(new FileReader("records.txt"))) {
            while (bufferedReader.ready()) {
                String currentLine = bufferedReader.readLine();
                System.out.println(currentLine);
            }
            Thread.sleep(5000);
        }catch (Exception e) {
            System.out.println(e.getMessage());
        }

        new MainMenu().menu();
    }
}




