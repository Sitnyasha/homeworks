import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

public class Main {
    public static void main(String[] args) {
        PowerfulSet powerfulSet = new PowerfulSet();

        Set<Integer> set1 = new HashSet<>(Arrays.asList(1, 2, 3));
        Set<Integer> set2 = new HashSet<>(Arrays.asList(0, 1, 2, 4));

        Set<Integer> intersection = powerfulSet.intersection(set1, set2);
        System.out.println("Пересечение: " + intersection);

        Set<Integer> union = powerfulSet.union(set1, set2);
        System.out.println("Объединение: " + union);

        Set<Integer> complement = powerfulSet.relativeComplement(set1, set2);
        System.out.println("Разность (set1 без set2): " + complement);

        Set<Integer> complement2 = powerfulSet.relativeComplement(set2, set1);
        System.out.println("Разность (set2 без set1): " + complement2);
    }
}