package com.kguard.tobecomebetter.baekjoon

// 골드 4 트리
// 자료구조, 그래프 이론, 그래프 탐색, 트리, 깊이 우선 탐색, 분리 집합
// bfs와 dfs로 문제 해결
// 양방향이기 때문에 그래프에 양쪽에 넣어 놓고
// 다음 단계로 넘어 갈때 그래프에 값이랑 이전 값 비교 해서 같으면 다음 그래프 값으로 넘어감
// 사이클을 찾으면 트리가 되지 않음
fun main() {
    var count = 1
    while (true) {
        val (n, m) = readln().split(" ").map { it.toInt() }
        if (n == 0 && m == 0) break
        var trees = 0
        val graph = MutableList(n + 1) { mutableListOf<Int>() }
        val visited = MutableList(n + 1) { 0 } // 방문했는지 확인
        repeat(m) {
            val (a, b) = readln().split(" ").map { it.toInt() }
            graph[a].add(b)
            graph[b].add(a)
        }
        // dfs 방법으로 풀기 실패 75%
        val vis = MutableList(n + 1) { false }
        fun dfs(s: Int, prev: Int): Boolean {
            vis[s] = true // 방문하
            for (i in graph[s]) // 정점에 해당되는 간선집합에서
            {
                if (prev == i) continue // -> 왕복 방지, 양방향이기 때문에
                if (vis[i]) return false // 이미 방문했으면 false -> 사이클이 생성됨
                if (!dfs(i,s)) return false // 깊이에서 false이면 false -> 이전거에서 사이클이 생기면 그 부분은 다 연결된다고 생각
            }
            return true
        }

        fun bfs(s: Int): Boolean {
            val queue = mutableListOf<Int>()
            queue.add(s)
            visited[s] = 1
            var tree = true
            while (queue.isNotEmpty()) {
                val poll = queue.removeFirst()
                for (i in graph[poll]) {
                    if (visited[i] != 0 && visited[i] != visited[poll] - 1) // 해당 정점을 방문하였으나, 그 값이 그 전 노드가 아닐때 -> 사이클이 생성됨
                        tree = false
                    if (visited[i] == 0) {  // 그 해당 정점을 방문하지 않았으면
                        visited[i] = visited[poll] + 1
                        queue.add(i)
                    }
                }
            }
            return tree
        }
//        for(i in 1..n){
//            if(visited[i] == 0) {
//                if(bfs(i))
//                    trees++
//            }
//        }
        for (i in 1..n) {
            if (!vis[i]) {
                if (dfs(i, 0)) {
                    trees++
                }
            }
        }
        when {
            trees > 1 -> println("Case $count: A forest of $trees trees.")
            trees == 1 -> println("Case $count: There is one tree.")
            else -> println("Case $count: No trees.")
        }
        count += 1
    }
}