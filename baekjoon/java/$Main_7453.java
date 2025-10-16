package com.kguard.tobecomebetter.baekjoon.java;

import java.io.*;
import java.util.*;

// 골드 2 합이 0인 네 정수
// 투포인터를 이용해서 문제를 해결
// 배열을 2개씩 합침
// 두 수를 더했을 떄 0이 되면, 중복이 될 수 있으니 하나씩 늘려가면 확인, 반대는 하나씩 줄여가며 확인
public class $Main_7453 {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = null;
        int n = Integer.parseInt(br.readLine());
        int[] a = new int[n], b = new int[n], c = new int[n], d = new int[n];

        long[] ab = new long[n*n];
        long[] cd = new long[n*n];
        for (int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine());
            a[i] = Integer.parseInt(st.nextToken());
            b[i] = Integer.parseInt(st.nextToken());
            c[i] = Integer.parseInt(st.nextToken());
            d[i] = Integer.parseInt(st.nextToken());
        }
        int idx =0;
        for (int i = 0; i < n; i++)
            for (int j = 0; j < n; j++) {
                ab[idx]=  (a[i] + b[j]);
                cd[idx] = (c[i] + d[j]);
                idx++;
            }
        Arrays.sort(ab);
        Arrays.sort(cd);

        int abi = 0;
        int cdi = n * n - 1;
        long count = 0;
        while (abi < n * n && cdi >= 0) {
            if (ab[abi] + cd[cdi] == 0) {

                long nowAB = ab[abi];
                long nowCD = cd[cdi];
                long countAB = 0L;
                long countCD = 0L;

                while (abi < n * n && ab[abi] == nowAB) {
                    abi++;
                    countAB++;
                }

                while (cdi >= 0 &&  cd[cdi] == nowCD) {
                    cdi--;
                    countCD++;
                }

                count += countAB * countCD;
            } else if (ab[abi] + cd[cdi] > 0) {
                cdi--;
            } else if (ab[abi] + cd[cdi]  < 0) {
                abi++;
            }
        }
     /*   if(abi == n*n-1){
            while(cdi >= 0){
                if(ab.get(abi) + cd.get(cdi) == 0)
                    count++;
                else if(ab.get(abi) + cd.get(cdi) < 0)
                    break;
                cdi--;
            }
        } else if (cdi == 0) {
            while(abi < n*n){
                if(ab.get(abi) + cd.get(cdi) == 0)
                    count++;
                else if(ab.get(abi) + cd.get(cdi) > 0)
                    break;
                abi++;
            }
        }*/
        System.out.println(count);
    }

}
