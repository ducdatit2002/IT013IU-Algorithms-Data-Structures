import java.util.LinkedList;
import java.util.List;
import java.util.Scanner;

public class JosephusProblem {
    public static int findSurvivor(int n, int k) {
        List<Integer> people = new LinkedList<>();
        for (int i = 1; i <= n; i++) {
            people.add(i);
        }

        int index = 0;
        while (people.size() > 1) {
            index = (index + k - 1) % people.size();
            people.remove(index);
        }

        return people.get(0);
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.print("Enter the number of people in the circle: ");
        int n = scanner.nextInt();

        System.out.print("Enter the number used for counting off: ");
        int k = scanner.nextInt();

        System.out.print("Enter the number of the person where counting starts: ");
        int start = scanner.nextInt();

        int survivor = findSurvivor(n, k);
        System.out.println("Last person standing: " + survivor);
    }
}
