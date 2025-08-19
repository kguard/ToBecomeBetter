package com.kguard.tobecomebetter.swea;

import java.io.*;
import java.util.*;

/*
그리디를 이용해서 문제를 해결하기
각 숫자에 대한 최적값을 찾는 방법이 아니라 필요한 1일의 개수와 2일의 개수를 찾아서 계산하기
1. 1일의 개수가 많을 때는 1을 2로 만들 수 없기 때문에 (1의 개수 * 2 - 1) 로 구해야 됨. -1을 하는 이유는 1일과 2일을 쌍으로 생각하는데 1일이 먼저 시작하기 때문에 -1필요
2. 2일의 개수가 많을 때는 2를 1, 1로 나눌 수 있기 때문에 계산 필요
 */
public class Solution_d2_14510_나무높이 {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        StringTokenizer st = null;
        int T = Integer.parseInt(br.readLine());
        for (int tc = 1; tc <= T; tc++) {
            int N = Integer.parseInt(br.readLine());
            int[] trees = new int[N];
            int maxTree = 0;

            int count1 = 0;
            int count2 = 0;
            st = new StringTokenizer(br.readLine(), " ");
            for (int i = 0; i < N; i++) {
                trees[i] = Integer.parseInt(st.nextToken());
                if (maxTree < trees[i])
                    maxTree = trees[i];
            }
            // 2일이 필요한 날짜와 1일이 필요한 날짜를 계산해줌 -> 2일을 1 + 1로 쪼개는 경우는 지금은 생각하지 않음 -> 필요한 부분만을 계산
            for (int i = 0; i < N; i++) {
                int toGrow = maxTree - trees[i];
                count2 += toGrow / 2;
                count1 += toGrow % 2;
            }

            sb.append("#").append(tc).append(" ");
            // 1일이 필요한 개수가 2일이 필요한 개수가 많을 경우 : (1일의 개수 *2) -1 -> -1 인 이유는 1부터 시작하기 때문에 홀수 일로 끝나기 떄문에 (*2는 2일의 개수 까지 센것) 가 최소
            if (count1 > count2) {
                sb.append(count1 * 2 - 1).append("\n");
            } else if (count1 == count2) {
                sb.append(count1 * 2).append("\n");
            } else {
                int date = count1 * 2; // 1일에 맞는 2일의 개수를 사용
                // 남은 2일의 개수 * 2 (필요한 일수를 계산하기 위해서).  예시) 1: 3, 2 : 10 이면  12,12,12 쓰고 남은 2는 7개  * 2는 일수 -> 홀수가 나올 수 없음
                int a = (count2 - count1) * 2;
                // 3으로 나누어 몫을 저장. 3일로 나눈 이유는 1일 2일 하나의 쌍으로 생각해서 개수를 세어줌. * 2를 통해서 1 2의 쌍을 세어줌
                date += a / 3 * 2;
                // 나머지는 남은 일수를 의미.
                // 0 이면 12의 쌍으로 끝나는 거니 몫만 더해주고,
                // 1이 남으면 1일이 남는것(몫에 쓰인 1은 홀수개, 2로 1 1 로 나눈 나머지 하나) 이니 +1
                // 2가 남으면 2일이 남는 것이니 쪼개는 것 보다 하루 쉬는게 나음 따라서 +2
                date += a % 3;
                sb.append(date).append("\n");
            }
        }
        System.out.println(sb.toString());
        br.close();
    }
}
