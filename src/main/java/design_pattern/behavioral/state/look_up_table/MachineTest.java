package design_pattern.behavioral.state.look_up_table;

import org.junit.Assert;
import org.junit.Test;

/**
 * @author chenyuqun
 */
public class MachineTest {
    @Test
    public void testMachine() {
        MarioStateMachine machine = new MarioStateMachine();
        machine.executeEvent(MarioStateMachine.Event.COTE_FIRE);
        Assert.assertTrue(machine.getCurrentState().equals(MarioStateMachine.State.FIRE));
        Assert.assertEquals(machine.getScore(), 300);
    }
}
