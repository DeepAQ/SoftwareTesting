import static org.junit.Assert.*;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

public class IDsTest {

    @Before
    public void setUp() throws Exception {
    }

    @After
    public void tearDown() throws Exception {
    }

    @Test
    public void testWithIDs() {
        assertEquals(new NonLeafID(IDs.zero(), IDs.zero()), IDs.with(IDs.zero(), IDs.zero()));
    }

}
