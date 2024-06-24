package com.kguard.tobecomebetter.baekjoon

import java.util.LinkedList
import java.util.Queue

// 골드 3 벽 부수고 이동하기
// 그래프 이론, 그래프 탐색, 너비 우선 탐색
// bfs 3차원 배열을 사용
// 3차원 배열을 사용하여 벽을 뚫었을 때와 벽을 뚫지 않았을 때의 count를 함
// 1. 내가 만난 숫자가 1 이고, 벽을 깨고 들어 왔을 때 -> 이동 하며 안되기 때문에 무시
// 2. 내가 만난 숫자가 1 이고, 벽을 깨지 않았을 때 -> 벽을 깨고 이동하며, 벽을 깼다는 표시
// 3. 내가 만난 숫자가 0 이고, 벽을 깨고 들어 왔을 때 -> 단순히 이동 하며, 숫자 + 1
// 4. 내가 만난 숫자가 0 이고, 벽을 깨지 않았을 때 -> 단순히 이동 하며, 숫자 + 1

fun main() {
    val (n, m) = readln().split(" ").map { it.toInt() }
    val list = mutableListOf<MutableList<Int>>()
    repeat(n) {
        val a = readln().split("").toMutableList()
        a.removeFirst()
        a.removeLast()
        list.add(a.map { it.toInt() }.toMutableList())
    }
    val visited = MutableList(n) { MutableList(m) { MutableList(2) { 0 } } } // 방문한 거리 count -> 마지막 부분이 벽을 뚫고 갔을 때와 뚫지 않고 갔을 때의 경우의 수
    val queue: Queue<Triple<Int, Int, Int>> = LinkedList()
    val moveHeight = mutableListOf(1, -1, 0, 0) // 아래, 위로 이동 하는 부분
    val moveWidth = mutableListOf(0, 0, 1, -1) // 오른쪽, 왼쪽으로 이동하는 부분
    fun bfs() :Int {
        queue.add(Triple(0, 0, 0))
        visited[0][0][0] = 1
        while (queue.isNotEmpty()) {
            val poll = queue.poll()
            if(poll.first == n-1 && poll.second == m-1){
                return visited[poll.first][poll.second][poll.third]
            }
            for (i in 0 until 4) {
                val ny = poll.first + moveHeight[i]
                val nx = poll.second + moveWidth[i]
                if (ny in 0 until n && nx in 0 until m) {
                    if (list[ny][nx] == 1 && poll.third == 0 ) { // 움직였을 때 만난 숫자가 1이고, 벽을 뚫지 않았을 경우 -> 벽을 뚫었을 경우로 이동 [poll.third + 1] 후 count+1
                        queue.add(Triple(ny,nx,poll.third+1))
                        visited[ny][nx][poll.third+1] = visited[poll.first][poll.second][poll.third] + 1
                    } else if (list[ny][nx] == 0 && visited[ny][nx][poll.third] == 0) { // 움직였을 때 만난 숫자가 0 이고, 방문 하지 않을 경우 -> 기존의 경우에 수에 방법 count+1
                        queue.add(Triple(ny,nx,poll.third))
                        visited[ny][nx][poll.third] =  visited[poll.first][poll.second][poll.third] + 1
                    }
                }
            }
        }
        return -1
    }
    println(bfs())
}