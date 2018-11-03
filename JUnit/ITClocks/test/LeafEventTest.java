import static org.junit.Assert.*;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

public class LeafEventTest {

    @Before
    public void setUp() throws Exception {
    }

    @After
    public void tearDown() throws Exception {
    }

    @Test
    public void test() {
        LeafEvent lev = new LeafEvent();
        assertNull(lev.getLeft());
        assertNull(lev.getRight());
        assertEquals(0, lev.max());
        assertEquals(0, lev.min());
        assertEquals(741, lev.lift(741).getValue());
        assertEquals(-741, lev.sink(741).getValue());
        assertEquals(lev, lev.normalize());
        lev.join(Events.with(0, lev, lev));
        assertFalse(lev.equals(null));
    }

}
