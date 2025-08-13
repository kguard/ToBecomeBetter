package com.kguard.tobecomebetter.swea;

import java.util.Scanner;

public class SWEA17642 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int tc = sc.nextInt();
        for (int i = 1; i <= tc; i++) {
            Long a = sc.nextLong();
            Long b = sc.nextLong();
            if (b - a == 1 || b - a < 0) System.out.println("#" + i + " " + -1);
            else {
                if ((b - a) % 2 == 0) {
                    System.out.println("#" + i + " " + ((b - a) / 2));
                } else {
                    System.out.println("#" + i + " " + ((b - a - 1) / 2));
                }
            }
        }
    }
}
