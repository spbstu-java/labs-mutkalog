import java.util.*;

public class Main {
    public static void main(String[] args) {
        StreamTasks tasks = new StreamTasks();
        List<Integer> numbers = Arrays.asList(1, 2, 2, 3, 4);
        List<String> strings = Arrays.asList("apple", "banana", "cherry");

        System.out.println("Average: " + tasks.average(numbers));
        System.out.println("To Upper Case with Prefix: " + tasks.toUpperCaseWithPrefix(strings));
        System.out.println("Unique Squares: " + tasks.uniqueSquares(numbers));
        System.out.println("Last Element: " + tasks.getLastElement(strings));
        System.out.println("Sum of Even Numbers: " + tasks.sumOfEvenNumbers(new int[]{1, 2, 3, 4, 5}));
        System.out.println("Strings to Map: " + tasks.stringsToMap(strings));
    }
}
