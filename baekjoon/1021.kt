package com.kguard.tobecomebetter.baekjoon

// 실버 3 회전하는 큐
// 자료구조, 덱
// 원하는 인덱스의 위치를 탐색해서 큐의 크기의 반이상 이면 오른쪽으로 이동하고, 반 보다 작으면 왼쪽으로 이동한다.
// 2.0으로 계산해서 double로 계산해서 이동하도록 함
fun main() {
    val (n, m) = readln().split(" ").map { it.toInt() }
    val queue = MutableList(n) { it + 1 }
    val pick = readln().split(" ").map { it.toInt() }
    var answer = 0
    repeat(m) {
        while (pick[it] != queue[0]) {
            if (queue.indexOf(pick[it]) >= queue.size / 2.0) {
                answer += 1
                queue.add(0, queue.removeAt(queue.lastIndex))
            } else {
                answer += 1
                queue.add(queue.removeAt(0))
            }
        }
        queue.removeAt(0)
    }
    println(answer)
}