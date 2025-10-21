import java.util.ArrayDeque
import kotlin.math.max

class Solution {
    fun solution(n: Int, infection: Int, edges: Array<IntArray>, k: Int): Int {
        // 파이프 연결 정보를 저장할 인접 리스트
        val adj = Array(4) { Array(n + 1) { mutableListOf<Int>() } }
        for (edge in edges) {
            val u = edge[0]
            val v = edge[1]
            val type = edge[2]
            adj[type][u].add(v)
            adj[type][v].add(u)
        }

        var maxInfectedCount = 0

        // BFS를 위한 큐. Pair<Int, Set<Int>>는 (depth, infectedSet)을 의미합니다.
        val queue: ArrayDeque<Pair<Int, Set<Int>>> = ArrayDeque()

        // 중복된 상태를 탐색하지 않기 위한 visited 집합
        val visited = mutableSetOf<Set<Int>>()

        // --- BFS 시작 ---
        // 1. 초기 상태를 Pair로 정의하고 큐에 추가합니다.
        val initialState = Pair(0, setOf(infection))
        queue.add(initialState)
        visited.add(initialState.second)

        while (queue.isNotEmpty()) {
            val currentState = queue.removeFirst()
            val depth = currentState.first          // .depth 대신 .first 사용
            val infectedSet = currentState.second   // .infectedSet 대신 .second 사용

            // 현재 상태의 감염자 수로 최댓값을 갱신합니다.
            maxInfectedCount = max(maxInfectedCount, infectedSet.size)

            // 행동 횟수(k)를 모두 사용했다면, 이 상태에서는 더 이상 탐색하지 않습니다.
            if (depth == k) {
                continue
            }

            // 2. 현재 상태에서 다음 행동(3가지 파이프 열기)을 시도합니다.
            for (pipeType in 1..3) {
                // 현재 감염된 집합을 기반으로 다음 감염 상태를 계산합니다. (내부 BFS)
                val infectionQueue = ArrayDeque<Int>(infectedSet)
                val nextInfectedSet = infectedSet.toMutableSet()

                while (infectionQueue.isNotEmpty()) {
                    val current = infectionQueue.removeFirst()
                    for (neighbor in adj[pipeType][current]) {
                        if (nextInfectedSet.add(neighbor)) {
                            infectionQueue.add(neighbor)
                        }
                    }
                }

                // 3. 계산된 다음 상태가 처음 보는 상태라면 큐와 visited에 추가합니다.
                if (nextInfectedSet !in visited) {
                    visited.add(nextInfectedSet)
                    queue.add(Pair(depth + 1, nextInfectedSet)) // State 대신 Pair 사용
                }
            }
        }

        return maxInfectedCount
    }
}

