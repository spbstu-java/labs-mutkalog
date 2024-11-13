import java.util.*;
import java.util.stream.Collectors;

public class StreamTasks {

    // Метод, возвращающий среднее значение списка целых чисел
    public OptionalDouble average(List<Integer> numbers) {
        return numbers.stream()
                .mapToInt(Integer::intValue)
                .average();
    }

    // Метод, приводящий все строки в списке в верхний регистр и добавляющий к ним префикс _new_
    public List<String> toUpperCaseWithPrefix(List<String> strings) {
        return strings.stream()
                .map(s -> "_new_" + s.toUpperCase())
                .collect(Collectors.toList());
    }

    // Метод, возвращающий список квадратов всех встречающихся только один раз элементов списка
    public List<Integer> uniqueSquares(List<Integer> numbers) {
        return numbers.stream()
                .filter(n -> Collections.frequency(numbers, n) == 1)
                .map(n -> n * n)
                .collect(Collectors.toList());
    }

    // Метод, принимающий на вход коллекцию и возвращающий ее последний элемент или кидающий исключение, если коллекция пуста
    public <T> T getLastElement(Collection<T> collection) {
        return collection.stream()
                .reduce((first, second) -> second)
                .orElseThrow(() -> new NoSuchElementException("Collection is empty"));
    }

    // Метод, принимающий на вход массив целых чисел, возвращающий сумму четных чисел или 0, если четных чисел нет
    public int sumOfEvenNumbers(int[] numbers) {
        return Arrays.stream(numbers)
                .filter(n -> n % 2 == 0)
                .sum();
    }

    // Метод, преобразовывающий все строки в списке в Map, где первый символ – ключ, оставшиеся – значение
    public Map<Character, String> stringsToMap(List<String> strings) {
        return strings.stream()
                .filter(s -> !s.isEmpty())
                .collect(Collectors.toMap(
                        s -> s.charAt(0),
                        s -> s.substring(1),
                        (existing, replacement) -> existing
                ));
    }
}
