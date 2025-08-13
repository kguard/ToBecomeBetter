package com.kguard.tobecomebetter.swea;

import java.util.ArrayList;
import java.util.Scanner;

public class SWEA19185 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int tc = sc.nextInt();
        for (int i = 1; i <= tc; i++) {
            int n = sc.nextInt();
            int m = sc.nextInt();
            ArrayList<String> nList = new ArrayList<>();
            ArrayList<String> mList = new ArrayList<>();
            for (int t = 0; t < n; t++)
                nList.add(sc.next());
            for (int t = 0; t < m; t++)
                mList.add(sc.next());
            int q = sc.nextInt();
            System.out.print("#" + i + " ");
            for (int j = 0; j < q; j++) {
                int y = sc.nextInt();
                int nIndex = y % n - 1;
                if (nIndex < 0) nIndex = n - 1;
                int mIndex = y % m - 1;
                if (mIndex < 0) mIndex = m - 1;
                System.out.print(nList.get(nIndex) + mList.get(mIndex) + " ");
            }
            System.out.println();
        }
    }
}
