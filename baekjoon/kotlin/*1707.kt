package com.kguard.tobecomebetter.baekjoon

// 골드 4 이분 그래프
// 그래프 이론, 그래프 탐색, 너비 우선 탐색, 깊이 우선 탐색, 이분 그래프
// dfs로 문제 해결
// 간선에 연결되어 있는 정점은 무조건 반대편으로 보내서 정점을 2개로 나눔
// 확인시 정점에 연결되어 있는 다른 정점들을 확인한 다음, 만약 visited의 값이 같으면 NO를 출력
fun main() {
    val k = readln().toInt()
    repeat(k) {
        val (v, e) = readln().split(" ").map { it.toInt() }
        val graph = MutableList(v + 1) { mutableListOf<Int>() }
        val visited = MutableList(v + 1) { 0 }
        repeat(e) {  // 간선 추가하는 부분
            val (a, b) = readln().split(" ").map { it.toInt() }
            graph[a].add(b)
            graph[b].add(a)
        }
        fun dfs(r: Int) {
            if (visited[r] == 0) // 방문 하지 않았으면
                visited[r] = 1 // 1번 그래프에 넣음
            for (i in graph[r]) { // r와 연결되어 있는 다른 정점들 중에
                if (visited[i] == 0) { // 방문하지 않았으면
                    if (visited[r] == 1) // r이 1번 그래프이면
                        visited[i] = 2 // 연결되어 있는 다른 정점은 2번 그래프
                    else
                        visited[i] = 1 // 아니면 1번 그래프
                    dfs(i) // 재귀 호출
                }
            }
        }
        for(i in 1..v) // 아무 정점과도 연결되어 있지 않은 정점이 존재 할 수 있으니 다 돌기
            if(visited[i] == 0)
                dfs(i)
        var ans = "YES" // 출력 꼭 확인 하기..
        for (i in 1..v) // 모든 정점에서
            for (j in graph[i]) // 연결되어 있는 다른 정점들을 확인
                if (visited[j] == visited[i]) // 간선으로 연결되어 있는 정점들이 같은 그래프에 있으면 NO 출력
                    ans = "NO"
        println(ans)
    }
}