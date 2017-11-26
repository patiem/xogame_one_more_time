package utility.intValues;

public class Horizontal implements IntValue {

    private int value;

    public Horizontal(int value) {
        this.value = value;
    }

    @Override
    public int intValue() {
        return value;
    }
}
