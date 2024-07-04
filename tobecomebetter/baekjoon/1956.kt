package com.kguard.tobecomebetter.baekjoon

// 골드 4 운동
// 그래프 이론, 최단 거리, 플로이드-워셜
// 사이클을 구하는 방식이기 때문에 같은 곳에서 출발해서 같은 곳으로 도착하는 부분에서 최소 거리를 구하면 됨
// 플로이드-워셜 알고리즘을 통해서 사이클의 최소거리 구하기
fun main(){
    val (v,e) = readln().split(" ").map { it.toInt() }
    val graph = MutableList(v+1){MutableList(v+1){Int.MAX_VALUE.toLong()} }
    repeat(e){
        val (a,b,c) = readln().split(" ").map { it.toInt() }
        if(graph[a][b] > c)
            graph[a][b] = c.toLong()
    }
    // 플로이드-워셜 알고리즘
    for(i in 1..v)
        for(a in 1..v)
            for(b in 1..v)
                if(graph[a][b] > graph[a][i] + graph[i][b])
                    graph[a][b] = graph[a][i] + graph[i][b]
    var min = Int.MAX_VALUE.toLong()
    for(i in 1..v){
        if(graph[i][i] < min) // 사이클을 구할거기 때문에 같은 곳에서 출발해서 같은 곳으로 도착하는 최소거리
            min = graph[i][i]
    }
    if(min >= Int.MAX_VALUE)
        println(-1)
    else
        println(min)
}