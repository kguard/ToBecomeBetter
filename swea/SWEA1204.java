package com.kguard.tobecomebetter.swea;

import java.util.*;

// 1204. [S/W 문제해결 기본] 1일차 - 최빈수 구하기 D2
public class SWEA1204 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int test_case = sc.nextInt();
        for (int i = 1; i <= test_case; i++) {
            int t = sc.nextInt();
            HashMap<Integer, Integer> score = new HashMap<Integer, Integer>();
            for (int k = 0; k < 1000; k++) {
                int s = sc.nextInt();
                if (!score.containsKey(s))
                    score.put(s, 1);
                else
                    score.replace(s, score.get(s) + 1);
            }
            int max = 0;
            int maxValue = Collections.max(score.values());
            for (int m : score.keySet()) {
                if (score.get(m) == maxValue)
                    max = Math.max(max, m);
            }
            System.out.println("#" + t + " " + max);
        }
    }
}