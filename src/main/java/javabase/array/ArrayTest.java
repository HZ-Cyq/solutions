package javabase.array;

import org.junit.Test;

/**
 * @author playcrab_chenyuqun
 */
public class ArrayTest {
    @Test
    public void testArray() {
        int[] array = initCombatDay(2);
        for (int i = 0; i < array.length; i++) {
            System.out.println(array[i]);
        }
    }

    public int[] initCombatDay(int expireDay) {
        int[] combatDay = new int[expireDay + 1];
        for(int i = 0; i < expireDay + 1; i++) {
            combatDay[i] = i + 1;
        }
        return combatDay;
    }
}
