package com.kguard.tobecomebetter.baekjoon

// 골드 1 다리 만들기 2
// 구현, 그래프 이론, 브루트포스 알고리즘, 그래프 탐색, 너비 우선 탐색(bfs), 깊이 우선 탐색(dfs), 최소 스패닝 트리
// bfs 와 크루스칼 알고리즘을 섞어서 사용
// 1. 1과 0으로 된 보드에서 bfs를 이용하여 섬들의 죄표와 좌표에 따른 섬의 위치를 저장
// 2. 브루트 포스 알고리즘을 사용하여 섬에서 섬으로 갈 수있는 모든 다리를 구함
// 3. 크루스칼 알고리즘을 사용하여서 모든 섬을 돌 수 있는 다리의 최소 값을 구함
fun main() {
    val (n, m) = readln().split(" ").map { it.toInt() } // n은 y, m은 x
    val board = mutableListOf<List<Int>>() // 숫자를 입력 받을 보드
    val island = mutableListOf<MutableList<Pair<Int, Int>>>() // 각 섬에 좌표들
    val visited = MutableList(n) { MutableList(m) { 0 } } // 전체 좌표에서 어느 섬에 위치하는 지에 대한 정보
    val graph = mutableListOf<Triple<Int, Int, Int>>() // 첫번째 섬, 두번쨰 섬, 두 섬 사이의 최소거리
    val moveHeight = mutableListOf(1, -1, 0, 0) // 아래, 위로 이동 하는 부분
    val moveWidth = mutableListOf(0, 0, 1, -1) // 오른쪽, 왼쪽으로 이동하는 부분
    repeat(n) {
        val a = readln().split(" ").map { it.toInt() }
        board.add(a)
    }
    fun findBFS(y: Int, x: Int, cc: Int): MutableList<Pair<Int, Int>> { // 섬을 구하는 방식 -> bfs로 해결
        val queue = mutableListOf<Pair<Int, Int>>()
        val list = mutableListOf<Pair<Int, Int>>()
        queue.add(Pair(y, x))
        list.add(Pair(y, x))
        visited[y][x] = cc
        while (queue.isNotEmpty()) {
            val poll = queue.removeFirst()
            for (i in 0 until 4) { // 상하좌우로 움직이기 위해 반복
                val ny = moveHeight[i] + poll.first // 아래, 위
                val nx = moveWidth[i] + poll.second // 오른쪽, 왼쪽
                if (ny in 0 until n && nx in 0 until m && board[ny][nx] == 1 && visited[ny][nx] == 0) //  상하좌우로 움직인 좌표가 인덱스 안에 있고, 움직인 좌표가 찾는 숫자 이고, 방문하지 않았으면
                {
                    queue.add(Pair(ny, nx))
                    visited[ny][nx] = cc
                    list.add(Pair(ny, nx))
                }
            }
        }
        return list
    }

    var cc = 1
    for (i in 0 until n)
        for (j in 0 until m)
            if (visited[i][j] == 0 && board[i][j] == 1) island.add(findBFS(i, j, cc++)) // vi
//    for (i in island)
//        println(i)
//    for (i in visited)
//        println(i)

    // 섬과 섬에서 갈 수있는 모든 선을 구하기
    island.forEach { a ->
        a.forEach { i ->
            for (j in 0 until 4) {
                var dist = 1 // 두 점 사이의 거리. 나중에 -1 해줘야 함
                while (true) {
                    val ny = moveHeight[j] * dist + i.first // 거리 만큼 y축으로 움직이기
                    val nx = moveWidth[j] * dist + i.second // 거리 만큼 x축으로 움직이기
                    if (ny !in 0 until n || nx !in 0 until m || visited[i.first][i.second] == visited[ny][nx]) break // 보드에서 벗어나거나, 같은 섬일 경우 나가기
                    if (visited[ny][nx] != 0) { // 다른 섬에 닿았다면,
                        if (dist - 1 >= 2) // 두 점사이의 거리가 2 이상 이어야 함
                            graph.add(Triple(visited[i.first][i.second] - 1, visited[ny][nx] - 1, dist - 1)) // 각 점이 1 부터 시작 하기 때문에 -1을 해주고, 거리도 -1 함
                        break
                    }
                    dist += 1
                }
            }
        }
    }
    // 크루스칼 알고리즘으로 모든 섬을 연결하는 최소값 구함
    graph.sortBy { it.third }
    val visitedMST = MutableList(island.size) { it }
    var dis = 0
    fun find(x: Int): Int {
        return if (x == visitedMST[x]) x
        else {
            visitedMST[x] = find(visitedMST[x])
            visitedMST[x]
        }
    }

    fun union(x: Int, y: Int) {
        val nx = find(x)
        val ny = find(y)
        if (nx != ny) visitedMST[nx] = ny
    }
    for (i in graph)
        if (find(i.first) != find(i.second)) {
            union(i.first, i.second)
            dis += i.third
        }
    // 닿을 수 없으면 거리가 -1 출력
    for (i in 0 until visitedMST.size)
        for (j in i + 1 until visitedMST.size)
            if (find(i) != find(j)) {
                println(-1)
                return
            }
    println(dis)
}