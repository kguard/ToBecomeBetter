package com.kguard.tobecomebetter.baekjoon

// 골드 4 숨바꼭질 4
// 그래프 이론, 그래프 탐색, 너비 우선 탐색
// bfs로 문제해결
// 1697과 같은 방법
// 이전 위치를 저장하는 리스트를 따로 만들어서 역추적
fun main() {
    val (n, k) = readln().split(" ").map { it.toInt() }
    val queue = mutableListOf<Int>() // 숫자가 들어가는 큐
    val visited = MutableList(100001) { 0 } // 위치 확인
    val check = MutableList(100001) { 0 } // 이전 위치가 저장되어 있는 리스트
    fun bfs(a: Int) {
        queue.add(a)
        while (queue.isNotEmpty()) {
            val now = queue.removeFirst()
            if (now == k) { // 원하는 숫자에 도달 하였을 때
                println(visited[now])
                return
            }
            val value = mutableListOf(now - 1, now + 1, now * 2) // 순간이동을 하거나 앞뒤로 이동 하였을 때
            for (i in value)
                if (i in 0..100000 && visited[i] == 0) { // 범위 내에 있고, 방문하지 않았을 때
                    visited[i] = visited[now] + 1 // 최소거리 구하기
                    check[i] = now
                    queue.add(i)
                }
        }
    }

    fun move(a: Int) { // 이동하는 위치들을 나타내는 함수
        val path = mutableListOf<Int>()
        var last = a // 도달하고 싶은 위치
        repeat(visited[a] + 1) // 도달하는 초 + 1 -> 들어가야하는 숫자 수
        {
            path.add(last) // 현재 위치 추가
            last = check[last] // 현재 위치를 이전 위치로 이동
        }
        for (i in path.reversed()) // 거꾸로 출력
            print("$i ")
    }
    bfs(n)
    move(k)
}