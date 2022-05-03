public class Ellenallas extends Alkatresz{
    private double value;

    public Ellenallas(double price, double value) {
        super(price);
        this.value = value;
    }

    public double getValue() {
        return value;
    }

    @Override
    public String toString() {
        return "Ellenallas{" +
                "price=" + price +
                ", value=" + value +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        if (((Ellenallas) o).price != this.price || ((Ellenallas) o).value != this.value) return false;
        return true;
    }
}
