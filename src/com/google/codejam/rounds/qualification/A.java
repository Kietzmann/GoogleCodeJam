package com.google.codejam.rounds.qualification;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Scanner;


public class A {
    public static void main(String[] args) {
        Scanner in = new Scanner(new BufferedReader(new InputStreamReader(System.in)));
        int n = in.nextInt();
        for (int i = 0; i < n; i++) {
            String temp = in.next();
            int nums = in.nextInt();
            System.out.println("Case #" + (i + 1) + ": " + solve(temp, nums));


        }
    }

    public static String solve(String line, int times) {
        int counter = 0;
        char[] symb = line.toCharArray();
        for (int i = 0; i < symb.length; i++) {
            if (symb[i] == '-') {
                for (int j = i; j < times + i && j < symb.length && (i + times - 1) < symb.length; j++) {
                    if (symb[j] == '-') {
                        symb[j] = '+';
                    } else {
                        symb[j] = '-';
                    }
                }
                counter++;
            }
        }
        for (int i = 0; i < symb.length; i++) {
            if (symb[i] == '-') {
                return "IMPOSSIBLE";
            }
        }
        return String.valueOf(counter);
    }

}
