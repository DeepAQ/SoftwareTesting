import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import java.util.Locale;

import static org.junit.Assert.*;


public class CMDTest {
    
    private CMD cmd;

    @Before
    public void setUp() throws Exception {
        cmd = new CMD();
    }

    @After
    public void tearDown() throws Exception {
    }

    @Test
    public void testParseNull() {
        try {
            cmd.parse(null);
            fail();
        } catch (Exception e) {
        }
    }
    
    @Test
    public void testParseEmpty() {
        try {
            cmd.parse(new String[]{""});
        } catch (Exception e) {
            e.printStackTrace();
            fail();
        }
    }
    
    @Test
    public void testParseEnd() {
        try {
            cmd.parse(new String[]{"--"});
        } catch (Exception e) {
            e.printStackTrace();
            fail();
        }
    }
    
    @Test
    public void testParseArgs() {
        try {
            cmd.addStringOption("test");
            cmd.parse(new String[]{"--test=test", "--", "a", "b", "c", "d"});
            assertEquals(4, cmd.getRemainingArgs().length);
        } catch (Exception e) {
            e.printStackTrace();
            fail();
        }
    }
    
    @Test
    public void testParseUnknown1() {
        try {
            cmd.parse(new String[]{"-a"});
            fail();
        } catch (CMD.UnknownOptionException e) {
            assertNotNull(e.getOptionName());
        } catch (Exception e) {
        }
    }
    
    @Test
    public void testParseUnknown2() {
        try {
            cmd.parse(new String[]{"--test=test"});
            fail();
        } catch (CMD.UnknownOptionException e) {
            assertNotNull(e.getOptionName());
        } catch (Exception e) {
        }
    }
    
    @Test
    public void testParseSub() {
        try {
            cmd.addBooleanOption('a', "a");
            cmd.addBooleanOption('b', "b");
            cmd.addBooleanOption('c', "c");
            cmd.addBooleanOption('d', "d");
        } catch (Exception e) {
            fail();
        }
        try {
            cmd.parse(new String[]{"-abcd"});
        } catch (Exception e) {
            fail();
        }
    }
    
    @Test
    public void testParseUnknownSub() {
        try {
            cmd.parse(new String[]{"-abcd"});
            fail();
        } catch (CMD.UnknownSuboptionException e) {
            assertEquals('a', e.getSuboption());
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
    
    @Test
    public void testParseNotFlag() {
        try {
            cmd.addBooleanOption('a', "a");
            cmd.addBooleanOption('b', "b");
            cmd.addStringOption('c', "c");
            cmd.addBooleanOption('d', "d");
        } catch (Exception e) {
            fail();
        }
        try {
            cmd.parse(new String[]{"-abcd"});
            fail();
        } catch (CMD.NotFlagException e) {
            assertEquals('c', e.getOptionChar());
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
    
    @Test
    public void testParseString() {
        try {
            cmd.addStringOption("test");
        } catch (Exception e) {
            fail();
        }
        try {
            cmd.parse(new String[]{"--test=test"});
        } catch (Exception e) {
            e.printStackTrace();
            fail();
        }
    }
    
    @Test
    public void testParseStringShort() {
        try {
            cmd.addStringOption('t', "test");
        } catch (Exception e) {
            fail();
        }
        try {
            cmd.parse(new String[]{"-t", "test"});
        } catch (Exception e) {
            e.printStackTrace();
            fail();
        }
    }
    
    @Test
    public void testParseStringInvalid() {
        try {
            cmd.addStringOption('t', "test");
        } catch (Exception e) {
            fail();
        }
        try {
            cmd.parse(new String[]{"-t"});
            fail();
        } catch (CMD.IllegalOptionValueException e) {
            assertNull(e.getOption().getDefaultValue());
            assertEquals("", e.getValue());
        } catch (Exception e) {
        }
        try {
            cmd.parse(new String[]{"--test"});
            fail();
        } catch (Exception e) {
        }
    }
    
    @Test
    public void testParseStringInvalid2() {
        try {
            cmd.addStringOption("test");
        } catch (Exception e) {
            fail();
        }
        try {
            cmd.parse(new String[]{"--test"});
            fail();
        } catch (CMD.IllegalOptionValueException e) {
            assertNull(e.getOption().getDefaultValue());
            assertEquals("", e.getValue());
        } catch (Exception e) {
        }
    }
    
    @Test
    public void testParseStringNull() {
        try {
            cmd.addStringOption(null);
            fail();
        } catch (Exception e) {
        }
    }
    
    @Test
    public void testParseBool() {
        try {
            cmd.addBooleanOption("test");
        } catch (Exception e) {
            fail();
        }
        try {
            cmd.parse(new String[]{"--test=1"});
        } catch (Exception e) {
            fail();
        }
        try {
            cmd.addBooleanOption('t', "test");
        } catch (Exception e) {
            fail();
        }
        try {
            cmd.parse(new String[]{"-t", "1", "--test=1"});
        } catch (Exception e) {
            fail();
        }
    }
    
    @Test
    public void testParseBoolValue() {
        try {
            CMD.Option<Boolean> opt = new CMD.Option.BooleanOption('b', "bool");
            assertTrue(opt.parseValue("hhhh", Locale.getDefault()));
        } catch (Exception e) {
            fail();
        }
    }
    
    @Test
    public void testParseDouble() {
        try {
            cmd.addDoubleOption("test");
        } catch (Exception e) {
            fail();
        }
        try {
            cmd.parse(new String[]{"--test=-0.1"});
        } catch (Exception e) {
            fail();
        }
        try {
            cmd.addDoubleOption('t', "test");
        } catch (Exception e) {
            fail();
        }
        try {
            cmd.parse(new String[]{"-t", "-0.1"});
        } catch (Exception e) {
            fail();
        }
    }
    
    @Test
    public void testParseDoubleInvalid() {
        try {
            cmd.addDoubleOption('t', "test");
        } catch (Exception e) {
            fail();
        }
        try {
            cmd.parse(new String[]{"-t", "hhhh"});
            fail();
        } catch (Exception e) {
        }
    }
    
    @Test
    public void testParseInt() {
        try {
            cmd.addIntegerOption("test");
        } catch (Exception e) {
            fail();
        }
        try {
            cmd.parse(new String[]{"--test=-9999"});
        } catch (Exception e) {
            fail();
        }
        try {
            cmd.addIntegerOption('t', "test");
        } catch (Exception e) {
            fail();
        }
        try {
            cmd.parse(new String[]{"-t", "-9999"});
        } catch (Exception e) {
            fail();
        }
    }
    
    @Test
    public void testParseIntInvalid() {
        try {
            cmd.addIntegerOption('t', "test");
        } catch (Exception e) {
            fail();
        }
        try {
            cmd.parse(new String[]{"-t", "-0.1"});
            fail();
        } catch (Exception e) {
        }
        try {
            cmd.parse(new String[]{"-t", "-99999999999999999999"});
            fail();
        } catch (Exception e) {
        }
    }
    
    @Test
    public void testParseLong() {
        try {
            cmd.addLongOption("test");
        } catch (Exception e) {
            fail();
        }
        try {
            cmd.parse(new String[]{"--test=-9999999999"});
        } catch (Exception e) {
            fail();
        }
        try {
            cmd.addLongOption('t', "test");
        } catch (Exception e) {
            fail();
        }
        try {
            cmd.parse(new String[]{"-t", "-9999999999"});
        } catch (Exception e) {
            e.printStackTrace();
            fail();
        }
    }
    
    @Test
    public void testParseLongInvalid() {
        try {
            cmd.addLongOption('t', "test");
        } catch (Exception e) {
            fail();
        }
        try {
            cmd.parse(new String[]{"-t", "-0.1"});
            fail();
        } catch (Exception e) {
        }
        try {
            cmd.parse(new String[]{"-t", "-99999999999999999999"});
            fail();
        } catch (Exception e) {
        }
    }
    
    @Test
    public void testGetOptionValue() {
        try {
            CMD.Option<String> opt = new CMD.Option.StringOption('t', "test");
            cmd.addOption(opt);
            cmd.parse(new String[]{"-t", "test1", "--test=test2"});
            assertEquals("test1", cmd.getOptionValue(opt));
            assertEquals("test2", cmd.getOptionValue(opt));
            assertEquals(null, cmd.getOptionValue(opt));
        } catch (Exception e) {
            fail();
        }
    }
    
    @Test
    public void testGetOptionValues() {
        try {
            CMD.Option<String> opt = new CMD.Option.StringOption('t', "test");
            cmd.addOption(opt);
            cmd.parse(new String[]{"-t", "test1", "--test=test2"});
            assertEquals(2, cmd.getOptionValues(opt).size());
            assertEquals(0, cmd.getOptionValues(opt).size());
        } catch (Exception e) {
            fail();
        }
    }
    
    @Test
    public void testGetOptionValueNull() {
        try {
            cmd.getOptionValue(null);
            fail();
        } catch (Exception e) {
        }
    }
    
    @Test
    public void testGetOptionValueInvalid() {
        try {
            assertNull(cmd.getOptionValue(new CMD.Option.StringOption("test")));
        } catch (Exception e) {
            fail();
        }
    }
    
    @Test
    public void testCustomOption2() {
        try {
            MyOption opt = new MyOption();
            cmd.addOption(opt);
            assertNull(opt.getDefaultValue());
            assertNull(opt.getValue("", Locale.getDefault()));
            opt = new MyOption('o');
            assertNull(opt.getDefaultValue());
            assertNull(opt.getValue("", Locale.getDefault()));
        } catch (Exception e) {
            fail();
        }
    }
    
    class MyOption extends CMD.Option<Void> {
        protected MyOption() {
            super("my", true);
        }

        protected MyOption(char shortForm) {
            super(shortForm, "my", true);
        }
    }

}
