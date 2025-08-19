import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class App {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        List<Person> people = new ArrayList<>();
        List<Product> products = new ArrayList<>();

        // Ввод покупателей
        System.out.println("Введите покупателей в формате: Имя=Сумма (через запятую)");
        String[] peopleInput = scanner.nextLine().split("[,;]");
        for (String personData : peopleInput) {
            try {
                String[] parts = personData.trim().split("=");
                if (parts.length != 2) {
                    throw new IllegalArgumentException("Неверный формат: используйте Имя=Сумма");
                }
                String name = parts[0].trim();
                int money = Integer.parseInt(parts[1].trim());
                people.add(new Person(name, money));
            } catch (Exception e) {
                System.out.println("Ошибка ввода покупателя: " + e.getMessage());
                return;
            }
        }

        // Ввод продуктов
        System.out.println("Введите продукты в формате: Название=Цена (обычный) или Название=Цена,Скидка%,ГГГГ-ММ-ДД (скидочный)");
        String[] productsInput = scanner.nextLine().split("[,;]");
        for (String productData : productsInput) {
            try {
                String[] parts = productData.trim().split("=");
                if (parts.length != 2) {
                    throw new IllegalArgumentException("Неверный формат продукта");
                }
                String name = parts[0].trim();
                String[] priceAndDiscount = parts[1].trim().split(",");

                if (priceAndDiscount.length == 1) {  // Обычный продукт
                    int price = Integer.parseInt(priceAndDiscount[0]);
                    products.add(new Product(name, price));
                } else if (priceAndDiscount.length == 3) {  // Скидочный продукт
                    int price = Integer.parseInt(priceAndDiscount[0]);
                    int discount = Integer.parseInt(priceAndDiscount[1]);
                    LocalDate endDate = LocalDate.parse(priceAndDiscount[2]);
                    products.add(new DiscountProduct(name, price, discount, endDate));
                } else {
                    throw new IllegalArgumentException("Неверный формат скидочного продукта");
                }
            } catch (Exception e) {
                System.out.println("Ошибка ввода продукта: " + e.getMessage());
                return;
            }
        }

        // Обработка покупок (остаётся без изменений)
        while (true) {
            System.out.println("Введите покупки в формате: Имя-Продукт (или END для завершения)");
            String input = scanner.nextLine();
            if (input.equalsIgnoreCase("END")) {
                break;
            }

            try {
                String[] parts = input.split("-");
                String personName = parts[0].trim();
                String productName = parts[1].trim();

                Person person = people.stream()
                        .filter(p -> p.getName().equals(personName))
                        .findFirst()
                        .orElseThrow(() -> new IllegalArgumentException("Покупатель не найден"));

                Product product = products.stream()
                        .filter(p -> p.getName().equals(productName))
                        .findFirst()
                        .orElseThrow(() -> new IllegalArgumentException("Продукт не найден"));

                person.addProduct(product);
            } catch (Exception e) {
                System.out.println("Ошибка: " + e.getMessage());
            }
        }

        // Вывод результатов
        System.out.println("\nРезультаты:");
        for (Person person : people) {
            System.out.println(person);
        }
    }
}