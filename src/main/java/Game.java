import java.util.Scanner;

public class Game {

    public Game() {
    }



    public static void startNewGame(int gameMode) {
        System.out.println("Please enter player name");
        Scanner scanner = new Scanner(System.in);
        String playerName = scanner.nextLine();
        HumanPlayer humanPlayer = new HumanPlayer(playerName);
        Computer cpu = new Computer(Computer.createCpuName());
        //if statement that chooses cpu or other player?
        if (gameMode == 1) {
            System.out.println("Your Cpu opponent is: " + cpu.getCpuName());
            pickType(humanPlayer, cpu);
        }
    }


    // change all occurrences of cpu to AI? or comp
    public static void pickType(HumanPlayer humanPlayer, Computer cpu) {
        RPS[] rspArr = new RPS[]{new RPS("Rock"), new RPS("Paper"),new RPS("Scissors")};
        System.out.println("Choose: \n 1. Rock \n 2. Paper \n 3. Scissors");
        Scanner scanner = new Scanner(System.in);
        String playerPick = rspArr[scanner.nextInt() - 1].getType();
        System.out.println(humanPlayer.getPlayerName() + " chose " + playerPick);
        String compPick = rspArr[(int) (Math.floor(Math.random() * 3))].getType(); //Picks Rock, Paper, or Scissors for computer
        System.out.println(cpu.getCpuName() + " chose " + compPick);
        if (playerPick.equals(compPick)) {
            System.out.println("Draw!");
        }else switch (playerPick) { // How did they do the multiple vowels?
            case "Rock" : if (compPick.equals("Scissors")) {
                System.out.println(humanPlayer.getPlayerName() + " Wins!");
            }else System.out.println(cpu.getCpuName() + " Wins!");
                break;
            case "Paper" : if (compPick.equals("Rock")) {
                System.out.println(humanPlayer.getPlayerName() + " Wins!");
            }else System.out.println(cpu.getCpuName() + " Wins!");
                break;
            case "Scissors" : if (compPick.equals("Paper")) {
                System.out.println(humanPlayer.getPlayerName() + " Wins!");
            }else System.out.println(cpu.getCpuName() + " Wins!");
                break;
        }
    }
}
