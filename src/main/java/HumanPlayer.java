import java.util.Scanner;

public class HumanPlayer extends Player{

    static HumanPlayer humanPlayer;
    static HumanPlayer humanPlayer2;

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

    public void setHumanPlayer2(HumanPlayer humanPlayer2) {
        HumanPlayer.humanPlayer2 = humanPlayer2;
    }

    public HumanPlayer getHumanPlayer2() {
        return humanPlayer2;
    }

    public void setHumanPlayer(HumanPlayer humanPlayer) {
        HumanPlayer.humanPlayer = humanPlayer;
    }

    public HumanPlayer getHumanPlayer() {
        return humanPlayer;
    }
}
