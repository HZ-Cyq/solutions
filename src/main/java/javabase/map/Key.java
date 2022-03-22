package javabase.map;

import org.jetbrains.annotations.NotNull;

/**
 * @author chenyuqun
 * @date 2022/3/18 6:51 下午
 */
public class Key implements Comparable<Key>{

    @Override
    public int compareTo(@NotNull Key o) {
        return -1;
    }

    @Override
    public int hashCode() {
       return 1;
    }

    @Override
    public boolean equals(Object obj) {
        return true;
    }
}
