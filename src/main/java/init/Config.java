package init;

import java.util.Map;

public interface Config<E> {
    Map<String, E> getConfig();
}
