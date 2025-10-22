/*
package com.kguard.tobecomebetter.forcodingtest



   private fun solution(board: Array<IntArray>, commands: Array<IntArray>): Array<IntArray> {
        val n = board.size
        val m = board[0].size
        var currentBoard = Array(n) { r -> board[r].clone() }

        for (command in commands) {
            val idToMove = command[0]
            val arrow = command[1]

            if (idToMove == 0) continue

            // 1. '원래 위치' 지도 만들기: 이번 명령 시작 전의 고정된 상태를 저장합니다.
            val originalLocations = mutableMapOf<Int, MutableList<Pair<Int, Int>>>()
            for (r in 0 until n) {
                for (c in 0 until m) {
                    val id = currentBoard[r][c]
                    if (id != 0) {
                        originalLocations.getOrPut(id) { mutableListOf() }.add(r to c)
                    }
                }
            }

            if (!originalLocations.containsKey(idToMove)) continue

            // 2. '가상 위치' 지도 만들기: 연쇄 반응을 시뮬레이션할 공간입니다.
            val hypotheticalLocations = mutableMapOf<Int, List<Pair<Int, Int>>>()
            originalLocations.forEach { (id, coords) ->
                hypotheticalLocations[id] = coords.toList()
            }

            // 3. 큐(Queue)를 이용해 연쇄 반응을 시뮬레이션합니다.
            val moveSet = mutableSetOf<Int>() // 최종적으로 움직일 모든 앱
            val queue = ArrayDeque<Int>()     // 탐색 목록

            moveSet.add(idToMove)
            queue.add(idToMove)

            val (dr, dc) = when (arrow) {
                1 -> -1 to 0; 2 -> 0 to 1; 3 -> 1 to 0; 4 -> 0 to -1; else -> 0 to 0
            }

            while (queue.isNotEmpty()) {
                val currentId = queue.removeFirst()

                // 현재 앱의 '가상 위치'를 한 칸 옮깁니다.
                val currentCoords = hypotheticalLocations[currentId] ?: continue
                val newCoords = currentCoords.map { (r, c) ->
                    (r + dr + n) % n to (c + dc + m) % m
                }
                hypotheticalLocations[currentId] = newCoords

                // 다른 모든 앱들과 겹치는지 '가상 위치' 기준으로 확인합니다.
                for ((otherId, otherCoords) in hypotheticalLocations) {
                    if (otherId == currentId || otherId in moveSet) continue

                    // 다른 앱의 '가상 위치' 조각 중 하나라도, 현재 앱의 '새 가상 위치'와 겹치는지 확인
                    if (otherCoords.any { it in newCoords }) {
                        moveSet.add(otherId)
                        queue.add(otherId)
                    }
                }
            }

            // 4. 시뮬레이션 결과를 실제 판에 적용합니다. (싹 지우고 -> 새로 그리기)
            val appsToMove = moveSet
                .filter { originalLocations.containsKey(it) }
                .map { it to originalLocations.getValue(it) }

            for ((_, coords) in appsToMove) {
                for ((r, c) in coords) {
                    currentBoard[r][c] = 0
                }
            }

            for ((appId, coords) in appsToMove) {
                for ((r, c) in coords) {
                    val newR = (r + dr + n) % n
                    val newC = (c + dc + m) % m
                    currentBoard[newR][newC] = appId
                }
            }
        }

        return currentBoard
    }


*/
