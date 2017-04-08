package com.google.codejam.rounds.qualification;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;
import java.util.TreeSet;

import static java.lang.Math.max;
import static java.lang.Math.min;

/**
 * Created by dmytro on 09.04.17.
 */
public class C {
    public static void main(String[] args) {
        Scanner in = new Scanner(new BufferedReader(new InputStreamReader(System.in)));
        int t = in.nextInt();  // Scanner has functions to read ints, longs, strings, chars, etc.
        for (int i = 1; i <= t; ++i) {
            long n = in.nextLong();
            long m = in.nextLong();
            long[] res = solve(n, m);
            System.out.println("Case #" + i + ": " + res[0] + " " + res[1]);
        }
    }

    public static long[] solve(long n, long m) {
        long[] result = new long[2];
        TreeSet<Long> sorted = new TreeSet<>();
        sorted.add(-n);
        Map<Long, Long> counts = new HashMap<>();

        counts.put(n, 1L);
        long i = 0L;
        while (i < m) {
            long temp = -sorted.first();
            long[] val = getValue(temp);
            long tCount = 0L;
            if (counts.get(temp) != null) {
                tCount = counts.get(temp);
            }

            i += tCount;
            if (i > m - 1L) {
                result[0] = val[0];
                result[1] = val[1];
                return result;
            }
            if (counts.get(val[0]) != null) {
                counts.put(val[0], counts.get(val[0]) + tCount);
            } else {
                counts.put(val[0], tCount);
            }

            if (counts.get(val[1]) != null) {
                counts.put(val[1], counts.get(val[1]) + tCount);
            } else {
                counts.put(val[1], tCount);
            }

            counts.remove(temp);
            sorted.remove(-temp);
            sorted.add(-val[0]);
            sorted.add(-val[1]);

        }
        return result;
    }


    public static long[] getValue(long number) {
        return new long[]{max(max(number - number / 2L - 1L, number / 2L), 0L), max(min(number - number / 2L - 1L, number / 2L), 0L)};
    }
}
