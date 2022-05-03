import java.util.Objects;

public class Kondenzator extends Alkatresz{
    private double value;

    public Kondenzator(double price, double value) {
        super(price);
        this.value = value;
    }

    public double getValue() {
        return value;
    }

    @Override
    public String toString() {
        return "Kondenzator{" +
                "price=" + price +
                ", value=" + value +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        if (((Kondenzator) o).price != this.price || ((Kondenzator) o).value != this.value) return false;
        return true;
    }

}
