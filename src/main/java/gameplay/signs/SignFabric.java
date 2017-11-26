package gameplay.signs;

public class SignFabric {

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


//TODO:  what to do with null when default?