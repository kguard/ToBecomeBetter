package com.kguard.tobecomebetter.baekjoon.kotlin

// 골드 4 미로만들기
// 0-1 BFS 와 다익스트라를 이용해서 문제를 해결
fun main() {
    val n = readln().toInt()
    val map = mutableListOf<List<Int>>()
    repeat(n) {
        map.add(readln().map { it.toString().toInt() })
    }
    val moveHeight = arrayOf(-1, 1, 0, 0)
    val moveWidth = arrayOf(0, 0, -1, 1)

    // 0-1 BFS를 이용하는 방법
    // 큐 대신에 deque(덱)을 이용해서 1 인 방들을 모두 방문 하고, 0 인 방들은 나중에 방문하도록 함
    // 벽을 0번 부순 모든 경로를 전부 탐색 -> 그 다음에야 벽을 1번 부순 경로들을 탐색 -> 그 다음에야 벽을 2번 부순 경로들을 탐색
    val queue = ArrayDeque<Pair<Int, Int>>()
    val visited = MutableList(n) { MutableList(n) { Int.MAX_VALUE } }
    visited[0][0] = 0
    queue.add(0 to 0)
    while (queue.isNotEmpty()) {
        val poll = queue.removeFirst()
        val y = poll.first
        val x = poll.second
        for (i in 0 until 4) {
            val ny = y + moveHeight[i]
            val nx = x + moveWidth[i]
            if (ny !in 0 until n || nx !in 0 until n || visited[ny][nx] != Int.MAX_VALUE)
                continue
            if (map[ny][nx] == 1) {
                visited[ny][nx] = visited[y][x]
                queue.addFirst(ny to nx)
            } else {
                visited[ny][nx] = visited[y][x] + 1
                queue.add(ny to nx)
            }
        }
    }
    println(visited[n - 1][n - 1])

    // 다익스트라로 문제를 해결하는 방식
    // Triple로 해서 움직이는 좌표 + 벽을 바꾸는 횟수를 너어 놓음
    // 우선순위큐를 이용해서 최단거리로 움직일 수 있도록 함
    /*
    val queue = PriorityQueue<Triple<Int,Int,Int>>{t1, t2 -> t1.third.compareTo(t2.third)}
    val dist = MutableList(n) { MutableList(n) { Int.MAX_VALUE } }
    dist[0][0] = 0
    queue.add(Triple(0,0,0))
    while (queue.isNotEmpty()){
        val poll = queue.poll()
        val y = poll.first
        val x = poll.second
        val v = poll.third
        if(v > dist[y][x])
            continue
        for(i in 0 until 4){
            val ny = y + moveHeight[i]
            val nx = x + moveWidth[i]
            if(ny !in 0 until n || nx !in 0 until n)
                continue
            val nv = if(map[ny][nx] == 1) v else v+1
            if(dist[ny][nx] > nv){
                dist[ny][nx] = nv
                queue.add(Triple(ny,nx,dist[ny][nx]))
            }
        }
    }
    println(dist[n-1][n-1])
    */
}