package com.kguard.tobecomebetter.swea;

import java.util.Scanner;

public class SWEA18662 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int tc = sc.nextInt();
        for (int i = 1; i <= tc; i++) {
            int a = sc.nextInt();
            int b = sc.nextInt();
            int c = sc.nextInt();
            System.out.println("#" + i + " " + Math.abs(((c - b) - (b - a)) / 2.0));
        }
    }
}
