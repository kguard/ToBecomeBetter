package com.kguard.tobecomebetter.swea;


import java.util.Scanner;

// 거듭제곱
// D3
public class SWEA1217 {
    static int result, N, M;

    static void pow(int cnt, int n) {
        if (cnt == M) {
            result = n;
            return;
        }
        pow(cnt + 1, n * N);
    }

    public static void main(String[] args) throws Exception {
        Scanner sc = new Scanner(System.in);
        for (int tc = 1; tc <= 10; tc++) {
            sc.nextInt();
            N = sc.nextInt();
            M = sc.nextInt();
            result = 0;
            pow(0, 1);
            System.out.println("#" + tc + " " + result);
        }
        sc.close();
    }

}
