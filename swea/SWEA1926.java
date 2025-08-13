package com.kguard.tobecomebetter.swea;

import java.util.Scanner;

public class SWEA1926 {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		for (int i = 1; i <= n; i++) {
			String is = Integer.toString(i);
			if (is.contains("3") || is.contains("6") || is.contains("9")) 
				is = is.replaceAll("[1245780]", "").replaceAll("[369]", "-");
			System.out.print(is + " ");
		}
	}
}
