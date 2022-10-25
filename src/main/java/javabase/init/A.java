package javabase.init;

import java.util.Objects;

/**
 * @author chenyuqun
 * @date 2020/12/17 10:38 上午
 */
public class A {
    int a = 1;

    public A(int a) {
        this.a = a;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        A a1 = (A) o;
        return a == a1.a;
    }

    @Override
    public int hashCode() {
        return Objects.hash(a);
    }

    public int getA() {
        return a;
    }

    public void setA(int a) {
        this.a = a;
    }
}
