package net.mooctest;

import org.junit.Assert;
import org.junit.Test;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.FileOutputStream;

public class BrainfuckEngineTest {
    @Test
    public void testConstruct() {
        new BrainfuckEngine(10);
        new BrainfuckEngine(10, System.out);
        new BrainfuckEngine(10, System.out, System.in);
        try {
            new BrainfuckEngine(-1);
            Assert.fail();
        } catch (Exception e) {
        }
    }

    private void testWithFile(String prog, String input, String expectedOutput) throws Exception {
        File file = new File("test");
        FileOutputStream fos = new FileOutputStream(file);
        fos.write(prog.getBytes());
        fos.flush();
        fos.close();

        ByteArrayOutputStream os = new ByteArrayOutputStream();
        ByteArrayInputStream is = new ByteArrayInputStream(input.getBytes());
        BrainfuckEngine engine = new BrainfuckEngine(1024, os, is);
        engine.interpret(file);
        is.close();
        os.close();
        Assert.assertEquals(expectedOutput, os.toString());
        Assert.assertEquals(1, engine.lineCount);
        Assert.assertTrue(engine.columnCount > 0);
    }

    @Test
    public void testHelloWorld() throws Exception {
        testWithFile("++++++++++[>+++++++>++++++++++>+++>+<<<<-]>++.>+.+++++++..+++.>++.<<+++++++++++++++.>.+++.------.--------.>+.>.", "", "Hello World!\n");
    }

    @Test
    public void testMultiply() throws Exception {
        testWithFile(",>,,>++++++++[<------<------>>-]<<[>[>+>+<<-]>>[<<+>>-]<<<-]>>>++++++[<++++++++>-],<.", "2*3", "6");
    }

    @Test
    public void testCellRange() throws Exception {
        BrainfuckEngine engine = new BrainfuckEngine(1);
        try {
            engine.interpret("<");
            Assert.fail();
        } catch (Exception e) {
            Assert.assertTrue(e.getMessage().contains("negative"));
        }
        engine.interpret(">");
        try {
            engine.interpret(">>");
            Assert.fail();
        } catch (Exception e) {
            Assert.assertTrue(e.getMessage().contains("out of range"));
        }
    }

    @Test
    public void testDataClean() throws Exception {
        BrainfuckEngine engine = new BrainfuckEngine(1);
        Assert.assertEquals(0, engine.data[0]);
        engine.interpret("+++");
        Assert.assertEquals(0, engine.data[0]);
    }
}
