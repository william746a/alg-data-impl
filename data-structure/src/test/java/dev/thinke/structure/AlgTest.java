package dev.thinke.structure;

import org.junit.jupiter.api.Test;

public class AlgTest {

    @Test
    void testFib() {
        final var iterativeStart = System.currentTimeMillis();
        System.out.println(fibIt(10000));
        final var iterativeTotal = System.currentTimeMillis() - iterativeStart;
        System.out.println("Iterative total: " + iterativeTotal);

        final var recursiveStart = System.currentTimeMillis();
        System.out.println(fibRec(10000));
        final var recursiveTotal = System.currentTimeMillis() - recursiveStart;
        System.out.println("Recursive total: " + recursiveTotal);
    }

    private long fibRec(int n) {
        if (n == 0) return n;
        return fibRec(0, 1, n);
    }

    private long fibRec(long x, long y, int i) {
        if (i <= 2) return y;
        else return fibRec(y, x + y, i - 1);
    }

    private long fibIt(int n) {
        if (n == 0) return n;
        return fibIt(0, 1, n);
    }

    private long fibIt(long x, long y, int i) {
        while (i > 2) {
            long t = x;
            x = y;
            y = t + y;
            i--;
        }
        return y;
    }
}
