package rescue;

import java.util.ArrayList;

/*
 RescueManager handles all rescue case operations.
 It stores rescue cases in an ArrayList and provides methods for
 adding, searching, updating, displaying, and reporting.
  
 This class demonstrates polymorphism because it stores all
 rescue types (Injured, Orphaned, Endangered) in one list.
  
 Patrick Tshiluwa Kamunga
 studentNumber ST10497579
 */
public class RescueManager {
    
    // ArrayList stores all rescue cases (polymorphism)
    private ArrayList<RescueCase> rescueCases = new ArrayList<>();
    
    // Constructor
    public RescueManager() {
        // Nothing needed here
    }
    
    /*
     Adds a new rescue case.
     Returns false if the Rescue Case ID already exists.
     */
    public boolean addRescueCase(RescueCase rescueCase) {
        for (RescueCase rc : rescueCases) {
            if (rc.getRescueCaseID().equals(rescueCase.getRescueCaseID())) {
                return false; // Duplicate ID
            }
        }
        rescueCases.add(rescueCase);
        return true;
    }
    
    /*
     Searches for a rescue case by ID.
     Returns null if not found.
     */
    public RescueCase searchRescueCase(String rescueCaseID) {
        for (RescueCase rc : rescueCases) {
            if (rc.getRescueCaseID().equals(rescueCaseID)) {
                return rc;
            }
        }
        return null;
    }
    
    /*
     Updates the rescue status of an existing case.
     */
    public boolean updateRescueStatus(String rescueCaseID, String newStatus) {
        RescueCase rc = searchRescueCase(rescueCaseID);
        if (rc == null) {
            return false;
        }
        rc.setRescueStatus(newStatus);
        return true;
    }
    
    /*
     Displays all rescue cases.
     */
    public void displayAllRescueCases() {
        if (rescueCases.isEmpty()) {
            System.out.println("No rescue cases recorded.");
            return;
        }
        System.out.println("\n=== ALL RESCUE CASES ===");
        for (RescueCase rc : rescueCases) {
            rc.displayDetails();
            System.out.println("-----------------------------");
        }
    }
    
    /*
     Generates a full rescue report with totals.
     */
    public void generateReport() {
        if (rescueCases.isEmpty()) {
            System.out.println("No rescue cases to report.");
            return;
        }
        
        double totalCost = 0;
        
        System.out.println("\n========== WILDLIFE RESCUE REPORT ==========");
        for (RescueCase rc : rescueCases) {
            System.out.println("Rescue Case ID: " + rc.getRescueCaseID());
            System.out.println("Rescue Type: " + rc.getClass().getSimpleName());
            System.out.println("Species: " + rc.getSpecies());
            System.out.println("Rescue Location: " + rc.getRescueLocation());
            System.out.println("Assigned Ranger: " + rc.getAssignedRanger());
            System.out.println("Rescue Priority: " + rc.determinePriority());
            System.out.println("Current Status: " + rc.getRescueStatus());
            System.out.println("Total Rescue Cost: R" + rc.calculateTotalCost());
            System.out.println("-----------------------------");
            
            totalCost += rc.calculateTotalCost();
        }
        
        System.out.println("Total number of rescue cases: " + rescueCases.size());
        System.out.println("Total estimated rescue cost: R" + totalCost);
        System.out.println("=============================================");
    }
    
    /*
     Starts a rescue operation for a specific case.
     */
    public boolean startRescue(String rescueCaseID) {
        RescueCase rc = searchRescueCase(rescueCaseID);
        if (rc == null) {
            return false;
        }
        rc.startRescue();
        return true;
    }
    
    /*
      Completes a rescue operation for a specific case.
     */
    public boolean completeRescue(String rescueCaseID) {
        RescueCase rc = searchRescueCase(rescueCaseID);
        if (rc == null) {
            return false;
        }
        rc.completeRescue();
        return true;
    }
    
    // Getter for all rescue cases
    public ArrayList<RescueCase> getAllRescueCases() {
        return rescueCases;
    }
}
