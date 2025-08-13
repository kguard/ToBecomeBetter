package com.kguard.tobecomebetter.swea;

import java.util.*;
// 로봇 언어
// D3
public class SWEA24001 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();
        for (int i = 0; i < t; i++) {
            int max = 0;
            int countL = 0;
            int countR = 0;
            String line = sc.next();
            for (String s : line.split("")) {
                if (s.equals("L")) {
                    countL++;
                    countR--;
                } else if (s.equals("R")) {
                    countR++;
                    countL--;
                } else {
                    countR++;
                    countL++;
                }
                max = Math.max(max, countR);
                max = Math.max(max, countL);
            }
            System.out.println(max);
        }
    }
}
