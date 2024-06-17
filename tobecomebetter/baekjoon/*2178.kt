package com.kguard.tobecomebetter.baekjoon

// 실버 1 미로 탐색
// 그래프 이론, 그래프 탐색, 너비 우선 탐색
// 최소거리를 구하는 문제에서는 bfs를 사용
// bfs는 항상 최단 거리 보장
// dfs는 모든 경우를 하나씩 탐색하는 경우에 사용
fun main(){
    val (n,m) = readln().split(" ").map { it.toInt() }
    val list = mutableListOf<MutableList<Int>>()
    val queue = mutableListOf<Pair<Int,Int>>()
    val moveHeight = mutableListOf(1, -1, 0, 0) // 아래, 위로 이동 하는 부분
    val moveWidth = mutableListOf(0, 0, 1, -1) // 오른쪽, 왼쪽으로 이동하는 부분
    repeat(n){
        val a = readln().split("").toMutableList()
        a.removeFirst()
        a.removeLast()
        list.add(a.map { it.toInt() }.toMutableList())
    }
    fun bfs(x: Int, y: Int){
        queue.add(Pair(x,y))
        while(queue.isNotEmpty()){
            val poll = queue.removeFirst()
            for(i in 0 until 4){
                val nx = moveHeight[i] + poll.first
                val ny = moveWidth[i] + poll.second
                if (nx in list.indices && ny in list[0].indices && list[nx][ny] == 1) //  상하좌우로 움직인 좌표가 인덱스 안에 있고, 움직인 좌표가 찾는 숫자
                {
                    queue.add(Pair(nx, ny))
                    list[nx][ny] = list[poll.first][poll.second] + 1 // 해당 위치에 값에 그 전 위치에서 1을 더해줌 -> 최단 거리를 나타냄
                }
            }
        }
    }
    bfs(0,0)
    println(list[n-1][m-1])
}