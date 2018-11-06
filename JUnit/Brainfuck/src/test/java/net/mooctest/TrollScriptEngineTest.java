package net.mooctest;

import org.junit.Assert;
import org.junit.Test;

import java.io.*;

public class TrollScriptEngineTest {
    @Test
    public void testConstruct() {
        new TrollScriptEngine(10);
        new TrollScriptEngine(10, System.out);
        new TrollScriptEngine(10, System.out, System.in);
        try {
            new TrollScriptEngine(-1);
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
        TrollScriptEngine engine = new TrollScriptEngine(1024, os, is);
        engine.interpret(file);
        is.close();
        os.close();
        Assert.assertEquals(expectedOutput, os.toString());
    }

    @Test
    public void testHelloWorld() throws Exception {
        testWithFile("Trooloolooloolooloolooloolooloolollooooolooloolooloolooloolooooolooloolooloolooloolooloolooloooooloolooloooooloooloolooloololllllooooloololoooooololooolooloolooloolooloololoolooolooloololooooooloololooooloololooloolooloolooloolooloolooloolooloolooloololooooolooolooloololooollollollollollolllooollollollollollollollollloooooololooooolooll.", "", "Hello World!\n");
    }

    @Test
    public void testFib() throws Exception {
        testWithFile("Trooloolooloolooloolooloolooloolooloolooloolooloolooloolooloolooloolooloolooloolooloolooloolooloolooloolooloolooloolooloolooloolooloolooooolooloolooloolooloolooloolooloolooloolooloolooloolooloolooloolooloolooloolooloolooloolooloolooloooooloolooloolooloolooloolooloolooloolooloolooloolooooooooloooloollloooooooooooooolooloolooloolooloolooloolooloooloollloolloooolooooollllooooolooooooolllooolloololloolloololoooollloooolooooooolllooloolooloolooloollllooollooololooooolllllooolloolllllooooooooooloolooloolooloolooloolooloolooollloolloooollllooooolooooooolllooolloololloolloololoooollloooolooooooollloolooloolooloollllooolloollllloooooollooloolooloolooloolooloolooloolooloolooloolooloolooloolooloolooloolooloolooloolooloolooloolooloolooloolooloolooloolooloolooloolooloolooloolooloololoolloolllllllloolllooloolooloolooloolooloolooloolooloolooloolooloolooloolooloolooloolooloolooloolooloolooloolooloolooloolooloolooloolooloolooloolooloolooloolooloololoolloolllllllloolooloololoolooloolooloolooloolooloolooloolooloolooloolooloolooloolooloolooloolooloolooloolooloolooloolooloolooloolooloolooloolooloolooloolooloolooloololoolloollllloolooloolooloolooloolloooooloooooooollooooooooloooloololllllooolloooooloooloololooooolllllooollooololooooollllloolooloololllllooloololoololooloolooll.", "", "1, 1, 2, 3, 5, 8, 13, 21, 34, 55, 89, 144, 233, 121, 98, 219, ...");
    }

    @Test
    public void testIO() throws Exception {
        testWithFile("Trolollooloolooll.", "?", "???");
        testWithFile("Trolollooloolool.", "?", "???");
    }

    @Test
    public void testInvalidToken() throws Exception {
        testWithFile("Trol", "", "");
    }
}
