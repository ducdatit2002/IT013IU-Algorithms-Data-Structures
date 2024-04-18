import java.util.Random;
import java.util.Stack;

public class SpecialArray {
    private int[] array = new int[20];
    private Stack<int[]> undoStack = new Stack<>();
    private Stack<int[]> redoStack = new Stack<>();

    public SpecialArray() {
        // Initialize the array with random values
        Random random = new Random();
        for (int i = 0; i < 20; i++) {
            array[i] = random.nextInt(100); // You can adjust the range of random values as needed
        }
    }

    // Function to update the value at a specific position
    public void updateValue(int position, int newValue) {
        if (position >= 0 && position < array.length) {
            undoStack.push(array.clone()); // Save the current state to the undo stack
            array[position] = newValue; // Update the value
            redoStack.clear(); // Clear the redo stack since a new change has been made
        } else {
            System.out.println("Invalid position.");
        }
    }

    // Function to undo the last update
    public void undo() {
        if (!undoStack.isEmpty()) {
            redoStack.push(array.clone()); // Save the current state to the redo stack
            array = undoStack.pop(); // Restore the previous state
        } else {
            System.out.println("Nothing to undo.");
        }
    }

    // Function to redo the last undo operation
    public void redo() {
        if (!redoStack.isEmpty()) {
            undoStack.push(array.clone()); // Save the current state to the undo stack
            array = redoStack.pop(); // Restore the previously undone state
        } else {
            System.out.println("Nothing to redo.");
        }
    }

    // Function to display the content of the array
    public void displayArray() {
        for (int value : array) {
            System.out.print(value + " ");
        }
        System.out.println();
    }

    public static void main(String[] args) {
        SpecialArray specialArray = new SpecialArray();
        specialArray.displayArray();

        // Example usage:
        specialArray.updateValue(5, 42);
        specialArray.displayArray();

        specialArray.undo();
        specialArray.displayArray();

        specialArray.redo();
        specialArray.displayArray();
    }
}
