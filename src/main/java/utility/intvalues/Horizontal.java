package utility.intvalues;

public class Horizontal implements IntValue {

    private final int value;

    public Horizontal(int value) {
        this.value = value;
    }

    @Override
    public Integer intValue() {
        return value;
    }
}
