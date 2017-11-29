package utility.intValues;

public class Height implements IntValue {

    private int value;

    public Height(int value) {
        this.value = value;
    }

    @Override
    public Integer intValue() {
        return value;
    }



}
