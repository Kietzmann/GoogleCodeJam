package com.google.codejam.rounds.qualification;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.Scanner;
import java.util.StringTokenizer;

public class B {
    public static void main(String[] args) {

        Scanner in = new Scanner(new BufferedReader(new InputStreamReader(System.in)));
        int n = in.nextInt();
        in.nextLine();
        System.out.println();
        for (int j = 0; j < n; j++) {
            String goal = in.next();
            char[] result = solve(goal);
            System.out.print("Case #" + (j + 1) + ": ");
            for (int i = 0; i < result.length; ++i) {
                if (result[i] == '0') {
                    continue;
                } else {
                    System.out.print(result[i]);
                }
            }
            System.out.print('\n');
        }
    }

    public static char[] solve(String line) {
        char[] nums = line.toCharArray();
        for (int i = nums.length - 2; i >= 0; --i) {
            if (nums[i] > nums[i + 1]) {
                --nums[i];
                for (int j = i + 1; j < nums.length; j++) {
                    nums[j] = '9';
                }
            }
        }
        return nums;
    }
}
