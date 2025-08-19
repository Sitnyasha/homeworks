import java.time.LocalDate;
import java.util.Objects;

public class DiscountProduct extends Product {
    private int discount;
    private LocalDate discountEndDate;

    public DiscountProduct(String name, int price, int discount, LocalDate discountEndDate) {
        super(name, price);
        setDiscount(discount);
        setDiscountEndDate(discountEndDate);
    }

    public void setDiscount(int discount) {
        if (discount < 0 || discount > 100) {
            throw new IllegalArgumentException("Скидка должна быть от 0% до 100%");
        }
        this.discount = discount;
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
            return super.getPrice();
        }
        return super.getPrice() * (100 - discount) / 100;
    }

    @Override
    public String toString() {
        if (LocalDate.now().isAfter(discountEndDate)) {
            return super.toString();
        }
        return super.getName() + " (Цена со скидкой " + discount + "%: " + getPrice() +
                ", Скидка действует до: " + discountEndDate + ")";
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        if (!super.equals(o)) return false;
        DiscountProduct that = (DiscountProduct) o;
        return discount == that.discount && discountEndDate.equals(that.discountEndDate);
    }

    @Override
    public int hashCode() {
        return Objects.hash(super.hashCode(), discount, discountEndDate);
    }
}