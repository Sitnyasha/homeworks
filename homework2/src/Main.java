class Television {
    private String brand;
    private int screenSize;
    private boolean isOn;
    private int currentChannel;
    private int currentVolume;

    public Television(String brand, int screenSize) {
        this.brand = brand;
        this.screenSize = screenSize;
        this.isOn = false;
        this.currentChannel = 1;
        this.currentVolume = 50;
    }

    public String getBrand() {
        return brand;
    }

    public int getScreenSize() {
        return screenSize;
    }

    public boolean isOn() {
        return isOn;
    }

    public int getCurrentChannel() {
        return currentChannel;
    }

    public int getCurrentVolume() {
        return currentVolume;
    }

    public void turnOn() {
        isOn = true;
        System.out.println("Телевизор " + brand + " включен");
    }

    public void turnOff() {
        isOn = false;
        System.out.println("Телевизор " + brand + " выключен");
    }

    public void changeChannel(int newChannel) {
        if (isOn) {
            currentChannel = newChannel;
            System.out.println("Канал изменен на " + newChannel);
        } else {
            System.out.println("Сначала включите телевизор");
        }
    }

    public void increaseVolume() {
        if (isOn) {
            if (currentVolume < 100) {
                currentVolume++;
                System.out.println("Громкость увеличена до " + currentVolume);
            } else {
                System.out.println("Максимальная громкость");
            }
        } else {
            System.out.println("Сначала включите телевизор");
        }
    }

    public void decreaseVolume() {
        if (isOn) {
            if (currentVolume > 0) {
                currentVolume--;
                System.out.println("Громкость уменьшена до " + currentVolume);
            } else {
                System.out.println("Минимальная громкость");
            }
        } else {
            System.out.println("Сначала включите телевизор");
        }
    }

    public void printStatus() {
        System.out.println("Телевизор " + brand +
                ", размер экрана: " + screenSize + " дюймов" +
                ", состояние: " + (isOn ? "включен" : "выключен") +
                ", текущий канал: " + currentChannel +
                ", громкость: " + currentVolume);
    }
}

