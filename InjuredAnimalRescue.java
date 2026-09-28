package rescue;

/**
 * InjuredAnimalRescue represents a rescue case for an injured animal.
 * It extends RescueCase and adds injury-specific information.
 * 
 * Total cost = vet treatment cost + (rescue days × daily care cost)
 * + R5000 if surgery is required.
 * 
 * @author Patrick Tshiluwa Kamunga
 * @studentNumber ST10497579
 */
public class InjuredAnimalRescue extends RescueCase {
    
    // Additional fields specific to injured animals
    private String injuryDescription;
    private double veterinaryTreatmentCost;
    private boolean surgeryRequired;
    
    // Constructor
    public InjuredAnimalRescue(String rescueCaseID, String animalName, String species,
                               String rescueLocation, String assignedRanger,
                               int numberOfRescueDays, double dailyCareCost,
                               String injuryDescription, double veterinaryTreatmentCost,
                               boolean surgeryRequired) {
        // Call the parent (RescueCase) constructor using super()
        super(rescueCaseID, animalName, species, rescueLocation,
              assignedRanger, numberOfRescueDays, dailyCareCost);
        
        this.injuryDescription = injuryDescription;
        this.veterinaryTreatmentCost = veterinaryTreatmentCost;
        this.surgeryRequired = surgeryRequired;
    }
    
    /**
     * Calculates total rescue cost for an injured animal.
     * Base cost = vet treatment + (days × daily care cost)
     * If surgery is required, add R5000.
     */
    @Override
    public double calculateTotalCost() {
        double total = veterinaryTreatmentCost + (getNumberOfRescueDays() * getDailyCareCost());
        if (surgeryRequired) {
            total += 5000;
        }
        return total;
    }
    
    /**
     * Determines rescue priority based on injury severity.
     */
    @Override
    public String determinePriority() {
        if (surgeryRequired) {
            return "High";
        } else if (veterinaryTreatmentCost > 3000) {
            return "Medium";
        } else {
            return "Low";
        }
    }
    
    /**
     * Displays injury-specific information.
     */
    @Override
    public void displayTypeSpecificInfo() {
        System.out.println("--- Injury Details ---");
        System.out.println("Injury Description: " + injuryDescription);
        System.out.println("Veterinary Treatment Cost: R" + veterinaryTreatmentCost);
        System.out.println("Surgery Required: " + (surgeryRequired ? "Yes" : "No"));
    }
    
    // Getters and setters
    public String getInjuryDescription() { return injuryDescription; }
    public void setInjuryDescription(String injuryDescription) { 
        this.injuryDescription = injuryDescription; 
    }
    
    public double getVeterinaryTreatmentCost() { return veterinaryTreatmentCost; }
    public void setVeterinaryTreatmentCost(double veterinaryTreatmentCost) { 
        this.veterinaryTreatmentCost = veterinaryTreatmentCost; 
    }
    
    public boolean isSurgeryRequired() { return surgeryRequired; }
    public void setSurgeryRequired(boolean surgeryRequired) { 
        this.surgeryRequired = surgeryRequired; 
    }
}