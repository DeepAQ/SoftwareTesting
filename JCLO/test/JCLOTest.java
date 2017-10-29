import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

public class JCLOTest {

    @Before
    public void setUp() throws Exception {
    }

    @After
    public void tearDown() throws Exception {
    }    
    
    @Test
    public void testConstruct() {
        TestObject obj = new TestObject();
        new JCLO(obj);
        new JCLO(obj, null);
        new JCLO(null, obj);
        new JCLO(null, obj, null);
    }

    @Test
    public void testUsage() {
        TestObject obj = new TestObject();
        JCLO jclo = new JCLO(obj);
        System.out.println(jclo.usage());
        jclo = new JCLO("bo", obj);
        System.out.println(jclo.usage());
    }
    
    @Test
    public void testParse() {
        TestObject obj = new TestObject();
        JCLO jclo = new JCLO(obj);
        jclo.parse(new String[]{"-b", "1"});
        assertEquals(1, obj.b);
        jclo.parse(new String[]{"--c=s"});
        assertEquals('s', obj.c);
        assertFalse(obj.bool);
        jclo.parse(new String[]{"-bool"});
        assertTrue(obj.bool);
        jclo.parse(new String[]{"-d=-0.1"});
        assertEquals(-0.1, obj.d, 0.1);
        jclo.parse(new String[]{"-f=+9.9"});
        assertEquals(9.9, obj.f, 0.1);
        jclo.parse(new String[]{"-1=2333"});
        assertEquals(2333, obj._1);
        jclo.parse(new String[]{"-l=-23333333333"});
        assertEquals(-23333333333L, obj.l);
        jclo.parse(new String[]{"--s=23456"});
        assertEquals(23456, obj.s);
        jclo.parse(new String[]{"-arr", "233", "-arr=666", "--arr=999"});
        assertArrayEquals(new int[]{233,  666, 999}, obj.arr);
        jclo.parse(new String[]{"-e", "C", "add1", "add2", "add3"});
        assertEquals(TestEnum.C, obj.e);
        assertArrayEquals(new String[]{"add1", "add2", "add3"}, obj.additional);
    }
    
    @Test
    public void testParseBooleanObj() {
        TestObject obj = new TestObject();
        JCLO jclo = new JCLO(obj);
        try {
            jclo.parse(new String[]{"--bool2"});
            assertTrue(obj.bool2);
        } catch (IllegalArgumentException e) {
        }
    }
    
    @Test
    public void testParseStr() {
        TestObject obj = new TestObject();
        JCLO jclo = new JCLO(obj);
        try {
            jclo.parse(new String[]{"-str=Hello World!"});
            assertEquals("Hello", obj.str);
        } catch (IllegalArgumentException e) {
        }
    }
    
    @Test
    public void testParseIllegal() {
        TestObject obj = new TestObject();
        JCLO jclo = new JCLO(obj);
        try {
            jclo.parse(new String[]{"-illegal=test"});
            fail();
        } catch (IllegalArgumentException e) {
        }
    }
    
    @Test
    public void testParseIllegalEqual() {
        TestObject obj = new TestObject();
        JCLO jclo = new JCLO(obj);
        try {
            jclo.parse(new String[]{"--d", "0.1"});
            fail();
        } catch (IllegalArgumentException e) {
        }
    }
    
    @Test
    public void testParseNoAdditional() {
        TestObject2 obj2 = new TestObject2();
        JCLO jclo = new JCLO(obj2);
        jclo.parse(new String[]{"test1", "test2", "test3"});
    }
    
    @Test
    public void testParseBooleanTrue() {
        TestObject obj = new TestObject();
        JCLO jclo = new JCLO(obj);
        jclo.parse(new String[]{"-bool=true"});
        assertTrue(obj.bool);
    }
    
    @Test
    public void testParseBooleanYes() {
        TestObject obj = new TestObject();
        JCLO jclo = new JCLO(obj);
        jclo.parse(new String[]{"-bool=yes"});
        assertTrue(obj.bool);
    }
    
    @Test
    public void testParseBooleanNo() {
        TestObject obj = new TestObject();
        JCLO jclo = new JCLO(obj);
        jclo.parse(new String[]{"-bool=no"});
        assertFalse(obj.bool);
    }
    
    @Test
    public void testAlias() {
        TestObject obj = new TestObject();
        JCLO jclo = new JCLO(obj, new String[][]{new String[]{"loob", "bool"}, new String[]{"i", "1"}});
        jclo.parse(new String[]{"--loob=true"});
        assertTrue(obj.bool);
    }
    
    @Test
    public void testToString() {
        TestObject obj = new TestObject();
        JCLO jclo = new JCLO(obj);
        try {
            System.out.println(jclo.toString());
        } catch (Exception e) {
        }
    }
    
    @Test
    public void testPrivate() {
        TestObject obj = new TestObject();
        JCLO jclo = new JCLO(obj);
        jclo.parse(new String[]{"-priv=123"});
        assertEquals(123, obj.priv);
    }
    
    @Test
    public void testPrefix() {
        TestObject obj = new TestObject();
        JCLO jclo = new JCLO("bo", obj);
        jclo.parse(new String[]{"-ol"});
        assertTrue(obj.bool);
    }
    
    class TestObject {
        boolean bool;
        Boolean bool2;
        byte b;
        short s;
        int _1;
        int __dd;
        float f;
        double d;
        long l;
        char c;
        String str;
        int[] arr;
        TestEnum e;
        String[] additional;
        
        private int priv;
    }
    
    class TestObject2 {
    }
    
    enum TestEnum {
        A, B, C, D
    }

}
