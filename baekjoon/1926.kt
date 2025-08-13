package com.kguard.tobecomebetter.baekjoon

import kotlin.math.max

// 실버 1 그림
// 그래프 이론, 그래프 탐색, 너비 우선 탐색(dfs), 깊이 우선 탐색(bfs)
fun main() {
    val (n, m) = readln().split(" ").map { it.toInt() }
    val graph = mutableListOf<List<Int>>()
    repeat(n) { graph.add(readln().split(" ").map { it.toInt() }) }
    val moveHeight = mutableListOf(1,-1,0,0) // 아래, 위로 이동 하는 부분
    val moveWidth = mutableListOf(0,0,1,-1) // 오른쪽, 왼쪽으로 이동하는 부분
    val visit = MutableList(n) { MutableList(m) { false } }
    var count = 0
    var max = 0
    // bfs로 해결 -> 한 블럭의 사이즈를 따로 return 함
    fun bfs(y: Int, x: Int) : Int{
        var size = 1
        val queue = mutableListOf<Pair<Int,Int>>()
        visit[y][x] = true
        queue.add(Pair(y,x))
        while(queue.isNotEmpty()){
            val poll = queue.removeAt(0)
            for(i in 0 until 4){
                val ny = poll.first + moveHeight[i]
                val nx = poll.second + moveWidth[i]
                if(ny in 0 until n && nx in 0 until m && !visit[ny][nx] && graph[ny][nx] == 1){
                    queue.add(Pair(ny,nx))
                    visit[ny][nx] = true
                    size++
                }
            }
        }
        return size
    }
    // dfs로 해결 -> dfs는 재귀함수로 해결했기 때문에 끝을 알 수 없어서 사이즈를 전역 변수로 빼서 dfs돌떄 마다 초기화
    var size = 0
    fun dfs(y: Int, x: Int){
        visit[y][x] = true
        size++
        for(i in 0 until 4){
            val ny = moveHeight[i] + y
            val nx = moveWidth[i] + x
            if(ny in 0 until n && nx in 0 until m && !visit[ny][nx] && graph[ny][nx] == 1)
                dfs(ny,nx)
        }
    }

//    for(i in 0 until n)
//        for(j in 0 until m)
//            if(graph[i][j] == 1 && !visit[i][j]) {
//                max = max(max,bfs(i,j))
//                count++
//            }
//

    for(i in 0 until n)
        for(j in 0 until m)
            if(graph[i][j] == 1 && !visit[i][j]) {
                size = 0
                dfs(i,j)
                max = max(max, size)
                count++
            }


    println(count)
    println(max)
}