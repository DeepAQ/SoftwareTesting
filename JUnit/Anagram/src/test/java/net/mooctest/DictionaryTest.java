package net.mooctest;

import org.junit.Assert;
import org.junit.Test;

import java.io.IOException;

public class DictionaryTest {
    @Test
    public void testLoad() throws IOException {
        Dictionary dict = new Dictionary();
        Assert.assertFalse(dict.isDictionaryLoaded());
        dict.loadDictionary("wordlist.txt");
        Assert.assertTrue(dict.isDictionaryLoaded());
    }

    @Test
    public void testLoadInvalid() throws IOException {
        Dictionary dict = new Dictionary();
        Assert.assertFalse(dict.isDictionaryLoaded());

        try {
            dict.loadDictionary(null);
            Assert.fail();
        } catch (IllegalArgumentException e) {
            Assert.assertEquals("file path invalid", e.getMessage());
        }
        Assert.assertFalse(dict.isDictionaryLoaded());

        try {
            dict.loadDictionary("");
            Assert.fail();
        } catch (IllegalArgumentException e) {
            Assert.assertEquals("file path invalid", e.getMessage());
        }
        Assert.assertFalse(dict.isDictionaryLoaded());

        try {
            dict.loadDictionary("???");
            Assert.fail();
        } catch (IOException e) {
        }
        Assert.assertFalse(dict.isDictionaryLoaded());
    }

    @Test
    public void testAddWords() throws IOException {
        Dictionary dict = new Dictionary();
        Assert.assertEquals("isDictionaryLoaded?: false\nDictionary: {}", dict.toString());
        try {
            dict.addWord(null);
            Assert.fail();
        } catch (NullPointerException e) {
        }
        Assert.assertFalse(dict.addWord(""));
        Assert.assertEquals(0, dict.getDictionaryKeyList().size());

        Assert.assertTrue(dict.addWord("listen"));
        Assert.assertEquals(1, dict.getDictionaryKeyList().size());
        Assert.assertTrue(dict.addWord("tinsel"));
        Assert.assertEquals(1, dict.getDictionaryKeyList().size());
        Assert.assertEquals("eilnst", dict.getDictionaryKeyList().get(0));

        Assert.assertTrue(dict.addWord("apple"));
        Assert.assertEquals(2, dict.getDictionaryKeyList().size());
        Assert.assertEquals("aelpp", dict.getDictionaryKeyList().get(0));
    }

    @Test
    public void testIllegalStates() throws IOException {
        Dictionary dict = new Dictionary();
        try {
            dict.findSingleWordAnagrams("test");
            Assert.fail();
        } catch (IllegalStateException e) {
            Assert.assertEquals("dictionary not loaded", e.getMessage());
        }

        dict.loadDictionary("wordlist.txt");
        try {
            dict.findSingleWordAnagrams("");
            Assert.fail();
        } catch (IllegalStateException e) {
            Assert.assertEquals("word string invalid", e.getMessage());
        }
        try {
            dict.findSingleWordAnagrams(null);
            Assert.fail();
        } catch (IllegalStateException e) {
            Assert.assertEquals("word string invalid", e.getMessage());
        }
    }
}
