import static org.junit.Assert.*;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

public class NonLeafEventTest {

    @Before
    public void setUp() throws Exception {
    }

    @After
    public void tearDown() throws Exception {
    }

    @Test
    public void test() {
        NonLeafEvent ev = new NonLeafEvent(1, Events.zero(), Events.zero());
        assertEquals(1, ev.min());
        assertEquals(1, ev.max());
        assertEquals(1, ev.maxDepth());
        assertEquals(742, ev.lift(741).getValue());
        assertEquals(-740, ev.sink(741).getValue());
        new NonLeafEvent(0, ev, Events.zero()).normalize();
        assertTrue(ev.leq(ev));
        assertFalse(ev.leq(new NonLeafEvent(0, ev, Events.zero())));
        ev.join(ev);
        ev.join(new NonLeafEvent(0, ev, Events.zero()));
        assertFalse(ev.equals(null));
        assertTrue(ev.equals(ev));
        ev.hashCode();
        ev.toString();
    }

}
