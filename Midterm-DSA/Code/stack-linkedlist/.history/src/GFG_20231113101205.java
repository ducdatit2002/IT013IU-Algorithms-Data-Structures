// Java program to Implement a stack
// using singly linked list
// import package
import static java.lang.System.exit;

// Driver code
class GFG {
	public static void main(String[] args)
	{
		// create Object of Implementing class
		StackUsingLinkedlist obj
			= new StackUsingLinkedlist();
		// insert Stack value
		obj.push(11);
		obj.push(22);
		obj.push(33);
		obj.push(44);

		// print Stack elements
		obj.display();

		// print Top element of Stack
		System.out.printf("\nTop element is %d\n",
						obj.peek());

		// Delete top element of Stack
		obj.pop();
		obj.pop();

		// print Stack elements
		obj.display();

		// print Top element of Stack
		System.out.printf("\nTop element is %d\n",
						obj.peek());
	}
}
