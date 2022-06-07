package app.knock.api.model.util;

import java.util.Map;

public abstract class PropertyBuilderHelper {

    public static <T> T setProperty(Map<String, Object> map, String key, Class<T> clazz) {
        if (map != null && map.containsKey(key)) {
            Object o = map.get(key);
            return clazz.isInstance(o) ? clazz.cast(o) : null;
        }
        return null;
    }

}
