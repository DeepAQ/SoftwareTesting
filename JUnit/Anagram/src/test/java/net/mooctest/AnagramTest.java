package net.mooctest;

import org.junit.Assert;
import org.junit.Test;

import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.PrintStream;
import java.lang.reflect.Method;
import java.util.Set;

public class AnagramTest {
//    @Test
//    public void testConstruct() {
//        try {
//            new Anagram("");
//        } catch (AssertionError e) {
//            return;
//        }
//        Assert.fail();
//    }

    @Test
    public void testUsage() throws Exception {
        PrintStream sysOut = System.out;
        ByteArrayOutputStream os = new ByteArrayOutputStream();
        System.setOut(new PrintStream(os));

        Method usage = Anagram.class.getDeclaredMethod("usage");
        usage.setAccessible(true);
        usage.invoke(null);

        System.setOut(sysOut);
        os.close();
        String out = os.toString();

        Assert.assertTrue(out.contains("Usage:"));
        Assert.assertTrue(out.contains("\tjava -cp AnagramSolver.jar com.parthparekh.algorithms.AnagramSolver <absolute_path_to_wordlist_file> <min_word_length> <words_for_anagram_search>"));
        Assert.assertTrue(out.contains("\n\n") || out.contains("\n\r"));
    }

    @Test
    public void testFindAnagram() throws IOException {
        PrintStream sysOut = System.out;
        ByteArrayOutputStream os = new ByteArrayOutputStream();
        System.setOut(new PrintStream(os));

        Anagram anagram = new Anagram(3, "wordlist.txt");
        Set<Set<String>> result = anagram.findAllAnagrams("listen");

        System.setOut(sysOut);
        os.close();
        String out = os.toString();

        Assert.assertEquals(10, result.size());
        Assert.assertTrue(out.contains("([enlist inlets listen silent tinsel])"));
        Assert.assertTrue(out.contains("[tinsel]"));
        Assert.assertTrue(out.contains("([let])"));
        Assert.assertTrue(out.contains("[let ins]"));
    }
}
