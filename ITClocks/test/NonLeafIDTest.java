import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.fail;

public class NonLeafIDTest {

    @Before
    public void setUp() throws Exception {
    }

    @After
    public void tearDown() throws Exception {
    }

    @Test
    public void test() {
        NonLeafID id = new NonLeafID(IDs.zero(), IDs.one());
        assertFalse(id.isOne());
        assertFalse(id.isZero());
        assertFalse(id.isLeaf());
        id.normalize();
        id.split();
        new NonLeafID(IDs.one(), IDs.zero()).split();
        new NonLeafID(IDs.one(), IDs.one()).split();
        try {
            id.sum(null);
            fail();
        } catch (Throwable e) {}
        try {
            id.sum(id);
            fail();
        } catch (Exception e) {}
        id.sum(IDs.zero());
        try {
            id.sum(IDs.one());
            fail();
        } catch (Exception e) {}
        assertFalse(id.equals(null));
        id.hashCode();
        id.toString();
    }

}
