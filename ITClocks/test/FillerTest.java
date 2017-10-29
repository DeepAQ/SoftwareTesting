import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.fail;

public class FillerTest {

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
        Event e1 = Events.with(0, e0, e0);
        Filler.fill(nl00, e0);
        Filler.fill(nl01, e0);
        Filler.fill(nl10, e0);
        Filler.fill(nl11, e0);
        Filler.fill(nl101, e0);
        Filler.fill(nl00, e1);
        Filler.fill(nl01, e1);
        Filler.fill(nl10, e1);
        Filler.fill(nl11, e1);
        Filler.fill(nl101, e1);
    }

}
