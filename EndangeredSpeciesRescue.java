package rescue;

/*
 EndangeredSpeciesRescue represents a rescue case for an endangered species.
 It extends RescueCase and adds conservation-specific information.
  
 Total cost = security cost + (rescue days × daily care cost)
 + R8000 if a specialist team is required.
  
 Patrick Tshiluwa Kamunga
 studentNumber ST10497579
 */
public class EndangeredSpeciesRescue extends RescueCase {
    
    // Additional fields specific to endangered species
    private String conservationClassification;
    private double securityCost;
    private boolean specialistTeamRequired;
    
    // Constructor
    public EndangeredSpeciesRescue(String rescueCaseID, String animalName, String species,
                                   String rescueLocation, String assignedRanger,
                                   int numberOfRescueDays, double dailyCareCost,
                                   String conservationClassification, double securityCost,
                                   boolean specialistTeamRequired) {
        // Call the parent constructor
        super(rescueCaseID, animalName, species, rescueLocation,
              assignedRanger, numberOfRescueDays, dailyCareCost);
        
        this.conservationClassification = conservationClassification;
        this.securityCost = securityCost;
        this.specialistTeamRequired = specialistTeamRequired;
    }
    
    /*
     Calculates total rescue cost for an endangered species.
     Base cost = security cost + (days × daily care cost)
     If specialist team required, add R8000.
     */
    @Override
    public double calculateTotalCost() {
        double total = securityCost + (getNumberOfRescueDays() * getDailyCareCost());
        if (specialistTeamRequired) {
            total += 8000;
        }
        return total;
    }
    
    /*
      Determines rescue priority based on conservation status.
     */
    @Override
    public String determinePriority() {
        if (specialistTeamRequired || 
            conservationClassification.equalsIgnoreCase("Critically Endangered")) {
            return "High";
        } else if (conservationClassification.equalsIgnoreCase("Endangered")) {
            return "Medium";
        } else {
            return "Low";
        }
    }
    
    /*
      Displays endangered-species-specific information.
     */
    @Override
    public void displayTypeSpecificInfo() {
        System.out.println("--- Conservation Details ---");
        System.out.println("Conservation Classification: " + conservationClassification);
        System.out.println("Security Cost: R" + securityCost);
        System.out.println("Specialist Team Required: " + (specialistTeamRequired ? "Yes" : "No"));
    }
    
    // Getters and setters
    public String getConservationClassification() { return conservationClassification; }
    public void setConservationClassification(String conservationClassification) { 
        this.conservationClassification = conservationClassification; 
    }
    
    public double getSecurityCost() { return securityCost; }
    public void setSecurityCost(double securityCost) { 
        this.securityCost = securityCost; 
    }
    
    public boolean isSpecialistTeamRequired() { return specialistTeamRequired; }
    public void setSpecialistTeamRequired(boolean specialistTeamRequired) { 
        this.specialistTeamRequired = specialistTeamRequired; 
    }
}