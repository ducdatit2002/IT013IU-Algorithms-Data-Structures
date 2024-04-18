import java.util.Stack;

public class StackOperations {
    public static void main(String[] args) {
        int decimalNumber = 123; // Change this to the decimal number you want to convert
        int originalNumber = decimalNumber;
        Stack<Integer> octalStack = new Stack<>();

        // Convert decimal to octal
        while (decimalNumber > 0) {
            int remainder = decimalNumber % 8;
            octalStack.push(remainder);
            decimalNumber /= 8;
        }

        System.out.print("Decimal " + originalNumber + " in octal: ");
        while (!octalStack.isEmpty()) {
            System.out.print(octalStack.pop());
        }
        System.out.println();

        // Concatenate two stacks
        Stack<Integer> stack1 = new Stack<>();
        stack1.push(1);
        stack1.push(2);
        stack1.push(3);
        Stack<Integer> stack2 = new Stack<>();
        stack2.push(4);
        stack2.push(5);
        stack2.push(6);

        Stack<Integer> concatenatedStack = new Stack<>();
        concatenatedStack.addAll(stack1);
        concatenatedStack.addAll(stack2);

        System.out.println("Concatenated Stack: " + concatenatedStack);

        // Determine if the contents of two stacks are identical
        boolean areIdentical = areStacksIdentical(stack1, stack2);
        System.out.println("Stack 1 and Stack 2 are identical: " + areIdentical);
    }

    // Function to determine if two stacks are identical
    public static boolean areStacksIdentical(Stack<Integer> stack1, Stack<Integer> stack2) {
        if (stack1.size() != stack2.size()) {
            return false;
        }

        for (int i = 0; i < stack1.size(); i++) {
            if (!stack1.get(i).equals(stack2.get(i)) ) {
                return false;
            }
        }

        return true;
    }
}
