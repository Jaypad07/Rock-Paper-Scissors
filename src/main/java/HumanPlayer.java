import java.util.Scanner;

public class HumanPlayer extends Player{

    static HumanPlayer humanPlayer; //These two fields belong the player class, and are not part of each created object.
                                    //they are used to hold a reference to a HumanPlayer object so this object can be called upon game restart.
    static HumanPlayer humanPlayer2;

    public HumanPlayer(String playerName) { //Constructor for the HumanPlayer class, this will pass the parameter of playerName to its parent to set.
        super(playerName);
    }

    /**
     * This method will be used to grab the players correct choice of Rock,Paper,or Scissors. A Scanner object to take in a number.
     * The number will be used to select the correct object in the RSP Array.
     * This will store the players choice in the playerPick variable and will also display to console what the player chose.
     * @return returns a String of Rock, Paper, or Scissors that the player chose.
     */
    @Override
    public String playerChoice() {
        Scanner scanner = new Scanner(System.in);
        String playerPick = getRspArr()[scanner.nextInt() - 1].getType();
        System.out.println(getPlayerName() + " chose " + playerPick);
        return playerPick;
    }

    /**
     *  This method will set the second HumanPlayer field to the passed reference.
     * @param humanPlayer2 this parameter will take in a reference to a HumanPlayer object and set the humanPlayer2 field to that value.
     */
    public void setHumanPlayer2(HumanPlayer humanPlayer2) {
        HumanPlayer.humanPlayer2 = humanPlayer2;
    }

    /**
     * A get method, this method will grab the reference stored inside the humanPlayer2 variable.
     * @return returns the reference stored inside the humanPlayer2 variable.
     */
    public HumanPlayer getHumanPlayer2() {
        return humanPlayer2;
    }

    /**
     * This method will set the HumanPlayer field to the passed reference.
     * @param humanPlayer this parameter will take in a reference to a HumanPlayer object and set the humanPlayer field to that value.
     */
    public void setHumanPlayer(HumanPlayer humanPlayer) {
        HumanPlayer.humanPlayer = humanPlayer;
    }

    /**
     * A get method, this method will grab the reference stored inside the humanPlayer2 variable.
     * @return will return the reference stored inside the humanPlayer variable.
     */
    public HumanPlayer getHumanPlayer() {
        return humanPlayer;
    }
}
