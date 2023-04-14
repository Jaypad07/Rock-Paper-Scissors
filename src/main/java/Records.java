import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;

public class Records {
    public void recordWin(Player playerOne, Player playerTwo, String playerPick, String playerTwoPick)  {
        try(FileWriter fileWriter = new FileWriter("records.txt", true)) {
            System.out.println(playerOne.getPlayerName() + " Wins!");
            fileWriter.write("WIN: " + playerOne.getPlayerName() +  " chose " + playerPick + ", " + playerTwo.getPlayerName() + " chose " + playerTwoPick + "\n");
        }catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }

    public void recordLoss(Player playerOne, Player playerTwo, String playerPick, String playerTwoPick)  {
        try(FileWriter fileWriter = new FileWriter("records.txt", true)) {
            System.out.println(playerOne.getPlayerName() + " Lost!");
            fileWriter.write("LOSS: " + playerOne.getPlayerName() +  " chose " + playerPick + ", " + playerTwo.getPlayerName() + " chose " + playerTwoPick + "\n");
        }catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }

    public void recordDraw(Player playerOne, Player playerTwo, String playerPick, String playerTwoPick)  {
        try(BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter("records.txt", true))) {
            System.out.println(playerOne.getPlayerName() + " Draw!");
            bufferedWriter.write("DRAW: " + playerOne.getPlayerName() +  " chose " + playerPick + ", " + playerTwo.getPlayerName() + " chose " + playerTwoPick + "\n");
        }catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }

    public void displayRecords() {
        try(BufferedReader bufferedReader = new BufferedReader(new FileReader("records.txt"))) {
            while (bufferedReader.ready()) {
                String currentLine = bufferedReader.readLine();
                System.out.println(currentLine);
            }
        }catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }
}