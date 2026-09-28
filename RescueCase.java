package rescue;

/**
 RescueCase is an abstract base class representing a general wildlife rescue case.
 All specific rescue types (Injured, Orphaned, Endangered) extend this class.
 * 
 Patrick Tshiluwa Kamunga
 studentNumber ST10497579
 */
public abstract class RescueCase implements RescueOperations {
    
    // Fields (encapsulation)
    private String rescueCaseID;
    private String animalName;
    private String species;
    private String rescueLocation;
    private String assignedRanger;
    private int numberOfRescueDays;
    private double dailyCareCost;
    private String rescueStatus;
    
    // Constructor
    public RescueCase(String rescueCaseID, String animalName, String species,
                      String rescueLocation, String assignedRanger,
                      int numberOfRescueDays, double dailyCareCost) {
        this.rescueCaseID = rescueCaseID;
        this.animalName = animalName;
        this.species = species;
        this.rescueLocation = rescueLocation;
        this.assignedRanger = assignedRanger;
        this.numberOfRescueDays = numberOfRescueDays;
        this.dailyCareCost = dailyCareCost;
        this.rescueStatus = "Pending";
    }
    
    // Abstract methods — subclasses must implement
    public abstract double calculateTotalCost();
    public abstract String determinePriority();
    public abstract void displayTypeSpecificInfo();
    
    // Concrete methods (shared)
    @Override
    public void startRescue() {
        this.rescueStatus = "In Progress";
    }
    
    @Override
    public void completeRescue() {
        this.rescueStatus = "Completed";
    }
    
    @Override
    public void generateSummary() {
        System.out.println("\n--- Rescue Summary ---");
        System.out.println("Rescue Case ID: " + rescueCaseID);
        System.out.println("Rescue Type: " + this.getClass().getSimpleName());
        System.out.println("Species: " + species);
        System.out.println("Assigned Ranger: " + assignedRanger);
        System.out.println("Rescue Priority: " + determinePriority());
        System.out.println("Current Status: " + rescueStatus);
        System.out.println("Total Rescue Cost: R" + calculateTotalCost());
    }
    
    public void displayDetails() {
        System.out.println("Rescue Case ID: " + rescueCaseID);
        System.out.println("Animal Name: " + animalName);
        System.out.println("Species: " + species);
        System.out.println("Rescue Location: " + rescueLocation);
        System.out.println("Assigned Ranger: " + assignedRanger);
        System.out.println("Number of Rescue Days: " + numberOfRescueDays);
        System.out.println("Daily Care Cost: R" + dailyCareCost);
        System.out.println("Rescue Priority: " + determinePriority());
        System.out.println("Current Status: " + rescueStatus);
        System.out.println("Total Rescue Cost: R" + calculateTotalCost());
        displayTypeSpecificInfo();
    }
    
    // Getters
    public String getRescueCaseID() { return rescueCaseID; }
    public String getAnimalName() { return animalName; }
    public String getSpecies() { return species; }
    public String getRescueLocation() { return rescueLocation; }
    public String getAssignedRanger() { return assignedRanger; }
    public int getNumberOfRescueDays() { return numberOfRescueDays; }
    public double getDailyCareCost() { return dailyCareCost; }
    public String getRescueStatus() { return rescueStatus; }
    
    // Setters
    public void setAnimalName(String animalName) { this.animalName = animalName; }
    public void setSpecies(String species) { this.species = species; }
    public void setRescueLocation(String rescueLocation) { this.rescueLocation = rescueLocation; }
    public void setAssignedRanger(String assignedRanger) { this.assignedRanger = assignedRanger; }
    public void setNumberOfRescueDays(int numberOfRescueDays) { this.numberOfRescueDays = numberOfRescueDays; }
    public void setDailyCareCost(double dailyCareCost) { this.dailyCareCost = dailyCareCost; }
    public void setRescueStatus(String rescueStatus) { this.rescueStatus = rescueStatus; }
}
