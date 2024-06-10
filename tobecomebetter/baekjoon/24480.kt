package com.kguard.tobecomebetter.baekjoon

// 실버 2 알고리즘 수업 - 깊이 우선 탐색 2
// 그래프 이론, 그래프 탐색, 정렬, 깊이 우선 탐색
// 24479번 코드 동일
fun main(){
    val (n,m,r) = readln().split(" ").map { it.toInt() }
    val visited = MutableList(n+1){false} // 방문했는지 확인
    val cnt = MutableList(n+1){0} // 정점에 방문한 순서
    var t = 1 // 1번째 순서
    val graph = MutableList(n+1){ mutableListOf<Int>() }
    repeat(m){ // 간선 추가
        val (n1, v1) = readln().split(" ").map { it.toInt() }
        graph[n1].add(v1)
        graph[v1].add(n1)
    }
    graph.forEach { it.sortDescending() } // 각 정점마다 연결되는 정점을 내림차순 정렬
    fun dfs(r:Int){
        visited[r] = true // 입력된 정점 방문
        cnt[r] = t // 입력된 정점에 방문한 순서 저장
        t++ // 순서 +1
        for(i in graph[r]) // 정점에 해당되는 간선집합에서
            if(!visited[i]) // 방문되지 않은 정점이라면
                dfs(i) // 그 정점 방문
    }
    dfs(r)
    val sb = StringBuilder()
    for(i in 1..n)
        sb.append(cnt[i]).append("\n")
    println(sb)
}

