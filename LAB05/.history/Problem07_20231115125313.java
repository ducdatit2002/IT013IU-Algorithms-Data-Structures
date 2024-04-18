public class StringReverse {
    public static void main(String[] args) {
        String input = "Hello, World!";
        String reversed = reverseString(input);
        System.out.println("Original String: " + input);
        System.out.println("Reversed String: " + reversed);
    }

    public static String reverseString(String str) {
        // Base case: If the string is empty or has only one character, return itself.
        if (str.isEmpty() || str.length() == 1) {
            return str;
        } else {
            // Recursive case: Reverse the substring excluding the first character,
            // and concatenate it with the first character.
            return reverseString(str.substring(1)) + str.charAt(0);
        }
    }
}
