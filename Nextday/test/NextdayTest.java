import org.junit.Assert;
import org.junit.Test;

import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.OutputStream;
import java.io.PrintStream;
import java.lang.reflect.Field;

public class NextdayTest {

    @Test
    public void test1() {
        new Date(1, 1, 2019);
        try {
            new Date(0, 1, 2019);
            Assert.fail();
        } catch (Exception ignored) {
        }
        try {
            new Date(13, 1, 2019);
            Assert.fail();
        } catch (Exception ignored) {
        }
        try {
            new Date(1, 0, 2019);
            Assert.fail();
        } catch (Exception ignored) {
        }
        try {
            new Date(1, 32, 2019);
            Assert.fail();
        } catch (Exception ignored) {
        }
        try {
            new Date(4, 31, 2019);
            Assert.fail();
        } catch (Exception ignored) {
        }
        try {
            new Date(2, 30, 2000);
            Assert.fail();
        } catch (Exception ignored) {
        }
        try {
            new Date(2, 29, 2001);
            Assert.fail();
        } catch (Exception ignored) {
        }
        try {
            new Date(2, 29, 1900);
            Assert.fail();
        } catch (Exception ignored) {
        }
        try {
            new Date(1, 1, 0);
            Assert.fail();
        } catch (Exception ignored) {
        }
    }

    @Test
    public void test2() {
        Assert.assertEquals(new Date(1, 2, 2019), Nextday.nextDay(new Date(1, 1, 2019)));
        Assert.assertEquals(new Date(2, 1, 2019), Nextday.nextDay(new Date(1, 31, 2019)));
        Assert.assertEquals(new Date(3, 1, 2019), Nextday.nextDay(new Date(2, 28, 2019)));
        Assert.assertEquals(new Date(5, 1, 2019), Nextday.nextDay(new Date(4, 30, 2019)));
        Assert.assertEquals(new Date(1, 1, 2019), Nextday.nextDay(new Date(12, 31, 2018)));
    }

    @Test
    public void test3() throws IOException, IllegalAccessException, NoSuchFieldException {
        OutputStream os = new ByteArrayOutputStream();
        System.setOut(new PrintStream(os));
        new Date(1, 1, 2019).printDate();
        os.flush();
        Assert.assertEquals("1/1/2019" + System.lineSeparator(), os.toString());

        Assert.assertTrue(new Day(30, new Month(1, new Year(2019))).increment());
        Assert.assertTrue(new Month(11, new Year(2019)).increment());
        Month m = new Month(1, new Year(2019));
        Field yField = Month.class.getDeclaredField("y");
        yField.setAccessible(true);
        yField.set(m, null);
        Assert.assertFalse(m.isValid());

        Assert.assertEquals("1/1/2019", new Date(1, 1, 2019).toString());
        Assert.assertFalse(new Date(1, 1, 2019).equals(null));
        Assert.assertFalse(new Date(1, 1, 2019).equals(""));
        Assert.assertFalse(new Date(1, 1, 2019).equals(new Date(1, 2, 2019)));
        Assert.assertFalse(new Date(1, 1, 2019).equals(new Date(2, 1, 2019)));
        Assert.assertFalse(new Date(1, 1, 2019).equals(new Date(1, 1, 2018)));
        Assert.assertTrue(new Date(1, 1, 2019).equals(new Date(1, 1, 2019)));
        Year y = new Year(-1);
        Assert.assertTrue(y.increment());
        Assert.assertEquals(1, y.getYear());

        Assert.assertTrue(new Year(-1).isLeap());
        Assert.assertTrue(new Year(-401).isLeap());
        Assert.assertFalse(new Year(-101).isLeap());
        Assert.assertFalse(new Year(-2).isLeap());

        Assert.assertTrue(new Year(4).isLeap());
        Assert.assertTrue(new Year(400).isLeap());
        Assert.assertFalse(new Year(100).isLeap());
        Assert.assertFalse(new Year(5).isLeap());

        y.currentPos = 0;
        Assert.assertTrue(y.isLeap());
    }

}
