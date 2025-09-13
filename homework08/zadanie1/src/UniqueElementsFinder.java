import java.util.ArrayList;
import java.util.HashSet;
import java.util.Set;

public class UniqueElementsFinder {

    public static <T> Set<T> findUniqueElements(ArrayList<T> inputList) {
        Set<T> uniqueSet = new HashSet<>();

        for (T element : inputList) {
            uniqueSet.add(element);
        }

        return uniqueSet;
    }
}