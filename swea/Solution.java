package com.kguard.tobecomebetter.swea;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.Scanner;

class Solution {
	public static void main(String args[]) throws Exception {
		Scanner sc = new Scanner(System.in);
		int tc = sc.nextInt();
		for (int i = 1; i <= tc; i++) {
			int n = sc.nextInt();
			int k = sc.nextInt();
			int count = 1;
			ArrayList<Integer> list = new ArrayList<>();
			ArrayList<int[]> list2 = new ArrayList<>();
			for (int j = 0; j < n; j++) {
				list.add(sc.nextInt());
			}
			list.sort(null);
			loop1: for (int j = 0; j < n; j++) {
				for (int t = 0; t < n; t++) {
					int[] y = { list.get(j), list.get(t) };
					list2.add(y);
				}
			}
//	  for(int j = 0 ; j<n*n; j++)
//	   {
//		 for(int a = 0; a<n*n;a++) {
//			if(list2.get(j)[0] == list2.get(a)[0]) {
//				if(list2.get(j)[1] < list2.get(a)[1]) {
//				int[] tex = list2.get(j);
//				list2.set(j, list2.get(a));
//				list2.set(a, tex);}
//			}
//		 }
//	   }
			list2.sort(new Comparator<int[]>() {
				@Override
				public int compare(int[] p1, int[] p2) {
					if (p1[0] != p2[0]) {
						return Integer.compare(p1[0], p2[0]);
					} else {
						return Integer.compare(p1[1], p2[1]);
					}
				}
			});
			for (int j = 0; j < n * n; j++) {
				if (count == k) {
					System.out.println("#" + i + " " + (list2.get(j)[0] + list2.get(j)[1]));
					break;
				} else
					count++;
			}
		}
	}
}