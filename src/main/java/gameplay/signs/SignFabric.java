package gameplay.signs;

public class SignFabric {

    private SignFabric(){}

    public static Sign getSign(String criteria) {
        switch (criteria) {
            case "X":
                return new XSign();
            case "O":
                return new OSign();
            default:
                return null;
        }
    }
}