package com.kguard.tobecomebetter.baekjoon.java;

import java.io.*;
import java.util.*;

// 플래티넘 5 찾기
// KMP 알고리즘 이지만 먼전 프루트 포스로 풀어보기
public class Main_1786 {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        StringTokenizer st = null;
        String t = br.readLine();
        String p = br.readLine();

        // 1. 문자열의 패턴을 찾는 부분
        int[] pi = new int[p.length()];
        for (int i = 1, j = 0; i < p.length(); i++) {
            while (j > 0 && p.charAt(i) != p.charAt(j))
                j = pi[j - 1];
            if (p.charAt(i) == p.charAt(j))
                pi[i] = ++j;
            else pi[i] = 0;
        }

        // 2. 긴 문자열에서 짧은 문자열이 나오는 부분 찾기
        // 위에서 구한 패턴을 이용해서 최적화
        List<Integer> list = new ArrayList<>();
        int cnt = 0;
        for (int i = 0, j = 0; i < t.length(); i++) {
            while (j > 0 && t.charAt(i) != p.charAt(j))
                j = pi[j - 1];
            if (t.charAt(i) == p.charAt(j)) { // 현재의 두 글자 일치
                if (j == p.length() - 1) { // j가 패턴의 마지막 인덱스일 경우
                    cnt++; // 카운트 증가
                    list.add(i - j);
                    j = pi[j];
                } else {
                    j++;
                }
            }
        }
        System.out.println(cnt);
        if (cnt > 0) {
            for (int i : list)
                System.out.println(i + 1);
        }
       /*
        List<Integer> result= matchBruteForce(a,b);
        System.out.println(result.size());
        if(!result.isEmpty()){
            for(int i : result)
                System.out.println(i);
        }
        */
    }

    // 브루트 포스로 문제를 해결하는 방법 -> 시간 초과로 인해서 사용 X
    static List<Integer> matchBruteForce(String a, String b) {
        List<Integer> location = new ArrayList<>();
        // a에서 b가 얼마나 나오는지 확인하기
        if (a.length() >= b.length()) {
            for (int i = 0; i < a.length(); i++) { // 시작 지점
                if (i + b.length() < a.length()) {
                    for (int j = 0; j < b.length(); j++) { // b 문자열 찾기
                        if (a.charAt(i + j) != b.charAt(j))
                            break;
                        if (j == b.length() - 1)
                            location.add(i + 1);
                    }
                }
            }
        }
        return location;
    }
}
