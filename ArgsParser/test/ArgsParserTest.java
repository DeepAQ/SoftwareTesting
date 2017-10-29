import static org.junit.Assert.*;

import java.util.List;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

public class ArgsParserTest {

    @Before
    public void setUp() throws Exception {
    }

    @After
    public void tearDown() throws Exception {
    }

    @Test
    public void testConstruct() {
        new ArgsParser();
        new ArgsParser(new String[]{});
    }
    
    @Test
    public void testConstructNull() {
        try {
            new ArgsParser(null);
            fail();
        } catch (NullPointerException e) {
        }
    }
    
    @Test
    public void testGetArgs() {
        String[] args = new String[]{"aaa", "bbb", "ccc"};
        ArgsParser parser = new ArgsParser(args);
        assertArrayEquals(args, parser.getArgs());
        assertEquals(args.length, parser.getArgsCount());
        assertEquals(args.length, parser.getArgsLeftCount());
    }
    
    @Test
    public void testParseSwitchArgs() {
        String[] args = new String[]{"-a", "a", "--b", "icbc", "-cc", "cc", "--dd", "dd", "ee"};
        ArgsParser parser = new ArgsParser(args);
        // short key
        assertTrue(parser.parseSwitchArgument("a").isSet());
        assertTrue(parser.parseSwitchArgument("b").isSet());
        assertFalse(parser.parseSwitchArgument("z").isSet());
        // long key
        assertTrue(parser.parseSwitchArgument("dd").isSet());
        assertFalse(parser.parseSwitchArgument("cc").isSet());
        assertEquals(7, parser.getArgsLeftCount());
        
        assertFalse(parser.parseSwitchArgument("-").isSet());
        assertTrue(parser.parseSwitchArgument("c").isSet());
        assertEquals(7, parser.getArgsLeftCount());
    }
    
    @Test
    public void testParseParamArgsLong() {
        String[] args = new String[]{null, "--L116_3", "Hit!", "--L116_2", null, "--L116_1"};
        ArgsParser parser = new ArgsParser(args);
        
        assertEquals(4, parser.getArgsLeftCount());
        assertNull(parser.parseParameterArgument("zz"));
        assertEquals(4, parser.getArgsLeftCount());
        
        assertNull(parser.parseParameterArgument("L116_1"));
        assertEquals(4, parser.getArgsLeftCount());
        
        assertNull(parser.parseParameterArgument("L116_2"));
        assertEquals(4, parser.getArgsLeftCount());
        
        ParameterArgument pa1 = parser.parseParameterArgument("L116_3");
        assertNotNull(pa1);
        assertEquals("Hit!", pa1.getValue());
        assertEquals(2, parser.getArgsLeftCount());
    }
    
    @Test
    public void testParseParamArgsShort() {
        String[] args = new String[]{null, "z", "-e", "Hit!", null, "-uvw", "-xy", "--f", "-c", null, "-dHit!", "-b"};
        ArgsParser parser = new ArgsParser(args);
        
        assertEquals(9, parser.getArgsLeftCount());
        assertNull(parser.parseParameterArgument("z"));
        assertEquals(9, parser.getArgsLeftCount());
        assertNull(parser.parseParameterArgument("b"));
        assertEquals(9, parser.getArgsLeftCount());
        assertNull(parser.parseParameterArgument("c"));
        assertEquals(9, parser.getArgsLeftCount());
        assertNull(parser.parseParameterArgument("f"));
        assertEquals(9, parser.getArgsLeftCount());
        
        ParameterArgument pa1 = parser.parseParameterArgument("e");
        assertNotNull(pa1);
        assertEquals("Hit!", pa1.getValue());
        assertEquals(7, parser.getArgsLeftCount());
        
        ParameterArgument pa2 = parser.parseParameterArgument("d");
        assertNotNull(pa2);
        assertEquals("Hit!", pa2.getValue());
        assertEquals(6, parser.getArgsLeftCount());
        
        ParameterArgument pa3 = parser.parseParameterArgument("y");
        assertNotNull(pa3);
        assertEquals("--f", pa3.getValue());
        assertEquals(5, parser.getArgsLeftCount());
        
        ParameterArgument pa4 = parser.parseParameterArgument("v");
        assertNotNull(pa4);
        assertEquals("w", pa4.getValue());
        assertEquals(5, parser.getArgsLeftCount());
        
        assertNull(parser.parseParameterArgument("-"));
    }
    
    @Test
    public void testParseStringArgs() {
        String[] args = new String[]{null, "aaa", null, "bbb", null, "ccc"};
        ArgsParser parser = new ArgsParser(args);
        
        assertEquals(3, parser.getArgsLeftCount());
        List<StringArgument> strs = parser.parseStringArgument();
        assertEquals(3, strs.size());
        assertEquals("aaa", strs.get(0).getValue());
        assertEquals("bbb", strs.get(1).getValue());
        assertEquals("ccc", strs.get(2).getValue());
        assertEquals(0, parser.getArgsLeftCount());
    }
    
    @Test
    public void testBoringClasses1() {
        Argument arg1 = new Argument(-2);
        Argument arg2 = new Argument(3);
        assertEquals(-2, arg1.getPosition());
        assertEquals(3, arg2.getPosition());
        assertEquals(-5, arg1.compareTo(arg2));
        assertEquals(5, arg2.compareTo(arg1));
    }
    
    @Test
    public void testBoringClasses2() {
        try {
            new ParameterArgument(0, "key", null);
            fail();
        } catch (NullPointerException e) {
        }
        try {
            new ParameterArgument(0, null, "value");
            fail();
        } catch (NullPointerException e) {
        }
        try {
            new ParameterArgument(0, null, null);
            fail();
        } catch (NullPointerException e) {
        }
        try {
            new ParameterArgument(0, "key", "");
            fail();
        } catch (IllegalArgumentException e) {
        }
        try {
            new ParameterArgument(0, "", "value");
            fail();
        } catch (IllegalArgumentException e) {
        }
        ParameterArgument pa = new ParameterArgument(741, "key", "value");
        assertEquals(741, pa.getPosition());
        assertEquals("key", pa.getKey());
        assertEquals("value", pa.getValue());
        
        assertTrue(new ParameterArgument(741, "key", "value").isLongKey());
        assertFalse(new ParameterArgument(741, "k", "value").isLongKey());
    }
    
    @Test
    public void testBoringClasses3() {
        try {
            new StringArgument(0, null);
            fail();
        } catch (NullPointerException e) {
        }
        StringArgument sa = new StringArgument(741, "");
        assertEquals(741, sa.getPosition());
        assertEquals("", sa.getValue());
    }
    
    @Test
    public void testExtra1() {
        String[] args = new String[]{"-"};
        ArgsParser parser = new ArgsParser(args);
        try {
            parser.parseSwitchArgument("");
        } catch (IllegalArgumentException e) {
        }
        assertEquals(1, parser.getArgsLeftCount());
    }

}
