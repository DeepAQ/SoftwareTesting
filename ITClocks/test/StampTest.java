import static org.junit.Assert.*;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

public class StampTest {

    @Before
    public void setUp() throws Exception {
    }

    @After
    public void tearDown() throws Exception {
    }

    @Test
    public void testID() {
        assertEquals(IDs.one(), new Stamp().getId());
    }
    
    @Test
    public void testForkPeek() {
        Stamp s1 = new Stamp();
        Stamp[] ss1 = s1.fork();
        assertNotEquals(ss1[0], ss1[1]);
        ss1 = s1.peek();
        assertEquals(s1.getId(), ss1[0].getId());
        assertEquals(IDs.zero(), ss1[1].getId());
    }
    
    @Test
    public void testJoin() {
        Stamp s1 = new Stamp();
        Stamp s2 = new Stamp();
        try {
            Stamp s3 = s1.join(s2);
            fail();
        } catch (Exception e) {
        }
        try {
            s2 = new Stamp(IDs.zero(), Events.zero());
            Stamp s3 = s1.join(s2);
        } catch (Exception e) {
            fail();
        }
    }
    
    @Test
    public void testEvent() {
        Stamp s0 = new Stamp(IDs.zero(), Events.zero());
        Stamp s1 = new Stamp();
        try {
            s0.event();
            fail();
        } catch (Exception e) {
        }
        s1.event();
        s1.send();
        s1.receive(s0);
        s1.sync(s0);
        s1.leq(s1);
    }
    
    @Test
    public void testObject() {
        Stamp s1 = new Stamp();
        assertEquals("(1, 0)", s1.toString());
        assertFalse(s1.equals(null));
        assertEquals(1817, s1.hashCode());
    }

}
