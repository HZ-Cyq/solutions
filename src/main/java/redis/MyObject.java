package redis;

import com.google.common.collect.Maps;

import java.util.Map;

/**
 * @author chenyuqun
 */
public enum  MyObject {
    INSTANCE;
    Map<String, String> map = Maps.newHashMap();

    public Map<String, String> getMap() {
        return map;
    }

    public void setMap(Map<String, String> map) {
        this.map = map;
    }
}
