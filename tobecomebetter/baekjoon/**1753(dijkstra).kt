package com.kguard.tobecomebetter.baekjoon

import java.util.PriorityQueue

// 골드 4 최단경로
// 그래프 이론, 데이크스트라(다익스트라), 최단 경로
// bfs와 비슷한 다익스트라 알고리즘을 사용해서 문제 해결
private data class Node1753(val index :Int, val weight: Int) : Comparable<Node1753> {
    override fun compareTo(other: Node1753): Int = weight-other.weight // 우선순위 큐를 사용하기 위해서 가중치로 우선순위를 정하는 부분
}

fun main(){
    val (v,e) = readln().split(" ").map { it.toInt() }
    val start = readln().toInt()
    val graph = MutableList(v+1){ mutableListOf<Node1753>() }
    val visited = MutableList(v+1){Int.MAX_VALUE}
    repeat(e){
        val (a,b,c) = readln().split(" ").map { it.toInt() }
        graph[a].add(Node1753(b,c))
    }
    fun bfs(){
        val queue = PriorityQueue<Node1753>() // 우선순위큐 -> 가중치에 따라서 순위가 정해짐
        queue.add(Node1753(start,0))
        visited[start] = 0
        while(queue.isNotEmpty()){
            val poll = queue.poll()
            if(poll.weight > visited[poll.index]) continue // 새로 들어온 가중치가 이미 원래 있던 가중치보다 크면 for문을 돌 필요 없음 -> 이미 작은게 정해져있기 때문에 바꿀 이유가 없음
            for(i in graph[poll.index]) {
                if(visited[i.index] > visited[poll.index] + i.weight) {  // 새로 찾은 거리가 원래 거리보다 작은 경우
                    visited[i.index] = visited[poll.index] + i.weight // 최소거리를 새로 찾은 거리로 변경
                    queue.add(Node1753(i.index,visited[i.index]))  // 이동할 정점과 정점까지의 거리 큐에 추가
                }
            }
        }
    }
    bfs()
    for(i in 1..v) {
        if (visited[i] == Int.MAX_VALUE)
            println("INF")
        else
            println(visited[i])
    }
}