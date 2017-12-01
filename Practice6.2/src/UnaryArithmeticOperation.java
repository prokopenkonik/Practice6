public class UnaryArithmeticOperation {
    private double value;

    public UnaryArithmeticOperation() {
    }

    public UnaryArithmeticOperation(double value) {
        this.value = value;
    }

    public double increment() {
        return ++value;
    }

    public double decrement() {
        return --value;
    }

    public double changeSign() {
        return value = -value;
    }

    public double getValue() {
        return value;
    }

    public void setValue(double value) {
        this.value = value;
    }

    @Override
    public String toString() {
        return Double.toString(value);
    }
}
