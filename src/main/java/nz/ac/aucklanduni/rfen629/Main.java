package nz.ac.aucklanduni.rfen629;

import java.util.Arrays;
import java.util.Objects;
import java.util.Scanner;

import nz.ac.aucklanduni.rfen629.util.Server;

/**
 * @author Raymond Feng (rfen629@aucklanduni.ac.nz)
 */
public class Main {

    static int somethingCool = Main.factorial(4);

    public static class Person {
        String name;
        int age;

        public Person(String name, int age) {
            this.name = name;
            this.age = age;
        }

        @Override
        public boolean equals(Object o) {
            if (this == o) return true;
            if (o == null || getClass() != o.getClass()) return false;
            Person person = (Person) o;
            return age == person.age && name.equals(person.name);
        }

        @Override
        public int hashCode() {
            return Objects.hash(name, age);
        }
    }

    public static void main(String[] args) {
        Person p1 = new Person("Raymond", 19);
        Person p2 = new Person("Ishaan", 19);

        System.out.println(Integer.toHexString(p1.hashCode()));
        System.out.println(p1.toString());
    }

    /**
     * Starts the server.
     */
    public static void startServer() {
        Server server = new Server("Raymond Feng");

        Scanner scanner = new Scanner(System.in);

        // Synonyms that can be used to command the server to end
        String[] synExit = { "end", "stop", "exit" };

        // Allow user to stop the input
        while (true) {
            System.out.print("Enter any command here (e.g. stop): ");

            if (scanner.hasNext()) {
                if (Arrays.asList(synExit).contains(scanner.next())) {
                    server.exit(0);
                    break;
                } else {
                    System.out.println("Unexpected command!");
                }
            }
        }
    }

    public int numberOfPathsDown(int bottom, int right) {
        return switch (bottom + right) {
            case 0 -> 2;
            case 1 -> 1;
            case 2 -> 0;
            default -> -1;
        };
    }

    private static int factorial(int num) {
        if (num - 1 == 0) {
            return num;
        } else {
            return factorial(num - 1) * num;
        }
    }

}
