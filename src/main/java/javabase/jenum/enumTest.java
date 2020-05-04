package javabase.jenum;

import org.junit.Test;

/**
 * @author playcrab_chenyuqun
 */
public class enumTest {
    private static double RE = 1.0;
    @Test
    public void testEnum() {
        for(SeasonEnum seasonEnum : SeasonEnum.values()) {
            Season season = new Season(seasonEnum);
            season.print();
        }
    }

    @Test
    public void test1() {
        System.out.println(getRe());
    }

    @Test
    public void test2() {
        SeasonEnum seasonEnum = SeasonEnum.valueOf("SPRING");
        System.out.println(seasonEnum);
    }
    private static double getRe() {
        return RE;
    }
}
