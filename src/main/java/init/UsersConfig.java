package init;

import java.util.HashMap;
import java.util.Map;

public class UsersConfig implements Config<String> {

    private String player1name;
    private String player2name;
    private String player1Sign;
    private String player2Sign;

    UsersConfig(String name, String name2, String sign1, String sign2) {

        this.player1name = name;
        this.player2name = name2;
        this.player1Sign = sign1;
        this.player2Sign = sign2;
    }

    public Map<String, String> getConfig() {

        Map<String, String> configs = new HashMap<>();
        configs.put("pl1name", player1name);
        configs.put("pl2name", player2name);
        configs.put("pl1sign", player1Sign);
        configs.put("pl2sign", player2Sign);

        return configs;
    }
}
