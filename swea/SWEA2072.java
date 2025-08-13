package com.kguard.tobecomebetter.swea;

import java.util.Scanner;

// 홀수만 더하기 D1

class SWEA2072 {
    public static void main(String[] args) throws Exception {
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();
        for (int i = 1; i <= t; i++) {
            int sum = 0;
            for (int j = 0; j < 10; j++) {
                int n = sc.nextInt();
                if (n % 2 == 1)
                    sum += n;
            }
            System.out.println("#" + i + " " + sum);
        }
    }
}


