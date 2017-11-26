package init;

import java.util.HashMap;
import java.util.Map;

public class BoardConfig implements Config<Integer> {

    private int horizontal;
    private int vertical;
    private int winningLenght;

    public BoardConfig(int horizontal, int vertical, int winningLenght) {
        this.horizontal = horizontal;
        this.vertical = vertical;
        this.winningLenght = winningLenght;
    }

    public Map<String, Integer> getConfig() {

        Map<String, Integer> configs = new HashMap<>();
        configs.put("horizontal", horizontal);
        configs.put("vertical", vertical);
        configs.put("winning", winningLenght);

        return configs;
    }


}
