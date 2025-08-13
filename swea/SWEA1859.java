package com.kguard.tobecomebetter.swea;

import java.util.*;

// 백만 장자 프로젝트 D2 *
public class SWEA1859 {
    public static void main(String[] args) throws Exception {
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();
        for (int i = 1; i <= t; i++) {
            int n = sc.nextInt();
            long[] c = new long[n];
            for (int j = 0; j < n; j++) {
                c[j] = sc.nextLong();
            }
//			long sum = Arrays.stream(c).sum();
            long max = 0;
            long benefit = 0;
            // 꼭 하루에 다 팔 필요가 없음 5일을 다이
            // 1 1 3 1 2 일때, 1,2일에 사고, 3일에 판다음, 4일에 사고, 5일에 팔면 5의 이득을 볼 수 있음
            for (int k = n - 1; k >= 0; k--) {
                if (max < c[k])
                    max = c[k];
                else
                    benefit += max - c[k];
            }
            System.out.println("#" + i + " " + benefit);
        }
    }
}
