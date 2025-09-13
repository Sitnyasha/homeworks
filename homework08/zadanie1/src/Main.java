import java.util.ArrayList;
import java.util.Set;

public class Main {
    public static void main(String[] args) {

        ArrayList<Integer> numbers = new ArrayList<>();
        numbers.add(10);
        numbers.add(20);
        numbers.add(30);
        numbers.add(20);
        numbers.add(10);
        numbers.add(40);

        Set<Integer> uniqueNumbers = UniqueElementsFinder.findUniqueElements(numbers);
        System.out.println("Тест с числами:");
        System.out.println("Исходный список: " + numbers);
        System.out.println("Уникальные элементы: " + uniqueNumbers);
        System.out.println();


        ArrayList<String> fruits = new ArrayList<>();
        fruits.add("яблоко");
        fruits.add("банан");
        fruits.add("апельсин");
        fruits.add("банан");
        fruits.add("яблоко");
        fruits.add("виноград");

        Set<String> uniqueFruits = UniqueElementsFinder.findUniqueElements(fruits);
        System.out.println("Тест со строками:");
        System.out.println("Исходный список: " + fruits);
        System.out.println("Уникальные элементы: " + uniqueFruits);
        System.out.println();

        ArrayList<Double> prices = new ArrayList<>();
        prices.add(99.99);
        prices.add(49.50);
        prices.add(99.99);
        prices.add(25.0);
        prices.add(49.50);

        Set<Double> uniquePrices = UniqueElementsFinder.findUniqueElements(prices);
        System.out.println("Тест с дробными числами:");
        System.out.println("Исходный список: " + prices);
        System.out.println("Уникальные элементы: " + uniquePrices);
    }
}