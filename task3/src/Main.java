import java.util.*;

public class Main {
    public static void main(String[] args) {
        Translator translator = new Translator();
        Scanner scanner = new Scanner(System.in);

        // Чтение словаря из файла
        System.out.println("Введите путь к файлу со словарем:");
        String filePath = scanner.nextLine();

        try {
            translator.loadDictionary(filePath);  // Загрузка словаря
            System.out.println("Словарь загружен успешно!");

            // Запрос текста для перевода
            System.out.println("Введите текст для перевода:");
            String text = scanner.nextLine();

            // Перевод текста
            String translatedText = translator.translate(text);
            System.out.println("Переведенный текст:");
            System.out.println(translatedText);

        } catch (InvalidFileFormatException e) {
            System.err.println("Ошибка: " + e.getMessage());
        } catch (FileReadException e) {
            System.err.println("Ошибка: " + e.getMessage());
        }
    }
}
