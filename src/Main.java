import java.util.Scanner;

class KeyboardNeighbor {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.print("Введите букву английского алфавита: ");
        String input = scanner.nextLine().toLowerCase();

        if (input.length() != 1 || !Character.isLetter(input.charAt(0))) {
            System.out.println("Ошибка: нужно ввести одну букву!");
            return;
        }

        char letter = input.charAt(0);
        char leftNeighbor = findLeftNeighbor(letter);

        System.out.println("Буква слева: " + leftNeighbor);
    }

    public static char findLeftNeighbor(char letter) {
        String keyboard = "qwertyuiopasdfghjklzxcvbnm";

        int index = keyboard.indexOf(letter);
        if (index == -1) {
            return '?';
        }

        if (index == 0) {
            return keyboard.charAt(keyboard.length() - 1);
        } else {
            return keyboard.charAt(index - 1);
        }
    }
}