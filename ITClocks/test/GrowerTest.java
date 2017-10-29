import static org.junit.Assert.*;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

public class GrowerTest {

    @Before
    public void setUp() throws Exception {
    }

    @After
    public void tearDown() throws Exception {
    }

    @Test
    public void test() {
        ID nl00 = IDs.with(IDs.zero(), IDs.zero());
        ID nl01 = IDs.with(IDs.zero(), IDs.one());
        ID nl10 = IDs.with(IDs.one(), IDs.zero());
        ID nl11 = IDs.with(IDs.one(), IDs.one());
        ID nl101 = IDs.with(IDs.one(), IDs.with(IDs.zero(), IDs.one()));
        Event e0 = Events.zero();
        try {
            Grower.grow(nl00, e0);
            fail();
        } catch (Exception e) {
        }
        Grower.grow(nl01, e0);
        Grower.grow(nl10, e0);
        Grower.grow(nl11, e0);
        Grower.grow(nl101, e0);
    }

}
