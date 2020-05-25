package javabase.statictest;

import org.junit.Test;

/**
 * @author playcrab_chenyuqun
 */
public class StaticTest {
    @Test
    public void testStatic() {
        Player player1 = new Player();
        Activity activity1 = new Activity();
        Activity activity2 = new Activity();
        player1.getActivityList().add(activity1);
        player1.getActivityList().add(activity2);
        activity1.init();
        activity2.init();
        System.out.println(SeasonMap.getNum());

        Player player2 = new Player();
        player2.getActivityList().add(activity1);
        player2.getActivityList().add(activity2);
        activity1.init();
        activity2.init();
        System.out.println(SeasonMap.getNum());
    }

}
