package com.kguard.tobecomebetter.swea;

import java.util.Scanner;

public class SWEA20551 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int T = sc.nextInt();
        for (int i = 0; i < T; i++) {
            int a = sc.nextInt();
            int b = sc.nextInt();
            int c = sc.nextInt();
            int count = 0;
            if (b >= c) {
                count += b - c + 1;
                b -= count;
            }
            if (a >= b) {
                count += a - b + 1;
                a -= count;
            }
            if (a <= 0 || b <= 0)
                count = -1;
            System.out.println("#" + (i + 1) + " " + count);
        }
    }
}
