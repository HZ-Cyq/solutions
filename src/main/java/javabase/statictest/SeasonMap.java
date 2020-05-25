package javabase.statictest;

/**
 * @author playcrab_chenyuqun
 */
public class SeasonMap {
    private static int Num;

    public SeasonMap() {
    }

    public void init() {
        Num++;
    }

    public static int getNum() {
        return Num;
    }

    public static void setNum(int num) {
        Num = num;
    }
}
