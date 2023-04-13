public class Computer extends Player{
   private static String[] cpuNames = {"Skynet", "Ultron", "Agent Smith", "Megatron", "Cylon", "T-1000", "Terminator", "The Borg", "The Replicant"};
   private String compName;

    public Computer() {
        int randomNum = (int) (Math.floor(Math.random() * cpuNames.length));
        this.compName = cpuNames[randomNum];
        setPlayerName(compName);
    }
    @Override
    public String playerChoice() {
        String compPick = getRspArr()[(int) (Math.floor(Math.random() * 3))].getType(); //Picks Rock, Paper, or Scissors for computer
        System.out.println(getCompName() + " chose " + compPick);
        return compPick;
    }

    public String getCompName() {
        return compName;
    }

    public void setCpuName(String cpuName) {
        this.compName = cpuName;
    }


}
