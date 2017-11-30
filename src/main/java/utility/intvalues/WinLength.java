package utility.intvalues;

public class WinLength implements IntValue {

    private final int value;

    public WinLength(int value) {
        this.value = value;
    }

    @Override
    public Integer intValue() {
        return value;
    }
}
