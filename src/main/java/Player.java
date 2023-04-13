import java.util.Scanner;

public abstract class Player {
    private String playerName;
    private RPS[] rspArr = new RPS[]{new RPS("Rock"), new RPS("Paper"),new RPS("Scissors")};

    public Player() {
    }

    public Player(String playerName) {
        this.playerName = playerName;
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

    @Override
    public String toString() {
        return "Player{" +
                "playerName='" + playerName + '\'' +
                '}';
    }
}
