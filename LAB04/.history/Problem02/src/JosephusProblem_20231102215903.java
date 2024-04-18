class Node:
    def __init__(self, value):
        self.value = value
        self.next = None

class CircularLinkedList:
    def __init__(self):
        self.head = None

    def insert(self, value):
        new_node = Node(value)
        if not self.head:
            self.head = new_node
            self.head.next = self.head
        else:
            current = self.head
            while current.next != self.head:
                current = current.next
            current.next = new_node
            new_node.next = self.head

    def eliminate(self, step):
        current = self.head
        while current.next != current:
            for _ in range(step - 1):
                current = current.next
            eliminated = current.next
            current.next = eliminated.next
            eliminated.next = None
            print(eliminated.value, end=" ")

        return current.value

def josephus_problem(n, step, start):
    circle = CircularLinkedList()
    for i in range(1, n + 1):
        circle.insert(i)

    print("Elimination order:")
    winner = circle.eliminate(step - 1)
    print("\nLast person standing:", winner)

if __name__ == "__main__":
    num_people = int(input("Enter the number of people in the circle: "))
    step_size = int(input("Enter the number used for counting off: "))
    start_position = int(input("Enter the number of the person where counting starts: "))
    josephus_problem(num_people, step_size, start_position)
