package net.mooctest;

import org.junit.Test;

import java.util.Random;
import java.util.UUID;

import static org.junit.Assert.assertTrue;

public class MSDTest {

    @Test
    public void test() {
        Random rand = new Random();
        for (int i = 0; i < 100; i++) {
            int n = rand.nextInt(100) + 1;
            String[] s = new String[n];
            int[] t = new int[n];
            for (int j = 0; j < n; j++) {
                s[j] = UUID.randomUUID().toString().substring(0, rand.nextInt(36) + 1);
                t[j] = rand.nextInt(n * 10);
            }
            MSD.sort(s);
            MSD.sort(t);
            for (int j = 1; j < n; j++) {
                assertTrue(s[j].compareTo(s[j - 1]) >= 0);
                assertTrue(t[j] - t[j - 1] >= 0);
            }
        }
    }

}
