package com.kguard.tobecomebetter.baekjoon

// 실버 2 알고리즘 수업 - 너비 우선 탐색 1
// 그래프 이론, 그래프 탐색, 정렬, 너비 우선 탐색
// 너비 우선 탐색을 하기 때문에 큐를 하나 만들어서 정점과 연결된 모든 정점을 탐색후 넘어감
// 연결된 간선이 없으면 탐색 x
fun main(){
    val (n,m,r) = readln().split(" ").map { it.toInt() }
    val graph = MutableList(n+1){ mutableListOf<Int>() }
    val queue = mutableListOf<Int>()
    repeat(m){ // 간선 추가
        val (n1, v1) = readln().split(" ").map { it.toInt() }
        graph[n1].add(v1)
        graph[v1].add(n1)
    }
    graph.forEach { it.sort() } // 각 정점마다 연결되는 정점을 오름차순 정렬
    val visited = MutableList(n+1){false} // 방문했는지 확인
    val cnt = MutableList(n+1){0} // 정점에 방문한 순서
    var t = 1 // 1번째 순서
    fun bfs(r: Int){
        visited[r] = true // 정점 방문
        cnt[r] = t++ // 순서 추가
        queue.add(r) // 큐에 정점을 추가
        while(queue.isNotEmpty()){ // 큐가 비어 있지 않을 때 까지 반복
            val u = queue.removeFirst() // 맨 앞에 있는 정점을 제거하며 탐색
            for(i in graph[u]) // 맨앞 정점과 간선으로 연결된 모든 정점 탐색 -> 너비로 탐색
                if(!visited[i]){ // 방문하지 않았으면
                    visited[i] = true // 방문으로 바꾸고
                    queue.add(i) // 큐에 정점 추가
                    cnt[i] = t++ // 순서 추가
                }
        }
    }
    bfs(r)
    val sb = StringBuilder()
    for(i in 1..n)
        sb.append(cnt[i]).append("\n")
    println(sb)
}