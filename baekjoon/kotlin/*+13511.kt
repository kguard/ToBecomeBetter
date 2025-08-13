package com.kguard.tobecomebetter.baekjoon

// 플래티넘 3 트리와 쿼리 2
// 자료 구조, 트리, 최소 공통 조상, 희소 배열
// 11438번과 기본적으로 같은 풀이
// 추가사항 (다른 점)
// 1. 길이를 저장하는 리스트가 추가됨
// 2. 1번일 시에 저장된 길이에서 올라가면서 길이를 더해주는 방식으로 문제 해결
// 3. 2번일 시에는 시작점과 끝점의 깊이를 보고 원하는 위치에 있는 게 시작점에서 시작하는 부모인지, 끝점에서 시작하는 부모인지 확인하는 작업 후, 차이를 계산해서 맞는 위치에서 부모 찾기
fun main() {
    val n = readln().toInt()
    val k = 17 // 2^17=131,072, n의 최대 값이 100,000 이기 때문에 k를 17로 잡음
    val depth = MutableList(n + 1) { 0 }
    val graph = MutableList(n + 1) { mutableListOf<Pair<Int, Int>>() }
    val parent = MutableList(k + 1) { MutableList(n + 1) { 0 } }
    val distance = MutableList(k + 1) { MutableList(n + 1) { 0L } }
    repeat(n - 1) {
        val (a, b, c) = readln().split(" ").map { it.toInt() }
        graph[a].add(Pair(b, c))
        graph[b].add(Pair(a, c))
    }
    fun fillParent(now: Int, deep: Int) { // 인접해 있는 부모를 채우기 위한 함수
        depth[now] = deep
        for (next in graph[now]) {
            if (depth[next.first] == 0) {
                fillParent(next.first, deep + 1)
                parent[0][next.first] = now
                distance[0][next.first] = next.second.toLong()
            }
        }
    }
    fillParent(1, 1)

    for (i in 1..k) // 밑으로 내려가면서 2진수에 맟춰서 부모를 찾고, 거리를 더해주는 작업
        for (j in 1..n) {
            parent[i][j] = parent[i - 1][parent[i - 1][j]]
            distance[i][j] = distance[i - 1][j] + distance[i - 1][parent[i - 1][j]]
        }
    fun lca(a1: Int, b1: Int) { // 1번을 골랐을 때 길이를 출력하는 함수
        var a = a1
        var b = b1
        var dist = 0L
        if (depth[a] < depth[b]) // 깊이에 따른 swap 함수
            a = b.also { b = a }

        for (i in k downTo 0) // 두 개의 깊이를 맞춰서 더 깊은 쪽의 노드를 올리는 작업
            if (depth[a] - depth[b] and (1 shl i) > 0) {
                dist += distance[i][a]
                a = parent[i][a]
            }

        if (a != b) { // 두 노드가 다를 때
            for (i in k downTo 0) { // 두 노드가 같아 질때 까지 부모 노드로 이동하는 작업 -> 2진수로 구성하여 빠르게 올릴 수 있음
                if (parent[i][a] != parent[i][b]) {
                    dist += distance[i][a] + distance[i][b] // 부모로 올릴때 거리들 다 더해주기
                    a = parent[i][a]
                    b = parent[i][b]
                }
            }
            dist += distance[0][a] + distance[0][b] // 마지막으로 거리 더하기
            a = parent[0][a]
        }
        println(dist)
    }

    fun lca(a1: Int, b1: Int, locate: Int) { // 2번을 골랐을시 경로에서 원하는 위치에 있는 노드를 출력하는 함수
        var a = a1
        var b = b1
        if (depth[a] < depth[b]) // 깊이에 따른 swap 함수
            a = b.also { b = a }

        for (i in k downTo 0)  // 두 개의 깊이를 맞춰서 더 깊은 쪽의 노드를 올리는 작업
            if (depth[a] - depth[b] and (1 shl i) > 0) {
                a = parent[i][a]
            }

        if (a != b) {
            for (i in k downTo 0) {
                if (parent[i][a] != parent[i][b]) {  // 두 노드가 같아 질때 까지 부모 노드로 이동하는 작업 -> 2진수로 구성하여 빠르게 올릴 수 있음
                    a = parent[i][a]
                    b = parent[i][b]
                }
            }
            a = parent[0][a] // a는 최소 공통 부모가 됨
        }
        if (depth[a1] - depth[a] + 1 >= locate){ // 원하는 위치에 노드가 a1의 부모 노드 일때
            var cur = a1 // 시작 위치
            for (i in k downTo 0)
                if (locate - 1 and (1 shl i) > 0) // 원하는 위치 만큼 부모로 올라가면 됨 -1은 자기자신도 올수 있기 때문에, 인덱스는 0부터 시작
                    cur = parent[i][cur]
            println(cur)
        } else { // 원하는 위치의 노드가 b1의 부모 노드 일때
            var cur = b1 // 시작 위치
            var l = locate - (depth[a1] - depth[a]) // a1 부터 최소 공통 노드 까지는 빼 줘야됨 -> b1의 부모 노드 이기 떄문에, a1부터 세기 시작
            l = depth[b1] - depth[a] - l // 최소 공통 노드 부터로 셈이 되었으니, 거꾸로 계산하기 위해 b1의 깊이에서 빼주기
            for(i in k downTo 0)
                if(l+1  and (1 shl i) > 0 ) // 원하는 위치 만큼 부모로 올라가면 됨 +1은 자기자신도 올 수 있기 때문에, 인덱스는 마지막-1 까지
                    cur = parent[i][cur]
            println(cur)
        }
    }

    val m = readln().toInt()
    repeat(m) {
        val list = readln().split(" ").map { it.toInt() }
        if (list[0] == 1)
            lca(list[1], list[2])
        else if (list[0] == 2)
            lca(list[1], list[2], list[3])
    }
}