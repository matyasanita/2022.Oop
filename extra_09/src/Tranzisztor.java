public class Tranzisztor extends Alkatresz{
    private String code;

    public Tranzisztor(double price, String code) {
        super(price);
        this.code = code;
    }

    public String getCode() {
        return code;
    }

    @Override
    public String toString() {
        return "Tranzisztor{" +
                "price=" + price +
                ", code='" + code + '\'' +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        if (((Tranzisztor) o).price != this.price || (!((Tranzisztor) o).code.equals(this.code))) return false;
        return true;
    }
}
