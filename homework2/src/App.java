public class App {
    public static void main(String[] args) {

        Television tv1 = new Television("Samsung", 55);
        Television tv2 = new Television("LG", 42);
        Television tv3 = new Television("Sony", 65);

        tv1.turnOn();
        tv1.changeChannel(5);
        tv1.increaseVolume();
        tv1.increaseVolume();
        tv1.printStatus();

        tv2.turnOn();
        tv2.changeChannel(10);
        for (int i = 0; i < 55; i++) {
            tv2.increaseVolume();
        }
        tv2.printStatus();

        tv3.printStatus();
        tv3.changeChannel(3);
    }
}
