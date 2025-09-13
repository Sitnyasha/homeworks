import java.util.ArrayList;
import java.util.HashSet;
import java.util.Set;

public class UniqueElementsFinder {

    // Метод, который находит уникальные элементы
    public static <T> Set<T> findUniqueElements(ArrayList<T> inputList) {
        // Создаем HashSet, который автоматически удаляет дубликаты
        Set<T> uniqueSet = new HashSet<>();

        // Проходим по всем элементам входного списка
        for (T element : inputList) {
            // Добавляем каждый элемент в множество
            uniqueSet.add(element);
        }

        // Возвращаем множество с уникальными элементами
        return uniqueSet;
    }
}