package com.google.codejam.rounds.oneb;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Scanner;

public class A {
    public static void main(String[] args) {
        Scanner in = new Scanner(new BufferedReader(new InputStreamReader(System.in)));
        int t = in.nextInt();  // Scanner has functions to read ints, longs, strings, chars, etc.
        for (int i = 1; i <= t; ++i)

        {
            int lenght = in.nextInt();
            int m = in.nextInt();
            double time = -1;
            for (int j = 0; j < m; ++j) {
                int coord = in.nextInt();
                int speed = in.nextInt();
                double ttime = ((double) lenght - coord) / ((double) speed);
                if (time < 0 || time < ttime) {
                    time = ttime;
                }
            }
            System.out.println("Case #" + i + ": " + String.format("%.6f", (double) lenght / time));
        }
    }
}
