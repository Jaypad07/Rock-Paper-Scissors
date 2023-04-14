import java.util.Scanner;

public abstract class Player {
    private String playerName;
    private RPS[] rspArr = new RPS[]{new RPS("Rock"), new RPS("Paper"),new RPS("Scissors")};

    private int playerPoints;
    public Player() {
    }

    public Player(String playerName) {
        this.playerName = playerName;
        this.playerPoints = 0;
    }

    public abstract String playerChoice();

    public String getPlayerName() {
        return playerName;
    }

    public void setPlayerName(String playerName) {
        this.playerName = playerName;
    }

    public RPS[] getRspArr() {
        return rspArr;
    }

    public void setRspArr(RPS[] rspArr) {
        this.rspArr = rspArr;
    }

    public int getPlayerPoints() {
        return playerPoints;
    }

    public void setPlayerPoints(int playerPoints) {
        this.playerPoints += playerPoints;
    }

    @Override
    public String toString() {
        return "Player{" +
                "playerName='" + playerName + '\'' +
                '}';
    }
}
