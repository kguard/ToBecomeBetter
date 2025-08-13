package com.kguard.tobecomebetter.baekjoon

// 골드 1 최종 순위
// 그래프 이론, 위상 정렬, 방향 비순환 그래프
// 순위를 기준으로 해서 그래프에 간선을 만들도록 함
// 예를 들어 1 2 3 4 이면 1->[2,3,4] 2-> [3,4] 3->[4] 4->[] 이런식으로 만듬
// 작년과 순위가 바뀐 경우 에는 일관성이 다를 수 있기 떄문에 간선이 있는 지 비교 해서 있으며 없게, 없으면 있게 바꾸기
// 진입차수를 추가 해줌
// 집입차수가 0인 부분이 2개면 순서가 명확하지 않으니 ? 출력
// 진입차수가 0인 부분이 없으면 사이클이 만들어져 순위를 정할 수 없어서 IMPOSSISBLE 출력
private fun topologySort(n: Int, inDegree: MutableList<Int>, graph: MutableList<MutableSet<Int>>) {
    val queue = mutableListOf<Int>() // 큐
    val result = mutableListOf<Int>() // 결과를 저장하기 위한 리스트
    for (i in 1..n)
        if (inDegree[i] == 0)
            queue.add(i) // 진입차수가 0인 팀만 추가

    for (t in 0 until n) {
        if (queue.isEmpty()) { // 진입차수가 0인 팀이 없으면 사이클이 생성되고 순위를 정할 수 없음
            println("IMPOSSIBLE")
            return
        }
        if (queue.size > 1) { // 진입차수가 0인 팀이 2이상이면 순위가 명확하지 않아짐
            println("?")
            return
        }
        val poll = queue.removeAt(0) // 큐에서 poll
        result.add(poll) // result에 poll 저장
        for (i in graph[poll]) { // poll에서 연결되어 있는 노드에서
            inDegree[i] -= 1 // poll을 result에 저장했으니 진입차수 -1
            if (inDegree[i] == 0) // 진입차수가 0이 되면
                queue.add(i)// queue에 노드 추가
        }
    }
    result.forEach { print("$it ") }
    println()
}

fun main() {
    val t = readln().toInt()
    repeat(t) {
        val n = readln().toInt()
        val rank = readln().split(" ").map { it.toInt() }
        val inDegree = MutableList(n + 1) { 0 }
        val graph = MutableList(n + 1) { mutableSetOf<Int>() } // 그래프를 그리기 위한 리스트
        val m = readln().toInt()
        for (i in rank.indices)
            for (j in i + 1 until rank.size)
                graph[rank[i]].add(rank[j]) // 각 팀별로 랭킹에 맞게 간선 추가
        repeat(m) {
            val (a, b) = readln().split(" ").map { it.toInt() } // 두 팀의 결과가 바뀌는 경우
            if (b !in graph[a]) { // 작년과 순위가 바뀐 경우 -> a 안에 b가 없어야 됨
                graph[a].add(b) // 그래프에 추가
                graph[b].remove(a) // b에서 a를 삭제 함으로써 간선 방향 바꾸기
            } else { // 작년과 순서가 바뀌었다고 하는데 일관성이 유지 되지 않아서 틀린 경우 -> 잘못된 정보일 경우
                graph[b].add(a) // 그래프에 추가
                graph[a].remove(b) // a에서 b를 삭제 함으로써 간선 방향 바꾸기
            }
        }
        for (i in 1..n)
            for (j in graph[i])
                inDegree[j] += 1 // 그래프에 맞춰서 진입차수 늘려주기
        topologySort(n, inDegree, graph) // 위상정렬 실행
    }
}