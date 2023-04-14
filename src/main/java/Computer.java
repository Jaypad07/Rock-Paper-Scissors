public class Computer extends Player{
   private static String[] cpuNames = {"Skynet", "Ultron", "Agent Smith", "Megatron", "Cylon", "T-1000", "Terminator", "The Borg", "The Replicant"};
   private String compName;
   static Computer computer;

    public Computer() {
        int randomNum = (int) (Math.floor(Math.random() * cpuNames.length));
        this.compName = cpuNames[randomNum];
        setPlayerName(compName);
    }
    @Override
    public String playerChoice() {
        String compPick = getRspArr()[(int) (Math.floor(Math.random() * 3))].getType(); //Picks Rock, Paper, or Scissors for computer
        System.out.println(getCompName() + " chose " + compPick);
        System.out.println();
        return compPick;
    }

    public String getCompName() {
        return compName;
    }

    public Computer getComputer() {
        return computer;
    }

    public void setComputer(Computer computer) {
        this.computer = computer;
    }

    public void setCpuName(String cpuName) {
        this.compName = cpuName;
    }
}
