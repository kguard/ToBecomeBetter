package com.kguard.tobecomebetter.baekjoon

import java.util.LinkedList
import java.util.Queue

// 골드 4 DSLR
// 그래프 이론, 그래프 탐색, 너비 우선 탐색
// bfs로 문제 해결
// DSLR 의 방법만 알면됨
fun main() {
    repeat(readln().toInt()) {
        val (a, b) = readln().split(" ").map { it.toInt() }
        val visited = MutableList(100001) { false } // 위치 확인
        val queue: Queue<Pair<Int,String>> = LinkedList()
        fun bfs(a: Int, b: Int) {
            queue.add(Pair(a, ""))
            while (queue.isNotEmpty()) {
                val poll = queue.poll()
                if (poll.first == b) { // 원하는 숫자에 도달 하였을 때
                    println(poll.second)
                    return
                }
                val d = (poll.first * 2) % 10000
                val s = if (poll.first == 0) 9999 else poll.first - 1;
                val l = (poll.first / 1000) + (poll.first % 1000) * 10 // 왼쪽으로 회전
                val r = (poll.first / 10) + (poll.first % 10) * 1000 // 오른쪽으로 회전
                if (!visited[d]) {
                    visited[d] = true
                    queue.add(Pair(d, poll.second + "D"))
                }
                if (!visited[s]) {
                    visited[s] = true
                    queue.add(Pair(s, poll.second + "S"))
                }
                if (!visited[l]) {
                    visited[l] = true
                    queue.add(Pair(l, poll.second + "L"))
                }
                if (!visited[r]) {
                    visited[r] = true
                    queue.add(Pair(r, poll.second + "R"))
                }
            }
        }
        bfs(a, b)
    }
}