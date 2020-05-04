package designpattern.behavioral.strategy;

import org.junit.Test;

/**
 * @author playcrab_chenyuqun
 */
public class StrategyTest {

    @Test
    public void testStrategy() {
        // 获得存在map里的策略
        Strategy strategy1 = StrategyFactory.getStrategy("A");
        strategy1.algorithm();
        Strategy strategy2 = StrategyFactory.getStrategy("B");
        strategy2.algorithm();

        // 获得新创建的策略：通过if,else:
        Strategy strategy3 = StrategyFactory.getNewStrategyWithIfElse("A");
        strategy3.algorithm();
        Strategy strategy4 = StrategyFactory.getNewStrategyWithIfElse("B");
        strategy4.algorithm();

        // 获得新创建的策略:通过enum类:
        Strategy strategy5 = StrategyFactory.getNewStrategy("A");
        strategy5.algorithm();
        Strategy strategy6 = StrategyFactory.getNewStrategy("B");
        strategy6.algorithm();
    }

}
