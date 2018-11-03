package net.mooctest;

import org.junit.Test;

import static org.junit.Assert.*;

// import static org.evosuite.runtime.EvoAssertions.verifyException;

public class IntegerBloomFilter_ESTest {

    @Test(timeout = 4000)
    public void test00() throws Throwable {
        int int0 = (-6001);
        IntegerBloomFilter integerBloomFilter0 = new IntegerBloomFilter(0, (-6001), 1036);
        integerBloomFilter0.clear();
        integerBloomFilter0.clear();
        integerBloomFilter0.getFilterSize();
        integerBloomFilter0.clear();
        int int1 = (-1995);
        integerBloomFilter0.clear();
        integerBloomFilter0.clear();
        integerBloomFilter0.clear();
        integerBloomFilter0.clear();
        // Undeclared exception!
        try {
            integerBloomFilter0.contains((-1995));
            fail("Expecting exception: ArithmeticException");

        } catch (ArithmeticException e) {
            //
            // / by zero
            //
            // verifyException("net.mooctest.IntegerBloomFilter", e);
        }
    }

    @Test(timeout = 4000)
    public void test01() throws Throwable {
        IntegerBloomFilter integerBloomFilter0 = new IntegerBloomFilter((-3), (-3), 1);
        integerBloomFilter0.clear();
        integerBloomFilter0.clear();
        integerBloomFilter0.clear();
        integerBloomFilter0.add(0);
        integerBloomFilter0.getFalsePositiveProbability(1);
        integerBloomFilter0.getExpectedFalsePositiveProbability();
        integerBloomFilter0.getBitsPerElement();
        integerBloomFilter0.getFilterSize();
        integerBloomFilter0.getExpectedFalsePositiveProbability();
    }

    @Test(timeout = 4000)
    public void test02() throws Throwable {
        IntegerBloomFilter integerBloomFilter0 = new IntegerBloomFilter(1, 565, 2882);
        integerBloomFilter0.add((-3874));
        integerBloomFilter0.clear();
        integerBloomFilter0.contains((-249));
        integerBloomFilter0.clear();
        integerBloomFilter0.add((-249));
        integerBloomFilter0.getBitsPerElement();
        integerBloomFilter0.clear();
        // Undeclared exception!
        integerBloomFilter0.contains(2123);
    }

    @Test(timeout = 4000)
    public void test03() throws Throwable {
        IntegerBloomFilter integerBloomFilter0 = new IntegerBloomFilter((-1878), (-1878), (-1878));
        integerBloomFilter0.clear();
        integerBloomFilter0.getTotalHashFunctions();
        // Undeclared exception!
        try {
            integerBloomFilter0.contains((-1878));
            fail("Expecting exception: NegativeArraySizeException");

        } catch (NegativeArraySizeException e) {
            //
            // no message in exception (getMessage() returned null)
            //
            // verifyException("net.mooctest.IntegerBloomFilter", e);
        }
    }

    @Test(timeout = 4000)
    public void test04() throws Throwable {
        IntegerBloomFilter integerBloomFilter0 = new IntegerBloomFilter(2538, 2538, 2538);
        integerBloomFilter0.clear();
        integerBloomFilter0.getCurrentFalsePositiveProbability();
        integerBloomFilter0.clear();
        integerBloomFilter0.clear();
        integerBloomFilter0.getTotalHashFunctions();
        integerBloomFilter0.getExpectedFalsePositiveProbability();
        integerBloomFilter0.clear();
        integerBloomFilter0.add(2538);
        integerBloomFilter0.add((-91));
        integerBloomFilter0.getFalsePositiveProbability((-1.0));
        integerBloomFilter0.getBitsPerElement();
        integerBloomFilter0.add((-2988));
        integerBloomFilter0.getExpectedFalsePositiveProbability();
        integerBloomFilter0.getCurrentFalsePositiveProbability();
        integerBloomFilter0.getCurrentFalsePositiveProbability();
        // Undeclared exception!
        integerBloomFilter0.add(2538);
    }

    @Test(timeout = 4000)
    public void test05() throws Throwable {
        int int0 = 0;
        IntegerBloomFilter integerBloomFilter0 = new IntegerBloomFilter(2286.44187, 0);
        // Undeclared exception!
        try {
            integerBloomFilter0.add(0);
            fail("Expecting exception: NegativeArraySizeException");

        } catch (NegativeArraySizeException e) {
            //
            // no message in exception (getMessage() returned null)
            //
            // verifyException("net.mooctest.IntegerBloomFilter", e);
        }
    }

    @Test(timeout = 4000)
    public void test06() throws Throwable {
        IntegerBloomFilter integerBloomFilter0 = null;
        try {
            integerBloomFilter0 = new IntegerBloomFilter(0.0, (-1201));
            fail("Expecting exception: NegativeArraySizeException");

        } catch (NegativeArraySizeException e) {
            //
            // nbits < 0: -2147482447
            //
            // verifyException("java.util.BitSet", e);
        }
    }

    @Test(timeout = 4000)
    public void test07() throws Throwable {
        IntegerBloomFilter integerBloomFilter0 = new IntegerBloomFilter((-4094.0092576), 1);
        integerBloomFilter0.add(1);
        integerBloomFilter0.add((-1701));
        integerBloomFilter0.getBitsPerElement();
        integerBloomFilter0.getTotalHashFunctions();
        integerBloomFilter0.getFilterSize();
        integerBloomFilter0.getCurrentFalsePositiveProbability();
        integerBloomFilter0.getCurrentFalsePositiveProbability();
        integerBloomFilter0.getBitsPerElement();
    }

    @Test(timeout = 4000)
    public void test08() throws Throwable {
        int int0 = (-3599);
        IntegerBloomFilter integerBloomFilter0 = null;
        try {
            integerBloomFilter0 = new IntegerBloomFilter(1329, (-3599), 1329);
            fail("Expecting exception: NegativeArraySizeException");

        } catch (NegativeArraySizeException e) {
            //
            // nbits < 0: -4783071
            //
            // verifyException("java.util.BitSet", e);
        }
    }

    @Test(timeout = 4000)
    public void test09() throws Throwable {
        int int0 = 701;
        IntegerBloomFilter integerBloomFilter0 = new IntegerBloomFilter(0, 0, 701);
        integerBloomFilter0.clear();
        integerBloomFilter0.clear();
        // Undeclared exception!
        try {
            integerBloomFilter0.add(0);
            fail("Expecting exception: ArithmeticException");

        } catch (ArithmeticException e) {
            //
            // / by zero
            //
            // verifyException("net.mooctest.IntegerBloomFilter", e);
        }
    }

    @Test(timeout = 4000)
    public void test10() throws Throwable {
        IntegerBloomFilter integerBloomFilter0 = new IntegerBloomFilter((-2345), (-2345), 1435);
        integerBloomFilter0.add((-2345));
        integerBloomFilter0.add(0);
        integerBloomFilter0.contains(1435);
        integerBloomFilter0.clear();
        integerBloomFilter0.getCurrentFalsePositiveProbability();
        integerBloomFilter0.getFalsePositiveProbability(3158.8709414451832);
        integerBloomFilter0.getFalsePositiveProbability(3943.30366499735);
    }

    @Test(timeout = 4000)
    public void test11() throws Throwable {
        IntegerBloomFilter integerBloomFilter0 = new IntegerBloomFilter((-1), (-1), (-1));
        integerBloomFilter0.getBitsPerElement();
        integerBloomFilter0.getFalsePositiveProbability((-1));
        // Undeclared exception!
        try {
            integerBloomFilter0.contains(1);
            fail("Expecting exception: NegativeArraySizeException");

        } catch (NegativeArraySizeException e) {
            //
            // no message in exception (getMessage() returned null)
            //
            // verifyException("net.mooctest.IntegerBloomFilter", e);
        }
    }

    @Test(timeout = 4000)
    public void test12() throws Throwable {
        // Random.setNextRandom(124);
        IntegerBloomFilter integerBloomFilter0 = new IntegerBloomFilter(124, 124, 124);
        integerBloomFilter0.clear();
        integerBloomFilter0.clear();
        integerBloomFilter0.getCurrentFalsePositiveProbability();
        integerBloomFilter0.getFilterSize();
        // Random.setNextRandom(1584);
        integerBloomFilter0.contains(1418);
    }

    @Test(timeout = 4000)
    public void test13() throws Throwable {
        IntegerBloomFilter integerBloomFilter0 = new IntegerBloomFilter((-4983.4879055474), (-883));
        integerBloomFilter0.add((-883));
        integerBloomFilter0.clear();
        integerBloomFilter0.add((-883));
        integerBloomFilter0.contains((-883));
        integerBloomFilter0.add(0);
        integerBloomFilter0.getExpectedFalsePositiveProbability();
        integerBloomFilter0.getExpectedFalsePositiveProbability();
    }

    @Test(timeout = 4000)
    public void test14() throws Throwable {
        IntegerBloomFilter integerBloomFilter0 = new IntegerBloomFilter(434, 434, 1296);
        integerBloomFilter0.add(1296);
        integerBloomFilter0.getTotalHashFunctions();
        integerBloomFilter0.getExpectedFalsePositiveProbability();
    }

    @Test(timeout = 4000)
    public void test15() throws Throwable {
        IntegerBloomFilter integerBloomFilter0 = new IntegerBloomFilter((-849.4082), (-1292));
        integerBloomFilter0.clear();
        integerBloomFilter0.getExpectedFalsePositiveProbability();
    }

    @Test(timeout = 4000)
    public void test16() throws Throwable {
        IntegerBloomFilter integerBloomFilter0 = new IntegerBloomFilter(19, 19, 1);
        integerBloomFilter0.clear();
        integerBloomFilter0.contains((-2546));
        integerBloomFilter0.clear();
        integerBloomFilter0.getFalsePositiveProbability((-2546));
        integerBloomFilter0.add((-2546));
        integerBloomFilter0.getBitsPerElement();
        integerBloomFilter0.clear();
    }

    @Test(timeout = 4000)
    public void test17() throws Throwable {
        IntegerBloomFilter integerBloomFilter0 = new IntegerBloomFilter((-1.0), (-863));
        integerBloomFilter0.contains(0);
        integerBloomFilter0.add(0);
    }

    @Test(timeout = 4000)
    public void test18() throws Throwable {
        IntegerBloomFilter integerBloomFilter0 = new IntegerBloomFilter(0, 0, 0);
        integerBloomFilter0.getCurrentFalsePositiveProbability();
    }

    @Test(timeout = 4000)
    public void test19() throws Throwable {
        IntegerBloomFilter integerBloomFilter0 = new IntegerBloomFilter(0, 0, 0);
        integerBloomFilter0.add(0);
        integerBloomFilter0.getTotalHashFunctions();
    }

    @Test(timeout = 4000)
    public void test20() throws Throwable {
        IntegerBloomFilter integerBloomFilter0 = new IntegerBloomFilter(0, 0, 255);
        // Undeclared exception!
        try {
            integerBloomFilter0.add(255);
            fail("Expecting exception: ArithmeticException");

        } catch (ArithmeticException e) {
            //
            // / by zero
            //
            // verifyException("net.mooctest.IntegerBloomFilter", e);
        }
    }

    @Test(timeout = 4000)
    public void test21() throws Throwable {
        IntegerBloomFilter integerBloomFilter0 = new IntegerBloomFilter(4278.0, (-1));
        // Undeclared exception!
        try {
            integerBloomFilter0.contains((-1));
            fail("Expecting exception: NegativeArraySizeException");

        } catch (NegativeArraySizeException e) {
            //
            // no message in exception (getMessage() returned null)
            //
            // verifyException("net.mooctest.IntegerBloomFilter", e);
        }
    }

    @Test(timeout = 4000)
    public void test22() throws Throwable {
        IntegerBloomFilter integerBloomFilter0 = new IntegerBloomFilter(1268.657799746, (-468));
        integerBloomFilter0.clear();
    }

    @Test(timeout = 4000)
    public void test23() throws Throwable {
        IntegerBloomFilter integerBloomFilter0 = new IntegerBloomFilter((-1.0), (-310));
        integerBloomFilter0.getCurrentFalsePositiveProbability();
        integerBloomFilter0.contains(68);
    }

    @Test(timeout = 4000)
    public void test24() throws Throwable {
        // Random.setNextRandom((-2558));
        IntegerBloomFilter integerBloomFilter0 = new IntegerBloomFilter(1, 689, 662);
        integerBloomFilter0.add((-146));
        integerBloomFilter0.clear();
        integerBloomFilter0.add((-146));
        integerBloomFilter0.add(689);
        integerBloomFilter0.clear();
        integerBloomFilter0.getFilterSize();
        integerBloomFilter0.add((-3737));
        integerBloomFilter0.contains(701);
        integerBloomFilter0.contains(700);
        integerBloomFilter0.add(0);
        integerBloomFilter0.add(0);
        integerBloomFilter0.getFilterSize();
        int int0 = integerBloomFilter0.getFilterSize();
        assertEquals(2.7042853291633306E-17, integerBloomFilter0.getCurrentFalsePositiveProbability(), 0.01);
        assertEquals(689, int0);
    }

    @Test(timeout = 4000)
    public void test25() throws Throwable {
        IntegerBloomFilter integerBloomFilter0 = new IntegerBloomFilter(4414.708636785823, 0);
        double double0 = integerBloomFilter0.getExpectedFalsePositiveProbability();
        assertEquals(Double.NaN, integerBloomFilter0.getCurrentFalsePositiveProbability(), 0.01);
        assertEquals((-17), integerBloomFilter0.getBitsPerElement());
        assertEquals((-12), integerBloomFilter0.getTotalHashFunctions());
        assertEquals(Double.NaN, double0, 0.01);
    }

    @Test(timeout = 4000)
    public void test26() throws Throwable {
        IntegerBloomFilter integerBloomFilter0 = new IntegerBloomFilter(0, 0, 0);
        int int0 = integerBloomFilter0.getTotalHashFunctions();
        int int1 = integerBloomFilter0.getBitsPerElement();
        assertTrue(int1 == int0);
        assertEquals(0, int1);
    }
}
