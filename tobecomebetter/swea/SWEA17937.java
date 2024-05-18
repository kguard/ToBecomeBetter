package com.kguard.tobecomebetter.swea;

import java.math.BigInteger;
import java.util.Scanner;

public class SWEA17937 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int tc = sc.nextInt();
        for (int i = 1; i <= tc; i++) {
            String a = sc.next();
            String b = sc.next();
            System.out.print("#"+i+" ");
            if(b.equals(a))
                System.out.println(a);
            else
                System.out.println(1);
        }
    }
}
