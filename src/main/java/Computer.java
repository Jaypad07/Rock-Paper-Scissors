public class Computer extends Player{
    //This array is used to store random robot names that the computer can use as names.
   private static String[] cpuNames = {"Skynet", "Ultron", "Agent Smith", "Megatron", "Cylon", "T-1000", "Terminator", "The Borg", "The Replicant"};
   private String compName; //Stores the computers name.
   static Computer computer; //Stores a reference to a computer object. This will be used to make sure that the object will remain the same.

    /**
     * This constructor allows a computer object to generate a name upon creation. When a computer object is created a random number will be generated within the range of the CpuNames
     * array. This random number will then be used to access an index and assign its value to the computer object.
     */
    public Computer() {
        int randomNum = (int) (Math.floor(Math.random() * cpuNames.length));
        this.compName = cpuNames[randomNum];
        setPlayerName(compName);
    }

    /**
     * This method will generate a choice of Rock, Paper, or Scissors for the computer. The RSP array will be called using its get method, and a random number will be generated
     * to access an index inside the RSP array this will be used to grab the element at the index.
     * The element will be stored in the compPick variable and displayed in the console as the chosen element.
     * returns a String of Rock, Paper, or Scissors that was randomly selected.
     * @return
     */
    @Override
    public String playerChoice() {
        String compPick = getRspArr()[(int) (Math.floor(Math.random() * 3))].getType(); //Picks Rock, Paper, or Scissors for computer
        System.out.println(getCompName() + " chose " + compPick);
        System.out.println();
        return compPick;
    }

    /**
     * A get method, this will grab the computer name from the compName variable.
     * @return String
     */
    public String getCompName() {
        return compName;
    }

    /**
     * A get method, this will grab the reference stored inside the computer variable.
     * @return Computer object.
     */
    public Computer getComputer() {
        return computer;
    }

    /**
     * A set method, this will take in a computer reference and store it inside the Computer class variable named computer.
     * @param computer takes in a reference to a Computer class object
     */
    public void setComputer(Computer computer) {
        Computer.computer = computer;
    }

    /**
     * A set method, this will allow the computers name to be changed when used.
     * @param cpuName Stores the String passed as the computer name.
     */
    public void setCpuName(String cpuName) {
        this.compName = cpuName;
    }
}
