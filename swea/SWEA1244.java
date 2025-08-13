package com.kguard.tobecomebetter.swea;

import java.util.*;

// 1244. [S/W 문제해결 응용] 2일차 - 최대 상금 D3 *
// 백트래킹을 사용해서 모든 경우의 수를 탐색해야 하는 문제 -> 이해하는데 오래 걸렸음
public class SWEA1244 {
    static int[] nums;
    static int change;
    static int max;

    public static void main(String[] args) throws Exception {
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();
        for (int i = 1; i <= t; i++) {
            nums = Arrays.stream(sc.next().split("")).mapToInt(Integer::parseInt).toArray();
            change = sc.nextInt();
            if(change > nums.length)
                change = nums.length;
            max = 0;
            backtracking(0, 0);
            System.out.println("#" + i + " " + max);
        }
    }
    static void backtracking(int start, int depth) {
        if (depth == change) {
            max = Math.max(max, Integer.parseInt(Arrays.toString(nums).replaceAll("[^0-9]", "")));
            return;
        }
        for (int i = start; i < nums.length; i++)
            for (int j = i + 1; j < nums.length; j++) {
                swap(i, j);
                backtracking(i, depth + 1);
                swap(i, j);
            }
    }

    static void swap(int a, int b) {
        int s = nums[a];
        nums[a] = nums[b];
        nums[b] = s;
    }
}