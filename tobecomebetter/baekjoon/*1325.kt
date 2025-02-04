package com.kguard.tobecomebetter.baekjoon

// 실버 1 효율적인 해킹
// 그래프 이론, 그래프 탐색, 너비 우선 탐색, 깊이 우선 탐색
// 역방향 그래프를 사용해서 문제 해결
// 그래프를 따라 올라 갔을 때 나오는 횟수를 체크
fun main() {
    val (n, m) = readln().split(" ").map { it.toInt() }
    val graph = Array(n + 1) { arrayListOf<Int>() }
    val list = Array(n + 1) { 0 } // 각 인덱스가 나오는 횟수를 저장하는 리스트
    repeat(m) {
        val (a, b) = readln().split(" ").map { it.toInt() }
        graph[a].add(b) // b를 해킹하면 a를 해킹할 수 있음 -> 역방향으로 그래프를 저장해서 많이 나오는 수를 체크
    }

    // bfs
//    fun bfs(now: Int) {
//        val visit = Array(n + 1) { false }
//        val queue : Queue<Int> =  LinkedList()
//        queue.add(now)
//        visit[now] = true
//        while (queue.isNotEmpty()) {
//            val poll = queue.poll()
//            for (i in graph[poll!!]) {
//                if (!visit[i]) {
//                    queue.add(i)
//                    visit[i] = true
//                    list[i]++
//                }
//            }
//        }
//    }
//    for (now in 1..n) {
//       bfs(now)
//    }

    //dfs
    var visit = Array(n + 1) { false }
    fun dfs(now: Int) {
        visit[now] = true
        for (i in graph[now]) {
            if (!visit[i]) {
                dfs(i)
                list[i]++
            }
        }
    }
    for (i in 1..n) {
        dfs(i)
        visit = Array(n + 1) { false }
    }

    // 출력
    val max = list.max()
    for(i in list.indices)
        if(list[i] == max)
            print("$i ")
}