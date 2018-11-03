import static org.junit.Assert.*;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

public class LeafIDTest {

    @Before
    public void setUp() throws Exception {
    }

    @After
    public void tearDown() throws Exception {
    }

    @Test
    public void test() {
        LeafID lid = new LeafID(0);
        assertEquals(0, lid.getValue());
        assertNull(lid.getLeft());
        assertNull(lid.getRight());
        assertEquals(lid, lid.normalize());
        assertEquals(IDs.zero(), lid.split()[0]);
        assertEquals(IDs.zero(), lid.split()[1]);
        assertEquals(IDs.one(), lid.sum(IDs.one()));
        assertFalse(lid.equals(null));
    }

}
