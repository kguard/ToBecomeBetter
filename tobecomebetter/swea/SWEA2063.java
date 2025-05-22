package com.kguard.tobecomebetter.swea;

import java.util.*;

// 2063. 중간값 찾기 D1
public class SWEA2063 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        String buffer = sc.nextLine();
        int[] num = Arrays.stream(sc.nextLine().split(" ")).mapToInt(Integer::parseInt).toArray();
        Arrays.sort(num);
        System.out.println(num[n / 2]);
    }
}
