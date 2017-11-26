package utility;

public enum Polish {
    ERR_NAME("Imie musi byc 3-21 znakow, spróbuj jeszcze raz"),
    ERR_SIGN("Twój znak nie był ani O ani X, więc przydzielamy Ci X");

    public String msg;

    Polish(String sign) {
        this.msg = sign;
    }

    public String msg() {
        return msg;
    }
}
