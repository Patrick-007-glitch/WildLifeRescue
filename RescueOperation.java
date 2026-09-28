package rescue;

/**
 * RescueOperations interface defines the operations that all rescue cases must support.
 * Any class implementing this interface must provide implementations for these methods.
 * 
 * @author Patrick Tshiluwa Kamunga
 * @studentNumber ST10497579
 */
public interface RescueOperations {
    
    /**
     * Starts the rescue operation.
     * Typically updates the rescue status to "In Progress".
     */
    void startRescue();
    
    /**
     * Completes the rescue operation.
     * Typically updates the rescue status to "Completed".
     */
    void completeRescue();
    
    /**
     * Generates a summary of the rescue case.
     * Displays key information about the rescue.
     */
    void generateSummary();
}
