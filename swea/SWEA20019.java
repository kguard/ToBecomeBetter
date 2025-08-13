package com.kguard.tobecomebetter.swea;

import java.util.Scanner;

public class SWEA20019 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();
        for (int i = 1; i <= t; i++) {
            String s = sc.next();
            String sr = new StringBuffer(s).reverse().toString();
            String fs = s.substring(0,(s.length()-1)/2);
            String fsr = new StringBuffer(fs).reverse().toString();
            String ls = s.substring((s.length()-1)/2+1);
            String lsr = new StringBuffer(ls).reverse().toString();
            if (s.equals(sr) && fs.equals(fsr) && ls.equals(lsr))
                System.out.println("#" + i + " YES");
            else
                System.out.println("#" + i + " NO");
        }
    }
}
