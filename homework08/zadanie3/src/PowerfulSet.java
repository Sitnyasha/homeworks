import java.util.HashSet;
import java.util.Set;

public class PowerfulSet {

    // Метод для пересечения двух множеств
    public <T> Set<T> intersection(Set<T> set1, Set<T> set2) {
        Set<T> result = new HashSet<>(set1); // Копируем первое множество
        result.retainAll(set2); // Оставляем только общие элементы
        return result;
    }

    // Метод для объединения двух множеств
    public <T> Set<T> union(Set<T> set1, Set<T> set2) {
        Set<T> result = new HashSet<>(set1); // Копируем первое множество
        result.addAll(set2); // Добавляем все элементы второго множества
        return result;
    }

    // Метод для разности множеств (set1 без set2)
    public <T> Set<T> relativeComplement(Set<T> set1, Set<T> set2) {
        Set<T> result = new HashSet<>(set1); // Копируем первое множество
        result.removeAll(set2); // Удаляем элементы, которые есть во втором множестве
        return result;
    }
}