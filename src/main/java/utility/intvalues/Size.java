package utility.intvalues;

public class Size implements IntValue {

    private final int value;

    public Size(int value) {
        this.value = value;
    }

    @Override
    public Integer intValue() {
        return value;
    }
}
