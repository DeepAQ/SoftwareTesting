import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

public class SuffixArrayTest {

    @Before
    public void setUp() throws Exception {
    }

    @After
    public void tearDown() throws Exception {
    }

    @Test
    public void testConstruct() {
        new SuffixArray();
    }

    @Test
    public void testSuffixArray() {
        String str = "AABBBCCDD";
        int[] sa = new int[str.length()];
        int[] lcp = new int[str.length()];
        SuffixArray.createSuffixArray(str, sa, lcp);
        int[] sa2 = new int[str.length()];
        int[] lcp2 = new int[str.length()];
        SuffixArray2.createSuffixArray(str, sa2, lcp2);
        assertArrayEquals(sa2, sa);
        assertArrayEquals(lcp2, lcp);
    }

    @Test
    public void testSuffixArraySlow() {
        String str = "N&Yn48rnN&*$Y";
        int[] sa = new int[str.length()];
        int[] lcp = new int[str.length()];
        SuffixArray.createSuffixArraySlow(str, sa, lcp);
        SuffixArray.printV(sa, "sa");
        int[] sa2 = new int[str.length()];
        int[] lcp2 = new int[str.length()];
        SuffixArray2.createSuffixArray(str, sa2, lcp2);
        assertArrayEquals(sa2, sa);
        assertArrayEquals(lcp2, lcp);
    }

    @Test
    public void testSuffixArraySlowIllegal() {
        String str = "N&Yn48rnN&*$Y";
        int[] sa = new int[str.length() + 1];
        int[] lcp = new int[str.length() + 1];
        try {
            SuffixArray.createSuffixArraySlow(str, sa, lcp);
            fail();
        } catch (IllegalArgumentException e) {
        }
        sa = new int[str.length()];
        try {
            SuffixArray.createSuffixArraySlow(str, sa, lcp);
            fail();
        } catch (IllegalArgumentException e) {
        }
    }

    @Test
    public void testPermutation() {
        assertTrue(SuffixArray.isPermutation(new int[]{0, 1, 2, 3, 4, 5}, 6));
        assertFalse(SuffixArray.isPermutation(new int[]{0, 0, 2, 3, 4, 5}, 6));
    }

    @Test
    public void testSleq() {
        assertTrue(SuffixArray.sleq(new int[]{1, 2, 3}, 0, new int[]{2, 3, 4}, 0));
        assertFalse(SuffixArray.sleq(new int[]{2, 3, 4}, 0, new int[]{1, 2, 3}, 0));
        assertFalse(SuffixArray.sleq(new int[]{2, 3, 4}, 0, new int[]{2, 2, 3}, 0));
    }

    @Test
    public void testSorted() {
        assertTrue(SuffixArray.isSorted(new int[]{0, 1, 2}, new int[]{1, 2, 3}, 3));
        assertFalse(SuffixArray.isSorted(new int[]{0, 1, 2}, new int[]{1, 2, 1}, 3));
    }

    @Test
    public void testComputeLCP() {
        assertEquals(SuffixArray2.computeLCP("G*&&Nb4nr7", "*M#7nnbg"), SuffixArray.computeLCP("G*&&Nb4nr7", "*M#7nnbg"));
    }

    private static class SuffixArray2 {
        public static void makeLCPArray(int[] s, int[] sa, int[] LCP) {
            int N = sa.length;
            int[] rank = new int[N];

            s[N] = -1;
            for (int i = 0; i < N; i++)
                rank[sa[i]] = i;

            int h = 0;
            for (int i = 0; i < N; i++)
                if (rank[i] > 0) {
                    int j = sa[rank[i] - 1];

                    while (s[i + h] == s[j + h])
                        h++;

                    LCP[rank[i]] = h;
                    if (h > 0)
                        h--;
                }
        }

        public static void createSuffixArray(String str, int[] sa, int[] LCP) {
            int N = str.length();

            int[] s = new int[N + 3];
            int[] SA = new int[N + 3];

            for (int i = 0; i < N; i++)
                s[i] = str.charAt(i);

            makeSuffixArray(s, SA, N, 256);

            for (int i = 0; i < N; i++)
                sa[i] = SA[i];

            makeLCPArray(s, sa, LCP);
        }

        public static void makeSuffixArray(int[] s, int[] SA, int n, int K) {
            int n0 = (n + 2) / 3;
            int n1 = (n + 1) / 3;
            int n2 = n / 3;
            int t = n0 - n1;  // 1 iff n%3 == 1
            int n12 = n1 + n2 + t;

            int[] s12 = new int[n12 + 3];
            int[] SA12 = new int[n12 + 3];
            int[] s0 = new int[n0];
            int[] SA0 = new int[n0];

            // generate positions in s for items in s12
            // the "+t" adds a dummy mod 1 suffix if n%3 == 1
            // at that point, the size of s12 is n12
            for (int i = 0, j = 0; i < n + t; i++)
                if (i % 3 != 0)
                    s12[j++] = i;

            int K12 = assignNames(s, s12, SA12, n0, n12, K);

            computeS12(s12, SA12, n12, K12);
            computeS0(s, s0, SA0, SA12, n0, n12, K);
            merge(s, s12, SA, SA0, SA12, n, n0, n12, t);
        }

        private static int assignNames(int[] s, int[] s12, int[] SA12,
                                       int n0, int n12, int K) {
            // radix sort the new character trios
            radixPass(s12, SA12, s, 2, n12, K);
            radixPass(SA12, s12, s, 1, n12, K);
            radixPass(s12, SA12, s, 0, n12, K);

            // find lexicographic names of triples
            int name = 0;
            int c0 = -1, c1 = -1, c2 = -1;

            for (int i = 0; i < n12; i++) {
                if (s[SA12[i]] != c0 || s[SA12[i] + 1] != c1
                        || s[SA12[i] + 2] != c2) {
                    name++;
                    c0 = s[SA12[i]];
                    c1 = s[SA12[i] + 1];
                    c2 = s[SA12[i] + 2];
                }

                if (SA12[i] % 3 == 1)
                    s12[SA12[i] / 3] = name;
                else
                    s12[SA12[i] / 3 + n0] = name;
            }

            return name;
        }

        private static void radixPass(int[] in, int[] out, int[] s, int offset,
                                      int n, int K) {
            int[] count = new int[K + 2];            // counter array

            for (int i = 0; i < n; i++)
                count[s[in[i] + offset] + 1]++;    // count occurences

            for (int i = 1; i <= K + 1; i++)            // compute exclusive sums
                count[i] += count[i - 1];

            for (int i = 0; i < n; i++)
                out[count[s[in[i] + offset]]++] = in[i];      // sort
        }

        private static void radixPass(int[] in, int[] out, int[] s, int n, int K) {
            radixPass(in, out, s, 0, n, K);
        }

        private static void computeS12(int[] s12, int[] SA12, int n12, int K12) {
            if (K12 == n12) // if unique names, don't need recursion
                for (int i = 0; i < n12; i++)
                    SA12[s12[i] - 1] = i;
            else {
                makeSuffixArray(s12, SA12, n12, K12);
                // store unique names in s12 using the suffix array 
                for (int i = 0; i < n12; i++)
                    s12[SA12[i]] = i + 1;
            }
        }

        private static void computeS0(int[] s, int[] s0, int[] SA0, int[] SA12,
                                      int n0, int n12, int K) {
            for (int i = 0, j = 0; i < n12; i++)
                if (SA12[i] < n0)
                    s0[j++] = 3 * SA12[i];

            radixPass(s0, SA0, s, n0, K);
        }

        private static void merge(int[] s, int[] s12,
                                  int[] SA, int[] SA0, int[] SA12,
                                  int n, int n0, int n12, int t) {
            int p = 0, k = 0;

            while (t != n12 && p != n0) {
                int i = getIndexIntoS(SA12, t, n0); // S12
                int j = SA0[p];                     // S0

                if (suffix12IsSmaller(s, s12, SA12, n0, i, j, t)) {
                    SA[k++] = i;
                    t++;
                } else {
                    SA[k++] = j;
                    p++;
                }
            }

            while (p < n0)
                SA[k++] = SA0[p++];
            while (t < n12)
                SA[k++] = getIndexIntoS(SA12, t++, n0);
        }

        private static int getIndexIntoS(int[] SA12, int t, int n0) {
            if (SA12[t] < n0)
                return SA12[t] * 3 + 1;
            else
                return (SA12[t] - n0) * 3 + 2;
        }

        private static boolean leq(int a1, int a2, int b1, int b2) {
            return a1 < b1 || a1 == b1 && a2 <= b2;
        }

        private static boolean leq(int a1, int a2, int a3, int b1, int b2, int b3) {
            return a1 < b1 || a1 == b1 && leq(a2, a3, b2, b3);
        }

        private static boolean suffix12IsSmaller(int[] s, int[] s12, int[] SA12,
                                                 int n0, int i, int j, int t) {
            if (SA12[t] < n0)  // s1 vs s0; can break tie after 1 character
                return leq(s[i], s12[SA12[t] + n0],
                        s[j], s12[j / 3]);
            else                  // s2 vs s0; can break tie after 2 characters
                return leq(s[i], s[i + 1], s12[SA12[t] - n0 + 1],
                        s[j], s[j + 1], s12[j / 3 + n0]);
        }

        public static int computeLCP(String s1, String s2) {
            int i = 0;

            while (i < s1.length() && i < s2.length() && s1.charAt(i) == s2.charAt(i))
                i++;

            return i;
        }
    }
}
