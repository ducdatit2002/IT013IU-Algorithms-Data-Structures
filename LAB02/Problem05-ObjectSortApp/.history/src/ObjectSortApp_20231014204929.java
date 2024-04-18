import java.util.Arrays;

class Person {
    private String lastName;
    private String firstName;
    private int age;

    public Person(String last, String first, int a) {
        lastName = last;
        firstName = first;
        age = a;
    }

    public void displayPerson() {
        System.out.print("   Last name: " + lastName);
        System.out.print(", First name: " + firstName);
        System.out.println(", Age: " + age);
    }

    public String getLastName() {
        return lastName;
    }

    public String getFirstName() {
        return firstName;
    }

    public int getAge() {
        return age;
    }
}

class ArrayInOb {
    private Person[] a;
    private int nElems;

    public ArrayInOb(int max) {
        a = new Person[max];
        nElems = 0;
    }

    public void insert(String last, String first, int age) {
        a[nElems] = new Person(last, first, age);
        nElems++;
    }

    public void display() {
        for (int j = 0; j < nElems; j++) {
            a[j].displayPerson();
        }
    }

    public void insertionSortByLastName() {
        int in, out;

        for (out = 1; out < nElems; out++) {
            Person temp = a[out];
            in = out;

            while (in > 0 && a[in - 1].getLastName().compareTo(temp.getLastName()) > 0) {
                a[in] = a[in - 1];
                in--;
            }

            a[in] = temp;
        }
    }

    public void insertionSortByFirstName() {
        int in, out;

        for (out = 1; out < nElems; out++) {
            Person temp = a[out];
            in = out;

            while (in > 0 && a[in - 1].getFirstName().compareTo(temp.getFirstName()) > 0) {
                a[in] = a[in - 1];
                in--;
            }

            a[in] = temp;
        }
    }

    public void insertionSortByAge() {
        int in, out;

        for (out = 1; out < nElems; out++) {
            Person temp = a[out];
            in = out;

            while (in > 0 && a[in - 1].getAge() > temp.getAge()) {
                a[in] = a[in - 1];
                in--;
            }

            a[in] = temp;
        }
    }
}

public class PersonSortApp {
    public static void main(String[] args) {
        int maxSize = 10;
        ArrayInOb arr = new ArrayInOb(maxSize);

        arr.insert("Evans", "Patty", 24);
        arr.insert("Smith", "Doc", 59);
        arr.insert("Smith", "Lorraine", 37);
        arr.insert("Smith", "Paul", 37);
        arr.insert("Yee", "Tom", 43);
        arr.insert("Hashimoto", "Sato", 21);
        arr.insert("Stimson", "Henry", 29);
        arr.insert("Velasquez", "Jose", 72);
        arr.insert("Vang", "Minh", 22);
        arr.insert("Creswell", "Lucinda", 18);

        System.out.println("Before sorting:");
        arr.display();

        arr.insertionSortByLastName();
        System.out.println("\nAfter sorting by last name:");
        arr.display();

        arr.insertionSortByFirstName();
        System.out.println("\nAfter sorting by first name:");
        arr.display();

        arr.insertionSortByAge();
        System.out.println("\nAfter sorting by age:");
        arr.display();
    }
}