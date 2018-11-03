package net.mooctest;

import org.junit.Assert;
import org.junit.Test;

import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.PrintStream;
import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

public class JCLOTest {

    @Test
    public void testConstruct() {
        Object obj = new TestObject();
        JCLO jclo1 = new JCLO(obj);
        JCLO jclo2 = new JCLO(obj, null);
        JCLO jclo3 = new JCLO(null, obj);
        Assert.assertNull(getField(jclo1, "prefix"));
        Assert.assertEquals(obj, getField(jclo1, "object"));
        Assert.assertNull(getField(jclo1, "aliases"));
        Assert.assertNull(getField(jclo2, "prefix"));
        Assert.assertEquals(obj, getField(jclo2, "object"));
        Assert.assertNull(getField(jclo2, "aliases"));
        Assert.assertNull(getField(jclo3, "prefix"));
        Assert.assertEquals(obj, getField(jclo3, "object"));
        Assert.assertNull(getField(jclo3, "aliases"));
    }

    @Test
    public void testReflection() {
        Object obj = new TestObject();
        JCLO jclo1 = new JCLO(obj);
        try {
            Method getObj = jclo1.getClass().getDeclaredMethod("getObject", Field.class);
            getObj.setAccessible(true);
            getObj.invoke(jclo1, new Object[]{null});
            Assert.fail();
        } catch (Throwable t) {
            Assert.assertEquals(InvocationTargetException.class, t.getClass());
            Assert.assertEquals(NullPointerException.class, t.getCause().getClass());
        }
        try {
            Method setObj = jclo1.getClass().getDeclaredMethod("setObject", Field.class, Object.class);
            setObj.setAccessible(true);
            Field priv = obj.getClass().getDeclaredField("priv");
            PrintStream old = System.err;
            ByteArrayOutputStream os = new ByteArrayOutputStream();
            PrintStream ps = new PrintStream(os);
            System.setErr(ps);
            setObj.invoke(jclo1, priv, obj);
            ps.flush();
            ps.close();
            os.flush();
            os.close();
            System.setErr(old);
            Assert.assertTrue(os.toString().contains("IllegalAccessException"));
        } catch (Throwable t) {
            Assert.fail();
        }
        try {
            Method makeObj = jclo1.getClass().getDeclaredMethod("makeObject", String.class, String.class);
            makeObj.setAccessible(true);
            Assert.assertEquals("test", makeObj.invoke(jclo1, "string", "test"));
        } catch (Throwable t) {
            Assert.fail();
        }
    }

    @Test
    public void testUsage() {
        Object obj = new TestObject();
        JCLO jclo1 = new JCLO(obj);
        Assert.assertTrue(jclo1.usage().contains("--dd int\n" +
                "-1 int\n" +
                "-arr int...\n" +
                "-b byte\n" +
                "-bool\n" +
                "-bool2\n" +
                "-c char\n" +
                "-d double\n" +
                "-e [A, B, C, D]\n" +
                "-f float\n" +
                "-l long\n" +
                "-priv int\n" +
                "-s short\n" +
                "-str String\n"));
        JCLO jclo2 = new JCLO("b", obj);
        Assert.assertTrue(jclo2.usage().contains("- byte\n" +
                "-ool\n" +
                "-ool2\n"));
    }

    @Test
    public void testParse() {
        TestObject obj = new TestObject();
        JCLO jclo = new JCLO(obj);
        jclo.parse(new String[]{"-b", "1"});
        Assert.assertEquals(1, obj.b);
        jclo.parse(new String[]{"--c=s"});
        Assert.assertEquals('s', obj.c);
        Assert.assertFalse(obj.bool);
        jclo.parse(new String[]{"-bool"});
        Assert.assertTrue(obj.bool);
        jclo.parse(new String[]{"-d=-0.1"});
        Assert.assertEquals(-0.1, obj.d, 0.1);
        jclo.parse(new String[]{"-f=+9.9"});
        Assert.assertEquals(9.9, obj.f, 0.1);
        jclo.parse(new String[]{"-1=2333"});
        Assert.assertEquals(2333, obj._1);
        jclo.parse(new String[]{"-l=-23333333333"});
        Assert.assertEquals(-23333333333L, obj.l);
        jclo.parse(new String[]{"--s=23456"});
        Assert.assertEquals(23456, obj.s);
        jclo.parse(new String[]{"-arr", "233", "-arr=666", "--arr=999"});
        Assert.assertArrayEquals(new int[]{233, 666, 999}, obj.arr);
        jclo.parse(new String[]{"-e", "C", "add1", "add2", "add3"});
        Assert.assertEquals(TestEnum.C, obj.e);
        Assert.assertArrayEquals(new String[]{"add1", "add2", "add3"}, obj.additional);
    }

    @Test
    public void testParseBooleanObj() {
        TestObject obj = new TestObject();
        JCLO jclo = new JCLO(obj);
        try {
            jclo.parse(new String[]{"--bool2"});
            Assert.assertTrue(obj.bool2);
        } catch (IllegalArgumentException e) {
        }
    }

    @Test
    public void testParseStr() {
        TestObject obj = new TestObject();
        JCLO jclo = new JCLO(obj);
        try {
            jclo.parse(new String[]{"-str=Hello World!"});
            Assert.assertEquals("Hello", obj.str);
        } catch (IllegalArgumentException e) {
        }
    }

    @Test
    public void testParseIllegal() {
        TestObject obj = new TestObject();
        JCLO jclo = new JCLO(obj);
        try {
            jclo.parse(new String[]{"-illegal=test"});
            Assert.fail();
        } catch (IllegalArgumentException e) {
        }
    }

    @Test
    public void testParseIllegalEqual() {
        TestObject obj = new TestObject();
        JCLO jclo = new JCLO(obj);
        try {
            jclo.parse(new String[]{"--d", "0.1"});
            Assert.fail();
        } catch (IllegalArgumentException e) {
        }
    }

    @Test
    public void testParseNoAdditional() throws IOException {
        TestObject2 obj2 = new TestObject2();
        JCLO jclo = new JCLO(obj2);
        PrintStream old = System.err;
        ByteArrayOutputStream os = new ByteArrayOutputStream();
        PrintStream ps = new PrintStream(os);
        System.setErr(ps);
        jclo.parse(new String[]{"test1", "test2", "test3"});
        ps.flush();
        ps.close();
        os.flush();
        os.close();
        System.setErr(old);
        Assert.assertTrue(os.toString().contains("No varible 'additional' found"));
    }

    @Test
    public void testParseBooleanTrue() {
        TestObject obj = new TestObject();
        JCLO jclo = new JCLO(obj);
        jclo.parse(new String[]{"-bool=true"});
        Assert.assertTrue(obj.bool);
    }

    @Test
    public void testParseBooleanYes() {
        TestObject obj = new TestObject();
        JCLO jclo = new JCLO(obj);
        jclo.parse(new String[]{"-bool=yes"});
        Assert.assertTrue(obj.bool);
    }

    @Test
    public void testParseBooleanNo() {
        TestObject obj = new TestObject();
        JCLO jclo = new JCLO(obj);
        jclo.parse(new String[]{"-bool=no"});
        Assert.assertFalse(obj.bool);
    }

    @Test
    public void testAlias() {
        TestObject obj = new TestObject();
        JCLO jclo = new JCLO(obj, new String[][]{new String[]{"loob", "bool"}, new String[]{"i", "1"}});
        jclo.parse(new String[]{"--loob=true"});
        Assert.assertTrue(obj.bool);
    }

    @Test
    public void testToString() {
        TestObject obj = new TestObject();
        JCLO jclo = new JCLO(obj);
        try {
            Assert.assertTrue(!jclo.toString().trim().isEmpty());
            Assert.assertTrue(!jclo.toString().startsWith("\n"));
        } catch (Exception e) {
            Assert.assertEquals(ClassCastException.class, e.getClass());
        }
    }

    @Test
    public void testPrivate() {
        TestObject obj = new TestObject();
        JCLO jclo = new JCLO(obj);
        jclo.parse(new String[]{"-priv=123"});
        Assert.assertEquals(123, obj.priv);
    }

    @Test
    public void testPrefix() {
        TestObject obj = new TestObject();
        JCLO jclo = new JCLO("bo", obj);
        jclo.parse(new String[]{"-ol"});
        Assert.assertTrue(obj.bool);
    }

    @Test
    public void testPrimitive() {
        TestObject3 obj = new TestObject3();
        JCLO jclo = new JCLO(obj);
        try {
            jclo.parse(new String[]{"-obj", ""});
            Assert.fail();
        } catch (Exception e) {
            Assert.assertEquals(IllegalArgumentException.class, e.getClass());
            Assert.assertTrue(e.getMessage().contains("Unknown type: object"));
        }
    }

    private static Object getField(Object target, String name) {
        try {
            Field field = target.getClass().getDeclaredField(name);
            field.setAccessible(true);
            return field.get(target);
        } catch (Exception e) {
            return null;
        }
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

    class TestObject3 {
        Object obj;
    }

    enum TestEnum {
        A, B, C, D
    }

}
