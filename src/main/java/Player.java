import java.util.Scanner;

public abstract class Player {
    private String playerName;
//    private int playerNum;


    public Player(String playerName) {
        this.playerName = playerName;
//        this.playerNum = playerNum;
    }


    public String getPlayerName() {
        return playerName;
    }

    public void setPlayerName(String playerName) {
        this.playerName = playerName;
    }

    @Override
    public String toString() {
        return "Player{" +
                "playerName='" + playerName + '\'' +
                '}';
    }

    //    public int getPlayerNum() {
//        return playerNum;
//    }
//
//    public void setPlayerNum(int playerNum) {
//        this.playerNum = playerNum;
//    }
}
