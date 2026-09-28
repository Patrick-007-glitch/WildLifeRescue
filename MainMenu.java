package rescue;

import java.util.Scanner;

/**
 MainMenu provides the console-based user interface for the
 Wildlife Rescue Operations System.
  
 Patrick Tshiluwa Kamunga
 studentNumber ST10497579
 */
public class MainMenu {
    
    private static RescueManager manager = new RescueManager();
    private static Scanner scanner = new Scanner(System.in);
    
    public static void main(String[] args) {
        System.out.println("=========================================");
        System.out.println("  WILDLIFE RESCUE OPERATIONS SYSTEM      ");
        System.out.println("=========================================");
        
        while (true) {
            System.out.println("\n--- MAIN MENU ---");
            System.out.println("1. Create Rescue Case");
            System.out.println("2. Search Rescue Case");
            System.out.println("3. Update Rescue Status");
            System.out.println("4. Display All Rescue Cases");
            System.out.println("5. Rescue Report");
            System.out.println("6. Start Rescue Operation");
            System.out.println("7. Complete Rescue Operation");
            System.out.println("8. Exit");
            System.out.print("Select an option: ");
            
            int choice = scanner.nextInt();
            scanner.nextLine(); // clear buffer
            
            switch (choice) {
                case 1: createRescueCase(); break;
                case 2: searchRescueCase(); break;
                case 3: updateRescueStatus(); break;
                case 4: manager.displayAllRescueCases(); break;
                case 5: manager.generateReport(); break;
                case 6: startRescueOperation(); break;
                case 7: completeRescueOperation(); break;
                case 8:
                    System.out.println("Thank you for using the Wildlife Rescue Operations System.");
                    scanner.close();
                    return;
                default:
                    System.out.println("Invalid option. Please try again.");
            }
        }
    }
    
    /*
     Prompts the user to create a new rescue case.
     Asks for the type first, then collects the relevant information.
     */
    private static void createRescueCase() {
        System.out.println("\n--- Create Rescue Case ---");
        System.out.println("Select rescue type:");
        System.out.println("1. Injured Animal Rescue");
        System.out.println("2. Orphaned Animal Rescue");
        System.out.println("3. Endangered Species Rescue");
        System.out.print("Enter type (1-3): ");
        
        int type = scanner.nextInt();
        scanner.nextLine();
        
        // Collect common details
        System.out.print("Rescue Case ID: ");
        String id = scanner.nextLine();
        System.out.print("Animal Name: ");
        String name = scanner.nextLine();
        System.out.print("Species: ");
        String species = scanner.nextLine();
        System.out.print("Rescue Location: ");
        String location = scanner.nextLine();
        System.out.print("Assigned Ranger: ");
        String ranger = scanner.nextLine();
        System.out.print("Number of Rescue Days: ");
        int days = scanner.nextInt();
        scanner.nextLine();
        System.out.print("Daily Care Cost: R");
        double dailyCost = scanner.nextDouble();
        scanner.nextLine();
        
        RescueCase newCase = null;
        
        if (type == 1) {
            // Injured Animal Rescue
            System.out.print("Injury Description: ");
            String injury = scanner.nextLine();
            System.out.print("Veterinary Treatment Cost: R");
            double vetCost = scanner.nextDouble();
            scanner.nextLine();
            System.out.print("Surgery Required? (yes/no): ");
            boolean surgery = scanner.nextLine().equalsIgnoreCase("yes");
            
            newCase = new InjuredAnimalRescue(id, name, species, location, ranger,
                                              days, dailyCost, injury, vetCost, surgery);
            
        } else if (type == 2) {
            // Orphaned Animal Rescue
            System.out.print("Estimated Age (months): ");
            int ageMonths = scanner.nextInt();
            scanner.nextLine();
            System.out.print("Feeding Cost: R");
            double feedingCost = scanner.nextDouble();
            scanner.nextLine();
            System.out.print("Foster Care Required? (yes/no): ");
            boolean foster = scanner.nextLine().equalsIgnoreCase("yes");
            
            newCase = new OrphanedAnimalRescue(id, name, species, location, ranger,
                                               days, dailyCost, ageMonths, feedingCost, foster);
            
        } else if (type == 3) {
            // Endangered Species Rescue
            System.out.print("Conservation Classification: ");
            String classification = scanner.nextLine();
            System.out.print("Security Cost: R");
            double securityCost = scanner.nextDouble();
            scanner.nextLine();
            System.out.print("Specialist Team Required? (yes/no): ");
            boolean specialist = scanner.nextLine().equalsIgnoreCase("yes");
            
            newCase = new EndangeredSpeciesRescue(id, name, species, location, ranger,
                                                  days, dailyCost, classification, securityCost, specialist);
            
        } else {
            System.out.println("Invalid rescue type.");
            return;
        }
        
        boolean success = manager.addRescueCase(newCase);
        if (success) {
            System.out.println("Rescue case created successfully.");
        } else {
            System.out.println("Rescue Case ID already exists.");
        }
    }
    
    /*
     Searches for a rescue case by ID.
     */
    private static void searchRescueCase() {
        System.out.print("\nEnter Rescue Case ID to search: ");
        String id = scanner.nextLine();
        RescueCase rc = manager.searchRescueCase(id);
        if (rc != null) {
            System.out.println("\n--- Rescue Case Found ---");
            rc.displayDetails();
        } else {
            System.out.println("Rescue case not found.");
        }
    }
    
    /*
     Updates the rescue status of a case.
     */
    private static void updateRescueStatus() {
        System.out.print("\nEnter Rescue Case ID: ");
        String id = scanner.nextLine();
        System.out.print("Enter new status: ");
        String status = scanner.nextLine();
        
        boolean success = manager.updateRescueStatus(id, status);
        if (success) {
            System.out.println("Rescue status updated.");
        } else {
            System.out.println("Rescue case not found.");
        }
    }
    
    /*
     Starts a rescue operation.
     */
    private static void startRescueOperation() {
        System.out.print("\nEnter Rescue Case ID to start: ");
        String id = scanner.nextLine();
        boolean success = manager.startRescue(id);
        if (success) {
            System.out.println("Rescue operation started.");
        } else {
            System.out.println("Rescue case not found.");
        }
    }
    
    /*
     Completes a rescue operation.
     */
    private static void completeRescueOperation() {
        System.out.print("\nEnter Rescue Case ID to complete: ");
        String id = scanner.nextLine();
        boolean success = manager.completeRescue(id);
        if (success) {
            System.out.println("Rescue operation completed.");
        } else {
            System.out.println("Rescue case not found.");
        }
    }
}
    

