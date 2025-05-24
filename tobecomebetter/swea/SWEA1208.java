package com.kguard.tobecomebetter.swea;

import java.util.*;
// 1208. [S/W 문제해결 기본] 1일차 - Flatten D3
public class SWEA1208 {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        for (int i = 1; i <= 10; i++) {
            int dump = sc.nextInt();
            String buffer = sc.nextLine();
            int[] nums = Arrays.stream(sc.nextLine().split(" ")).mapToInt(Integer::parseInt).toArray();
            Arrays.sort(nums);
            while (dump > 0) {
                if (nums[99] - nums[0] > 1) {
                    nums[0]++;
                    nums[99]--;
                    Arrays.sort(nums);
                } else {
                    break;
                }
                dump--;
            }
            System.out.println("#" + i + " " + (nums[99] - nums[0]));
        }
    }
}
