package net.mooctest;

import org.junit.Assert;
import org.junit.Test;

import java.io.IOException;
import java.lang.reflect.Method;
import java.util.Collections;
import java.util.List;
import java.util.Set;

public class HelperTest {
    @Test
    public void testAssertNonNull() throws IOException {
        try {
            Helper.setDifference(null, null);
        } catch (Throwable t) {
            return;
        }
        Assert.fail();
    }

    @Test
    public void testToCharArray() throws Exception {
        Method toCharArray = Helper.class.getDeclaredMethod("toCharArray", List.class);
        toCharArray.setAccessible(true);
        Assert.assertEquals(0, ((char[]) toCharArray.invoke(null, new Object[]{null})).length);
        Assert.assertEquals(0, ((char[]) toCharArray.invoke(null, Collections.emptyList())).length);
    }

    @Test
    public void testSetMultiplication() throws Exception {
        Method setMultiplication = Helper.class.getDeclaredMethod("setMultiplication", Set[].class);
        Assert.assertNull(setMultiplication.invoke(null, new Object[]{null}));
        Assert.assertNull(setMultiplication.invoke(null, new Object[]{new Set[0]}));
    }
}
