package com.kguard.tobecomebetter.baekjoon

// 실버 2 알고리즘 수업 - 너비 우선 탐색 2
// 그래프 이론, 그래프 탐색, 정렬, 너비 우선 탐색
// 24444번과 동일
fun main(){
    val (n,m,r) = readln().split(" ").map { it.toInt() }
    val graph = MutableList(n+1){ mutableListOf<Int>() }
    val queue = mutableListOf<Int>()
    repeat(m){ // 간선 추가
        val (n1, v1) = readln().split(" ").map { it.toInt() }
        graph[n1].add(v1)
        graph[v1].add(n1)
    }
    graph.forEach { it.sortDescending() } // 각 정점마다 연결되는 정점을 오름차순 정렬
    val visited = MutableList(n+1){false} // 방문했는지 확인
    val cnt = MutableList(n+1){0} // 정점에 방문한 순서
    var t = 1 // 1번째 순서
    fun bfs(r: Int){
        visited[r] = true
        cnt[r] = t++
        queue.add(r)
        while(queue.isNotEmpty()){
            val u = queue.removeFirst()
            for(i in graph[u])
                if(!visited[i]){
                    visited[i] = true
                    queue.add(i)
                    cnt[i] = t++
                }
        }
    }
    bfs(r)
    val sb = StringBuilder()
    for(i in 1..n)
        sb.append(cnt[i]).append("\n")
    println(sb)
}