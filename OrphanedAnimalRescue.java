package rescue;

/**
 OrphanedAnimalRescue represents a rescue case for an orphaned animal.
 It extends RescueCase and adds orphan-specific information.
  
 Assumption: Total cost = feeding cost + (rescue days × daily care cost)
 + R2000 if foster care is required.
  
 Patrick Tshiluwa Kamunga
 studentNumber ST10497579
 */
public class OrphanedAnimalRescue extends RescueCase {
    
    // Additional fields specific to orphaned animals
    private int estimatedAgeMonths;
    private double feedingCost;
    private boolean fosterCareRequired;
    
    // Constructor
    public OrphanedAnimalRescue(String rescueCaseID, String animalName, String species,
                                String rescueLocation, String assignedRanger,
                                int numberOfRescueDays, double dailyCareCost,
                                int estimatedAgeMonths, double feedingCost,
                                boolean fosterCareRequired) {
        // Call the parent constructor
        super(rescueCaseID, animalName, species, rescueLocation,
              assignedRanger, numberOfRescueDays, dailyCareCost);
        
        this.estimatedAgeMonths = estimatedAgeMonths;
        this.feedingCost = feedingCost;
        this.fosterCareRequired = fosterCareRequired;
    }
    
    /*
      Calculates total rescue cost for an orphaned animal.
      Base cost = feeding cost + (days × daily care cost)
      If foster care is required, add R2000.
     */
    @Override
    public double calculateTotalCost() {
        double total = feedingCost + (getNumberOfRescueDays() * getDailyCareCost());
        if (fosterCareRequired) {
            total += 2000;
        }
        return total;
    }
    
    /**
     * Determines rescue priority.
     * Younger animals with foster care needs = higher priority.
     */
    @Override
    public String determinePriority() {
        if (estimatedAgeMonths < 6 && fosterCareRequired) {
            return "High";
        } else if (fosterCareRequired || estimatedAgeMonths < 12) {
            return "Medium";
        } else {
            return "Low";
        }
    }
    
    /*
      Displays orphan-specific information.
     */
    @Override
    public void displayTypeSpecificInfo() {
        System.out.println("--- Orphan Details ---");
        System.out.println("Estimated Age: " + estimatedAgeMonths + " months");
        System.out.println("Feeding Cost: R" + feedingCost);
        System.out.println("Foster Care Required: " + (fosterCareRequired ? "Yes" : "No"));
    }
    
    // Getters and setters
    public int getEstimatedAgeMonths() { return estimatedAgeMonths; }
    public void setEstimatedAgeMonths(int estimatedAgeMonths) { 
        this.estimatedAgeMonths = estimatedAgeMonths; 
    }
    
    public double getFeedingCost() { return feedingCost; }
    public void setFeedingCost(double feedingCost) { 
        this.feedingCost = feedingCost; 
    }
    
    public boolean isFosterCareRequired() { return fosterCareRequired; }
    public void setFosterCareRequired(boolean fosterCareRequired) { 
        this.fosterCareRequired = fosterCareRequired; 
    }
}
