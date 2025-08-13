package com.kguard.tobecomebetter.swea;

import java.util.ArrayList;
import java.util.Scanner;

public class SWEA19003 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int tc = sc.nextInt();
        for (int i = 1; i <= tc; i++) {
            int count = 0;
            int n = sc.nextInt();
            int m = sc.nextInt();
            ArrayList<String> list = new ArrayList<>();
            for (int j = 0; j < n; j++) {
                String ad = sc.next();
                if (ad.equals(new StringBuffer(ad).reverse().toString())) {
                    if (count < m)
                        count += m;
                } else
                    list.add(ad);
            }
            for (int j = 0; j < list.size(); j++) {
                if(list.contains(new StringBuffer(list.get(j)).reverse().toString())){
                    count += m;
                }
            }
            System.out.println("#" + i + " "+count);
        }
    }
}
