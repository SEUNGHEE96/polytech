package com.example;

import java.util.Scanner;

public class Algorithm {

    private static int a;
    private static int b;
    private static int R;
    private static Scanner sc;

    public static void main(String[] args) {
        sc = new Scanner(System.in);
        a = sc.nextInt();
        b = sc.nextInt();
        R = sc.nextInt();

        int N = sc.nextInt();
        String[] result = inputCase(N);
        print(result);
    }

    private static String[] inputCase(int N) {
        String[] result = new String[N];
        for (int i = 0; i < N; i++) {
            int x = sc.nextInt();
            int y = sc.nextInt();
            result[i] = checkSpot(x, y);
        }
        return result;
    }

    private static String checkSpot(int x, int y) {
        String result = "silent";
        double check = Math.pow((x - a), 2) + Math.pow((y - b), 2);
        if (check < Math.pow(R, 2)) {
            result = "noisy";
        }
        return result;
    }

    private static void print(String[] result) {
        for (String s : result) {
            System.out.println(s);
        }
    }

}
