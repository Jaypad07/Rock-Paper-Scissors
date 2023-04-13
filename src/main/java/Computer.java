public class Computer {
   private static String[] cpuNames = {"Skynet", "Ultron", "Sentinels", "Megatron", "The Cylons", "T-1000", "Terminator", "The Borg", "The Replicants"};
private String cpuName;

    public Computer(String cpuName) {
        this.cpuName = cpuName;
    }

    public String getCpuName() {
        return cpuName;
    }

    public void setCpuName(String cpuName) {
        this.cpuName = cpuName;
    }

    public static Computer createCpu() {

        int randomNum = (int) (Math.floor(Math.random() * 9));
        return new Computer(cpuNames[randomNum]);
    }
}
