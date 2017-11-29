package utility.intValues;

public class Size implements IntValue {

    private int value;

    public Size(int value) {
        this.value = value;
    }

    @Override
    public Integer intValue() {
        return value;
    }
}
