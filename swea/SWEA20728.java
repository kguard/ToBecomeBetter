package com.kguard.tobecomebetter.swea;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Scanner;

public class SWEA20728 {
    public static void main(String[] args) throws IOException {
        Scanner s = new Scanner(System.in);
        int t = s.nextInt();
        for (int i = 0; i < t; i++) {
            int min = Integer.MAX_VALUE;
            int n = s.nextInt();
            int k = s.nextInt();
            ArrayList<Integer> list = new ArrayList<>();
            for (int j = 0; j < n; j++)
                list.add(s.nextInt());
            Collections.sort(list);
            for (int j = 0; j <= n - k; j++) {
                min = Math.min(list.get(j + k - 1) - list.get(j), min);
            }
            System.out.println("#" + (i + 1) + " " + min);
        }
    }
}
