import java.util.Scanner;

public abstract class Player {
    private String playerName;
    private RPS[] rspArr = new RPS[]{new RPS("Rock"), new RPS("Paper"),new RPS("Scissors")}; //An array of objects to be used for selecting each player pick.
    private int playerPoints;
    public Player() {
    }

    public Player(String playerName) { //This allows player objects to store a name as well as their points.
        this.playerName = playerName;
        this.playerPoints = 0;
    }

    /**
     * This abstract method forces the children of this class to implement this method in their own unique way.
     * This playerChoice will be the players choice of Rock,Paper,or Scissors.
     * @return will be used to return a String.
     */
    public abstract String playerChoice();

    /**
     * This gets the players name from the PlayerName field.
     * @return playerName.
     */
    public String getPlayerName() {
        return playerName;
    }

    /**
     * A set method, this will set the player name when called.
     * @param playerName will take in a String and set the playerName field to this String.
     */
    public void setPlayerName(String playerName) {
        this.playerName = playerName;
    }

    /**
     * A get method, this method will grab the RSP array for use outside the class.
     * @return the rsp array.
     */
    public RPS[] getRspArr() {
        return rspArr;
    }

    /**
     *  A get method, this method will grab the value stored in the playerPoints variable.
     * @return This will return the points stored in the data field, playerPoints.
     */
    public int getPlayerPoints() {
        return playerPoints;
    }

    /**
     * A set method, this method will accumulate points to the playerPoints variable.
     * @param playerPoints this parameter will take in a number to accumulate into the playerPoints variable.
     */
    public void setPlayerPoints(int playerPoints) {
        this.playerPoints += playerPoints;
    }

    /**
     * This toString method will Override the original toString method to display the player object with its instance name.
     * @return returns a String formatted to display the instance name, this name will be displayed inside a bracket showing it is an object.
     */
    @Override
    public String toString() {
        return "Player{" +
                "playerName='" + playerName + '\'' +
                '}';
    }
}
