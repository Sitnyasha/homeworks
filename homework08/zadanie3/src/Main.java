import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

public class Main {
    public static void main(String[] args) {
        PowerfulSet powerfulSet = new PowerfulSet();

        // Создаем тестовые множества
        Set<Integer> set1 = new HashSet<>(Arrays.asList(1, 2, 3));
        Set<Integer> set2 = new HashSet<>(Arrays.asList(0, 1, 2, 4));

        // Тестируем пересечение
        Set<Integer> intersection = powerfulSet.intersection(set1, set2);
        System.out.println("Пересечение: " + intersection); // Должно быть {1, 2}

        // Тестируем объединение
        Set<Integer> union = powerfulSet.union(set1, set2);
        System.out.println("Объединение: " + union); // Должно быть {0, 1, 2, 3, 4}

        // Тестируем разность
        Set<Integer> complement = powerfulSet.relativeComplement(set1, set2);
        System.out.println("Разность (set1 без set2): " + complement); // Должно быть {3}

        // Тестируем разность (set2 без set1)
        Set<Integer> complement2 = powerfulSet.relativeComplement(set2, set1);
        System.out.println("Разность (set2 без set1): " + complement2); // Должно быть {0, 4}
    }
}