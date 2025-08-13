package com.kguard.tobecomebetter.baekjoon

import java.util.PriorityQueue

// 골드 3 최소비용 구하기 2
// 그래프 이론, 데이크스트라(다익크스트라), 최단 경로
// 13913번의 역추적을 사용하고, 1504번의 다익스트라를 이용하여서 문제 해결
fun main() {
    val n = readln().toInt()
    val m = readln().toInt()
    val graph = MutableList(n + 1) { mutableListOf<Pair<Int, Int>>() }
    val check = MutableList(n + 1) { 0 } // 이전 위치가 저장되어 있는 리스트
    repeat(m) {
        val (a, b, c) = readln().split(" ").map { it.toInt() }
        graph[a].add(Pair(b, c))
    }
    val (s, e) = readln().split(" ").map { it.toInt() }
    fun dijkstra(start: Int, end: Int): Int { // -> 1504번
        val visited = MutableList(n + 1) { 200000001 } // 간선의 최대 갯수가 200000개 이고 가중치의 최대 값이 1000이기 때문에 최소거리값중 최대값은 200000000이 될 수 있기 때문에 초기값 200000001로 설정
        val queue = PriorityQueue<Pair<Int, Int>> { a, b -> a.second - b.second } // 두번째 값으로 비교하는 부분 -> 가중치 끼리 비교
        queue.add(Pair(start, 0))
        visited[start] = 0
        while (queue.isNotEmpty()) {
            val poll = queue.poll()
            if (poll.second > visited[poll.first]) continue // 새로 들어온 가중치가 이미 원래 있던 가중치보다 크면 for문을 돌 필요 없음 -> 이미 작은게 정해져있기 때문에 바꿀 이유가 없음
            for (i in graph[poll.first]) {
                if (visited[i.first] > visited[poll.first] + i.second) { // 새로 찾은 거리가 원래 거리보다 작은 경우
                    visited[i.first] = visited[poll.first] + i.second  // 최소거리를 새로 찾은 거리로 변경
                    check[i.first] =  poll.first // 13913번 참고
                    queue.add(Pair(i.first, visited[i.first])) // 이동할 정점과 정점까지의 거리 큐에 추가
                }
            }
        }
        return visited[end]
    }

    fun move(s: Int, e : Int) { // 이동하는 위치들을 나타내는 함수 -> 13913번
        val path = mutableListOf<Int>()
        var last = e // 도달하고 싶은 위치
        while(last != s) // 도달하는 초 + 1 -> 들어가야하는 숫자 수
        {
            path.add(last) // 현재 위치 추가
            last = check[last] // 현재 위치를 이전 위치로 이동
        }
        path.add(s)
        println(path.size)
        for (i in path.reversed()) // 거꾸로 출력
            print("$i ")
    }
    println(dijkstra(s, e))
    move(s,e)
}