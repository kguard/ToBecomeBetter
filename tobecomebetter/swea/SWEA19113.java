package com.kguard.tobecomebetter.swea;

import java.util.ArrayList;
import java.util.Scanner;

public class SWEA19113 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int tc = sc.nextInt();
        for (int i = 1; i <= tc; i++) {
            int n = sc.nextInt();
            ArrayList<Long> list = new ArrayList<>();
            ArrayList<Long> result = new ArrayList<>();
            for (int j = 0; j < 2 * n; j++) {
                list.add(sc.nextLong());
            }
            for (int j = 0; j < 2 * n; j++) {
                if (list.get(j) == 0L) continue;
                if (list.get(j) % 4 == 0 && list.contains(list.get(j) * 3 / 4)) {
                    result.add(list.get(j) * 3 / 4);
                    list.set(list.indexOf(list.get(j) * 3 / 4), 0L);
                    list.set(j, 0L);
                }
            }
            System.out.print("#" + i + " ");
            for (int j = 0; j < n; j++) {
                System.out.print(result.get(j) + " ");
            }
            System.out.println();
        }
    }
}
