package com.kguard.tobecomebetter.swea;

import java.util.Scanner;

public class SWEA1954 {

	static int[] moveHeight = { 0, 1, 0, -1 };
	static int[] moveWidth = { 1, 0, -1, 0 };

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int t = sc.nextInt();
		for (int i = 1; i <= t; i++) {
			int n = sc.nextInt();
			a = n;
			int[][] snail = bfs(n);
			s = new int[n][n];
			System.out.println("#" + i);
			dfs(0, 0, 0, 1);
			for (int[] k : s) {
				for (int c : k)
					System.out.print(c + " ");
				System.out.println();
			}
		}

	}

	static int[][] bfs(int n) {
		int[][] snail = new int[n][n];
		int dir = 0;
		int y = 0;
		int x = 0;
		for (int i = 1; i <= n * n; i++) {
			snail[y][x] = i;
			int ny = y + moveHeight[dir];
			int nx = x + moveWidth[dir];
			if (nx < 0 || nx >= n || ny < 0 || ny >= n || snail[ny][nx] != 0)
				dir = (dir + 1) % 4;
			y += moveHeight[dir];
			x += moveWidth[dir];
		}
		return snail;
	}

	static int[][] s;
	static int a;

	static void dfs(int y, int x, int dir, int count) {
		s[y][x] = count;
		if (count == a * a)
			return;
		int ny = y + moveHeight[dir];
		int nx = x + moveWidth[dir];
		if (nx < 0 || nx >= a || ny < 0 || ny >= a || s[ny][nx] != 0) {
			dir = (dir + 1) % 4;
			dfs(y, x, dir, count);
		} else
			dfs(ny, nx, dir, count + 1);
	}
//	public static class Pair<Y, X> {
//		Y y;
//		X x;
//
//		Pair(Y y, X x) {
//			this.y = y;
//			this.x = x;
//		}
//	}	
//	static int[][] bfs(int n) {
//		int count = 1;
//		int[][] snail = new int[n][n];
//		Queue<Pair> q = new LinkedList<>();
//		snail[0][0] = count;
//		count++;
//		q.add(new Pair(0, 0));
//		int dir = 0;
//		while (!q.isEmpty()) {
//			Pair peek = q.peek();
//			int ny = (int) peek.y + moveHeight[dir];
//			int nx = (int) peek.x + moveWidth[dir];
//
//			if (0 <= ny && ny < n && 0 <= nx && nx < n && snail[ny][nx] == 0) {
//				snail[ny][nx] = count;
//				count++;
//				q.poll();
//				q.add(new Pair(ny, nx));
//
//			} else
//				dir = (dir + 1) % 4;
//			if (count == n * n + 1)
//				break;
//		}
//		return snail;
//	}

}
