import java.util.Stack;

class Tree {
    public static void main(String[] args) {
        Node a = node(2);
        Node b = node(3);
        Node c = node('+', a, b);
        Node d = node(5);
        Node e = node(1);
        Node f = node('-', d, e);
        Node g = node('*', c, f);
        Node h = node(8);
        Node i = node('/', g, h);

        System.out.println("Tree:");
        showTree(0, i);
        System.out.print("Prefix: ");
        prefix(i);
        System.out.print("\nPostfix: ");
        postfix(i);
        System.out.print("\nInfix: ");
        infix(i);
        System.out.println("\nValue: " + eval(i));

        // Example of a new prefix expression: "* + 4 5 2"
        String prefixExpression = "* + 4 5 2";
        Node treeFromPrefix = buildTreeFromPrefix(prefixExpression);

        System.out.println("\nTree from Prefix Expression:");
        showTree(0, treeFromPrefix);
        System.out.print("Prefix: ");
        prefix(treeFromPrefix);
        System.out.print("\nPostfix: ");
        postfix(treeFromPrefix);
        System.out.print("\nInfix: ");
        infix(treeFromPrefix);
        System.out.println("\nValue: " + eval(treeFromPrefix));
    }

    public static Node buildTreeFromPrefix(String prefix) {
        Stack<Node> stack = new Stack<>();

        String[] tokens = prefix.split("\\s");

        for (int i = tokens.length - 1; i >= 0; i--) {
            String token = tokens[i];

            if (isOperator(token)) {
                char operator = token.charAt(0);
                Node right = stack.pop();
                Node left = stack.pop();
                Node newNode = node(operator, left, right);
                stack.push(newNode);
            } else {
                int value = Integer.parseInt(token);
                Node newNode = node(value);
                stack.push(newNode);
            }
        }

        return stack.pop();
    }

    private static boolean isOperator(String token) {
        return token.length() == 1 && "+-*/".contains(token);
    }

    public static Node node(char op, Node l, Node r) {
        Node a = new Node();
        a.operation = op;
        a.leftChild = l;
        a.rightChild = r;
        return a;
    }

    public static Node node(int val) {
        Node a = new Node();
        a.value = val;
        return a;
    }

    public static void prefix(Node t) {
        if (t.leftChild == null && t.rightChild == null)
            System.out.print(t.value + " ");
        else {
            System.out.print(t.operation + " ");
            prefix(t.leftChild);
            prefix(t.rightChild);
        }
    }

    public static void postfix(Node t) {
        if (t.leftChild == null && t.rightChild == null)
            System.out.print(t.value + " ");
        else {
            postfix(t.leftChild);
            postfix(t.rightChild);
            System.out.print(t.operation + " ");
        }
    }

    public static void infix(Node t) {
        if (t.leftChild == null && t.rightChild == null)
            System.out.print(t.value);
        else {
            System.out.print("(");
            infix(t.leftChild);
            System.out.print(t.operation);
            infix(t.rightChild);
            System.out.print(")");
        }
    }

    public static double eval(Node t) {
        double val = 0;
        if (t.leftChild == null && t.rightChild == null)
            val = t.value;
        else
            switch (t.operation) {
                case '+':
                    val = eval(t.leftChild) + eval(t.rightChild);
                    break;
                case '-':
                    val = eval(t.leftChild) - eval(t.rightChild);
                    break;
                case '*':
                    val = eval(t.leftChild) * eval(t.rightChild);
                    break;
                case '/':
                    val = eval(t.leftChild) / eval(t.rightChild);
            }
        return val;
    }

    public static void showTree(int n, Node t) {
        tab(n);
        if (t.leftChild == null && t.rightChild == null)
            System.out.println(t.value);
        else {
            System.out.println(t.operation);
            showTree(n + 2, t.leftChild);
            showTree(n + 2, t.rightChild);
        }
    }

    public static void tab(int n) {
        for (int i = 0; i < n; i++)
            System.out.print(" ");
    }
}

class Node {
    char operation;
    int value;
    Node leftChild;
    Node rightChild;
}
