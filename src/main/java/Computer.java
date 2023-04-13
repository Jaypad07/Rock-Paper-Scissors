public class Computer extends Player{
   private static String[] cpuNames = {"Skynet", "Ultron", "Agent Smith", "Megatron", "Cylon", "T-1000", "Terminator", "The Borg", "The Replicant"};
private String cpuName;

    public Computer(String name) {
        super(name);
        this.cpuName = Computer.createCpuName();
    }

    public String getCpuName() {
        return cpuName;
    }

    public void setCpuName(String cpuName) {
        this.cpuName = cpuName;
    }

    public static String createCpuName() {
        int randomNum = (int) (Math.floor(Math.random() * cpuNames.length));
        return cpuNames[randomNum];
    }
}
