import java.util.Scanner;
import java.io.*;

public class Students {
    public static void main(String[] args) throws IOException {
        int total = 0;
        int count = 0;
        int excellentCount = 0;
        int okCount = 0;
        int failureCount = 0;

        Scanner fileInput = new Scanner(new File("students.txt"));
        while (fileInput.hasNext()) {
            String first_name = fileInput.next();
            String last_name = fileInput.next();
            int grade = fileInput.nextInt();

            Student st = new Student(first_name, last_name, grade);

            System.out.println(st);
            total += grade;
            count++;

            String studentType = st.getStudentType();
            if (studentType.equals("Excellent")) {
                excellentCount++;
            } else if (studentType.equals("OK")) {
                okCount++;
            } else {
                failureCount++;
            }
        }
        fileInput.close();

        double average = (double) total / count;
        System.out.println("There are " + count + " students with an average grade of " + average);
        System.out.println("Excellent students: " + excellentCount);
        System.out.println("OK students: " + okCount);
        System.out.println("Failure students: " + failureCount);
    }
}