package com.kguard.tobecomebetter.swea;

import java.util.Scanner;

public class SWEA17319 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int tc = sc.nextInt();
        for(int i = 1; i<= tc; i++) {
            int n = sc.nextInt();
            String s= sc.next();
            String st= s.substring(0,s.length()/2);
            if(s.equals(st+st)) {
                System.out.println("#"+i+" Yes");
            }
            else
                System.out.println("#"+i+" No");
        }
    }

}
