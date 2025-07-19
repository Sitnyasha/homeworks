import javax.swing.plaf.PanelUI;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Введите имя пользователя: ");
        String name = scanner.nextLine();

        System.out.println("Привет, " + name);
    }
}