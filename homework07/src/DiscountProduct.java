import java.time.LocalDate;

public class DiscountProduct extends Product {
    private int discount;  // Скидка в процентах (например, 10 = 10%)
    private LocalDate discountEndDate;  // Дата окончания скидки

    public DiscountProduct(String name, int price, int discount, LocalDate discountEndDate) {
        super(name, price);
        setDiscount(discount);
        setDiscountEndDate(discountEndDate);
    }

    public int getDiscount() {
        return discount;
    }

    public void setDiscount(int discount) {
        if (discount < 0 || discount > 100) {
            throw new IllegalArgumentException("Скидка должна быть от 0% до 100%");
        }
        this.discount = discount;
    }

    public LocalDate getDiscountEndDate() {
        return discountEndDate;
    }

    public void setDiscountEndDate(LocalDate discountEndDate) {
        if (discountEndDate.isBefore(LocalDate.now())) {
            throw new IllegalArgumentException("Срок действия скидки уже истёк");
        }
        this.discountEndDate = discountEndDate;
    }

    @Override
    public int getPrice() {
        if (LocalDate.now().isAfter(discountEndDate)) {
            return super.getPrice();  // Если скидка истекла, возвращаем полную цену
        }
        return super.getPrice() * (100 - discount) / 100;  // Цена со скидкой
    }

    @Override
    public String toString() {
        if (LocalDate.now().isAfter(discountEndDate)) {
            return super.toString();
        }
        return super.getName() + " (Цена со скидкой " + discount + "%: " + getPrice() +
                ", Скидка действует до: " + discountEndDate + ")";
    }
}