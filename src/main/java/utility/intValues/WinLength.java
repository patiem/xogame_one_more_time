package utility.intValues;

public class WinLength implements IntValue {

    private int value;

    public WinLength(int value) {
        this.value = value;
    }

    @Override
    public Integer intValue() {
        return value;
    }
}
