import java.util.Scanner;

public class HumanPlayer extends Player{

    public HumanPlayer(String playerName) {
        super(playerName);
    }

    @Override
    public String playerChoice() {
        Scanner scanner = new Scanner(System.in);
        String playerPick = getRspArr()[scanner.nextInt() - 1].getType();
        System.out.println(getPlayerName() + " chose " + playerPick);
        return playerPick;
    }


}
