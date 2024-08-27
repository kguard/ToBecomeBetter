package com.kguard.tobecomebetter.baekjoon

// 골드 3 내리막길
// 다이나믹 프로그래밍, 그래프 이론, 그래프 탐색, 깊이 우선 탐색
// dfs + dp
// 현재 위치에서 끝까지 갈 수있는 경우의 수를 담은 2차원 배열 생성
// 상하좌우로 이동해서 이동한 범위가 벗어나지 않고, 리스트의 수보다 작으면 dfs 탐색
// 마지막으로 가면 1을 반환
fun main(){
    val (n, m) = readln().split(" ").map { it.toInt() }
    val list = mutableListOf<List<Int>>()
    repeat(n){
        list.add(readln().split(" ").map { it.toInt() })
    }
    val dp = MutableList(n){MutableList(m){-1} }
    val moveHeight = mutableListOf(1,-1,0,0) // 아래, 위로 이동 하는 부분
    val moveWidth = mutableListOf(0,0,1,-1) // 오른쪽, 왼쪽으로 이동하는 부분
    // 위에 두개를 합쳐서 이동
    fun dfs(x: Int, y: Int): Int{
        if(x == n-1 && y == m-1) return 1 // 마지막 인덱스에서는 1을 반환
        if(dp[x][y] != -1) return dp[x][y] // 다른 길로 지나왔던 경우가 있을 수 있으니 -1이 아니면 원래 있던 값 반환
        var way = 0
        for(i in 0 until 4){ // 상하좌우로 움직이기 위해 반복
            val nx = moveHeight[i] + x // 아래, 위
            val ny = moveWidth[i] + y // 오른쪽, 왼쪽
            if(nx in 0 until n && ny in 0 until m && list[nx][ny] < list[x][y]) // 이동한 위치가 인덱스 범위 안에 있고, 리스트에서 원래 값보다 작으면 이동
                way += dfs(nx,ny) // 이동할 수 있는 모든 가능성 더하기
        }
        dp[x][y] = way
        return dp[x][y]
    }
    println(dfs(0,0))
//    for(i in dp)
//        println(i)
}
