import java.util.*;

class Person {
   private String name;
   private int age;

   public Person(String name, int age) {
      this.name = name;
      this.age = age;
   }

   public String getName() {
      return name;
   }

   public int getAge() {
      return age;
   }
}

public class ReversePersonList {
   public static void main(String[] args) {
      Stack<Person> stack = new Stack<>();
      List<Person> persons = new ArrayList<>();
      persons.add(new Person("Alice", 25));
      persons.add(new Person("Bob", 30));
      persons.add(new Person("Charlie", 35));

      for (Person person : persons) {
         stack.push(person);
      }

      List<Person> reversedPersons = new ArrayList<>();
      while (!stack.isEmpty()) {
         reversedPersons.add(stack.pop());
      }

      for (Person person : reversedPersons) {
         System.out.println(person.getName() + " " + person.getAge());
      }
   }
}