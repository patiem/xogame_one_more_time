package utility.intValues;

public class WinLength implements IntValue {

    private int value;

    public WinLength(int value) {
        this.value = value;
    }

    @Override
    public int intValue() {
        return value;
    }
}
