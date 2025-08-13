package com.kguard.tobecomebetter.baekjoon

import java.util.PriorityQueue

// 골드 4 전력난
// 그래프 이론, 최소 스패닝 트리 MST
// 크루스칼 알고리즘으로 문제 해결
// 간선을 기준으로 오름차순으로 정렬한 다, 두 정점이 서로 사이클을 만들지 않는 선에서 트리를 계속해서 만들도록 함
//fun main() {
//    while (true) {
//        val (m, n) = readln().split(" ").map { it.toInt() }
//        if (m == 0 && n == 0) break
//        val graph = mutableListOf<Triple<Int, Int, Int>>()
//        val visited = MutableList(m) { it }
//        var sum = 0
//        repeat(n) {
//            val (a, b, c) = readln().split(" ").map { it.toInt() }
//            graph.add(Triple(a, b, c))
//            sum += c
//        }
//        graph.sortBy { it.third }
//        fun find(x: Int): Int {
//            return if (x == visited[x]) x
//            else {
//                visited[x] = find(visited[x])
//                visited[x]
//            }
//        }
//
//        fun union(x: Int, y: Int) {
//            val nx = find(x)
//            val ny = find(y)
//            if (nx != ny) visited[nx] = ny
//        }
//
//        var answer = 0
//        for (i in graph)
//            if (find(i.first) != find(i.second)) { // 같은 트리가 아니면
//                union(i.first, i.second) // 같은 집합으로 만들면서
//                answer += i.third // 두 점사이의 거리 길이 추가
//            }
//        println(sum - answer)
//    }
//}

// 프림 알고리즘
// PriorityQueue를 이용하여, 정점을 큐에 넣은 다음, 가중치를 기준으로 오름차순으로 정렬되게 하여, 연결하도록하여, 모든 정점을 방문하면 멈추도록 하게 만듬
fun main() {
    while (true) {
        val (m, n) = readln().split(" ").map { it.toInt() }
        if (m == 0 && n == 0) break
        val graph = MutableList(m) { mutableListOf<Pair<Int, Int>>() }
        var sum = 0
        repeat(n) {
            val (a, b, c) = readln().split(" ").map { it.toInt() }
            graph[a].add(Pair(b, c))
            graph[b].add(Pair(a, c))
            sum += c
        }
        var answer = 0
        val visited = MutableList(m) { false }
        val queue = PriorityQueue<Pair<Int, Int>> { a, b -> a.second - b.second } // () 안에 아무것도 없으면 오름차순 -> 두 점사이의 거리를 기준으로 순서가 바뀌는 큐'
        queue.add(Pair(0, 0))
        while (queue.isNotEmpty()) {
            val poll = queue.poll()
            if (visited[poll.first]) continue
            visited[poll.first] = true
            answer += poll.second
            for (i in graph[poll.first])
                if (!visited[i.first]) // bfs식으로 구하면 같은 정점을 가는 선에서 가중치의 최소값을 넣을수 없음
                    queue.add(i)
        }
        println(sum - answer)
//            fun prim(s : Int){
//            val visited = MutableList(m) { false }
//            val queue = PriorityQueue<Pair<Int, Int>> { a, b -> a.second - b.second } // () 안에 아무것도 없으면 오름차순 -> 두 점사이의 거리를 기준으로 순서가 바뀌는 큐'
//            queue.add(Pair(s,0))
//            while(queue.isNotEmpty()){
//                val poll = queue.poll()
//                visited[poll.first] = true
//                for(i in graph[poll.first]){
//                    if(!visited[i.first]) // bfs식으로 구하면 같은 정점을 가는 선에서 가중치의 최소값을 넣을수 없음
//                    {
//                        visited[i.first] = true
//                        answer += i.second
//                        queue.add(i)
//                    }
//                }
//            }
//        }
    }
}