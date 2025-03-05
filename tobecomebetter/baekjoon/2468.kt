package com.kguard.tobecomebetter.baekjoon

import kotlin.math.max

// 실버 1 안전 영역
// 그래프 이론, 브루트포스 알고리즘, 그래프 탐색, 너비 우선 탐색, 깊이 우선 탐색
// dfs, bfs를 사용해서 해결하는 문제 -> 상하좌우로 움직이며 확인함
// 0 부터 100 까지의 수위를 모두 돌면서, 수위가 높으면 안전한 구역으로 취급하여서 인접한 구역들 찾으며 count로 표시
// count 가 제일 많은것만 출력
private val moveHeight = mutableListOf(1,-1,0,0) // 아래, 위로 이동 하는 부분
private val moveWidth = mutableListOf(0,0,1,-1) // 오른쪽, 왼쪽으로 이동하는 부분
private var n = 0
private val graph = mutableListOf<List<Int>>()
fun main() {
    n = readln().toInt()
    repeat(n) {
        graph.add(readln().split(" ").map { it.toInt() })
    }
    var max = 0
    for(w in 0..100){
        val visited = MutableList(n) { MutableList(n) { 0 } }
        var count = 0
        for(i in 0 until n)
            for(j in 0 until n){
                if(graph[i][j] > w && visited[i][j] == 0){
                    count++
                    dfs(i,j,w,count,visited)
//                    bfs(i,j,w,count,visited)
                }
            }
        max = max(max,count)
    }
    println(max)
}

private fun dfs(y: Int, x: Int, water: Int, count: Int,visited : MutableList<MutableList<Int>>){ // dfs로 풀기
    visited[y][x] = count
    for(i in 0 until 4){ // 상하좌우로 움직이기 위해 반복
        val ny = moveHeight[i] + y // 아래, 위
        val nx = moveWidth[i] + x // 오른쪽, 왼쪽
        if(ny in 0 until n && nx in 0 until n && graph[ny][nx] > water && visited[ny][nx] == 0){ // 이동한 위치가 인덱스 범위 안에 있고, 수위보다 높고, 방문하지 않았으면 이동
            dfs(ny,nx,water,count,visited)
        }
    }
}

private fun bfs(startY : Int, startX: Int, water: Int, count: Int, visited : MutableList<MutableList<Int>>){ // bfs로 풀기
    val queue = mutableListOf<Pair<Int,Int>>()
    visited[startY][startX] = count
    queue.add(Pair(startY, startX))
    while (queue.isNotEmpty()){
        val poll = queue.removeAt(0)
        for(i in 0 until 4){ // 상하좌우로 움직이기 위해 반복
            val ny = moveHeight[i] + poll.first // 아래, 위
            val nx = moveWidth[i] + poll.second // 오른쪽, 왼쪽
            if(ny in 0 until n && nx in 0 until n && graph[ny][nx] > water && visited[ny][nx] == 0){  // 이동한 위치가 인덱스 범위 안에 있고, 수위보다 높고, 방문하지 않았으면 이동
                queue.add(Pair(ny,nx))
                visited[ny][nx] = count
            }
        }
    }
}
