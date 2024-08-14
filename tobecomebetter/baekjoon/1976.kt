package com.kguard.tobecomebetter.baekjoon

// 골드 4 여행 가자
// 자료 구조, 그래프 이론, 그래프 탐색, 분리 집합
// 값들을 union해서 루트 노드를 구한 다음, 경로에 있는 값들의 루트 노드 값을 확인해서 다른게 있으면 no 출력
fun main() {
    val n = readln().toInt()
    val m = readln().toInt()
    val graph = MutableList(n + 1) { it } // 루트 노드 저장하는 리스트
    fun find(x: Int): Int { // 루트 노드 찾기
        return if (graph[x] == x) x
        else {
            graph[x] = find(graph[x])
            graph[x]
        }
    }

    fun union(x: Int, y: Int) { // 합치기 -> 루트 노드가 같아짐
        val nx = find(x)
        val ny = find(y)
        if (nx != ny) graph[nx] = ny
    }
    repeat(n) { index ->
        val list = readln().split(" ").map { li -> li.toInt() }
        for (i in 0 until n)
            if (list[i] == 1) // 1이면 union
                union(index + 1, i + 1)
    }
    val city = readln().split(" ").map { it.toInt() }
    city.forEach { find(it) }
    val tree = graph[city[0]] // 경로의 처음 값에 대한 루트 노드
    var check = true
    for (i in city) {
        if (graph[i] != tree) check = false // 하나라도 다른게 있으면 false
    }
    if (check) println("YES")
    else println("NO")
}