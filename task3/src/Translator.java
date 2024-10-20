import java.io.*;
import java.util.*;

public class Translator {

    private Map<String, String> dictionary = new HashMap<>();

    // Метод для чтения словаря из файла
    public void loadDictionary(String filePath) throws InvalidFileFormatException, FileReadException {
        try (BufferedReader reader = new BufferedReader(new FileReader(filePath))) {
            String line;
            while ((line = reader.readLine()) != null) {
                String[] parts = line.split("\\|");
                if (parts.length != 2) {
                    throw new InvalidFileFormatException("Неправильный формат файла: " + line);
                }
                String expression = parts[0].trim().toLowerCase(); // Игнорируем регистр
                String translation = parts[1].trim();
                dictionary.put(expression, translation);
            }
        } catch (FileNotFoundException e) {
            throw new FileReadException("Файл не найден: " + filePath);
        } catch (IOException e) {
            throw new FileReadException("Ошибка чтения файла: " + filePath);
        }
    }

    // Метод для перевода текста
    public String translate(String text) {
        String[] words = text.split("\\s+"); // Разбиваем текст на слова
        StringBuilder translatedText = new StringBuilder();
        int i = 0;
        while (i < words.length) {
            String bestMatch = null;
            String bestTranslation = null;
            for (String key : dictionary.keySet()) {
                String[] keyWords = key.split("\\s+");
                if (i + keyWords.length <= words.length) {
                    boolean match = true;
                    for (int j = 0; j < keyWords.length; j++) {
                        if (!words[i + j].equalsIgnoreCase(keyWords[j])) {
                            match = false;
                            break;
                        }
                    }
                    if (match && (bestMatch == null || key.length() > bestMatch.length())) {
                        bestMatch = key;
                        bestTranslation = dictionary.get(key);
                    }
                }
            }

            // Если нашли лучшее совпадение
            if (bestMatch != null) {
                translatedText.append(bestTranslation).append(" ");
                i += bestMatch.split("\\s+").length; // Пропускаем использованные слова
            } else {
                translatedText.append(words[i]).append(" "); // Если нет перевода
                i++;
            }
        }

        return translatedText.toString().trim();
    }
}
