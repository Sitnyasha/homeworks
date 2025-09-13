import java.util.Arrays;
import java.util.Scanner;

public class AnagramChecker {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.println("Введите первую строку:");
        String s = scanner.nextLine().toLowerCase().replaceAll("\\s+", "");

        System.out.println("Введите вторую строку:");
        String t = scanner.nextLine().toLowerCase().replaceAll("\\s+", "");

        boolean result = isAnagram(s, t);
        System.out.println("Результат: " + result);

        scanner.close();
    }

    public static boolean isAnagram(String s, String t) {
        // Если строки разной длины - точно не анаграммы
        if (s.length() != t.length()) {
            return false;
        }

        // Преобразуем строки в массивы символов
        char[] sArray = s.toCharArray();
        char[] tArray = t.toCharArray();

        // Сортируем оба массива
        Arrays.sort(sArray);
        Arrays.sort(tArray);

        // Сравниваем отсортированные массивы
        return Arrays.equals(sArray, tArray);
    }
}